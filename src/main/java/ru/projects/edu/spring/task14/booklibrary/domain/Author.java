package ru.projects.edu.spring.task14.booklibrary.domain;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "family")
  private String family;

  @Column(name = "patronymic")
  private String patronymic;

  public Author() {
  }

  public Author(Long id, String firstName, String family, String patronymic) {
    this.id = id;
    this.firstName = firstName;
    this.family = family;
    this.patronymic = patronymic;
  }

  public Author(String firstName, String family, String patronymic) {
    this.firstName = firstName;
    this.family = family;
    this.patronymic = patronymic;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFamily() {
    return family;
  }

  public void setFamily(String family) {
    this.family = family;
  }

  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }
}
