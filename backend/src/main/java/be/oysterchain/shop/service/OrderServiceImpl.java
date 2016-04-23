package be.oysterchain.shop.service;

import be.oysterchain.shop.dao.product.ProductDao;
import be.oysterchain.shop.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by peterdp on 02.08.15.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void order(Product product) {
        productDao.save(product);
    }

    @Override
    public Product find(Long id) {
        return productDao.find(id);
    }
}
