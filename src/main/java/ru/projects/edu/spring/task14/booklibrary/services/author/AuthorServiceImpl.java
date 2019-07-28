package ru.projects.edu.spring.task14.booklibrary.services.author;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

  private AuthorRepository authorRepository;

  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public List<Author> findAll() {
    return authorRepository.findAll();
  }

  @Override
  public Author save(Author author) {
    return authorRepository.save(author);
  }

  @Override
  public void deleteById(Long id) {
    authorRepository.deleteById(id);
  }

  @Override
  public Optional<Author> findById(Long id) {
    return authorRepository.findById(id);
  }
}
