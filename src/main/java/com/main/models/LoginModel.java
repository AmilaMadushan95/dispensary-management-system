package com.main.models;

import com.common.AlertDialog;
import com.common.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Damsith on 8/12/2017.
 */
public class LoginModel {

    private static String user;

    public static void setUser(String username){
        user = username;
    }

    public static String getUser(){
        return LoginModel.user;
    }

}
