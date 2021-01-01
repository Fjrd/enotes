package com.example.enotes.controllers;

import com.example.enotes.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/note", method = RequestMethod.GET)
public class NoteController {

    NoteRepository noteRepository;

    @Autowired
    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping()
    public String getNote(){
        System.out.println(noteRepository.findById(1L));
        return "note";

    }

}
