package com.example.enotes.controllers;

import com.example.enotes.domain.Note;
import com.example.enotes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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
        return "notes/showAllNotes";
    }

    @PostMapping()
    public String addNewNote(@RequestParam String text,
                             @RequestParam String tag){

        notesService.save(new Note(text, tag));
        return "redirect:/notes";
    }


    @GetMapping("/{id}")
    public String getNoteById(@PathVariable Long id, Model model){
        model.addAttribute("note", notesService.findById(id));
        return "notes/showNoteById";
    }


    @GetMapping("/new")
    public String addNewNoteForm(){
        return "notes/showAddNewNote";
    }

    //@GetMapping("/{id}/edit")


    //TODO POST
    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable Long id){
        notesService.deleteById(id);
        return "redirect:/notes";
    }

    @GetMapping("/{id}/edit")
    public String editNote(@PathVariable Long id,
                           @ModelAttribute Note note){
        note = notesService.findById(id);
        return "notes/showEditNote";
    }

    @PostMapping("/{id}/edit")
    public String editNotePatch(@ModelAttribute Note note,
                                @ModelAttribute String method,
                                @ModelAttribute Long id){
        System.out.println(note.toString());
        if (method.equals("patch"))
            notesService.save(note);
        return "redirect:/notes";
    }




}
