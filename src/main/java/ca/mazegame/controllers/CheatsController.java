/**
 * Controller for managing cheat-related API endpoints.
 */

package ca.mazegame.controllers;

import ca.mazegame.model.MazeGame;
import ca.mazegame.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class CheatsController {
    private final GameService gameService;

    public CheatsController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/{id}/cheatstate")
    public ResponseEntity<String> activateCheat(@PathVariable int id, @RequestBody String cheat) {
        MazeGame game = gameService.getGameById(id);
        if (game == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
        }

        switch (cheat) {
            case "1_CHEESE":
                game.setNumberCheeseToCollect(1);
                break;
            case "SHOW_ALL":
                game.setAllCellsVisible();
                break;
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid cheat code");
        }

        return ResponseEntity.accepted().build();
    }
}
