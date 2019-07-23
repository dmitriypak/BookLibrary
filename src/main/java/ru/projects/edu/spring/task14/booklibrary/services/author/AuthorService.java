package ru.projects.edu.spring.task14.booklibrary.services.author;

import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.dto.AuthorDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
  List<Author> findAll();
  Author save(Author author);
  void delete(long id);
  Optional<Author> findById(Long id);
}
