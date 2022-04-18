package cmcglobal.ebook.service.impl;

import cmcglobal.ebook.exception.ExceptionHandle;
import cmcglobal.ebook.entity.Book;
import cmcglobal.ebook.repository.IBookRepository;
import cmcglobal.ebook.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    public IBookRepository bookRepository;


    @Override
    public Book saveBook(Book book) throws ExceptionHandle {
        if (book.getName() == null ){
            throw new ExceptionHandle("Name cannot be null", "000" );
        }
        if (book.getName().isEmpty() ){
            throw new ExceptionHandle("Name cannot be empty", "111" );
        }
        if (book.getPrice() == null){
            throw new ExceptionHandle("Price cannot be null", "112");
        }
        if (book.getAuthor() == null){
            throw new ExceptionHandle("Author cannot be null", "113");
        }
        if (book.getAuthor().isEmpty()){
            throw new ExceptionHandle("Author cannot be empty", "114");
        }

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book findBookByISBNCode(String isbnCode) {
        return bookRepository.findByISBNCode(isbnCode);
    }
}
