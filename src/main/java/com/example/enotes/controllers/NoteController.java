package com.example.enotes.controllers;

import com.example.enotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping(value = "/notes", method = RequestMethod.GET)
public class NoteController {

    NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/{id}")
    public String getNoteById(@PathVariable Long id, Model model){
        model.addAttribute("note", noteService.findById(id));
        return "getNoteById";
    }

    @GetMapping("/")
    public String getAllNotes(Map<String, Object> model){
        model.put("notes", noteService.findAll());
        return "getAllNotes";
    }

}
