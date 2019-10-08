package ru.projects.edu.spring.task14.booklibrary.controllers;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
class GlobalControllerExceptionHandler {
  public static final String DEFAULT_ERROR_VIEW = "error";

  @ExceptionHandler(value = Exception.class)
  public ModelAndView
  defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    if (AnnotationUtils.findAnnotation
        (e.getClass(), ResponseStatus.class) != null)
      throw e;
    ModelAndView mav = new ModelAndView();
    mav.addObject("message", e.toString());
    mav.setViewName(DEFAULT_ERROR_VIEW);
    return mav;
  }
}