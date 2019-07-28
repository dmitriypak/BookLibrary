package ru.projects.edu.spring.task14.booklibrary.domain.dto;

public class AuthorDto {
  private Long id;
  private String firstName;
  private String family;
  private String patronymic;
  private String fullName;

  public AuthorDto() {

  }

  public AuthorDto(long id, String firstName, String family, String patronymic) {
    this.id = id;
    this.firstName = firstName;
    this.family = family;
    this.patronymic = patronymic;
  }

  public long getId() {
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

  public String getFullName() {
    return String.format("%s %s.%s.",this.family, this.firstName.substring(0,1),this.patronymic.substring(0,1));
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
}
