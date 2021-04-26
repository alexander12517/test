package lab6;


import java.util.*;

public class Main {

//????? ??????? ????????? ?????? main (??????????? ????????? 33) - ???????? ?? 31 ??????????? ???????????.
// ????? ?????????? ?? break ? continue
// ??????? ??????.
// ??????? ??? ????? ????????
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int count = 0;

        String[] masOfProducts = new String[5];
        Integer[] masOfCosts = new Integer[5];
        Integer[] masOfCounts = new Integer[5];

        while(sc.hasNext() && count < 5) {
            String s = sc.nextLine();
            if("q".equals(s)) {
                break;
            }

            String[] parts = s.split(" ");

            if(parts.length != 3){
                System.out.println("Wrong number of arguments! Retry!");
                continue;
            }

            String productName = parts[0];
            Integer productCost;
            Integer productCount;
            try {
                productCost = Integer.parseInt(parts[1]);
                productCount = Integer.parseInt(parts[2]);
            } catch (NumberFormatException ex){
                System.out.println(ex.getMessage());
                System.out.println("Retry!");
                continue;
            }

            boolean productAlreadyExists = false;
            for (int i = 0; i < 5; i++) {
                if(productName.equals(masOfProducts[i])){
                    masOfCosts[i] = productCost;
                    masOfCounts[i] += productCount;
                    productAlreadyExists = true;
                }
            }

            if(!productAlreadyExists) {
                for (int i = 0; i < 5; i++) {
                    if(masOfProducts[i] == null){
                        masOfProducts[i] = productName;
                        masOfCosts[i] = productCost;
                        masOfCounts[i] = productCount;
                        break;
                    }
                }
            }
            count++;
        }
        sc.close();
        if(count == 0) {
            System.out.println("Empty shopping list!");
            return;
            }

        String[] sortedProducts = new String[5];
        System.arraycopy(masOfProducts, 0, sortedProducts, 0, 5);

       try {
           Arrays.sort(sortedProducts, String.CASE_INSENSITIVE_ORDER.thenComparing(String::compareTo));
       } catch (NullPointerException e) {
           System.out.println("Start are catch");
           e.printStackTrace();
       }
       finally {
           System.out.println(Arrays.toString(sortedProducts));
       }

        long sum = 0;
        for (int i = 0; i < count; i++) {
            sum += masOfCosts[i] * masOfCounts[i];
        }
        System.out.println("Purchase amount = " + sum);


        for (int j = 0; j < 3; j++) {
            int indexOfMostPopularProduct = 0;
            for (int i = 0; i < count; i++) {
                if(masOfCounts[i] > masOfCounts[indexOfMostPopularProduct]){
                    indexOfMostPopularProduct = i;
                }
            }
            System.out.println("Most popular product is " + masOfProducts[indexOfMostPopularProduct]);
            masOfProducts[indexOfMostPopularProduct] = null;
            masOfCounts[indexOfMostPopularProduct] = 0;
            masOfCosts[indexOfMostPopularProduct] = 0;
        }
    }
}
