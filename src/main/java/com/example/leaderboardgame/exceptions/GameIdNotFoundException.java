package com.example.leaderboardgame.exceptions;

public class GameIdNotFoundException extends RuntimeException{

    public GameIdNotFoundException(String message){
        super(message);
    }
}
