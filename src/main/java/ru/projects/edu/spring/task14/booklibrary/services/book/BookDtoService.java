package ru.projects.edu.spring.task14.booklibrary.services.book;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.dto.AuthorDto;
import ru.projects.edu.spring.task14.booklibrary.dto.BookDto;
import ru.projects.edu.spring.task14.booklibrary.services.author.AuthorDtoService;

@Service
public class BookDtoService {

  public BookDto toDto(Book book) {
    Author author = book.getAuthor();
    return new BookDto(book.getId(), book.getName(), author.getFirstName(),author.getFamily(),author.getPatronymic(),book.getGenre().getName());
  }

}
