package ru.projects.edu.spring.task14.booklibrary.services.book;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.AuthorDto;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.BookDto;

@Service
public class BookDtoService {

  public BookDto toDto(Book book) {
    Genre genre = book.getGenre();
    BookDto bookDto = new BookDto(book.getId(), book.getName(), book.getAuthor(),genre, book.getReleaseYear());
    if(book.getCoverImage()!=null){
      bookDto.setCoverImage(book.getCoverImage());
    }
    bookDto.setGenreName(genre.getName());
    return bookDto;

  }

  public Book toDomainObject(BookDto bookDto){
    return new Book(bookDto.getId(),bookDto.getName(),bookDto.getAuthor(),bookDto.getGenre(),bookDto.getReleaseYear(),bookDto.getCoverImage());
  }

}
