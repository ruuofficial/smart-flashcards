package com.example.smartflashcards.controller;

import com.example.smartflashcards.model.Flashcard;
import com.example.smartflashcards.service.FlashcardService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class FlashcardController {

    private final FlashcardService service;

    public FlashcardController(FlashcardService service) {
        this.service = service;
    }

    @PostMapping("/flashcard")
    public Map<String, String> addFlashcard(@RequestBody FlashcardRequest req) {
        Flashcard flashcard = service.addFlashcard(req.getStudentId(), req.getQuestion(), req.getAnswer());
        return Map.of("message", "Flashcard added successfully", "subject", flashcard.getSubject());
    }

    @GetMapping("/get-subject")
    public List<Flashcard> getFlashcards(@RequestParam String student_id, @RequestParam int limit) {
        return service.getMixedFlashcards(student_id, limit);
    }

    @Data
    static class FlashcardRequest {
        private String studentId;
        private String question;
        private String answer;
    }
}
