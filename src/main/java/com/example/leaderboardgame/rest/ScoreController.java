package com.example.leaderboardgame.rest;

import com.example.leaderboardgame.pojo.LeaderBoard;
import com.example.leaderboardgame.service.ScoreService;
import com.example.leaderboardgame.service.impl.LeaderBoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @PostMapping("save/score")
    public ResponseEntity<String> saveScore(@RequestBody LeaderBoard score) {
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
