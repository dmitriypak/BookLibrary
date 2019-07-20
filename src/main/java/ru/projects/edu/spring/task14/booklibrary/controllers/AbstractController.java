package ru.projects.edu.spring.task14.booklibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AbstractController {
  @ExceptionHandler(Exception.class)
  public ModelAndView handleError(Exception e) {
    ModelAndView modelAndView = new ModelAndView("error");
    modelAndView.addObject("message", e.getMessage());
    return modelAndView;
  }
}
