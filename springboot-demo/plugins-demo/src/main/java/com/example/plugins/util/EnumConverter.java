package com.example.plugins.util;

/**
 * @Description:
 * @Author: Chenyang on 2025/03/31 21:37
 * @Version: 1.0
 */
public class EnumConverter {

    public static String formatGender(String raw) {
        String gender = "";
        switch (raw) {
            case "M":
                gender = "男性";
                break;
            case "F":
                gender = "女性";
                break;
            default:
                gender = "未知";
        }
        return gender;
    }

    public static String formatJob(String raw) {
        String job = "";
        switch (raw) {
            case "0":
                job = "银行职员";
                break;
            case "1":
                job = "程序员";
                break;
            case "2":
                job = "警察";
                break;
            default:
                job = "未知";
        }
        return job;
    }

    public static String convertGender(String raw) {
        String gender = "";
        switch (raw) {
            case "男性":
                gender = "M";
                break;
            case "女性":
                gender = "F";
                break;
        }
        return gender;
    }

    public static String convertJob(String raw) {
        String job = "";
        switch (raw) {
            case "银行职员":
                job = "0";
                break;
            case "程序员":
                job = "1";
                break;
            case "警察":
                job = "2";
                break;
        }
        return job;
    }
}
