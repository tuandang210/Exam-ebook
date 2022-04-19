package cmcglobal.ebook.controller;

import cmcglobal.ebook.entity.Author;
import cmcglobal.ebook.exception.ExceptionHandle;
import cmcglobal.ebook.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping("/add")
    public ResponseEntity<?> addNewAuthor(@RequestBody Author author) throws ExceptionHandle {
        return new ResponseEntity<>(authorService.save(author), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateAuthor(@RequestBody Author author) throws ExceptionHandle {
        return new ResponseEntity<>(authorService.update(author), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAuthor(@Param("id") Long id) throws ExceptionHandle {
        return new ResponseEntity<>(authorService.deleteAuthor(id), HttpStatus.OK);
    }
}
