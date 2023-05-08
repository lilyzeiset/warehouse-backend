package com.skillstorm.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project.dtos.ItemDto;
import com.skillstorm.project.dtos.WarehouseDto;
import com.skillstorm.project.exceptions.ExceedMaxCapacityException;
import com.skillstorm.project.models.Item;
import com.skillstorm.project.models.Warehouse;
import com.skillstorm.project.repositories.ItemRepository;
import com.skillstorm.project.repositories.WarehouseRepository;

/**
 * Service for warehouse
 * @author Lily Zeiset
 *
 */
@Service
@Transactional
public class WarehouseService {
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	/**
	 * Finds a warehouse by its id
	 * @param id The warehouse's id
	 * @return The data of the found warehouse
	 */
	public WarehouseDto findWarehouseById(long id) {
		return warehouseRepository.findById(id)
				.orElseThrow()
				.toDto();
	}
	
	/**
	 * Finds all warehouses
	 * @return List of all warehouses
	 */
	public List<WarehouseDto> findAllWarehouses() {
		return warehouseRepository.findAll()
				.stream()
				.map(w -> w.toDto())
				.toList();
	}

	/**
	 * Creates/updates a warehouse
	 * @param warehouseData The data of the new/updated warehouse
	 * @return The data of the new/updated warehouse
	 */
	public WarehouseDto createWarehouse(WarehouseDto warehouseData) {
		Warehouse warehouse = new Warehouse(
				warehouseData.getId(),
				warehouseData.getName(),
				warehouseData.getDescription(),
				warehouseData.getAddress(),
				warehouseData.getMaxCapacity());
		
		return warehouseRepository.save(warehouse).toDto();
	}

	/**
	 * Deletes a warehouse
	 * @param id The warehouse's id
	 */
	public void deleteWarehouse(long id) {
		List<Item> items = itemRepository.findAllItemsByWarehouseId(id);
		
		for (Item i : items) {
			itemRepository.deleteById(i.getId());
		}
		warehouseRepository.deleteById(id);
		
	}

	/**
	 * Gets the current number of items in a warehouse
	 * @param id The id of the warehouse
	 * @return Number of items in the warehouse
	 */
	public int getCurrentCapacityById(long id) {
		List<Item> items = itemRepository.findAllItemsByWarehouseId(id);

		Warehouse warehouse = warehouseRepository.findById(id).orElseThrow();
		
		if (items.size() > warehouse.getMaxCapacity()) {
			throw new ExceedMaxCapacityException();
		}
		
		return items.size();
	}

	/**
	 * Finds all items within a warehouse
	 * @param warehouseId The id of the warehouse
	 * @return List of items
	 */
	public List<ItemDto> findAllItemsByWarehouseId(long warehouseId) {
		return itemRepository.findAllItemsByWarehouseId(warehouseId)
				.stream()
				.map(i -> i.toDto())
				.toList();
	}

	

}
