package ru.projects.edu.spring.task14.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.projects.edu.spring.task14.booklibrary.domain.DBFile;

public interface DBFileRepository extends JpaRepository<DBFile,Long> {
}
