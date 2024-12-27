/**
 * Data Transfer Object (DTO) representing the board state.
 * Contains details about the board's dimensions, visibility, walls, and item positions.
 */

package ca.mazegame.dto;

import ca.mazegame.model.CellLocation;
import ca.mazegame.model.MazeGame;
import java.util.List;
import java.util.stream.Collectors;

public class ApiBoardDTO {
    public int boardWidth;
    public int boardHeight;
    public ApiLocationDTO mouseLocation;
    public ApiLocationDTO cheeseLocation;
    public List<ApiLocationDTO> catLocations;
    public boolean[][] hasWalls;
    public boolean[][] isVisible;

    public static ApiBoardDTO fromModel(MazeGame game) {
        ApiBoardDTO dto = new ApiBoardDTO();

        // Board dimensions
        dto.boardWidth = MazeGame.getMazeWidth();
        dto.boardHeight = MazeGame.getMazeHeight();

        // Mouse and cheese locations
        dto.mouseLocation = ApiLocationDTO.fromModel(game.getPlayerLocation());
        dto.cheeseLocation = ApiLocationDTO.fromModel(game.getCheeseLocation());

        // Cat locations
        dto.catLocations = game.getCats().stream()
                .map(cat -> ApiLocationDTO.fromModel(cat.getLocation()))
                .collect(Collectors.toList());

        // Wall and visibility data
        dto.hasWalls = generateWallData(game);
        dto.isVisible = generateVisibilityData(game);

        return dto;
    }

    // Helper method to generate wall data
    private static boolean[][] generateWallData(MazeGame game) {
        int width = MazeGame.getMazeWidth();
        int height = MazeGame.getMazeHeight();
        boolean[][] walls = new boolean[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                CellLocation location = new CellLocation(x, y);
                walls[y][x] = game.getCellState(location).isWall();
            }
        }
        return walls;
    }

    // Helper method to generate visibility data
    private static boolean[][] generateVisibilityData(MazeGame game) {
        int width = MazeGame.getMazeWidth();
        int height = MazeGame.getMazeHeight();
        boolean[][] visibility = new boolean[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                CellLocation location = new CellLocation(x, y);
                visibility[y][x] = game.getCellState(location).isVisible();
            }
        }
        return visibility;
    }
}
