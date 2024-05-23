package com.example.leaderboardgame.repo;

import com.example.leaderboardgame.pojo.LeaderBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GlobalLeaderRepo extends JpaRepository<LeaderBoard, Long> {

    @Query("SELECT s FROM LeaderBoard s ORDER BY s.score DESC LIMIT 5")
    List<LeaderBoard> findTopByOrderByScoreDesc();
}
