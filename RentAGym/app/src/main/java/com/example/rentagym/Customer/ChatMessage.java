package com.example.rentagym.Customer;



public class ChatMessage {
    public String message;
    public String fromUser;

    public ChatMessage(){
        this.message = "";
        this.fromUser = "";
    }

    public ChatMessage(String fromUser, String message){
        this.message = message;
        this.fromUser = fromUser;

    }

}
