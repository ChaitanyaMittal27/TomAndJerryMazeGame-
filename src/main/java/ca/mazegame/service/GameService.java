/**
 * Service layer for managing games in the maze game API.
 * Provides methods for creating and retrieving games.
 */

package ca.mazegame.service;

import ca.mazegame.model.MazeGame;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private final List<MazeGame> games = new ArrayList<>();

    public List<MazeGame> getGames() {
        return games;
    }

    public MazeGame getGameById(int id) {
        if (id < 0 || id >= games.size()) {
            return null; // Or throw an exception if needed
        }
        return games.get(id);
    }

    public void addGame(MazeGame game) {
        games.add(game);
    }
}
