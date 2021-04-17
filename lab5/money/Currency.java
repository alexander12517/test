package ru.luxoft.cources.model.money;

public class Currency {
    private String name;
    private float usdCource;
    public Currency(String name, float usdCource) {
        this.name = name;
        this.usdCource = usdCource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUsdCource() {
        return usdCource;
    }

    public void setUsdCource(float usdCource) {
        this.usdCource = usdCource;
    }
    public interface MoneyInterface {
        void addMoney(Money money);
        Money getMoney(double balanceLess);
        Money getMoneyWithoutLess();
    }

}
