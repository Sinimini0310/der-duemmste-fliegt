package de.derduemmstefliegt.backend.service;

import de.derduemmstefliegt.backend.model.Question;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class QuestionService {

    private final List<Question> questions = new ArrayList<>();
    private final Map<String, Queue<Question>> used = new HashMap<>();

    public QuestionService() throws IOException {
        var resource = new ClassPathResource("questions.json");
        try (var is = resource.getInputStream()) {
            var scanner = new Scanner(is).useDelimiter("\\A");
            String json = scanner.hasNext() ? scanner.next() : "[]";
            String[] arr = json.replace("[", "").replace("]", "").replace("\"", "").split(",");
            for (String q : arr) {
                if (!q.isBlank()) {
                    questions.add(new Question(q.trim()));
                }
            }
        }
    }

    public Question random(String lobbyId) {
        used.putIfAbsent(lobbyId, new ArrayDeque<>());
        Queue<Question> queue = used.get(lobbyId);
        if (queue.size() == questions.size()) {
            queue.clear();
        }
        Question q;
        do {
            q = questions.get(new Random().nextInt(questions.size()));
        } while (queue.contains(q));
        queue.add(q);
        return q;
    }
}

