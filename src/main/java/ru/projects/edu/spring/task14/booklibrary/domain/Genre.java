package ru.projects.edu.spring.task14.booklibrary.domain;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;


}
