package com.skillstorm.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.project.dtos.ItemDto;
import com.skillstorm.project.models.Item;
import com.skillstorm.project.models.Warehouse;
import com.skillstorm.project.repositories.ItemRepository;
import com.skillstorm.project.repositories.WarehouseRepository;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	/**
	 * Finds an item by its id
	 * @param id item id
	 * @return the found item
	 */
	public ItemDto findItemById(long id) {
		return itemRepository.findById(id)
				.orElseThrow()
				.toDto();
	}
	
	/**
	 * Finds all items
	 * @return list of items
	 */
	public List<ItemDto> findAllItems() {
		return itemRepository.findAll()
				.stream()
				.map(i -> i.toDto())
				.toList();
	}
	
	/**
	 * Creates/updates an item
	 * @param itemData
	 * @return the new item
	 */
	public ItemDto createItem(ItemDto itemData) {
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
	 * @param id item id
	 */
	public void deleteItem(long id) {
		itemRepository.deleteById(id);
		
	}
}
