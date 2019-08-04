package ru.projects.edu.spring.task14.booklibrary.services.author;

import org.springframework.stereotype.Service;
import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.AuthorDto;

@Service
public class AuthorDtoService {

  public AuthorDto toDto(Author author){
    AuthorDto authorDto = new AuthorDto(author.getId(),author.getFirstName(),author.getFamily(),author.getPatronymic());
    return authorDto;
  }

  public  Author toDomainObject(AuthorDto authorDto){
    return new Author(authorDto.getId(),authorDto.getFirstName(),authorDto.getFamily(),authorDto.getPatronymic());
  }
}
