package be.oysterchain.shop.service;

import be.oysterchain.shop.domain.product.Product;

/**
 * Created by peterdp on 02.08.15.
 */
public interface OrderService {

    void order(Product product);

    Product find(Long id);
}
