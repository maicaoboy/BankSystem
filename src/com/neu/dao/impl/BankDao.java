package com.neu.dao.impl;

import com.neu.dao.IDao;
import com.neu.pojo.Bank;
import com.neu.pojo.Customer;
import java.util.Arrays;

/**
 * 数据操作类
 *
 */
public class BankDao implements IDao {
    private Bank bank;
    private Customer currentUser;
    private static BankDao instance;

    public static BankDao getInstance() {
        if(instance == null) {
            instance = new BankDao();
        }
        return instance;
    }

    private BankDao() {
        bank = new Bank();
        currentUser = null;
    }

    //
    @Override
    public boolean addCustomer(Customer customer) {
        Customer[] customers;
        if(bank.getCustomers() != null) {
            for(Customer customer1 : bank.getCustomers()) {
                if(customer1.equals(customer)){
                    return false;
                }
            }
        }
        customers = Arrays.copyOf(bank.getCustomers(),bank.getCustomers().length + 1);
        customers[customers.length-1] = customer;
        bank.setCustomers(customers);
        return true;
    }

    @Override
    public void deleteCustomer(Customer customer) {
        //未完成
    }

    //balance数组第一个元素为储蓄账户余额，第二个元素为信用账户余额
    @Override
    public double[] getBalance() {
        double[] balance = new double[2];
        balance[0] = currentUser.getAccount().getSaving().getBalance();
        balance[1] = currentUser.getAccount().getBalance();
        return balance;
    }

    @Override
    public void deposit(double money) {
        currentUser.getAccount().getSaving().setBalance(currentUser.getAccount().getSaving().getBalance() + money);
    }

    @Override
    public boolean withdrawBalance(double money) {
        boolean success = false;
        if((currentUser.getAccount().getSaving().getBalance() + currentUser.getAccount().getBalance()) >=money) {
            success = true;
            if(money <= currentUser.getAccount().getSaving().getBalance()) {
                currentUser.getAccount().getSaving().setBalance(
                        currentUser.getAccount().getSaving().getBalance() - money);
            }else {
                currentUser.getAccount().setBalance(currentUser.getAccount().getSaving().getBalance() +
                        currentUser.getAccount().getBalance()-money);
                currentUser.getAccount().getSaving().setBalance(0.0);
            }
        }else{
            System.out.println("余额不足.");
        }
        return success;
    }

    @Override
    public Customer getCurrentCustomer() {
        return currentUser;
    }

    @Override
    public void setCurrentUser(Customer customer) {
        this.currentUser = customer;
    }

    @Override
    public Customer findCustomer(Customer customer) {
        Customer customer2 = null;
        for(Customer customer1 : bank.getCustomers()) {
            if(customer1.equals(customer)){
                customer2 = customer1;
            }
        }
        return customer2;
    }


}
