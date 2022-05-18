package com.example.rentagym.Customer;

public class User {
    public String email;
    public String username;
    public UsersRooms activeRooms;
    public String accountType;

    public User(){
        this.email = "";
        this.username = "";

        this.accountType = "";
    }

    public User(String username, String accountType){
        this.username = username;
        this.accountType = accountType;
    }

    public UsersRooms getUsersRooms(){
        return this.activeRooms;
    }

    public void setUsersRooms(UsersRooms activeRooms){
        this.activeRooms = activeRooms;
    }


}