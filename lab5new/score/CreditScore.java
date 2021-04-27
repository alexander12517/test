package lab5new.score;

import lab5new.account.Account;
import lab5new.money.Money;

public class CreditScore extends Score {
    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }
}
