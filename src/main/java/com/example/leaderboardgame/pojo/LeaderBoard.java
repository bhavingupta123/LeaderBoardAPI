package com.example.leaderboardgame.pojo;

import jakarta.persistence.*;

@Entity
public class LeaderBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long playerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long score;

    @Column(nullable = false)
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
