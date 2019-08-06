package ru.projects.edu.spring.task14.booklibrary.services.storage;

import org.springframework.web.multipart.MultipartFile;
import ru.projects.edu.spring.task14.booklibrary.domain.DBFile;

import java.io.IOException;
import java.util.Optional;

public interface FileStorageService {
  Optional<DBFile> findById(Long id);
  DBFile getDbFile(MultipartFile file);
  void delete(DBFile dbFile);
}
