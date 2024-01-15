package com.murach.db;

import com.murach.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, String> {
    List<Product> findAllByPriceGreaterThan(double price);
}
