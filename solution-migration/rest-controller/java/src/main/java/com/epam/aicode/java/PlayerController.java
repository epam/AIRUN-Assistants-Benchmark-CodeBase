package com.epam.aicode.java;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private static final Logger LOGGER = Logger.getLogger(PlayerController.class.getName());

    private static final String PLAYER_MAIN_PAGE = "player/player-main";
    private static final String PLAYER_ADD_PAGE = "player/player-add";
    private static final String PLAYER_DETAILS_PAGE = "player/player-details";
    private static final String PLAYER_ATTRIBUTE = "player";
    private static final String PLAYERS_ATTRIBUTE = "players";
    private static final String REDIRECT_TO_PLAYER = "redirect:/player";

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String getPlayers(Model model) {
        model.addAttribute(PLAYERS_ATTRIBUTE, playerService.getAllPlayers());
        return PLAYER_MAIN_PAGE;
    }

    @PostMapping("/add")
    public String addPlayer(@ModelAttribute Player player, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(PLAYER_ATTRIBUTE, player);
            return PLAYER_ADD_PAGE;
        }
        playerService.savePlayer(player);
        LOGGER.log(Level.INFO, "Player " + player.getSurname() + " " + player.getName()
                + " with ID " + player.getId() + " has been saved in the DB");
        return REDIRECT_TO_PLAYER;
    }

    @GetMapping("/{id}")
    public String getPlayerById(@PathVariable("id") Long id, Model model) {
        Player player = playerService.getPlayerById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player by ID not found"));

        model.addAttribute(PLAYER_ATTRIBUTE, player);
        return PLAYER_DETAILS_PAGE;
    }

    @PostMapping("/{id}/edit")
    public String updatePlayer(@ModelAttribute Player player, Model model) {
        playerService.savePlayer(player);
        LOGGER.log(Level.INFO, "Player " + player.getSurname() + " " + player.getName() + " with ID " +
            player.getId() + " has been updated in the DB");

        model.addAttribute(PLAYER_ATTRIBUTE, player);
        return PLAYER_DETAILS_PAGE;
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable("id") Long id) {
        Player player = playerService.getPlayerById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player by ID not found"));
        playerService.deletePlayer(id);
        LOGGER.log(Level.INFO, "Player " + player.getSurname() + " " + player.getName() + " with ID " +
            player.getId() + " was REMOVED from DB");
        return REDIRECT_TO_PLAYER;
    }
}