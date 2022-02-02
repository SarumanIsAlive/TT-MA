package test.test.service;

import test.test.model.Author;
import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findById(Long id);
    Author create(Author author);
    Author update(Long id, Author author);
    void delete(Long id);
}
