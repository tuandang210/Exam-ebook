package cmcglobal.ebook.repository;

import cmcglobal.ebook.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProviderRepository extends JpaRepository<Provider, Long> {
    Provider getProviderByName(String name);

}
