package de.derduemmstefliegt.backend.controller;

import de.derduemmstefliegt.backend.model.Lobby;
import de.derduemmstefliegt.backend.service.LobbyService;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lobbies")
public class LobbiesController {
    private final LobbyService lobbyService;

    public LobbiesController(LobbyService lobbyService) {
        this.lobbyService = lobbyService;
    }

    @PostMapping
    public Map<String, String> createLobby() {
        return lobbyService.createLobby();
    }

    @GetMapping("/{code}")
    public Lobby getLobby(@PathVariable String code) {
        return lobbyService.getLobby(code);
    }

    @PostMapping("/{code}/rules")
    public Lobby updateRules(@PathVariable String code, @RequestBody Map<String, Object> rules) {
        return lobbyService.updateRules(code, rules);
    }
}
