package ru.projects.edu.spring.task14.booklibrary.services.storage;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.projects.edu.spring.task14.booklibrary.config.StoragePath;
import ru.projects.edu.spring.task14.booklibrary.domain.DBFile;
import ru.projects.edu.spring.task14.booklibrary.exception.FileStorageException;
import ru.projects.edu.spring.task14.booklibrary.repository.DBFileRepository;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class FileStorageServiceImpl implements FileStorageService {
  private final StoragePath storagePath;
  private DBFileRepository dbFileRepository;

  public FileStorageServiceImpl(DBFileRepository dbFileRepository, StoragePath storagePath) {
    this.dbFileRepository = dbFileRepository;
    this.storagePath = storagePath;
  }

  @Override
  public Optional<DBFile> findById(Long id) {
    return dbFileRepository.findById(id);
  }

  public DBFile getDbFile(MultipartFile file) {
    try {
      File dir = new File(storagePath.getPath());
      if (!dir.exists()) {
        dir.mkdir();
      }
      String uuidFile = UUID.randomUUID().toString();
      String fileName = uuidFile + "." + file.getOriginalFilename();
      file.transferTo(new File(dir.getAbsolutePath() + "/" + fileName));
      DBFile dbFile = dbFileRepository.save(new DBFile(fileName, file.getContentType()));
      return dbFile;
    } catch (IOException ex){
      throw new FileStorageException(ex.getMessage());
    }
  }

  @Override
  public void delete(DBFile dbFile) {
    File delFile = new File(storagePath.getPath()+"/"+dbFile.getFileName());
    if(delFile.exists()){
      delFile.delete();
    }
    dbFileRepository.delete(dbFile);
  }
}
