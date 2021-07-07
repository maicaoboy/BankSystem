package com.neu.pojo.SAccount;

import com.neu.pojo.Account;

//信用账户
public class CheckingAccount extends Account {
    //实际账户
    private SavingAccount saving;

    //setter / getter
    public SavingAccount getSaving() {
        return saving;
    }

    public void setSaving(SavingAccount saving) {
        this.saving = saving;
    }

    //构造函数，信用账户被默认未100000
    public CheckingAccount() {
        super(100000);
        this.saving = new SavingAccount();
    }
}
