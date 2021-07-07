package com.neu.service.impl;

import com.neu.dao.IDao;
import com.neu.dao.impl.BankDao;
import com.neu.pojo.Customer;
import com.neu.service.IBankService;
import com.neu.view.SystemUI;

public class BankService implements IBankService {
    private IDao data;
    private static BankService instance;

    public static BankService getInstance() {
        if(instance == null) {
            instance = new BankService();
        }
        return instance;
    }

    private  BankService() {
        data = BankDao.getInstance();
    }

    @Override
    public void register() {
        boolean sign;
        String[] message = SystemUI.registerOrLogin();
        sign = data.addCustomer(new Customer(message[0],message[1]));
        if(sign) {
            System.out.println("用户 " + message[0] + " 注册成功");
        }else {
            System.out.println("注册失败，用户已存在");
        }
        System.out.println(" ");
    }

    @Override
    public void login() {
        String[] message;
        boolean state = false;
        for(int i = 0; i <3; i++){
            SystemUI.loginTimes(i);
            message = SystemUI.registerOrLogin();
            if((data.findCustomer(new Customer(message[0],message[1]))) != null){
                data.setCurrentUser(data.findCustomer(new Customer(message[0],message[1])));
                state = true;
                break;
            }
        }
        if(state) {
            System.out.println("用户" +  data.getCurrentCustomer().getName() + "登陆成功");
            System.out.println(" ");
        }else{
            System.out.println("登陆失败");
            System.out.println(" ");
        }

    }

    @Override
    public void logout() {
        if(data.getCurrentCustomer() != null) {
            SystemUI.logoutReminder(data.getCurrentCustomer().getName());
            data.setCurrentUser(null);
        }else {
            System.out.println("对不起，您还未登录");
            System.out.println("");
        }
    }

    @Override
    public void deposit() {
        double money =SystemUI.getMoney("请输入存款额度");
        if(data.getCurrentCustomer() != null) {
            data.getCurrentCustomer().getAccount().getSaving().setBalance(
                    data.getCurrentCustomer().getAccount().getSaving().getBalance() + money);
            System.out.println("成功存入" + money + "元.");
            System.out.println("存款账户余额：" + data.getCurrentCustomer().getAccount().getSaving().getBalance());
            System.out.println("信用账户余额：" + data.getCurrentCustomer().getAccount().getBalance());
            System.out.println(" ");
        }else {
            System.out.println("对不起，您还未登录");
        }
    }

    @Override
    public void withdraw() {
        double money =SystemUI.getMoney("请输入存款额度");
        if(data.getCurrentCustomer() != null) {
            if(data.withdrawBalance(money)) {
                System.out.println("取款成功");
                System.out.println(" ");
            }
            System.out.println("当前余额：");
            System.out.println("存款账户余额：" + data.getCurrentCustomer().getAccount().getSaving().getBalance());
            System.out.println("信用账户余额：" + data.getCurrentCustomer().getAccount().getBalance());
        }else {
            System.out.println("对不起,您还未登录.");
        }
        System.out.println(" ");
    }

    @Override
    public void checkBalance() {
        if(data.getCurrentCustomer() != null) {
            System.out.println("尊敬的" + data.getCurrentCustomer().getName() + "您的");
            System.out.println("存款账户余额：" + data.getCurrentCustomer().getAccount().getSaving().getBalance());
            System.out.println("信用账户余额：" + data.getCurrentCustomer().getAccount().getBalance());
        }else {
            System.out.println("对不起，您还没登录");
        }
        System.out.println(" ");
    }
}
