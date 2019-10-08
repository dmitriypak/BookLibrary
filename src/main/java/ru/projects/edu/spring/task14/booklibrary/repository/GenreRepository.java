package ru.projects.edu.spring.task14.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre,Long> {

}
