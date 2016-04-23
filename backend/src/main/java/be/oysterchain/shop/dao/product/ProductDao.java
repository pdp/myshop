package be.oysterchain.shop.dao.product;

import be.oysterchain.shop.domain.product.Product;

/**
 * peter
 * 20.07.15
 */
public interface ProductDao {

    void save(Product product);

    Product find(Long id);
}
