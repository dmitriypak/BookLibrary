package ru.projects.edu.spring.task14.booklibrary.services.book;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.repository.BookRepository;

import java.util.List;
import java.util.Optional;

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

  @Override
  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  @Override
  public Optional<Book> findById(Long id) {
    return bookRepository.findById(id);
  }

  @Override
  public void deleteById(Long id) {
    bookRepository.deleteById(id);
  }

  @Override
  public List<Book>findAll(Specification<Book> specification){
    return bookRepository.findAll(specification);
  }
}
