package ru.projects.edu.spring.task14.booklibrary.services.author;

import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
  List<AuthorDto> findAll();
  Author save(Author author);
  void deleteById(Long id);
  Optional<Author> findById(Long id);
}
