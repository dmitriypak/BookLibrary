package ru.projects.edu.spring.task14.booklibrary.services.author;

import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
  List<Author> findAll();
  Author save(Author author);
}
