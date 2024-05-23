package com.example.leaderboardgame.rest;

import com.example.leaderboardgame.pojo.LeaderBoard;
import com.example.leaderboardgame.service.LeaderBoardService;
import com.example.leaderboardgame.service.impl.GlobalServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GlobalController {

    @Autowired
    GlobalServiceLayer globalServiceLayer;

    @GetMapping("/get/global/leaderboard")
    public ResponseEntity<?> globalLeaderBoard(){
        try {
            List<LeaderBoard> leaderBoardList = globalServiceLayer.globalLeaderSerive();
            return ResponseEntity.ok(leaderBoardList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
