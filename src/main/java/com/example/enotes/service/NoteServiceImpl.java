package com.example.enotes.service;

import com.example.enotes.domain.Note;
import com.example.enotes.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note findById(long id) {
        //TODO if exists
        return noteRepository.findById(id).get();
    }

    @Override
    public Iterable<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }
}
