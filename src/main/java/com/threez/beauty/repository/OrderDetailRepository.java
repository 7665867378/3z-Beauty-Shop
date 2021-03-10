package com.threez.beauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.threez.beauty.model.OrderDetails;

@RepositoryRestResource(collectionResourceRel = "orderDetails", path = "orderDetails")
public interface OrderDetailRepository extends JpaRepository<OrderDetails, String>{

}
