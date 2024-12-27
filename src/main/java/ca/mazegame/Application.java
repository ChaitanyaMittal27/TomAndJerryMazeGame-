/**
 * Entry point for the Maze Game REST API application.
 * Configures and starts the Spring Boot application.
 */

package ca.mazegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}