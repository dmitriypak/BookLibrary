package ru.projects.edu.spring.task14.booklibrary.domain.dto;

import ru.projects.edu.spring.task14.booklibrary.domain.Author;
import ru.projects.edu.spring.task14.booklibrary.domain.DBFile;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;

import javax.persistence.criteria.CriteriaBuilder;

public class BookDto {
  private long id;
  private String name;
  private String authorFullName;
  private String genreName;
  private Author author;
  private Genre genre;
  private int releaseYear;
  private DBFile coverImage;


  public BookDto(long id, String name, Author author, Genre genre) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.genre = genre;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getAuthorFullName() {
    authorFullName = String.format("%s %s.%s.",author.getFamily(), author.getFirstName().substring(0,1),
        author.getPatronymic().substring(0,1));
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

  public String getGenreName() {
    return genre.getName();
  }

  public int getReleaseYear() {
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
}
