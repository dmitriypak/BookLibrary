package ru.projects.edu.spring.task14.booklibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;
import ru.projects.edu.spring.task14.booklibrary.dto.AuthorDto;
import ru.projects.edu.spring.task14.booklibrary.dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PageController {
  @GetMapping({"/","/index"})
  public String indexPage() {
    return "redirect:/books";
  }
}
