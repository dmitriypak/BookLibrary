package ru.projects.edu.spring.task14.booklibrary.dto;

public class BookDto {
  private long id;
  private String authorName;
  private String authorFamily;
  private String authorPatronymic;
  private String name;
  private String genreName;
  private String authorFullName;


  public BookDto(long id, String name, String authorName, String authorFamily, String authorPatronymic, String genreName) {
    this.id = id;
    this.name = name;
    this.authorName = authorName;
    this.authorFamily = authorFamily;
    this.authorPatronymic = authorPatronymic;
    this.genreName = genreName;
    this.authorFullName = this.getAuthorFullName();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGenreName() {
    return genreName;
  }

  public void setGenreName(String genreName) {
    this.genreName = genreName;
  }

  public String getAuthorFamily() {
    return authorFamily;
  }

  public void setAuthorFamily(String authorFamily) {
    this.authorFamily = authorFamily;
  }

  public String getAuthorPatronymic() {
    return authorPatronymic;
  }

  public void setAuthorPatronymic(String authorPatronymic) {
    this.authorPatronymic = authorPatronymic;
  }

  public String getAuthorFullName() {
    authorFullName = String.format("%s %s.%s.",authorFamily, authorName.substring(0,1),authorPatronymic.substring(0,1));
    return authorFullName;
  }
}
