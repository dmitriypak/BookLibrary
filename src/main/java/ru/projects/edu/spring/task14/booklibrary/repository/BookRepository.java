package ru.projects.edu.spring.task14.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;


public interface BookRepository extends JpaRepository<Book,Long>, JpaSpecificationExecutor<Book> {

}
