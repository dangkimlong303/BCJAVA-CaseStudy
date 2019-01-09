package com.longdk.inotes;

import com.longdk.inotes.service.Impl.NoteServiceImpl;
import com.longdk.inotes.service.Impl.NoteTypeServiceImpl;
import com.longdk.inotes.service.NoteService;
import com.longdk.inotes.service.NoteTypeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InotesApplication.class, args);
	}

	@Bean
	public NoteService noteService(){
		return new NoteServiceImpl();
	}
	@Bean
	public NoteTypeService noteTypeService(){
		return new NoteTypeServiceImpl();
	}
}

