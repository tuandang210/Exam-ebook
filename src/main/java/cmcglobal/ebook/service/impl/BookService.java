package cmcglobal.ebook.service.impl;


import cmcglobal.ebook.exception.ExceptionHandle;
import cmcglobal.ebook.entity.Book;
import cmcglobal.ebook.exception.ExceptionResponse;
import cmcglobal.ebook.model.request.BookRequest;
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
    public Book saveBook(BookRequest book) throws ExceptionHandle {
        ExceptionResponse.checkExceptionOfBook(book);
        Book newBook = new Book();
        newBook.setName(book.getName());
        newBook.setiSBNCode(book.getiSBNCode());
        newBook.setPrice(book.getPrice());
        newBook.setQuantity(book.getQuantity());
//        newBook.setAuthor(book.getAuthor());
//        newBook.setProvider(book.getProvider());
        String isbn = newBook.getiSBNCode();
        Book checkBook = bookRepository.findByISBNCode(isbn);
        if(checkBook != null){
            updateBook(book);
        }
        return bookRepository.save(newBook);
    }

    @Override
    public Book deleteBook(BookRequest bookRequest) throws ExceptionHandle {
        String isbn = bookRequest.getiSBNCode();
        Book checkBook = bookRepository.findByISBNCode(isbn);
        if (checkBook == null) {
            throw new ExceptionHandle("Isbn code does not exist","404");
        }else {
            checkBook.setStatus(true);
            return bookRepository.save(checkBook);
        }
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public Book updateBook(BookRequest book) throws ExceptionHandle{
        ExceptionResponse.checkExceptionOfBook(book);
        String isbn = book.getiSBNCode();
        Book checkBook = bookRepository.findByISBNCode(isbn);
        if (checkBook == null) {
            throw new ExceptionHandle("Isbn code does not exist","404");
        }else {
            checkBook.setName(book.getName());
            checkBook.setPrice(book.getPrice());
            checkBook.setQuantity(book.getQuantity() + book.getQuantity());
            return bookRepository.save(checkBook);
        }
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
