# Tom & Jerry Maze Game

A fun maze game inspired by the iconic Tom and Jerry cartoon!
[Website Link](https://chaitanyamittal27.github.io/TomAndJerryMazeGame-/)

---

## Description

This project is a web-based maze game where the player controls Jerry to collect cheese while avoiding Tom. It features a Spring Boot backend with a REST API and Java-based game logic. Inspired by a university assignment, this project incorporates a playful design and customizable cheats for testing.

---

## Features

- Navigate Jerry to collect all the cheese.
- Avoid Tom to win.
- Use cheats for testing and exploration.
- Modular design with reusable components.

---

## Technologies Used

- **Frontend**:
  - HTML, CSS, Vue.js for a dynamic and interactive UI.
- **Backend**:
  - Java with Spring Boot for REST API and game logic.
- **Assets**:
  - Custom sprites and textures for a themed experience.

---

## Composition

### **Frontend**
- **Files**: `index.html`, `game.css`
- **Purpose**: The main UI of the game, including visuals, controls, and cheat functionalities.

### **Backend**
- **Language/Framework**: Java + Spring Boot
- **Purpose**:
  - Manages the game logic, including maze generation, player movement, and win/loss conditions.
  - Exposes REST API endpoints for real-time communication between the frontend and backend.

### **REST API**
- **Purpose**: Facilitates communication between the frontend and backend for:
  - Generating the maze.
  - Handling player movement.
  - Checking game state.

### **Assets**
- **Directory**: `res/`
- **Purpose**: Contains images (Jerry, Tom, cheese, walls) and sounds to enhance the user experience.

---

  ## Credits
  
  1. Inspired by a university assignment.
  2. Images sourced from google

## Future Enhancements
- **Timer and High Score Tracking**: timer and DOM storage to maintain record times and alert when new record.
- **Leaderboard**: Track multiple high scores and store them locally or in a backend.
- **Enhanced Animations**: Add animations for game events (e.g., cheese collected, win/loss).
- **Sound Effects**: Play unique sounds for key events like collecting cheese or losing.
- **Responsive Design**: Improve layout for mobile and smaller screens.

## Update:
With recent changes [deployment at gh pages](https://chaitanyamittal27.github.io/TomAndJerryMazeGame-/) failed. Please clone the main and run the Application.java (src/java/ca/mazegame/Application.java)
