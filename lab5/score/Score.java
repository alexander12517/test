package ru.luxoft.cources.model.score;

import model.account.Account;
import model.money.Money;
import model.money.MoneyInterface;
import ru.luxoft.cources.model.CreditScore;
import ru.luxoft.cources.model.money.Money;

public abstract class Score {
    private Money balance;
    private Account owner;
    private Integer number;

    protected Score(Money balance, Account owner, Integer number) {
        this.balance = balance;
        this.owner = owner;
        this.number = number;

        public Money getBalance () {
            return balance;
        }

        public void setBalance (Money balance){
            this.balance = balance;
        }

        public Account getOwner () {
            return owner;
        }

        public void setOwner (Account owner){
            this.owner = owner;
        }

        public Integer getNumber () {
            return number;
        }

        public void setNumber (Integer number){
            this.number = number;
        }
}

    @Override
    public void addMoney(Money money) {
        double usdValueIn = money.getValue() * money.getCurrency().getUsdCource();
        double usdValueThis = this.balance.getValue() * this.balance.getCurrency().getUsdCource();
        this.balance.setValue((usdValueThis + usdValueIn) * this.balance.getCurrency().getUsdCource());
    }

    @Override
    public Money getMoney(double balanceLess){
        if(balanceLess > 30000) {
            throw new IllegalArgumentException("Wrong balance less!");
        }

        this.balance.setValue(this.balance.getValue() - balanceLess);

        return this.balance;
    }
    @Override
    public Money getMoneyWithoutLess(){
        return this.balance;
    }

    public class DebetScore extends Score {
        private CreditScore creditScore;

        public DebetScore(Money balance, Account owner, Integer number, CreditScore creditScore) {
            super(balance, owner, number);
            this.creditScore = creditScore;
        }
    }
    public class CurrentScore extends Score {
        private DebetScore debetScore;

        public CurrentScore(Money balance, Account owner, Integer number, DebetScore debetScore) {
            super(balance, owner, number);
            this.debetScore = debetScore;
        }
    }
