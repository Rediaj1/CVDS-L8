package edu.eci.cvds.servlet.model;

public class Todo {
    private String userId;
    private String Id;
    private String title;
    private String completed;
    public Todo() {

    }
    public String getUserId(){
        return userId;
    }
    public String getId(){
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
    public void setUserId(String newUserId){
        userId = newUserId;
    }
    public String setId(){
        return Id;
    }

    
}
