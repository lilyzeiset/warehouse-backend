package com.skillstorm.project.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project.dtos.ItemDto;
import com.skillstorm.project.services.ItemService;

/**
 * handles incoming http requests at the /item endpoint
 * @author Lily Zeiset
 *
 */
@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/**
	 * Finds an item by its id
	 * @param id The id of the item
	 * @return Data of the found item
	 */
	@GetMapping("/{id}")
	public ItemDto findItemById(@PathVariable long id) {
		return itemService.findItemById(id);
	}
	
	/**
	 * Finds all items in the database
	 * @return List of all the items' data
	 */
	@GetMapping
	public List<ItemDto> findAllItems() {
		return itemService.findAllItems();
	}
	
	/**
	 * Creates a new item
	 * @param itemData The data of the new item
	 * @return The data of the created item wrapped in a 201 Created status
	 */
	@PostMapping
	public ResponseEntity<ItemDto> createItem(@Valid @RequestBody ItemDto itemData) {
		ItemDto item = itemService.createItem(itemData);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}
	
	/**
	 * Updates an existing item
	 * @param id The id of the item to be updated
	 * @param itemData The new data for the item
	 * @return The data of the updated item
	 */
	@PutMapping("/{id}")
	public ItemDto updateItem(@PathVariable long id, @Valid @RequestBody ItemDto itemData) {
		itemData.setId(id);
		return itemService.updateItem(itemData);
	}
	
	/**
	 * Deletes an item
	 * @param id The id of the item to be deleted
	 */
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable long id) {
		itemService.deleteItem(id);
	}
}
