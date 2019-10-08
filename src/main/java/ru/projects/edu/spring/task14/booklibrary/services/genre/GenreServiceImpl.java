package ru.projects.edu.spring.task14.booklibrary.services.genre;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;
import ru.projects.edu.spring.task14.booklibrary.repository.GenreRepository;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
  private final GenreRepository genreRepository;

  public GenreServiceImpl(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  @Override
  public Genre save(Genre genre) {
    return genreRepository.save(genre);
  }

  @Override
  public List<Genre> findAll() {
    return genreRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    genreRepository.deleteById(id);
  }
}
