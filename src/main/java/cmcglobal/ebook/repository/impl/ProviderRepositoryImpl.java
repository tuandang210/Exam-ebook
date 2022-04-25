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
public class ProviderRepositoryImpl implements IProviderRepositoryExtend   {

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
        List<Provider> result=null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            result = query.getResultList();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();

        }
        return result;
    }

//    @Autowired
//    public void saveAllProviderByHQL2(String stringQuery) {
//        Session session = factory.openSession();
//        Transaction tx = null;
//        String hql = "INSERT INTO Provider(code,name) VALUES ('NXB6' , 'Nhà xuất bản Khoa Học') , ('NXB7' , 'Nhà xuất bản Thành Công')";
//
//        try {
//            tx = session.beginTransaction();
//            Query query = session.createQuery(hql);
//            int result = query.executeUpdate();
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//
//    }


}
