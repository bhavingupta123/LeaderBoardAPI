package com.example.leaderboardgame.service;

import com.example.leaderboardgame.pojo.LeaderBoard;
import java.util.List;

/**
 * Interface for managing leaderboards.
 */
public interface LeaderBoardService {

     /**
      * Retrieves the top 5 scores for a given game ID.
      * @param gameId The ID of the game.
      * @return A list of LeaderBoard objects representing the top 5 scores.
      */
     List<LeaderBoard> getTop5ScoresForGameId(Long gameId);
}
