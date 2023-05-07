package com.skillstorm.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.project.dtos.ItemDto;
import com.skillstorm.project.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("select i from Item i where i.warehouse.id = ?1")
	public List<Item> findAllItemsByWarehouseId(long id);

}
