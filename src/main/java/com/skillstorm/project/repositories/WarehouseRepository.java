package com.skillstorm.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.project.models.Warehouse;

/**
 * Repository to interface with warehouse table in database
 * @author Lily Zeiset
 *
 */
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long>{

}
