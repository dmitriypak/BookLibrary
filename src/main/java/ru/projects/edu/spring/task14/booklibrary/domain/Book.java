package ru.projects.edu.spring.task14.booklibrary.domain;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id")
  private Author author;

  @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  @JoinColumn(name = "genre_id")
  private Genre genre;
  @Column(name="release_year", nullable = false)
  private Integer releaseYear;

  @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  @JoinColumn(name = "cover_file_id", nullable = false)
  private DBFile coverImage;

  public Book() {
  }

  public Book(Long id, String name, Author author, Genre genre, Integer releaseYear,DBFile coverImage) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.genre = genre;
    this.releaseYear = releaseYear;
    this.coverImage = coverImage;
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

  public void setReleaseYear(Integer releaseYear) {
    this.releaseYear = releaseYear;
  }

  public DBFile getCoverImage() {
    return coverImage;
  }

  public void setCoverImage(DBFile coverImage) {
    this.coverImage = coverImage;
  }


}
