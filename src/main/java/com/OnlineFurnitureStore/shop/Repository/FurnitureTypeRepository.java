package com.OnlineFurnitureStore.shop.Repository;

import com.OnlineFurnitureStore.shop.Entity.FurnitureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureTypeRepository extends JpaRepository<FurnitureType, Long> {
}
