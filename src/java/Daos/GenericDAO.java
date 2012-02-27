/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

/**
 *
 * @author snidE
 */
public class GenericDAO<T, PK extends Serializable> {

    private Class<T> type;
    private Session session;

    public GenericDAO() {
        type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        if (session == null) {
            session = Hibernate.getSessionFactory().getCurrentSession();
        }
        return session;
    }

    public PK create(T o) {
        getSession().beginTransaction();
        PK r = (PK) getSession().save(o);
        getSession().getTransaction().commit();
        return r;
    }

    public List<T> findByExample(T exampleInstance, String... excludeProperty) {
        getSession().beginTransaction();
        Criteria crit = getSession().createCriteria(type);
        Example example = Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        List<T> r = crit.list();
        getSession().getTransaction().commit();
        return r;
    }

    public T findById(PK id) {
        getSession().beginTransaction();
        T result = (T) getSession().get(type, id);
        getSession().getTransaction().commit();
        return result;
    }

    public void update(T o) {
        getSession().beginTransaction();
        getSession().update(o);
        getSession().getTransaction().commit();
    }

    public void delete(T o) {
        getSession().beginTransaction();
        getSession().delete(o);
        getSession().getTransaction().commit();
    }
}
