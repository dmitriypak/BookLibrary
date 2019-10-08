package ru.projects.edu.spring.task14.booklibrary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.validation.support.BindingAwareModelMap;
import ru.projects.edu.spring.task14.booklibrary.config.StoragePath;
import ru.projects.edu.spring.task14.booklibrary.controllers.AuthorsPageController;
import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.AuthorDto;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorDtoService;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorService;
import ru.projects.edu.spring.task14.booklibrary.services.book.BookDtoService;
import ru.projects.edu.spring.task14.booklibrary.services.book.BookService;
import ru.projects.edu.spring.task14.booklibrary.services.genre.GenreService;
import ru.projects.edu.spring.task14.booklibrary.services.storage.FileStorageService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@WebMvcTest
public class AuthorsPageControllerTests {
  @Autowired
  private AuthorsPageController authorsPageController;
  @MockBean
  private AuthorService authorService;
  @MockBean
  private StoragePath storagePath;
  @MockBean
  private AuthorDtoService authorDtoService;
  @MockBean
  private BookService bookService;
  @MockBean
  private BookDtoService bookDtoService;
  @MockBean
  private GenreService genreService;
  @MockBean
  private FileStorageService fileStorageService;


  @Test
  public void listAuthorsTest() {
    BindingAwareModelMap model = new BindingAwareModelMap();
    List<AuthorDto> authors = new ArrayList<>();
    given(authorService.findAll()).willReturn(authors);
    String view = authorsPageController.listAuthors(model);
    verify(authorService,times(1)).findAll();
    verifyNoMoreInteractions(authorService);
    assertEquals("authors", view);
    assertEquals(authors, model.asMap().get("authors"));
  }

}
