package cmcglobal.ebook.service.impl;

import cmcglobal.ebook.exception.ExceptionHandle;
import cmcglobal.ebook.entity.Book;
import cmcglobal.ebook.repository.IRepositoryBook;
import cmcglobal.ebook.service.IServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBook implements IServiceBook {
    @Autowired
    public IRepositoryBook repositoryBook;


    @Override
    public Book saveBook(Book book) throws ExceptionHandle {
        if (book.getName() == null ){
            throw new ExceptionHandle("Null", "000" );
        }
        if (book.getName().isEmpty() ){
            throw new ExceptionHandle("isEmpty", "111" );
        }

        return repositoryBook.save(book);
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
        return repositoryBook.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return repositoryBook.getById(id);
    }

//    @Override
//    public Book findBookByISBNCode(String isbnCode) {
////        return repositoryBook.findBookByISBNCode(isbnCode);
//    }
}
