package cmcglobal.ebook;


import cmcglobal.ebook.entity.Provider;
import cmcglobal.ebook.repository.impl.ProviderRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class EbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbookApplication.class, args);

	}



}
