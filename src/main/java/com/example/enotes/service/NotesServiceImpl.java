package com.example.enotes.service;

import com.example.enotes.domain.Note;
import com.example.enotes.repositories.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    NotesRepository notesRepository;

    @Override
    public Note findById(long id) {
        //TODO if exists
        return notesRepository.findById(id).get();
    }

    @Override
    public Iterable<Note> findAll() {
        return notesRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        notesRepository.deleteById(id);
    }

    @Override
    public Note save(Note note) {
        return notesRepository.save(note);
    }
}
