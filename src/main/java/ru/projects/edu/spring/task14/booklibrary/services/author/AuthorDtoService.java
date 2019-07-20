package ru.projects.edu.spring.task14.booklibrary.services.author;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.dto.AuthorDto;

@Service
public class AuthorDtoService {
  public static AuthorDto toDto(Author author){
    return new AuthorDto(author.getId(),author.getFirstName(),author.getFamily(),author.getPatronymic());
  }

  public  Author toDomainObject(AuthorDto authorDto){
    return new Author(authorDto.getId(),authorDto.getFirstName(),authorDto.getFamily(),authorDto.getPatronymic());
  }
}
