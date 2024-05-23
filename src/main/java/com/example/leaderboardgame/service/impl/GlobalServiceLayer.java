package com.example.leaderboardgame.service.impl;

import com.example.leaderboardgame.pojo.LeaderBoard;
import com.example.leaderboardgame.repo.GlobalLeaderRepo;
import com.example.leaderboardgame.repo.LeaderBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GlobalServiceLayer {

    @Autowired
    private GlobalLeaderRepo globalLeaderRepo;

    public List<LeaderBoard> globalLeaderSerive(){

        try {
            return globalLeaderRepo.findTopByOrderByScoreDesc();
        }
        catch (Exception e){
            System.out.println("exceptions in GlobalServiceLayer : {}");
        }

        return new ArrayList<>();
    }
}
