package com.skillstorm.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project.dtos.ItemDto;
import com.skillstorm.project.exceptions.ExceedMaxCapacityException;
import com.skillstorm.project.models.Item;
import com.skillstorm.project.models.Warehouse;
import com.skillstorm.project.repositories.ItemRepository;
import com.skillstorm.project.repositories.WarehouseRepository;

/**
 * Service for item
 * @author Lily Zeiset
 *
 */
@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	/**
	 * Finds an item by its id
	 * @param id The item's id
	 * @return The found item
	 */
	public ItemDto findItemById(long id) {
		return itemRepository.findById(id)
				.orElseThrow()
				.toDto();
	}
	
	/**
	 * Finds all items
	 * @return List of all items
	 */
	public List<ItemDto> findAllItems() {
		return itemRepository.findAll()
				.stream()
				.map(i -> i.toDto())
				.toList();
	}
	
	/**
	 * Creates an item
	 * @param itemData The data of the new item
	 * @return The data of the new item
	 */
	public ItemDto createItem(ItemDto itemData) {
		Warehouse warehouse = warehouseRepository.findById(itemData.getWarehouseId())
				.orElseThrow();
		
		int currentCapacity = itemRepository.findAllItemsByWarehouseId(warehouse.getId()).size();
		
		if (currentCapacity + 1 > warehouse.getMaxCapacity()) {
			throw new ExceedMaxCapacityException();
		} else {
		
			Item item = new Item(
					itemData.getId(),
					itemData.getName(),
					itemData.getDescription(),
					warehouse);
			
			return itemRepository.save(item).toDto();
		}
	}
	
	/**
	 * Updates an item
	 * @param itemData The data of the updated item
	 * @return The data of the updated item
	 */
	public ItemDto updateItem(ItemDto itemData) {
		Warehouse warehouse = warehouseRepository.findById(itemData.getWarehouseId())
				.orElseThrow();
		Item item = new Item(
				itemData.getId(),
				itemData.getName(),
				itemData.getDescription(),
				warehouse);
		
		return itemRepository.save(item).toDto();
	}
	
	/**
	 * Deletes an item
	 * @param id The id of the item to be deletd
	 */
	public void deleteItem(long id) {
		itemRepository.deleteById(id);
		
	}
}
