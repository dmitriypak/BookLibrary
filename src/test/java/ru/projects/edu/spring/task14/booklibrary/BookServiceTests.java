package ru.projects.edu.spring.task14.booklibrary;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.domain.DBFile;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;
import ru.projects.edu.spring.task14.booklibrary.repository.BookRepository;
import ru.projects.edu.spring.task14.booklibrary.services.book.BookService;
import ru.projects.edu.spring.task14.booklibrary.services.book.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {
  @Autowired
  private BookService bookService;

 @MockBean
  private BookRepository bookRepository;

  private Author author;
  private Genre genre;
  private DBFile dbFile;

  @BeforeEach
  void setUp() {
    bookService = new BookServiceImpl(bookRepository);
  }

  @Test
  public void findAll() throws Exception {
    Author author = new Author("Корней","Чуковский","Иванович");
    Genre genre = new Genre("Детские сказки");
    DBFile cover = new DBFile("test","image/jpeg");
    Book book = new Book("Бармалей",author,genre,1970,cover);
    List<Book>listBook = new ArrayList<>();
    listBook.add(book);

    given(bookRepository.findAll()).willReturn(listBook);
    Assertions.assertThat(bookService.findAll()).isEqualTo(listBook);
  }

}
