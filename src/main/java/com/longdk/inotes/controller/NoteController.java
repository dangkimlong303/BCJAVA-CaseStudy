package com.longdk.inotes.controller;

import com.longdk.inotes.model.Note;
import com.longdk.inotes.model.NoteType;
import com.longdk.inotes.service.NoteService;
import com.longdk.inotes.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    public NoteService noteService;

    @Autowired
    private NoteTypeService noteTypeService;

    @ModelAttribute("notetype")
    public Iterable<NoteType> noteTypes(){
        return noteTypeService.findAll();
    }

    @GetMapping("note-list")
    public ModelAndView showListNoteForm(@PageableDefault(size = 3) Pageable pageable, @RequestParam("s") Optional<String> s){
        Page<Note> notes;
        if(s.isPresent()){
            notes = noteService.findAllByTitleContaining(s.get(), pageable);
        } else {
            notes = noteService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("note/list");
        modelAndView.addObject("notes",notes);
        return modelAndView;
    }
    @GetMapping("note-create")
    public ModelAndView showCreateNoteForm(){
        ModelAndView modelAndView = new ModelAndView("note/create");
        modelAndView.addObject("note",new Note());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createNote(@ModelAttribute("note") Note note){
        ModelAndView modelAndView = new ModelAndView("note/create");
        noteService.save(note);
        modelAndView.addObject("mess","create a new note successed!");
        return modelAndView;
    }
    @GetMapping("note-delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("note/delete");
        Note note = noteService.findById(id);
        modelAndView.addObject("note",note);
        return modelAndView;
    }
    @PostMapping("/delete")
    public String  deleteNote(@ModelAttribute("note") Note note){
        noteService.remove(note.getId());
        return "redirect:note-list";
    }
    @GetMapping("note-edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("note/edit");
        Note note = noteService.findById(id);
        modelAndView.addObject("note",note);
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView EditNote(@ModelAttribute("note") Note note){
        noteService.save(note);
        return new ModelAndView("note/edit","mess","Edit Note Successful!");
    }
}
