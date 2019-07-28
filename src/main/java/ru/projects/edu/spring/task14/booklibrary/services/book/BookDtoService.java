package ru.projects.edu.spring.task14.booklibrary.services.book;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.BookDto;

@Service
public class BookDtoService {

  public BookDto toDto(Book book) {
    return new BookDto(book.getId(), book.getName(), book.getAuthor(),book.getGenre());
  }

  public Book toDomainObject(BookDto bookDto){
    return new Book(bookDto.getId(),bookDto.getName(),bookDto.getAuthor(),bookDto.getGenre());
  }

}
