package com.neu.pojo;

public class Bank {
    //用户数组
    private Customer[] customers;

    //构造函数
    public Bank() {
        this.customers = new Customer[0];
    }

    //获得用户数组
    public Customer[] getCustomers() {
        if(customers ==null) {
            return null;
        }else {
            return customers;
        }
    }

    //设置用户数组
    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }
}
