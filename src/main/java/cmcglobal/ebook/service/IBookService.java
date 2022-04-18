package cmcglobal.ebook.service;


import cmcglobal.ebook.exception.ExceptionHandle;
import cmcglobal.ebook.entity.Book;
import cmcglobal.ebook.model.request.BookRequest;


import java.util.List;

public interface IBookService {
     Book saveBook(BookRequest book) throws ExceptionHandle;
     Book deleteBook(BookRequest bookRequest) throws ExceptionHandle;
     List<Book> getAll();
     Book updateBook (BookRequest book) throws ExceptionHandle;
     Book getBookById (Long id);
     Book findBookByISBNCode(String isbnCode);
}
