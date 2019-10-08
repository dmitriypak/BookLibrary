package ru.projects.edu.spring.task14.booklibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.AuthorDto;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.BookDto;

@Controller
public class PageController {
  @GetMapping({"/","/index"})
  public String indexPage() {
    return "redirect:/books";
  }
}
