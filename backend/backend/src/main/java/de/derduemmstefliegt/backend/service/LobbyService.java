package de.derduemmstefliegt.backend.service;

import de.derduemmstefliegt.backend.model.Lobby;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LobbyService {
    private final Map<String, Lobby> lobbies = new ConcurrentHashMap<>();
    private final Map<String, Object> defaultRules;

    public LobbyService() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Path configPath = Paths.get("../shared/config/default.config.json").toAbsolutePath().normalize();
        Map<String, Object> config = mapper.readValue(Files.newBufferedReader(configPath), Map.class);
        this.defaultRules = (Map<String, Object>) config.get("game");
    }

    public Map<String, String> createLobby() {
        String code;
        do {
            code = randomCode();
        } while (lobbies.containsKey(code));
        String token = UUID.randomUUID().toString();
        Lobby lobby = new Lobby(code, token, new HashMap<>(defaultRules));
        lobbies.put(code, lobby);
        Map<String, String> response = new HashMap<>();
        response.put("code", code);
        response.put("adminToken", token);
        return response;
    }

    public Lobby getLobby(String code) {
        Lobby lobby = lobbies.get(code);
        if (lobby == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lobby not found");
        }
        return lobby;
    }

    public Lobby updateRules(String code, Map<String, Object> rules) {
        Lobby lobby = getLobby(code);
        lobby.setRules(rules);
        return lobby;
    }

    private String randomCode() {
        return UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }
}
