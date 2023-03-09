package com.game.backingBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Random;
@ManagedBean(name = "guessBean")
@ApplicationScoped
public class guessBean {
    private int guessNumber;
    private int numberAttemp;
    private int attempts;
    private int prize;
    private String state;
    public guessBean(){
        attempts = 0;
        prize = 100000;
        state = "No ha ganado";
        Random random = new Random();
        guessNumber = random.nextInt(100) + 1;
    }
    public int getAttempts(){
        return attempts;
    }
    public int getPrize(){
        return prize;
    }
    public int getGuessNumber(){
        return guessNumber;
    }
    public String getState(){
        return state;
    }
    public int numberAttemp(){
        return numberAttemp;
    }
    public void setnumberAttemp(int numberAttemps){
        attempts = numberAttemps;
    }
    public void setAttempts(int newAttempt){
        attempts = newAttempt;
    }
    public void setPrize(int newPrize){
        prize = newPrize;
    }
    public void setGuessNumber(){
        Random random = new Random();
        guessNumber = random.nextInt(100) + 1;
    }
    public void setState(String newState){
        state = newState;
    }
    public void gess(int attemp) {
        if (attemp == guessNumber) {
            state = "Has ganado " + String.valueOf(prize) + "$";
            restart();
        }
        else {
            attempts++;
            prize -= 10000;
            if (prize == 0) {
                state = "Has perdido";
                restart();
            }
        }
    }
    public void restart() {
        attempts = 0;
        prize = 100000;
        state = "No ha ganado";
        Random random = new Random();
        guessNumber = random.nextInt(100) + 1;
    }
    
}
