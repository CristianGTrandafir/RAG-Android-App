package com.example.rentagym.Customer;

public class ChatRoom {
    public ChatMessage message;
    public String firstUser;
    public String secondUser;

    ChatRoom(){

    }

    ChatRoom(ChatMessage message, String firstUser, String secondUser){
        this.message = message;
        this.firstUser = firstUser;
        this.secondUser = secondUser;
    }

}
