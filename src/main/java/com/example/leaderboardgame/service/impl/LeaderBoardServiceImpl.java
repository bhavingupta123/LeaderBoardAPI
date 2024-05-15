package com.example.leaderboardgame.service.impl;

import com.example.leaderboardgame.pojo.LeaderBoard;
import com.example.leaderboardgame.repo.LeaderBoardRepository;
import com.example.leaderboardgame.rest.LeaderboardController;
import com.example.leaderboardgame.service.LeaderBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {

    @Autowired
    private LeaderBoardRepository leaderBoardRepository;

    private static final Logger logger = LoggerFactory.getLogger(LeaderBoardServiceImpl.class);

    @Override
    public List<LeaderBoard> getTop5ScoresForGameId(Long gameId) {
        logger.debug("Getting leader board info from db for : {}" , gameId);

        try {
            List<LeaderBoard> leaderBoardList =  leaderBoardRepository.findTop5ByOrderByScoreDesc(gameId);

            if(leaderBoardList.isEmpty()) {
                logger.warn("No leaderboard found for game ID: {}", gameId);
            }
            return leaderBoardList;
        }
        catch (Exception e){
            logger.error("Error occurred while finding leaderboard for game ID: {}", gameId, e);
            throw new RuntimeException("Error occurred while finding leaderboard for game ID: " + gameId, e);
        }
    }
}
