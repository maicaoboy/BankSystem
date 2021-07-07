package com.neu.dao;

import com.neu.pojo.Customer;

public interface IDao {
    boolean addCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    double[] getBalance();
    boolean withdrawBalance(double money);
    Customer getCurrentCustomer();
    void setCurrentUser(Customer customer);
    Customer findCustomer(Customer customer);
    void deposit(double money);
}
