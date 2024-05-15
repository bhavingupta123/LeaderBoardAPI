package com.example.leaderboardgame.repo;

import com.example.leaderboardgame.pojo.LeaderBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<LeaderBoard, Long> {

    LeaderBoard save(LeaderBoard leaderBoard);
}
