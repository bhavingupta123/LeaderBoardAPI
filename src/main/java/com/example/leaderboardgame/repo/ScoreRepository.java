package com.example.leaderboardgame.repo;

import com.example.leaderboardgame.pojo.LeaderBoard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing LeaderBoard entities in the database.
 */
public interface ScoreRepository extends JpaRepository<LeaderBoard, Long> {

    /**
     * Saves a LeaderBoard entity to the database.
     * @param leaderBoard The LeaderBoard entity to be saved.
     * @return The saved LeaderBoard entity.
     */
    @Override
    LeaderBoard save(LeaderBoard leaderBoard);
}
