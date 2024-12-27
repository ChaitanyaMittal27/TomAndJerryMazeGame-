/**
 * Data Transfer Object (DTO) representing the game state.
 * Includes information about game progress, win/loss conditions, and cheese collection.
 */

package ca.mazegame.dto;

import ca.mazegame.model.MazeGame;

public class ApiGameDTO {
    public int gameNumber;
    public boolean isGameWon;
    public boolean isGameLost;
    public int numCheeseFound;
    public int numCheeseGoal;

    // Factory method to populate ApiGameDTO from MazeGame model
    public static ApiGameDTO fromModel(MazeGame game, int id) {
        ApiGameDTO dto = new ApiGameDTO();
        dto.gameNumber = id;
        dto.isGameWon = game.hasUserWon();
        dto.isGameLost = game.hasUserLost();
        dto.numCheeseFound = game.getNumberCheeseCollected();
        dto.numCheeseGoal = game.getNumberCheeseToCollect();
        return dto;
    }
}
