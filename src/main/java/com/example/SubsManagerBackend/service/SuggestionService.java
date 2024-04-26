package com.example.SubsManagerBackend.service;

import com.example.SubsManagerBackend.dao.Repositories.SuggestionRepository;
import com.example.SubsManagerBackend.dao.entities.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionService implements SuggestionManager{
    @Autowired
    public SuggestionRepository suggestionRepository;

    @Override
    public Suggestion addSuggestion(Suggestion suggestion) {
        return suggestionRepository.save(suggestion);
    }

    @Override
    public Suggestion editSuggestion(Suggestion suggestion) {
        return suggestionRepository.save(suggestion);
    }

    @Override
    public boolean removeSuggestion(Suggestion suggestion) {
        try{
            suggestionRepository.delete(suggestion);
            return true;
        }catch(Exception exception){
            return false;
        }
    }

    @Override
    public boolean removeSuggestionById(Integer id) {
        try{
            suggestionRepository.deleteById(id);
            return true;
        }catch(Exception exception){
            return false;
        }
    }

    @Override
    public List<Suggestion> getAllSuggestion() {
        return suggestionRepository.findAll();
    }

    @Override
    public Suggestion getSuggestionById(Integer id) {
        return suggestionRepository.findById(id).get();
    }
}
