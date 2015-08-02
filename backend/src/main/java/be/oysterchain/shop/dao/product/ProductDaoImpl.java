package be.oysterchain.shop.dao.product;

import be.oysterchain.shop.dao.common.EntityDao;
import be.oysterchain.shop.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private EntityDao entityDao;

    public ProductDaoImpl() {

    }

    @Override
    @Transactional
    public void save(Product product) {
        entityDao.persist(product);
    }

}
