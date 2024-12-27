/**
 * Controller for managing board-related API endpoints.
 */

package ca.mazegame.controllers;

import ca.mazegame.dto.ApiBoardDTO;
import ca.mazegame.model.MazeGame;
import ca.mazegame.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class BoardController {
    private final GameService gameService;

    public BoardController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/{id}/board")
    public ResponseEntity<ApiBoardDTO> getBoard(@PathVariable int id) {
        MazeGame game = gameService.getGameById(id);
        if (game == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        ApiBoardDTO dto = ApiBoardDTO.fromModel(game);
        return ResponseEntity.ok(dto);
    }
}
