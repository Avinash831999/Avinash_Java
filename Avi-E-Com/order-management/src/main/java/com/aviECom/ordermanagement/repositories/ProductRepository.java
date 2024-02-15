package com.aviECom.ordermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aviECom.ordermanagement.entity.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
