package com.example.enotes.controllers;

import com.example.enotes.domain.Note;
import com.example.enotes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/notes")
public class NotesController {

    NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping()
    public String getAllNotes(Model model){
        model.addAttribute("notes", notesService.findAll());
        return "notes/NotesList";
    }

    @PostMapping()
    public String addNewNote(@RequestParam String text,
                             @RequestParam String tag){

        notesService.save(new Note(text, tag));
        return "redirect:/notes";
    }

    @GetMapping("/{id}")
    public String getNoteById(@PathVariable Long id,
                              Model model){
        model.addAttribute("note", notesService.findById(id));
        return "notes/NoteById";
    }


    @GetMapping("/new")
    public String addNewNoteForm(){
        return "notes/AddNewNoteForm";
    }

    //@GetMapping("/{id}/edit")

    //TODO DELETE method
    @PostMapping("/{id}/delete")
    public String deleteById(@PathVariable Long id){
        notesService.deleteById(id);
        return "redirect:/notes";
    }

    @GetMapping("/{id}/edit")
    public String editNote(@PathVariable Long id,
                           Model model){
        Note note = notesService.findById(id);
        model.addAttribute("note", note);
        return "notes/EditNoteForm";
    }

    //TODO patch method
    @PostMapping("/{id}/edit")
    public String editNotePatch(@ModelAttribute Note note,
                                @ModelAttribute String method){
        notesService.save(note);
        return "redirect:/notes";
    }




}
