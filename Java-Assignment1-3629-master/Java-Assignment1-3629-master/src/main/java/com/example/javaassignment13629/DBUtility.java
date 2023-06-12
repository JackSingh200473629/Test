package com.example.javaassignment13629;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DBUtility {

    private Connection connection;
    private String host;
    private String user;
    private String password;
    private String database;

    public DBUtility(String host, String user, String password, String database){
        this.host = host;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    public void connect(){
        try{
            String url = "jdbc:mysql://"+host+"/"+database;
            connection = DriverManager.getConnection(url, username, password);
        }catch(SQlException e){
            System.out.println("Connection Error " + e.getMessage());;
        }
    }

    public void getStats(){
        if(connection == null){
            System.out.println("Not connected");
            return;
        }

        try{
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM gym_membership_yearly";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Object stats = new Object(resultSet.getInt("id"), resultSet.getInt("year"), resultSet.getDouble("number_of_memberships"));
                System.out.println(stats);
            }

            statement.close();
            resultSet.close();
        }catch(SQLException e){
            System.out.println("Error " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String host = "172.31.22.43";
        try{
            String user = DBCreds.findUser();
            String password = DBCreds.findPass();
        }catch(IOException){
            e.printStackTrace;
        }
        String database = "assignemnt1jdk";

        DBUtility = dbUtility = new DBUtility(host, user, password, database);
        dbUtility.connect();
        dbUtility.getStats();
    }
}