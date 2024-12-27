/**
 * Controller for managing move-related API endpoints.
 */

package ca.mazegame.controllers;

import ca.mazegame.model.MazeGame;
import ca.mazegame.model.MoveDirection;
import ca.mazegame.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class MovesController {
    private final GameService gameService;

    public MovesController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/{id}/moves")
    public ResponseEntity<String> makeMove(@PathVariable int id, @RequestBody String move) {
        //System.out.println("Received move: " + move);

        MazeGame game = gameService.getGameById(id);
        if (game == null) {
            //System.out.println("Game not found for ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game not found");
        }

        if (game.hasUserWon() || game.hasUserLost()) {
            //System.out.println("Game is already over");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Game is already over");
        }

        try {
            if ("MOVE_CATS".equals(move)) {
                game.doCatMoves();
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Cats moved");
            }

            MoveDirection direction = MoveDirection.valueOf(move);
            if (!game.isValidPlayerMove(direction)) {
                //System.out.println("Invalid move direction: " + direction);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid move");
            }

            game.recordPlayerMove(direction);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Move processed");
        } catch (IllegalArgumentException e) {
            //System.out.println("Invalid move received: " + move);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid move");
        }
    }
}
