package be.oysterchain.shop.dao.common;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by peterdp on 02.08.15.
 */
@Repository
public class EntityDao {

    @PersistenceContext
    private EntityManager entityManager;


    public <T> T find(Long id, Class<T> clazz) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findAll(Class<T> clazz) {
        return entityManager.createQuery("select o from " + clazz.getSimpleName() + " o").getResultList();
    }

    public EntityManager getEm() {
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getEntitiesByNamedQuery(final String nameQuery, Class<T> clazz) {
        Query q = getEm().createNamedQuery(nameQuery);
        return q.getResultList();
    }


    @SuppressWarnings("unchecked")
    public <T> List<T> getEntitiesByNamedQuery(final String nameQuery, Map<String, Object> params, Class<T> clazz) {
        Query query = getNamedQueryWithParameters(nameQuery, params);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getEntitiesByNamedQuery(final String nameQuery, Map<String, Object> params, Class<T> clazz, int maxResults) {
        Query query = getNamedQueryWithParameters(nameQuery, params);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

/*    @SuppressWarnings("unchecked")
    public <T> Optional<T> getEntityByNamedQuery(final String nameQuery, Map<String, Object> params, Class<T> clazz) {
        Query query = getNamedQueryWithParameters(nameQuery, params);
        try {
            return Optional.of((T) query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.<T> absent();
        }
    }*/

    public Query getNamedQueryWithParameters(final String namedQuery, Map<String, Object> params) {
        Query query = getEm().createNamedQuery(namedQuery);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query;
    }

/*    public <T extends AbstractDomainObject> T mergeOrPersist(T entity) {
        if (!entity.isPersisted()) {
            persist(entity);
            return entity;
        }
        return entityManager.merge(entity);
    }*/

    public <T> void persist(T entity) {
        entityManager.persist(entity);
    }

    public void flush() {
        entityManager.flush();
    }

    public <T> void remove(T entity) {
        entityManager.remove(entity);
    }

/*    public <T> List<T> getEntitiesBySqlQueryBuilderAndPaginationParam(SqlQueryBuilder sqlQueryBuilder, PaginationParam paginationParam, Class<T> clazz) {
        Query query = entityManager.createNativeQuery(sqlQueryBuilder.build(), clazz);
        query.setFirstResult(paginationParam.getFirstResult());
        Integer maxResults = paginationParam.getPageSize();
        if (maxResults != null) {
            query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T getValueBySqlQueryBuilder(SqlQueryBuilder sqlQueryBuilder) {
        Query query = entityManager.createNativeQuery(sqlQueryBuilder.build());
        return (T) query.getSingleResult();
    }*/

    public Long getLongByNamedQuery(String namedQuery, Map<String, Object> parameters) {
        Query query = getNamedQueryWithParameters(namedQuery, parameters);
        return ((Number) query.getSingleResult()).longValue();
    }
}
