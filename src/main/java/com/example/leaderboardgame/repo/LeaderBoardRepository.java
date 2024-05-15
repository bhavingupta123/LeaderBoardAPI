package com.example.leaderboardgame.repo;

import com.example.leaderboardgame.pojo.LeaderBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for managing LeaderBoard entities in the database.
 */
public interface LeaderBoardRepository extends JpaRepository<LeaderBoard, Long> {

    /**
     * Retrieves the top 5 leaderboard entries for a given game ID, ordered by score in descending order.
     * @param gameId The ID of the game for which leaderboard entries are to be retrieved.
     * @return A list of the top 5 leaderboard entries for the specified game.
     */
    @Query("SELECT s FROM LeaderBoard s WHERE s.gameId = :gameId ORDER BY s.score DESC")
    List<LeaderBoard> findTop5ByOrderByScoreDesc(Long gameId);
}
