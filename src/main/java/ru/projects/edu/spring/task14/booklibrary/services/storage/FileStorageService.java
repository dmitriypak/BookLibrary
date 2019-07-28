package ru.projects.edu.spring.task14.booklibrary.services.storage;

import org.springframework.web.multipart.MultipartFile;
import ru.projects.edu.spring.task14.booklibrary.domain.DBFile;

import java.util.Optional;

public interface FileStorageService {
  DBFile save(MultipartFile file);
  Optional<DBFile> findById(Long id);

}
