package com.neu.view;

import com.neu.service.IBankService;
import com.neu.service.impl.BankService;
import java.util.Scanner;

public class SystemUI {
    public static void main(String[] args) {
        IBankService service = BankService.getInstance();
        while(true) {
            initPanel();
            switch (getString("请输入对应数字选择需要的业务")) {
                case "1" -> service.register();
                case "2" -> service.login();
                case "3" -> service.deposit();
                case "4" -> service.withdraw();
                case "5" -> service.checkBalance();
                case "6" -> service.logout();
                default -> System.exit(0);
            }
        }

    }



    public static String[] registerOrLogin() {
        String[] message = new String[2];
        System.out.println("注册开始...");
        message[0] = getString("1.请输入用户名");
        message[1] = getString("请输入密码");
        return message;
    }



    public static void loginTimes(int i) {
        if(i == 1){
            System.out.println("还剩两次尝试机会.");
        }
        if (i == 2) {
            System.out.println("还剩最后一次尝试机会.");
        }
    }

    public static void initPanel() {
        System.out.println("加载中......");
        System.out.println("尊敬的用户，欢迎使用中国银行.");
        System.out.println("您要办理什么业务：");
        System.out.println("1.注册新账户 2.登录 3.存款 4.取款 5.查询余额 6.登出");
    }


    //参数为提示，返回值获得输入
    public static String getString(String reminder) {
        //保存输入的变量
        Scanner scan = new Scanner(System.in);
        System.out.print(reminder + ":");
        return scan.next();
    }

    public static double getMoney(String reminder) {
        //保存输入的变量
        Scanner scan = new Scanner(System.in);
        System.out.print(reminder + ":");
        return scan.nextDouble();
    }

    //登出提示
    public static void logoutReminder(String name) {
        System.out.println("登出成功");
        System.out.println("尊敬的 " + name +" 用户，感谢您使用中国银行.");
    }
}
