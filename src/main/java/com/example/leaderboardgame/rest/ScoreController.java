package com.example.leaderboardgame.rest;

import com.example.leaderboardgame.pojo.LeaderBoard;
import com.example.leaderboardgame.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * REST controller for managing score-related operations.
 */
@RestController
@RequestMapping("/api")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    /**
     * Endpoint to save a player's score.
     *
     * @param score The LeaderBoard object containing the player's score information.
     * @return A ResponseEntity indicating the success or failure of the operation.
     */
    @PostMapping("/save/score")
    public ResponseEntity<String> saveScore(@RequestBody @Valid LeaderBoard score) {
        try {
            scoreService.saveScore(score);
            return ResponseEntity.status(HttpStatus.CREATED).body("Score saved successfully");
        } catch (IllegalArgumentException e) {
            // Handle validation errors
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save score");
        }
    }
}