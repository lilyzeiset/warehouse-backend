package com.skillstorm.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.project.dtos.ItemDto;
import com.skillstorm.project.models.Item;

/**
 * Repository to interface with item table in database
 * @author Lily Zeiset
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	/**
	 * Finds all Items in a particular warehouse
	 * @param id The id of the warehouse
	 * @return List of items in the warehouse
	 */
	@Query("select i from Item i where i.warehouse.id = ?1")
	public List<Item> findAllItemsByWarehouseId(long id);

}
