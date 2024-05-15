package com.example.leaderboardgame.pojo;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class LeaderBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long playerId;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false)
    @NotNull
    private Long score;

    @Column(nullable = false)
    @NotNull
    private Long gameId;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long id) {
        this.playerId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "LeaderBoard{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", gameId=" + gameId +
                '}';
    }
}
