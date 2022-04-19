package cmcglobal.ebook.repository;

import cmcglobal.ebook.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {

    Author findAuthorById(Long id);

    @Query(value = "select count(a.id) as int from author a join book_author ba on a.id = ba.author_id where a.id = ?1;", nativeQuery = true)
    int isAuthorStillHasBookInStock(Long id);

}