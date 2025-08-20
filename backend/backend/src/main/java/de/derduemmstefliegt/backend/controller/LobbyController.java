package de.derduemmstefliegt.backend.controller;

import de.derduemmstefliegt.backend.dto.CreateLobbyRequest;
import de.derduemmstefliegt.backend.dto.JoinLobbyRequest;
import de.derduemmstefliegt.backend.model.Lobby;
import de.derduemmstefliegt.backend.model.Player;
import de.derduemmstefliegt.backend.model.Question;
import de.derduemmstefliegt.backend.service.LobbyService;
import de.derduemmstefliegt.backend.service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LobbyController {

    private final LobbyService lobbyService;
    private final QuestionService questionService;

    public LobbyController(LobbyService lobbyService, QuestionService questionService) {
        this.lobbyService = lobbyService;
        this.questionService = questionService;
    }

    @PostMapping("/lobbies")
    public Lobby create(@RequestBody CreateLobbyRequest req) {
        return lobbyService.createLobby(req.hostName(), req.settings());
    }

    @PostMapping("/lobbies/{id}/join")
    public Player join(@PathVariable String id, @RequestBody JoinLobbyRequest req) {
        return lobbyService.joinLobby(id, req.name(), req.spectator());
    }

    @GetMapping("/lobbies/{id}")
    public Lobby get(@PathVariable String id) {
        return lobbyService.getLobby(id);
    }

    @GetMapping("/questions/random")
    public Question question(@RequestParam String lobbyId) {
        return questionService.random(lobbyId);
    }
}

