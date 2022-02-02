package test.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import test.test.model.Author;
import test.test.service.AuthorService;
import java.util.List;

@RestController
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author findAuthor(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        return authorService.create(author);
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        return authorService.update(id, author);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
    }
}
