package lab6;

public class Product implements Comparable<Product>{

//public class Product {
//public class Product {
    private int count;
    private float cost;
    private String name;

    public Product(int count, float cost, String name) {
        this.count = count;
        this.cost = cost;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Product o) {
        if(this.count > o.count){
            return -1;
        } else if(this.count < o.count){
            return 1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return "Product{" +
                "count=" + count +
                ", cost=" + cost +
                ", name='" + name + '\'' +
                '}';
    }
}
