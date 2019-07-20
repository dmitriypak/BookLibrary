package ru.projects.edu.spring.task14.booklibrary.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorPageController {
  @GetMapping("/authors")
  public String listBooksPage() {
    return "authors";
  }
}
