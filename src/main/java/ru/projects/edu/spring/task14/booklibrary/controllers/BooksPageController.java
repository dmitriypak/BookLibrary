package ru.projects.edu.spring.task14.booklibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.BookDto;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.AuthorDto;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorDtoService;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorService;
import ru.projects.edu.spring.task14.booklibrary.services.book.BookDtoService;
import ru.projects.edu.spring.task14.booklibrary.services.book.BookService;
import ru.projects.edu.spring.task14.booklibrary.services.genre.GenreService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BooksPageController extends AbstractController {
  private AuthorService authorService;
  private BookService bookService;
  private AuthorDtoService authorDtoService;
  private BookDtoService bookDtoService;
  private GenreService genreService;

  public BooksPageController(AuthorService authorService, BookService bookService, AuthorDtoService authorDtoService,
         BookDtoService bookDtoService, GenreService genreService) {
    this.authorService = authorService;
    this.bookService = bookService;
    this.authorDtoService = authorDtoService;
    this.bookDtoService = bookDtoService;
    this.genreService = genreService;
  }

  @GetMapping("/books")
  public String listBooksPage(Model model) {
    List<BookDto>books = bookService.findAll().stream().map(bookDtoService::toDto).collect(Collectors.toList());
    List<Genre>genres = genreService.findAll();
    List<AuthorDto>authors = authorService.findAll().stream().map(authorDtoService::toDto).collect(Collectors.toList());
    model.addAttribute("books",books);
    model.addAttribute("genres",genres);
    model.addAttribute("authors",authors);
    model.addAttribute("newBook",new Book());
    return "books";
  }

  @GetMapping("/books/edit")
  public String editBooksPage(@RequestParam("id") long bookId,Model model) {
    BookDto book = bookDtoService.toDto(bookService.findById(bookId).get());
    model.addAttribute("book",book);
    return "editbook";
  }
  @PostMapping("/books/add")
  @Transactional
  public String addBook(@ModelAttribute Book newBook) {
    bookService.save(newBook);
    return "redirect:/books";
  }

}
