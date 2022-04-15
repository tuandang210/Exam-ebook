package cmcglobal.ebook.service;

import cmcglobal.ebook.exception.ExceptionHandle;
import cmcglobal.ebook.entity.Book;

import java.util.List;

public interface IServiceBook {
     Book saveBook(Book book) throws ExceptionHandle;
     void deleteBook(Long id);
     List<Book> getAll();
     Book updateBook (Book book);
     Book getBookById (Long id);
//     Book findBookByISBNCode(String isbnCode);

}
