package cmcglobal.ebook.repository;

import cmcglobal.ebook.entity.Book;
import cmcglobal.ebook.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
    @Query(value = "select * from book b where b.isbncode = :iSBNCode", nativeQuery = true)
    Book findByISBNCode(@Param("iSBNCode") String iSBNCode);

    Book getBookByProvider(Provider provider);
}
