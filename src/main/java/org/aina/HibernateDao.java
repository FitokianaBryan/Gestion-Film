package org.aina;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class HibernateDao {
    private SessionFactory sessionFactory;

    public HibernateDao() {
    }

    public <T> T create(T entity) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    public <T> T findById(Class<T> clazz, Serializable id) {
        Session session = this.sessionFactory.openSession();
        T entity = session.get(clazz, id);
        session.close();
        return entity;
    }

    public <T> List<T> findAll(Class<T> tClass) {
        Session session = this.sessionFactory.openSession();
        List<T> results = session.createCriteria(tClass).list();
        session.close();
        return results;
    }

    public <T> List<T> findWhere(T entity) {
        Session session = this.sessionFactory.openSession();
        Example example = Example.create(entity).ignoreCase();
        List<T> results = session.createCriteria(entity.getClass()).add(example).list();
        session.close();
        return results;
    }

    public <T> List<T> paginateWhere(T entity, int offset, int size) {
        Session session = this.sessionFactory.openSession();
        Example example = Example.create(entity).ignoreCase();
        List<T> results = session.createCriteria(entity.getClass()).add(example).setFirstResult(offset).setMaxResults(offset + size).list();
        session.close();
        return results;
    }

    public <T> List<T> paginate(Class<T> clazz, int offset, int size) {
        Session session = this.sessionFactory.openSession();
        List<T> results = session.createCriteria(clazz).setFirstResult(offset).setMaxResults(offset + size).list();
        session.close();
        return results;
    }

    public <T> List<T> paginate(Class<T> clazz, int offset, int size, String orderBy, boolean orderAsc) {
        Session session = this.sessionFactory.openSession();
        Order order = orderAsc ? Order.asc(orderBy) : Order.desc(orderBy);
        List<T> results = session.createCriteria(clazz).addOrder(order).setFirstResult(offset).setMaxResults(offset + size).list();
        session.close();
        return results;
    }

    public void deleteById(Class tClass, Serializable id) {
        this.delete(this.findById(tClass, id));
    }

    public void delete(Object entity) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public <T> T update(T entity) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
        return entity;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public <T> List<T>  pagination(Class<T> tClass,int page, int size) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(tClass);
        criteria.setFirstResult((page - 1) * size);
        criteria.setMaxResults(size);
        List<T> results = criteria.list();
        session.getTransaction().commit();
        session.close();
        return results;
    }
    public <T> List<T>  paginationwhere(T entity,int page, int size) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Example example = Example.create(entity).ignoreCase();
        List<T> results = session.createCriteria(entity.getClass()).add(example).setFirstResult((page - 1) * size).setMaxResults(size).list();
        session.getTransaction().commit();
        session.close();
        return results;
    }

    public <T> int Count(Class<T> classe) throws Exception {
        long count = 0;
        Session session = this.sessionFactory.openSession();
        Query<Long> query = session.createQuery("SELECT COUNT(*) FROM "+classe.getSimpleName(),Long.class);
        count = query.uniqueResult();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return (int) count;
    }
}
