package cmcglobal.ebook.service;


import cmcglobal.ebook.common.ResponseData;
import cmcglobal.ebook.entity.Author;
import cmcglobal.ebook.exception.ExceptionHandle;

public interface IAuthorService{
    ResponseData save(Author author) throws ExceptionHandle;
    Author findById(Long id);
    ResponseData update(Author author) throws ExceptionHandle;
    int isAuthorStillHasBookInStock(Long id);
    ResponseData deleteAuthor(Long id) throws ExceptionHandle;
}
