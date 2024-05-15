package com.example.leaderboardgame.repo;

import com.example.leaderboardgame.pojo.LeaderBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LeaderBoardRepository extends JpaRepository<LeaderBoard, Long> {
    @Query("SELECT s FROM LeaderBoard s WHERE s.gameId = :gameId ORDER BY s.score DESC")
    List<LeaderBoard> findTop5ByOrderByScoreDesc(Long gameId);
}
