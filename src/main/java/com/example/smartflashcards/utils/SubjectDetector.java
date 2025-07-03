package com.example.smartflashcards.utils;

import java.util.*;

public class SubjectDetector {

    private static final Map<String, List<String>> SUBJECT_KEYWORDS = new HashMap<>();

    static {
        SUBJECT_KEYWORDS.put("Physics", Arrays.asList("newton", "acceleration", "velocity", "force"));
        SUBJECT_KEYWORDS.put("Biology", Arrays.asList("photosynthesis", "cell", "organism"));
        SUBJECT_KEYWORDS.put("Math", Arrays.asList("algebra", "equation", "geometry", "calculus"));
        SUBJECT_KEYWORDS.put("History", Arrays.asList("war", "revolution", "empire"));
        SUBJECT_KEYWORDS.put("Chemistry", Arrays.asList("atom", "reaction", "compound"));
        SUBJECT_KEYWORDS.put("Computer Science", Arrays.asList("algorithm", "loop", "data", "function"));
    }

    public static String detectSubject(String question) {
        String lower = question.toLowerCase();
        for (Map.Entry<String, List<String>> entry : SUBJECT_KEYWORDS.entrySet()) {
            for (String keyword : entry.getValue()) {
                if (lower.contains(keyword)) {
                    return entry.getKey();
                }
            }
        }
        return "General";
    }
}
