package com.longdk.inotes.formatter;

import com.longdk.inotes.model.NoteType;
import com.longdk.inotes.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class NoteTypeFormatter implements Formatter<NoteType> {
    private NoteTypeService noteTypeService;

    @Autowired
    public NoteTypeFormatter(NoteTypeService noteTypeService){
        this.noteTypeService = noteTypeService;
    }
    @Override
    public NoteType parse(String text, Locale locale) throws ParseException {
        return noteTypeService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(NoteType object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
