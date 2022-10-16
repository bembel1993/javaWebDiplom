package by.application.javaWeb.dao.daoImpl;


import by.application.javaWeb.dao.IFileDao;
import by.application.javaWeb.model.file.FileEntity;
import by.application.javaWeb.sessionFactory.SessionFactoryImpl;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Marcio Ballem on 16/04/2014.
 */
public class FileDao implements IFileDao<FileEntity> {

    public void save(FileEntity entity) {
        Session session = SessionFactoryImpl.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<FileEntity> findAll() {
        Session session = SessionFactoryImpl.getSessionFactory().openSession();;
        session.beginTransaction();

        List<FileEntity> entities = session.createCriteria(FileEntity.class).list();

        session.getTransaction().commit();
        return entities;
    }

    @Override
    public FileEntity find(String year, String month, String name) {
        Session session = SessionFactoryImpl.getSessionFactory().openSession();;
        session.beginTransaction();

        FileEntity entity = (FileEntity) session.createCriteria(FileEntity.class)
                .add(Restrictions.eq("year", year))
                .add(Restrictions.eq("month", month))
                .add(Restrictions.eq("name", name))
                .uniqueResult();

        session.getTransaction().commit();
        return entity;
    }
}
