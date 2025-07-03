package com.example.smartflashcards.service;

import com.example.smartflashcards.model.Flashcard;
import com.example.smartflashcards.repository.FlashcardRepository;
import com.example.smartflashcards.utils.SubjectDetector;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlashcardService {

    private final FlashcardRepository repo;

    public FlashcardService(FlashcardRepository repo) {
        this.repo = repo;
    }

    public Flashcard addFlashcard(String studentId, String question, String answer) {
        String subject = SubjectDetector.detectSubject(question);
        Flashcard flashcard = Flashcard.builder()
                .studentId(studentId)
                .question(question)
                .answer(answer)
                .subject(subject)
                .build();
        return repo.save(flashcard);
    }

    public List<Flashcard> getMixedFlashcards(String studentId, int limit) {
        List<Flashcard> all = repo.findByStudentId(studentId);
        Map<String, List<Flashcard>> grouped = all.stream()
                .collect(Collectors.groupingBy(Flashcard::getSubject));

        List<String> subjects = new ArrayList<>(grouped.keySet());
        Collections.shuffle(subjects);

        List<Flashcard> result = new ArrayList<>();
        for (String subject : subjects) {
            List<Flashcard> cards = grouped.get(subject);
            if (!cards.isEmpty()) {
                result.add(cards.remove(0));
            }
            if (result.size() == limit) break;
        }
        return result;
    }
}
