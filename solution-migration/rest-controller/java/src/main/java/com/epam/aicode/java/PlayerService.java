package com.epam.aicode.java;

import java.util.Optional;

public interface PlayerService {

    Iterable<Player> getAllPlayers();
    Optional<Player> getPlayerById(Long id);
    Player savePlayer(Player player);
    void deletePlayer(Long id);
}
