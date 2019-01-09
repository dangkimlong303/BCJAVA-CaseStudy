package com.longdk.inotes.controller;

import com.longdk.inotes.model.Note;
import com.longdk.inotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    public NoteService noteService;

    @GetMapping("note-list")
    public ModelAndView showListNoteForm(){
        ModelAndView modelAndView = new ModelAndView("note/list");
        Iterable<Note> notes = noteService.findAll();
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
