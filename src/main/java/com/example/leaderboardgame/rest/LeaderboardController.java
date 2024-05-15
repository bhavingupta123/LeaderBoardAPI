package com.example.leaderboardgame.rest;

import com.example.leaderboardgame.pojo.LeaderBoard;
import com.example.leaderboardgame.service.LeaderBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * REST controller for managing leaderboard operations.
 */
@RestController
@RequestMapping("/api")
public class LeaderboardController {

    private static final Logger logger = LoggerFactory.getLogger(LeaderboardController.class);

    @Autowired
    LeaderBoardService leaderBoardService;

    /**
     * Endpoint to retrieve leaderboard for a specific game.
     *
     * @param gameId The ID of the game for which leaderboard is requested.
     * @param model  The UI model (unused in this endpoint).
     * @return A ResponseEntity containing the leaderboard data or an error response.
     */
    @GetMapping("/get/leaderboard")
    public ResponseEntity<List<LeaderBoard>> getLeaderBoardForAGame(
            @NotNull(message = "Game ID cannot be null") @RequestParam("gameId") Long gameId,
            Model model
    ) {
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
