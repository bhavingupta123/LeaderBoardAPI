package com.example.leaderboardgame.exceptions;

public class InvalidGameIdException extends RuntimeException{

    public InvalidGameIdException(String message){
        super(message);
    }
}
