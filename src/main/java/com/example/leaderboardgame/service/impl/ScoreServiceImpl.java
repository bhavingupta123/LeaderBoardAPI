package com.example.leaderboardgame.service.impl;

import com.example.leaderboardgame.pojo.LeaderBoard;
import com.example.leaderboardgame.repo.ScoreRepository;
import com.example.leaderboardgame.service.ScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of the ScoreService interface.
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    private static final Logger logger = LoggerFactory.getLogger(ScoreServiceImpl.class);

    @Autowired
    private ScoreRepository scoreRepository;

    /**
     * Saves the score of a player for a particular game.
     * @param leaderBoard The LeaderBoard object representing the player's score and game details.
     * @throws IllegalArgumentException if the LeaderBoard object is null, or if any of its fields are invalid.
     * @throws RuntimeException if an error occurs while saving the score.
     */
    @Override
    @Transactional
    public void saveScore(LeaderBoard leaderBoard) {
        // Check if LeaderBoard is null
        if (leaderBoard == null) {
            throw new IllegalArgumentException("LeaderBoard object is null");
        }

        // Check if playerName is empty or null
        if (leaderBoard.getName() == null || leaderBoard.getName().isEmpty()) {
            throw new IllegalArgumentException("Player name is required");
        }

        // Check if gameId is null or <= 0
        if (leaderBoard.getGameId() == null || leaderBoard.getGameId() <= 0) {
            throw new IllegalArgumentException("Invalid game ID");
        }

        // Check if score is null or < 0
        if (leaderBoard.getScore() == null || leaderBoard.getScore() < 0) {
            throw new IllegalArgumentException("Invalid score");
        }

        logger.info("Saving score for: {}", leaderBoard);

        // Save the score
        try {
            scoreRepository.save(leaderBoard);
        } catch (Exception e) {
            logger.error("Error saving score: {}", e.getMessage());
            throw new RuntimeException("Error saving score");
        }
    }
}
