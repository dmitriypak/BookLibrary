package ru.projects.edu.spring.task14.booklibrary;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.support.BindingAwareModelMap;
import ru.projects.edu.spring.task14.booklibrary.controllers.AuthorsPageControllerExceptionHandler;
import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AuthorsPageControllerTests {

  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private AuthorsPageControllerExceptionHandler authorsPageController;
  @MockBean
  private AuthorService authorService;

  @Test
  public void listAuthorsTest() {
    BindingAwareModelMap model = new BindingAwareModelMap();
    List<Author> authors = new ArrayList<>();
    given(authorService.findAll()).willReturn(authors);
    String view = authorsPageController.listAuthors(model);
    verify(authorService,times(1)).findAll();
    verifyNoMoreInteractions(authorService);
    assertEquals("authors", view);
    assertEquals(authors, model.asMap().get("authors"));
  }

}
