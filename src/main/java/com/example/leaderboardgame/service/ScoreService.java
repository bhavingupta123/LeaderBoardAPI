package com.example.leaderboardgame.service;

import com.example.leaderboardgame.pojo.LeaderBoard;

/**
 * Interface for managing scores.
 */
public interface ScoreService {

     /**
      * Saves a score.
      * @param leaderBoard The LeaderBoard object representing the score to be saved.
      */
     void saveScore(LeaderBoard leaderBoard);
}