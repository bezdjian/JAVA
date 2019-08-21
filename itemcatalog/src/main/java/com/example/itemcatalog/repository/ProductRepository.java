package com.example.itemcatalog.repository;

import com.example.itemcatalog.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
// Endpoint localhost:8089/items from edge-server comes here because of @RepositoryRestResource!! AWSome!
public interface ProductRepository extends JpaRepository<Product, Long> {}
