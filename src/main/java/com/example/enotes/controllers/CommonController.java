package com.example.enotes.controllers;

import com.example.enotes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController{
    private NotesService notesService;

    @Autowired
    public CommonController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping()
    public String getIndex(){
        //TODO move index from notes
        return "notes/Index";
    }
}
