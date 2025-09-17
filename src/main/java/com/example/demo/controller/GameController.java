package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/games") // Base URL for all endpoints
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // GET all games
    @GetMapping
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    // GET a game by ID
    @GetMapping("/{id}")
    public Game getGameById(@PathVariable String id) {
        return gameRepository.findById(id).orElse(null);
    }

    // POST a new game
    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    // PUT update a game
    @PutMapping("/{id}")
    public Game updateGame(@PathVariable String id, @RequestBody Game gameDetails) {
        Game game = gameRepository.findById(id).orElseThrow();
        game.setName(gameDetails.getName());
        game.setType(gameDetails.getType());
        return gameRepository.save(game);
    }

    // DELETE a game
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable String id) {
        gameRepository.deleteById(id);
    }
}
