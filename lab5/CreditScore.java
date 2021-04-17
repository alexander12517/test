
package ru.luxoft.cources.model;

import ru.luxoft.cources.model.money.Money;
import ru.luxoft.cources.model.score.Score;
import ru.luxoft.cources.model.account.Account;

public class CreditScore extends Score {
    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }
}

