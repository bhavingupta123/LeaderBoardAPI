package com.example.leaderboardgame.service.impl;

import com.example.leaderboardgame.pojo.LeaderBoard;
import com.example.leaderboardgame.repo.LeaderBoardRepository;
import com.example.leaderboardgame.service.LeaderBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementation of the LeaderBoardService interface.
 */
@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {

    @Autowired
    private LeaderBoardRepository leaderBoardRepository;

    private static final Logger logger = LoggerFactory.getLogger(LeaderBoardServiceImpl.class);

    /**
     * Retrieves the top 5 leaderboard entries for a given game ID.
     * @param gameId The ID of the game for which leaderboard entries are to be retrieved.
     * @return A list of the top 5 leaderboard entries for the specified game.
     * @throws RuntimeException if an error occurs while retrieving the leaderboard entries.
     */
    @Override
    public List<LeaderBoard> getTop5ScoresForGameId(Long gameId) {
        logger.debug("Getting leaderboard info from database for game ID: {}", gameId);

        try {
            List<LeaderBoard> leaderBoardList =  leaderBoardRepository.findTop5ByOrderByScoreDesc(gameId);

            if(leaderBoardList.isEmpty()) {
                logger.warn("No leaderboard found for game ID: {}", gameId);
            }
            return leaderBoardList;
        } catch (Exception e) {
            logger.error("Error occurred while finding leaderboard for game ID: {}", gameId, e);
            throw new RuntimeException("Error occurred while finding leaderboard for game ID: " + gameId, e);
        }
    }
}
