package com.OnlineFurnitureStore.shop.Repository;

import com.OnlineFurnitureStore.shop.Entity.Country;
import com.OnlineFurnitureStore.shop.Entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
}
