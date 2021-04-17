package ru.luxoft.cources.model;

import ru.luxoft.cources.model.money.Money;
import ru.luxoft.cources.model.score.Score.CurrentScore;
import ru.luxoft.cources.model.score.Score.DebetScore;
import ru.luxoft.cources.model.account.Account;

public class DebitScore extends Score {

    public DebitScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }

    @Override
    public void addMoney(Money money) {
        if (isLargeCredit(this.getOwner())) {
            System.out.println("You have too large credit.");
            return;
        }
        super.addMoney(money);
    }

    @Override
    public Money getMoney(double balanceLess) {
        if (isLargeCredit(this.getOwner())) {
            System.out.println("You have too large credit.");
            return super.getMoneyWithoutLess();
        }
        return super.getMoney(balanceLess);
    }

    private boolean isLargeCredit(Account owner) {
        for (Score score : owner.getScoreMap()) {
            if (score.getBalance().getValue() < -20000) {
                return true;
            }
        }
        return false;
    }
}

