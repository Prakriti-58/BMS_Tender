package com.ngn.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.ProductModel;

@Repository
public interface ProductModelRepo extends JpaRepository<ProductModel, Integer>{

}
