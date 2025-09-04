package de.derduemmstefliegt.backend.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class QuestionsController {
    private final Object questions;

    public QuestionsController() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Path path = Paths.get("../shared/questions/questions.json").toAbsolutePath().normalize();
        this.questions = mapper.readValue(Files.newBufferedReader(path), Map.class);
    }

    @GetMapping("/api/questions")
    public Object getQuestions() {
        return questions;
    }
}
