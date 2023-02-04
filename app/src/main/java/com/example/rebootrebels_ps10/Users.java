package com.example.rebootrebels_ps10;

public class Users {
    String email,username,passwordMatch;
    int qScore,tScore;

    public Users() {
    }

    public Users(String email, String password, String name,  int quiz_score, int task_score) {
        this.email = email;
        this.passwordMatch=password;
        this.username = name;
        this.qScore = quiz_score;
        this.tScore = task_score;
    }
    public String getUsername(){return username;}
    public void setUsername(String username){
        this.username=username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword() {
        return passwordMatch;
    }
    public void setPasswordMatch(String passwordMatch){
        this.passwordMatch=passwordMatch;
    }
    public int getqScore(){return qScore ;}
    public void setqScore(int qScore){
        this.qScore=qScore;
    }
    public int gettScore() {
        return tScore;
    }
    public void settScore(int tScore){
        this.tScore=tScore;
    }

}
