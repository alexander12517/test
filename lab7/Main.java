package lab7;

public class Main {

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();

        myArrayList.add("John");
        myArrayList.add("Sarah");
        myArrayList.add("Arny");
        myArrayList.add("Elizabeth");
        myArrayList.add("Jack");
        myArrayList.add("William");
        myArrayList.add("Mirriam");
        myArrayList.add("Ortega");
        myArrayList.add("Takeshy");
        myArrayList.add("Doloreya");
        myArrayList.add("Teddy");
        myArrayList.add("Arnold");
        myArrayList.add("Essy");
        myArrayList.add("ManInBlack");
        myArrayList.add("White");

        for (int i = 0; i < myArrayList.size(); i++) System.out.println(myArrayList.get(i));

        myArrayList.remove(0);
        myArrayList.remove(1);
        myArrayList.remove(2);

        System.out.println ("Первый элемент ArrayList:" + myArrayList.get(0));
        System.out.println ("Первый элемент ArrayList:" + myArrayList.get(1));
        System.out.println ("Первый элемент ArrayList:" + myArrayList.get(2));

        for (int i = 0; i < myArrayList.size(); i++) System.out.println(myArrayList.get(i));

        System.out.println ("Размер массива:" + myArrayList.size());

    }
}
