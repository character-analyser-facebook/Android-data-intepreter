package com.example.sanjeev.intelligentorganizer;

public class SingletonCredentials {
    private static SingletonCredentials singletonCredentials= null;
    private static boolean fbLoggedIn = false;
    private static String userName = null;

    private SingletonCredentials(){
    }

    public static SingletonCredentials getSingletonCredentials() {
        if(singletonCredentials == null) {
            singletonCredentials = new SingletonCredentials();
        }
        return singletonCredentials;
    }

    public static boolean isFbLoggedIn() {
        return fbLoggedIn;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setFbLoggedIn(boolean fbLoggedIn) {
        SingletonCredentials.fbLoggedIn = fbLoggedIn;
    }

    public static void setUserName(String userName) {
        SingletonCredentials.userName = userName;
    }
}