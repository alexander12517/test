package com.luxoft.lab9;

import java.util.*;

public class Main {
    private Scanner in;
    private TreeMap<String, TreeMap<String, Integer>> clients;

    public Main(Scanner in) {
        this.in = in;
        clients = new TreeMap<String, TreeMap<String, Integer>>();
    }

    public void Purchases() {
        String inputString = "";
        String clientName = "";
        String productName = "";
        Integer productCount = 0;

        while (true) {
            System.out.print("Enter: 'client product count' or 'quit' : ");
            inputString = in.nextLine();
            if ("quit".equals(inputString)) {
                return;
            }
            inputString = inputString.trim();
            String[] parts = inputString.split(" ");
            if (parts.length != 3) {
                System.out.println("Wrong number of arguments! Retry!" + parts.length + " " + parts[0]);
                inputString = "";
                continue;
            }
            try {
                clientName = parts[0];
                productName = parts[1];
                productCount = Integer.parseInt(parts[2]);
                updateClientsMap(clientName, productName, productCount);
            } catch (NumberFormatException e) {
                System.out.println("invalid number. " + e.getMessage() + " Retry!");
                inputString = "";
            } catch (Exception e) {
                System.out.println("Unexpected error. " + e.getMessage());
                return;
            }
        }
    }

    public void Statistic() {
        TreeMap<String, Integer> client;
        for (String clientKey : clients.navigableKeySet()) {
            System.out.println(clientKey + ":");
            client = clients.get(clientKey);
            for (String productKey : client.navigableKeySet()) {
                int count = client.get(productKey);
                System.out.println(productKey + " " + count);
            }
        }
    }

    private void updateClientsMap(String clientName, String productName, int productCount) {
        TreeMap<String, Integer> client;
        if (!clients.containsKey(clientName)) {
            client = new TreeMap<String, Integer>();
            client.put(productName, productCount);
            clients.put(clientName, client);
        }
        else {
            client = clients.get(clientName);
            if (!client.containsKey(productName)) {
                client.put(productName, productCount);
            } else {
                int oldProductCount = client.get(productName);
                client.put(productName, productCount + oldProductCount);
            }
        }
    }

    public static void main(String[] args) {
        Main shop = new Main(new Scanner(System.in));
        shop.Purchases();
        shop.Statistic();
    }
}