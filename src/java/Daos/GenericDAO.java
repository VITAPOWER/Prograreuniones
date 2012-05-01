/*
 * Do not change this page
 */
package Daos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

/**
 * Metodo de interfaz generico con la base de datos se puede aplicar a cualquier pojo
 */
public class GenericDAO<T, PK extends Serializable> {

    private Class<T> type;
    private Session session;

    public GenericDAO() {
        type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Obtiene la conexion a la base de datos.
     * @return 
     */
    protected Session getSession() {
        if (session == null) {
            session = Hibernate.getSessionFactory().getCurrentSession();
        }
        return session;
    }

    /**
     * Metodo para crear un row en la base de datos dependiendo del pojo que se asocia
     * @param o 
     * @return regresa su id
     */
    public PK create(T o) {
        getSession().beginTransaction();
        PK r = (PK) getSession().save(o);
        getSession().getTransaction().commit();
        return r;
    }

    /**
     * Encuentra rows de una tabla que son parecidos al objeto pojo que le das de ejemplo
     * @param exampleInstance
     * @param excludeProperty parametro opcional para exluir atributos
     * @return regresa los rows en forma de una lista de objetos del tipo pojo que cumplen con las condiciones del objeto
     */
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

    /**
     * Encuentra un objeto pojo con el id dado
     * @param id
     * @return Si encuentra un row con el id lo regresa en forma de pojo
     */
    public T findById(PK id) {
        getSession().beginTransaction();
        T result = (T) getSession().get(type, id);
        getSession().getTransaction().commit();
        return result;
    }

    /**
     * Updatea el pojo dado
     * @param o el pojo que se va a borrar
     */
    public void update(T o) {
        getSession().beginTransaction();
        getSession().update(o);
        getSession().getTransaction().commit();
    }

    /**
     * Borra el pojo dado
     * @param o el pojo que se va a borrar
     */
    public void delete(T o) {
        getSession().beginTransaction();
        getSession().delete(o);
        getSession().getTransaction().commit();
    }
}
