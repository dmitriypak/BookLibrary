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

  public DBFile() {
  }

  public DBFile(String fileName, String fileType) {
    this.name = fileName;
    this.type = fileType;
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
}