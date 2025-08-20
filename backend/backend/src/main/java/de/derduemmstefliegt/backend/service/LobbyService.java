package de.derduemmstefliegt.backend.service;

import de.derduemmstefliegt.backend.model.*;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LobbyService {

    private final Map<String, Lobby> lobbies = new ConcurrentHashMap<>();

    public Lobby createLobby(String hostName, GameSettings settings) {
        Lobby lobby = new Lobby(settings);
        Player host = new Player(hostName, settings.hearts(), true);
        lobby.getPlayers().add(host);
        lobbies.put(lobby.getId(), lobby);
        return lobby;
    }

    public Player joinLobby(String lobbyId, String name, boolean spectator) {
        Lobby lobby = lobbies.get(lobbyId);
        if (lobby == null) {
            return null;
        }
        Player player = new Player(name, lobby.getSettings().hearts(), false);
        if (spectator) {
            lobby.getSpectators().add(player);
        } else {
            lobby.getPlayers().add(player);
        }
        return player;
    }

    public Lobby getLobby(String id) {
        return lobbies.get(id);
    }
}

