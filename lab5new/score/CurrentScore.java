package lab5new.score;

import lab5new.account.Account;
import lab5new.money.Money;

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
