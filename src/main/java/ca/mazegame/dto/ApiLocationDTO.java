/**
 * Data Transfer Object (DTO) representing a location in the maze.
 * Encapsulates x and y coordinates.
 */

package ca.mazegame.dto;

import ca.mazegame.model.CellLocation;

public class ApiLocationDTO {
    public int x;
    public int y;

    public static ApiLocationDTO fromModel(CellLocation location) {
        ApiLocationDTO dto = new ApiLocationDTO();
        dto.x = location.getX();
        dto.y = location.getY();
        return dto;
    }

}
