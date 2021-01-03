package com.example.enotes.service;

import com.example.enotes.domain.Note;

public interface NotesService {

    public Note findById(long id);

    public Iterable<Note> findAll();

    public void deleteById(long id);

    public Note save(Note note);


}
