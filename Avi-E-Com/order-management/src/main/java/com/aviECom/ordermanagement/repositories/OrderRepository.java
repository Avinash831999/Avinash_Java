package com.aviECom.ordermanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aviECom.ordermanagement.entity.OrderEntity;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	List<OrderEntity> findByUserId(Long userId);
}
