package de.derduemmstefliegt.backend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Lobby {
    private final String id = UUID.randomUUID().toString().substring(0, 6);
    private final GameSettings settings;
    private final List<Player> players = new ArrayList<>();
    private final List<Player> spectators = new ArrayList<>();

    public Lobby(GameSettings settings) {
        this.settings = settings;
    }

    public String getId() {
        return id;
    }

    public GameSettings getSettings() {
        return settings;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Player> getSpectators() {
        return spectators;
    }
}

