/**
 * Handles general API endpoints (e.g., about information).
 */

package ca.mazegame.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GeneralController {
    private final String name = "Anonymouse";

    //GET /api/about
    @GetMapping("/about")
    public String getHelloMessage() {
        return name;
    }
}
