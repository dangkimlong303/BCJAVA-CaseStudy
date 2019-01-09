package com.longdk.inotes.controller;

import com.longdk.inotes.model.Note;
import com.longdk.inotes.model.NoteType;
import com.longdk.inotes.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;

    @GetMapping("notetype-list")
    public ModelAndView showListNoteType(){
        ModelAndView modelAndView = new ModelAndView("notetype/list");
        Iterable<NoteType> noteTypes = noteTypeService.findAll();
        modelAndView.addObject("notetypes",noteTypes);
        return modelAndView;
    }

    @GetMapping("notetype-create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("notetype/create");
        modelAndView.addObject("notetype",new NoteType());
        return modelAndView;
    }

    @PostMapping("/create-notetype")
    public ModelAndView CreateNoteType(@ModelAttribute("notetype") NoteType noteType){
        noteTypeService.save(noteType);
        ModelAndView modelAndView = new ModelAndView("notetype/create","message","Notetype Create successed!");
        return modelAndView;
    }

    @GetMapping("notetype-delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("notetype/delete");
        NoteType noteType = noteTypeService.findById(id);
        modelAndView.addObject("notetype",noteType);
        return modelAndView;
    }
    @PostMapping("/notetype-delete")
    public String  deleteNote(@ModelAttribute("notetype") NoteType noteType){
        noteTypeService.remove(noteType.getId());
        return "redirect:notetype-list";
    }
    @GetMapping("notetype-edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("notetype/edit");
        NoteType notetype = noteTypeService.findById(id);
        modelAndView.addObject("notetype",notetype);
        return modelAndView;
    }
    @PostMapping("/notetype-edit")
    public ModelAndView EditNote(@ModelAttribute("notetype") NoteType noteType){
        noteTypeService.save(noteType);
        return new ModelAndView("notetype/edit","mes","Edit NoteType Successful!");
    }
}
