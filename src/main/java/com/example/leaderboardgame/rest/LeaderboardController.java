package com.example.leaderboardgame.rest;

import com.example.leaderboardgame.pojo.LeaderBoard;
import com.example.leaderboardgame.service.LeaderBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeaderboardController {

    private static final Logger logger = LoggerFactory.getLogger(LeaderboardController.class);

    @Autowired
    LeaderBoardService leaderBoardService;

    @RequestMapping("/get/leaderboard/{gameId}")
    public ResponseEntity<List<LeaderBoard>> getLeaderBoardForAGame(@Validated @PathVariable("gameId") Long gameId, Model model){
        logger.info("Getting leaderboard for gameId: {}", gameId);

        try {
            List<LeaderBoard> leaderBoardList = leaderBoardService.getTop5ScoresForGameId(gameId);
            return ResponseEntity.ok(leaderBoardList);
        } catch (Exception e) {
            logger.error("Error occurred while getting leaderboard for game ID: {}", gameId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
