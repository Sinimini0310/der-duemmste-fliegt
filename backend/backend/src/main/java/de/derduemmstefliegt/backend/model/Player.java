package de.derduemmstefliegt.backend.model;

public class Player {
    private final String id;
    private final String name;
    private final String avatar;

    public Player(String id, String name, String avatar) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }
}
