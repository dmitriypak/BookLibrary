package ru.projects.edu.spring.task14.booklibrary.services.book;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

  private BookRepository bookRepository;
  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public Book save(Book book){
    Book newBook = bookRepository.save(book);
    return newBook;
  }


}
