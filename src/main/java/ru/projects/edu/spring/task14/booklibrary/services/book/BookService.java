package ru.projects.edu.spring.task14.booklibrary.services.book;

import ru.projects.edu.spring.task14.booklibrary.domain.Book;

import java.util.List;

public interface BookService {
  List<Book> findAll();
  Book save(Book book);
}
