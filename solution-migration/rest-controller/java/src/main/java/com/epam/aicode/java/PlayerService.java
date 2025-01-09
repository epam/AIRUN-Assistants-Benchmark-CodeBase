package com.epam.aicode.java;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    List<Player> getAllPlayers();
    Optional<Player> getPlayerById(Long id);
    Player savePlayer(Player player);
    void deletePlayer(Long id);
}
