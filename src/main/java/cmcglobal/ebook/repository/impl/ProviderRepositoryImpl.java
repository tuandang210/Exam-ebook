package cmcglobal.ebook.repository.impl;


import javax.persistence.*;

import cmcglobal.ebook.entity.Provider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class ProviderRepositoryImpl implements IProviderRepositoryExtend {

    //    @Autowired
//     private SessionFactory sessionFactory;
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Provider> findProviderByCodesList(String stringQuery) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);

//       Session session = sessionFactory.openSession();

        Transaction tx = null;
        String hql = stringQuery;
        List<Provider> result = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery(hql);
            result = query.getResultList();

            Query query2 = session.createNativeQuery(hql);
            result = query.getResultList();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();

        }
        return result;
    }

    @Override
    public void saveAllProviderByHibernate(Provider[] providers) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        Transaction tx = null;


        try {
            tx = session.beginTransaction();

            for (int i = 0; i < providers.length; i++) {
                session.save(providers[i]);

                if (i % 100 == 0) {//a batch size for safety
                    session.flush();
                    session.clear();
                }
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


}
