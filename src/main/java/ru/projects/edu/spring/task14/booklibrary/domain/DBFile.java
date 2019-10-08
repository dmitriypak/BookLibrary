package ru.projects.edu.spring.task14.booklibrary.domain;

import javax.persistence.*;

@Entity
@Table(name = "db_files")
public class DBFile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name="name")
  private String fileName;
  private String type;

  public DBFile() {
  }

  public DBFile(String fileName, String fileType) {
    this.fileName = fileName;
    this.type = fileType;
  }

  public DBFile(Long id, String fileName, String fileType) {
    this.id = id;
    this.fileName = fileName;
    this.type = fileType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}