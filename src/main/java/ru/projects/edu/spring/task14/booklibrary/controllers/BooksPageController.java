package ru.projects.edu.spring.task14.booklibrary.controllers;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.projects.edu.spring.task14.booklibrary.config.StoragePath;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.domain.DBFile;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.AuthorDto;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.BookDto;
import ru.projects.edu.spring.task14.booklibrary.repository.specification.BookSpecification;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorDtoService;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorService;
import ru.projects.edu.spring.task14.booklibrary.services.book.BookDtoService;
import ru.projects.edu.spring.task14.booklibrary.services.book.BookService;
import ru.projects.edu.spring.task14.booklibrary.services.genre.GenreService;
import ru.projects.edu.spring.task14.booklibrary.services.storage.FileStorageService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class BooksPageController {
  private final AuthorService authorService;
  private final BookService bookService;
  private final AuthorDtoService authorDtoService;
  private final BookDtoService bookDtoService;
  private final GenreService genreService;
  private final FileStorageService fileStorageService;
  private final StoragePath storagePath;

  public BooksPageController(AuthorService authorService, BookService bookService, AuthorDtoService authorDtoService,
                             BookDtoService bookDtoService, GenreService genreService, FileStorageService fileStorageService,
                             StoragePath storagePath) {
    this.authorService = authorService;
    this.bookService = bookService;
    this.authorDtoService = authorDtoService;
    this.bookDtoService = bookDtoService;
    this.genreService = genreService;
    this.fileStorageService = fileStorageService;
    this.storagePath = storagePath;
  }

  @GetMapping("/books")
  public String listBooksPage(Model model) {
    List<BookDto>books = bookService.findAll().stream().map(bookDtoService::toDto).collect(Collectors.toList());
    List<Genre>genres = genreService.findAll();
    List<AuthorDto>authors = authorService.findAll().stream().map(authorDtoService::toDto).collect(Collectors.toList());
    model.addAttribute("books",books);
    model.addAttribute("genres",genres);
    model.addAttribute("authors",authors);
    model.addAttribute("objBook",new BookDto());
    return "books";
  }

  @GetMapping("/books/edit")
  public String editBooksPage(@RequestParam("id") long bookId, Model model) {
    Optional<Book> bookOpt = bookService.findById(bookId);
    BookDto book = bookDtoService.toDto(bookOpt.orElseThrow(()->new RuntimeException("Book not found")));
    List<AuthorDto>authors = authorService.findAll().stream().map(authorDtoService::toDto).collect(Collectors.toList());
    List<Genre>genres = genreService.findAll();
    model.addAttribute("book",book);
    model.addAttribute("genres",genres);
    model.addAttribute("authors",authors);
    return "editbook";
  }

  @PostMapping("/books/save")
  @Transactional
  public String saveBook( @RequestParam(required = false) MultipartFile cover, @ModelAttribute BookDto book) {
    if(cover!=null && !cover.isEmpty()){
      book.setCoverImage(fileStorageService.getDbFile(cover));
    }
    bookService.save(bookDtoService.toDomainObject(book));
    return "redirect:/books";
  }

  @PostMapping("/books/update")
  @Transactional
  public String updateBook( @RequestParam(required = false) MultipartFile cover, @ModelAttribute BookDto book) {
    if(cover!=null && !cover.isEmpty()){
      if(book.getCoverImage()!=null) {
        fileStorageService.delete(book.getCoverImage());
      }
      book.setCoverImage(fileStorageService.getDbFile(cover));
    }
    bookService.save(bookDtoService.toDomainObject(book));
    return "redirect:/books";
  }

  @PostMapping("/books/delete")
  @Transactional
  public String deleteBook(@RequestParam("id") long bookId) {
    bookService.deleteById(bookId);
    return "redirect:/books";
  }

  @PostMapping("/books/search")
  public String bookSearchPage(@ModelAttribute("objBook") BookDto bookObj, Model model) {
    Specification<Book> specification = new BookSpecification(bookObj);
    List<BookDto> books = bookService.findAll(specification).stream().map(bookDtoService::toDto).collect(Collectors.toList());
    List<AuthorDto>authors = authorService.findAll().stream().map(authorDtoService::toDto).collect(Collectors.toList());
    List<Genre>genres = genreService.findAll();
    model.addAttribute("books",books);
    model.addAttribute("genres",genres);
    model.addAttribute("authors",authors);
    model.addAttribute("objBook",new BookDto());
    return "books";
  }

}