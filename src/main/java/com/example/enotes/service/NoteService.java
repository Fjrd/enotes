package com.example.enotes.service;

import com.example.enotes.domain.Note;
import com.example.enotes.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

public interface NoteService {

    public Note findById(long id);

    public Iterable<Note> findAll();

    public void deleteById(long id);

    public Note save(Note note);


}
