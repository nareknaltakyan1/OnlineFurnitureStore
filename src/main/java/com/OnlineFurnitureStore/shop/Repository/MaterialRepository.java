package com.OnlineFurnitureStore.shop.Repository;

import com.OnlineFurnitureStore.shop.Entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
}
