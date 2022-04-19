package cmcglobal.ebook.exception;

import cmcglobal.ebook.entity.Author;
import cmcglobal.ebook.entity.Book;
import cmcglobal.ebook.model.request.BookRequest;

public class ExceptionResponse {
    public static void checkException(BookRequest book) throws ExceptionHandle{


        if (book.getName() == null) {
            throw new ExceptionHandle("Name cannot be null", "000");
        }
        if (book.getName().isEmpty()) {
            throw new ExceptionHandle("Name cannot be empty", "111");
        }
        if (book.getPrice() == null) {
            throw new ExceptionHandle("Price cannot be null", "112");
        }
        if (book.getQuantity() == null) {
            throw new ExceptionHandle("Quantity cannot be null", "115");
        }
        if (book.getiSBNCode() == null) {
            throw new ExceptionHandle("ISBN code cannot be null", "116");
        }
        if (book.getiSBNCode().isEmpty()) {
            throw new ExceptionHandle("ISBN code cannot be empty", "117");
        }
//        if (book.getProvider() == null ){
//            throw new ExceptionHandle("Provider cannot be null", "118" );
//        }
//        if (book.getAuthor() == null){
//            throw new ExceptionHandle("Author cannot be null", "113");
//        }
    }

    public static void checkExceptionAuthor(Author author) throws ExceptionHandle{
        if (author.getName() == null) {
                throw new ExceptionHandle("Name cannot be null", "000");
        }
        if (author.getName().isEmpty()) {
                throw new ExceptionHandle("Name cannot be empty", "111");
        }
        if(author.getId() == null){
            throw new ExceptionHandle("Cant find author id", "404");
        }
    }
}
