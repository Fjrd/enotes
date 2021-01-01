package com.example.enotes.controllers;

import com.example.enotes.domain.Note;
import com.example.enotes.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping(value = "/note", method = RequestMethod.GET)
public class NoteController {

    NoteRepository noteRepository;

    @Autowired
    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping()
    public String getNote(Model model){
        Optional<Note> optionalNote = noteRepository.findById(1L);
        Note note = optionalNote.get();
        model.addAttribute("note", note);
        return "note";
    }
}
