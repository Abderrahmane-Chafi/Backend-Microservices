package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource //It simplifies the process of creating REST APIs by providing default CRUD operations for an entity.
public interface ProductRepository extends JpaRepository<Product,Long> {
}
