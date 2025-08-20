package de.derduemmstefliegt.backend.dto;

import de.derduemmstefliegt.backend.model.GameSettings;

public record CreateLobbyRequest(String hostName, GameSettings settings) {}

