package com.spring.product.repositories;

import com.spring.product.models.Prop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropRepository extends JpaRepository<Prop, Integer> {
    List<Prop> findAllByOwner_Id(Integer id);
    List<Prop> findAllByOwnerIsNull();
}
