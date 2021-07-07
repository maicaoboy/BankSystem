package com.neu.pojo;

import com.neu.pojo.SAccount.CheckingAccount;

//用户
public class Customer {
    //用户姓名
    private String name;

    //用户密码
    private String password;

    //账户
    private CheckingAccount account;

    //构造函数
    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
        account = new CheckingAccount();
    }

    //setter / getter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CheckingAccount getAccount() {
        return account;
    }

    public void setAccount(CheckingAccount account) {
        this.account = account;
    }



    //重写equals方法。用于验证登录信息
    @Override
    public boolean equals(Object o) {
        Customer customer = (Customer) o;
        return name.equals(customer.getName()) && password.equals(customer.getPassword());
    }

}
