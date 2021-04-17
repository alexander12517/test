package ru.luxoft.cources.model;

import ru.luxoft.cources.model.money.Money;
import ru.luxoft.cources.model.score.Score;
import ru.luxoft.cources.model.account.Account;

public class CurrentScore extends Score {

    public CurrentScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }

    @Override
    public void addMoney(Money money) {
        super.addMoney(money);
        if (money.getValue() > 1000000.0) {
            money.setValue(2000.0);
            super.addMoney(money);
        }
    }

}
