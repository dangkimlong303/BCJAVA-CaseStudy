package com.longdk.inotes;

import com.longdk.inotes.service.Impl.NoteServiceImpl;
import com.longdk.inotes.service.NoteService;
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
}

