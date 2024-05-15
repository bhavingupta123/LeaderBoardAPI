package com.example.leaderboardgame.pojo;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Represents a player's leaderboard entry in the game.
 */
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

    /**
     * Retrieves the unique identifier of the player's leaderboard entry.
     * @return The player's unique identifier.
     */
    public Long getPlayerId() {
        return playerId;
    }

    /**
     * Sets the unique identifier of the player's leaderboard entry.
     * @param id The player's unique identifier.
     */
    public void setPlayerId(Long id) {
        this.playerId = id;
    }

    /**
     * Retrieves the name of the player associated with the leaderboard entry.
     * @return The player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the player associated with the leaderboard entry.
     * @param name The player's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the score achieved by the player in the game.
     * @return The player's score.
     */
    public Long getScore() {
        return score;
    }

    /**
     * Sets the score achieved by the player in the game.
     * @param score The player's score.
     */
    public void setScore(Long score) {
        this.score = score;
    }

    /**
     * Retrieves the unique identifier of the game associated with the leaderboard entry.
     * @return The game's unique identifier.
     */
    public Long getGameId() {
        return gameId;
    }

    /**
     * Sets the unique identifier of the game associated with the leaderboard entry.
     * @param gameId The game's unique identifier.
     */
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    /**
     * Overrides the default toString method to provide a string representation of the LeaderBoard object.
     * @return A string representation of the LeaderBoard object.
     */
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
