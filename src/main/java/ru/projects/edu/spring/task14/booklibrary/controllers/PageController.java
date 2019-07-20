package ru.projects.edu.spring.task14.booklibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController extends AbstractController {
  @GetMapping({"/","/index"})
  public String indexPage() {
    return "index";
  }

}
