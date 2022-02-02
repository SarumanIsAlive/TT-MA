package test.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.test.model.Author;
import test.test.repository.AuthorRepository;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Long id, Author author) {
        return authorRepository.findById(id).map(existingAuthor -> {
            existingAuthor.setName(author.getName());
            existingAuthor.setBooks(author.getBooks());
            return authorRepository.save(existingAuthor);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
