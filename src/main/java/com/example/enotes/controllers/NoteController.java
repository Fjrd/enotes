package com.example.enotes.controllers;

import com.example.enotes.domain.Note;
import com.example.enotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/notes")
public class NoteController {

    NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/{id}")
    public String getNoteById(@PathVariable Long id, Model model){
        model.addAttribute("note", noteService.findById(id));
        return "showNoteById";
    }

    @GetMapping()
    public String getAllNotes(Model model){
        model.addAttribute("notes", noteService.findAll());
        return "showAllNotes";
    }

    @PostMapping()
    public String add(@RequestParam String text,
                      @RequestParam String tag,
                      Model model){
        noteService.save(new Note(text, tag));
        return "redirect:/notes";
    }

    //@GetMapping("/{id}/edit")
    //@PostMapping("/{id}/edit")
    //@GetMapping("/{id}/delete")
    //@PostMapping("/{id}/delete")




}
