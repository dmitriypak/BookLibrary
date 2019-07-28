package ru.projects.edu.spring.task14.booklibrary.services.book;

import ru.projects.edu.spring.task14.booklibrary.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
  List<Book> findAll();
  Book save(Book book);
  Optional<Book> findById(Long id);
  void deleteById(Long id);
}
