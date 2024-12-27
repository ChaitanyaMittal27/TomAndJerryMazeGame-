/**
 * Handles API endpoints related to game management.
 */

package ca.mazegame.controllers;

import ca.mazegame.dto.ApiGameDTO;
import ca.mazegame.model.MazeGame;
import ca.mazegame.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<ApiGameDTO> getAllGames() {
        return gameService.getGames().stream()
                .map(game -> ApiGameDTO.fromModel(game, gameService.getGames().indexOf(game)))
                .toList();
    }

    @PostMapping
    public ResponseEntity<ApiGameDTO> createGame() {
        MazeGame newGame = new MazeGame();
        gameService.addGame(newGame);
        int gameId = gameService.getGames().size() - 1;
        ApiGameDTO dto = ApiGameDTO.fromModel(newGame, gameId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiGameDTO> getGameAPIGameDTO(@PathVariable int id) {
        MazeGame game = gameService.getGameById(id);
        if (game == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        ApiGameDTO dto = ApiGameDTO.fromModel(game, id);
        return ResponseEntity.ok(dto);
    }
}
