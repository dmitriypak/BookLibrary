package ru.projects.edu.spring.task14.booklibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.dto.AuthorDto;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorDtoService;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorService;
import ru.projects.edu.spring.task14.booklibrary.services.book.BookService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookPageController extends AbstractController {
  private AuthorService authorService;
  private BookService bookService;
  public BookPageController(AuthorService authorService, BookService bookService) {
    this.authorService = authorService;
    this.bookService = bookService;
  }

  @GetMapping("/books")
  public String listBooksPage(Model model) {
    List<AuthorDto>authors = authorService.findAll().stream().map(AuthorDtoService::toDto).collect(Collectors.toList());
    model.addAttribute("authors",authors);
    model.addAttribute("newBook",new Book());
    return "books";
  }

  @PostMapping("/books/add")
  @Transactional
  public String addBook(@ModelAttribute Book newBook) {
    bookService.save(newBook);
    return "redirect:/books";
  }

}
