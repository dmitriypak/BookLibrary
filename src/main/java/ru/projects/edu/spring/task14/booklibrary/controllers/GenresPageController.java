package ru.projects.edu.spring.task14.booklibrary.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.projects.edu.spring.task14.booklibrary.domain.Genre;
import ru.projects.edu.spring.task14.booklibrary.services.genre.GenreService;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class GenresPageController extends AbstractController {
  private GenreService genreService;

  public GenresPageController(GenreService genreService) {
    this.genreService = genreService;
  }

  @GetMapping("/genres")
  public String listGenres(Model model) {
    List<Genre> genres = genreService.findAll();
    model.addAttribute("genres",genres);
    model.addAttribute("newGenre",new Genre());
    return "genres";
  }

  @PostMapping("/genres/add")
  @Transactional
  public String addGenre(@ModelAttribute Genre newGenre) {
    genreService.save(newGenre);
    return "redirect:/genres";
  }


  @PostMapping("/genres/delete")
  @Transactional
  public String deleteGenre(@RequestParam("id") long genreId) {
    genreService.deleteById(genreId);
    return "redirect:/genres";
  }

}
