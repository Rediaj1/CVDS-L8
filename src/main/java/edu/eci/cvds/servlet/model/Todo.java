package edu.eci.cvds.servlet.model;

public class Todo {
    private int userId;
    private int Id;
    private String title;
    private String completed;
    public Todo() {

    }
    public int getUserId(){
        return userId;
    }
    public int getId(){
        return Id;
    }
    public String getTitle(){
        return title;
    }
    public String getCompleted(){ 
        return completed;
    } 
    public void setTitle(String newTittle){
        title = newTittle;
    }
    public void setCompleted(String newCompleted){ 
        completed = newCompleted;
    }
    public void setUserId(int newUserId){
        userId = newUserId;
    }
    public int setId(){
        return Id;
    }

    
}
