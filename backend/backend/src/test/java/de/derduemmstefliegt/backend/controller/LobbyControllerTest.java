package de.derduemmstefliegt.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LobbyControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void createAndJoinLobby() throws Exception {
        String body = "{\"hostName\":\"Alice\",\"settings\":{\"hearts\":3,\"roundSeconds\":120,\"spectatorVoting\":true}}";
        var result = mvc.perform(post("/api/lobbies").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andReturn();
        String lobbyId = mapper.readTree(result.getResponse().getContentAsString()).get("id").asText();
        String joinBody = "{\"name\":\"Bob\",\"spectator\":false}";
        mvc.perform(post("/api/lobbies/" + lobbyId + "/join").contentType(MediaType.APPLICATION_JSON).content(joinBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Bob"));
    }
}

