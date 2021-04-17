package ru.luxoft.cources.model.money;

import ru.luxoft.cources.model.money.Money;
import ru.luxoft.cources.model.money.Currency.MoneyInterfacee;
import ru.luxoft.cources.model.money.Currency;

public class Money {
    private Currency currency;
    private double value;
    public Money(double value, String currencyName) {
        this.value = value;
        this.currency = CurrencyHolder.getCurrencyByName(currencyName);
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    public static class CurrencyHolder {
        private static final Map<String,Currency> currencies = new HashMap<String, Currency>();
        static {
            currencies.put("USD",new Currency("USD", 1));
            currencies.put("RUR",new Currency("RUR", 65.5f));
        }

        public static Currency getCurrencyByName(String name) {
            return currencies.get(name);
        }
    }
}
