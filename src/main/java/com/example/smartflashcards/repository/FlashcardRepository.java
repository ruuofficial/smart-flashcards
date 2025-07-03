package com.example.smartflashcards.repository;

import com.example.smartflashcards.model.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
    List<Flashcard> findByStudentId(String studentId);
}
