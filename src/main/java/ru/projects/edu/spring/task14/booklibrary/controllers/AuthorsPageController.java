package ru.projects.edu.spring.task14.booklibrary.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;
import ru.projects.edu.spring.task14.booklibrary.dto.AuthorDto;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorDtoService;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AuthorsPageController {

  private AuthorService authorService;
  private AuthorDtoService authorDtoService;

  public AuthorsPageController(AuthorService authorService, AuthorDtoService authorDtoService) {
    this.authorService = authorService;
    this.authorDtoService = authorDtoService;
  }

  @GetMapping("/authors")
  public String listBooksPage(Model model) {
    List<AuthorDto>authors = authorService.findAll().stream().map(authorDtoService::toDto).collect(Collectors.toList());
    model.addAttribute("authors",authors);
    model.addAttribute("newAuthor",new AuthorDto());
    return "authors";
  }

  @PostMapping("/authors/add")
  @Transactional
  public String addGenre(@ModelAttribute AuthorDto newAuthor) {
    authorService.save(authorDtoService.toDomainObject(newAuthor));
    return "redirect:/authors";
  }

}
