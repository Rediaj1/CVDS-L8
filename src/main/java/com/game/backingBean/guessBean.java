package com.game.backingBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Random;
@ManagedBean(name = "guessBean")
@ApplicationScoped
public class guessBean{
    private int guessNumber;
    private int numberAttemp;
    private int attempts;
    private int prize;
    private String state;
    private ArrayList<Integer> numbers;
    public guessBean(){
        restart();
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
    public int getNumberAttemp(){
        return numberAttemp;
    }
    public void setNumberAttemp(int numberAttemps){
        numberAttemp = numberAttemps;
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
    public void guess() {
        if (prize == 0) {
            state = "Reinicie el juego";
        }
        else if (numberAttemp == guessNumber) {
            state = "Has ganado " + String.valueOf(prize) + "$";
        }
        else {
            attempts++;
            numbers.add(numberAttemp);
            prize -= 10000;
            if (prize == 0) {
                state = "Has perdido";
            }
        }
    }
    public ArrayList<Integer> getNumbers(){
        return numbers;
    }
    public void restart() {
        attempts = 0;
        numbers = new ArrayList<>();
        prize = 100000;
        state = "Jugando";
        Random random = new Random();
        guessNumber = random.nextInt(100) + 1;
    }    
}
