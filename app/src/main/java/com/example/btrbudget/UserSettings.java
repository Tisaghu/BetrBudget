package com.example.btrbudget;

public class UserSettings {
    // define member variables
    public String name;
    public int moneySaved;
    public int notificationSetting;

    public UserSettings(String usrName, int money, int notif)
    {
        name = usrName;
        moneySaved = money;
        notificationSetting = notif;
    }


    public UserSettings()
    {
        name = "user";
        moneySaved = 0;
        notificationSetting = -1;
    }
}
