package test.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.test.model.Book;
import test.test.repository.BookRepository;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setName(book.getName());
            existingBook.setAuthors(book.getAuthors());
            return bookRepository.save(existingBook);
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
