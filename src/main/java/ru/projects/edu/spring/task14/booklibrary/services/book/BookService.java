package ru.projects.edu.spring.task14.booklibrary.services.book;

import org.springframework.data.jpa.domain.Specification;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
  List<Book> findAll();
  List<Book> findAll(Specification<Book> specification);
  Book save(Book book);
  Optional<Book> findById(Long id);
  void deleteById(Long id);
}
