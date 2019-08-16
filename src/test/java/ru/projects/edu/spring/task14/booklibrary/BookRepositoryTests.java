package ru.projects.edu.spring.task14.booklibrary;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.projects.edu.spring.task14.booklibrary.config.AppConfig;
import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.domain.DBFile;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;
import ru.projects.edu.spring.task14.booklibrary.repository.BookRepository;

import javax.sql.DataSource;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTests {

  @Autowired
  private TestEntityManager entityManager;
  @Autowired
  private BookRepository bookRepository;

  @Test
  public void testFindById(){
    Author author = new Author("Корней","Чуковский","Иванович");
    Genre genre = new Genre("Детские сказки");
    DBFile cover = new DBFile("test","image/jpeg");
    Book savedToDbBook = new Book("Бармалей",author,genre,1970,cover);
    this.entityManager.persist(savedToDbBook);
    entityManager.flush();
    Book findBook = this.bookRepository.findById(savedToDbBook.getId()).get();
    Assertions.assertThat(savedToDbBook.equals(findBook));
  }


}

