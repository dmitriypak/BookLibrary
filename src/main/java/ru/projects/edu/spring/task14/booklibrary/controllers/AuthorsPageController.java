package ru.projects.edu.spring.task14.booklibrary.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.AuthorDto;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorDtoService;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
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

  @PostMapping("/authors/save")
  @Transactional
  public String saveAuthor(@ModelAttribute AuthorDto author) {
    authorService.save(authorDtoService.toDomainObject(author));
    return "redirect:/authors";
  }


  @PostMapping("/authors/delete")
  @Transactional
  public String deleteAuthor(@RequestParam("id") Long authorId) {
    authorService.deleteById(authorId);
    return "redirect:/authors";
  }

  @GetMapping("/authors/edit")
  public String editAuthor(@RequestParam("id") Long authorId, Model model) {
    Optional<Author> author = authorService.findById(authorId);
    model.addAttribute("author",author.get());
    return "editauthor";
  }
}
