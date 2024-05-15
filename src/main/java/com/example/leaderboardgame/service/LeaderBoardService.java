package com.example.leaderboardgame.service;

import com.example.leaderboardgame.pojo.LeaderBoard;

import java.util.List;

public interface LeaderBoardService {
     List<LeaderBoard> getTop5ScoresForGameId(Long gameId);
}
