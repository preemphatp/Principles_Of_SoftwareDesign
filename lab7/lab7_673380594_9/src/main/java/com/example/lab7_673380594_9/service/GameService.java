package com.example.lab7_673380594_9.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lab7_673380594_9.model.Game;
import com.example.lab7_673380594_9.repository.GameRepository;
import com.example.lab7_673380594_9.strategy.DiscountContext;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final DiscountContext discountContext;

    // Constructor Injection
    public GameService(GameRepository gameRepository, DiscountContext discountContext) {
        this.gameRepository = gameRepository;
        this.discountContext = discountContext;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with id: " + id));
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public Game updateGame(Long id, Game updatedGame) {
        Game existingGame = getGameById(id);

        existingGame.setTitle(updatedGame.getTitle());
        existingGame.setGenre(updatedGame.getGenre());
        existingGame.setPlatform(updatedGame.getPlatform());
        existingGame.setRating(updatedGame.getRating());
        existingGame.setReleaseDate(updatedGame.getReleaseDate());
        existingGame.setPrice(updatedGame.getPrice());
        existingGame.setDiscountType(updatedGame.getDiscountType());

        return gameRepository.save(existingGame);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    
    public double calculateFinalPrice(Game game) {
        return discountContext.calculatePrice(game.getPrice(), game.getDiscountType());
    }
}