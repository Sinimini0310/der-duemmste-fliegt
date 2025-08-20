package de.derduemmstefliegt.backend.model;

import java.util.UUID;

public class Player {
    private final String id = UUID.randomUUID().toString();
    private final String name;
    private int hearts;
    private final boolean host;

    public Player(String name, int hearts, boolean host) {
        this.name = name;
        this.hearts = hearts;
        this.host = host;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHearts() {
        return hearts;
    }

    public boolean isHost() {
        return host;
    }

    public void loseHeart() {
        hearts = Math.max(0, hearts - 1);
    }
}

