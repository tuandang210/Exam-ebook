package cmcglobal.ebook.controller.api;

import cmcglobal.ebook.common.ResponseData;
import cmcglobal.ebook.exception.ExceptionHandle;
import cmcglobal.ebook.entity.Book;
import cmcglobal.ebook.service.IServiceBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/book")
public class ControllerBook {
    private static final Logger log = LoggerFactory.getLogger(ControllerBook.class);
    @Autowired
    private IServiceBook serviceBook;


    @PostMapping("/create-book")
    public ResponseData createBook(@RequestBody Book book) {
        ResponseData responseData = new ResponseData();
        try {
            Book bookResult = serviceBook.saveBook(book);
            responseData.setData(bookResult);
            responseData.setStatus("SUCCESS");
            responseData.setCode("");
        } catch (ExceptionHandle e) {
            log.error(e.getMessage());
            e.printStackTrace();
            responseData.setMessage(e.getMessage());
            responseData.setCode(e.getCode());
            responseData.setStatus("ERROR");
        }catch (Exception e) {
            e.printStackTrace();
            responseData.setStatus("ERROR");
        }
        return responseData;
    }
}
