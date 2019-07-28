package ru.projects.edu.spring.task14.booklibrary.domain;

import javax.persistence.*;

@Entity
@Table(name = "db_files")
public class DBFile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  private String name;
  private String type;
  private String path;

  public DBFile() {
  }

  public DBFile(String fileName, String fileType) {
    this.name = fileName;
    this.type = fileType;
  }


  public DBFile(String fileName, String fileType, String path) {
    this.name = fileName;
    this.type = fileType;
    this.path = path;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getFullPath() {
    return  path+"/"+name;
  }

}