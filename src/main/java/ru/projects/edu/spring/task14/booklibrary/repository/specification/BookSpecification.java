package ru.projects.edu.spring.task14.booklibrary.repository.specification;
import org.springframework.data.jpa.domain.Specification;
import ru.projects.edu.spring.task14.booklibrary.domain.Book;
import ru.projects.edu.spring.task14.booklibrary.domain.dto.BookDto;

import javax.persistence.criteria.*;

public class BookSpecification implements Specification<Book> {
  private BookDto filter;
  public BookSpecification(BookDto filter) {
    super();
    this.filter = filter;
  }

  @Override
  public Specification<Book> and(Specification<Book> other) {
    return null;
  }

  @Override
  public Specification<Book> or(Specification<Book> other) {
    return null;
  }

  public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
    Join joinAuthor = root.join("author");
    Join joinGenre = root.join("genre");
    Predicate p = cb.conjunction();
    if (filter.getAuthorFullName() != null && !filter.getAuthorFullName().isEmpty()) {
      p.getExpressions().add(cb.or(cb.like(cb.lower(joinAuthor.get("family")), "%"+filter.getAuthorFullName().toLowerCase()+"%"),
          cb.like(cb.lower(joinAuthor.get("firstName")), "%"+filter.getAuthorFullName().toLowerCase()+"%"),
          cb.or(cb.like(cb.lower(joinAuthor.get("patronymic")), "%"+filter.getAuthorFullName().toLowerCase()+"%"))));
    }

    if(filter.getReleaseYear()!=null){
      p.getExpressions().add(cb.equal(root.get("releaseYear"),filter.getReleaseYear()));
    }
    if(filter.getGenreName()!=null && !filter.getGenreName().isEmpty()){
      p.getExpressions().add(cb.like(cb.lower(joinGenre.get("name")), "'%"+filter.getGenreName().toLowerCase()+"%'"));
    }
    if(filter.getName()!=null && !filter.getName().isEmpty()){
      p.getExpressions().add(cb.like(cb.lower(root.get("name")), "%"+filter.getName().toLowerCase()+"%"));
    }
    return p;
  }
}
