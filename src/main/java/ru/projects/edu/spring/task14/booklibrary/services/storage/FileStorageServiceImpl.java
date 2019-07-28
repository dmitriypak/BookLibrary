package ru.projects.edu.spring.task14.booklibrary.services.storage;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.projects.edu.spring.task14.booklibrary.domain.DBFile;
import ru.projects.edu.spring.task14.booklibrary.exception.FileStorageException;
import ru.projects.edu.spring.task14.booklibrary.repository.DBFileRepository;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileStorageServiceImpl implements FileStorageService {

  private DBFileRepository dbFileRepository;

  public FileStorageServiceImpl(DBFileRepository dbFileRepository) {
    this.dbFileRepository = dbFileRepository;
  }

  @Override
  public DBFile save(MultipartFile file) {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    DBFile dbFile;
    try{
      dbFile = new DBFile(fileName, file.getContentType());
      dbFileRepository.save(dbFile);
    } catch (Exception ex) {
      throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
    }
    return dbFile;
  }

  @Override
  public Optional<DBFile> findById(Long id) {
    return dbFileRepository.findById(id);
  }
}
