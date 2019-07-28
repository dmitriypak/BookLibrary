package ru.projects.edu.spring.task14.booklibrary.domain.dto;

import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.domain.DBFile;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;


public class BookDto {
  private Long id;
  private String name;
  private String authorFullName;
  private String genreName;
  private Author author;
  private Genre genre;
  private Integer releaseYear;
  private DBFile coverImage;

  public BookDto() {
  }

  public BookDto(Long id, String name, Author author, Genre genre, Integer releaseYear) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.genre = genre;
    this.releaseYear = releaseYear;
    genreName = genre.getName();
    authorFullName = String.format("%s %s.%s.",author.getFamily(), author.getFirstName().substring(0,1),
        author.getPatronymic().substring(0,1));
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


  public String getAuthorFullName() {
    return authorFullName;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }


  public Integer getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public DBFile getCoverImage() {
    return coverImage;
  }

  public void setCoverImage(DBFile coverImage) {
    this.coverImage = coverImage;
  }

  public void setAuthorFullName(String authorFullName) {
    this.authorFullName = authorFullName;
  }


  public void setReleaseYear(Integer releaseYear) {
    this.releaseYear = releaseYear;
  }

  public String getGenreName() {
    return genreName;
  }

  public void setGenreName(String genreName) {
    this.genreName = genreName;
  }


}
