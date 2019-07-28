package ru.projects.edu.spring.task14.booklibrary.services.genre;

import ru.projects.edu.spring.task14.booklibrary.domain.Genre;

import java.util.List;

public interface GenreService {
  Genre save(Genre genre);
  List<Genre> findAll();
  void deleteById(Long id);
}
