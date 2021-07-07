package com.neu.pojo;

//账户父类
public class Account {
    //存款
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //构造函数
    public Account() {
        this.balance = 0;
    }

    public Account(double money) {
        this.balance = money;
    }
}
