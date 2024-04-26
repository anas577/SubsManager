package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.entities.Suggestion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SuggestionManager {
    public Suggestion addSuggestion(Suggestion suggestion);
    public Suggestion editSuggestion(Suggestion suggestion);
    public boolean removeSuggestion(Suggestion suggestion);
    public boolean removeSuggestionById(Integer id);
    public List<Suggestion> getAllSuggestion();
    public Suggestion getSuggestionById(Integer id);

}
