package de.derduemmstefliegt.backend.model;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lobby {
    private final String code;
    private final String adminToken;
    private Map<String, Object> rules;
    private final List<Player> players = new CopyOnWriteArrayList<>();

    public Lobby(String code, String adminToken, Map<String, Object> rules) {
        this.code = code;
        this.adminToken = adminToken;
        this.rules = rules;
    }

    public String getCode() {
        return code;
    }

    public String getAdminToken() {
        return adminToken;
    }

    public Map<String, Object> getRules() {
        return rules;
    }

    public void setRules(Map<String, Object> rules) {
        this.rules = rules;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
