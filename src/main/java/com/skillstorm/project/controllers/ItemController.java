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

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/{id}")
	public ItemDto findItemById(@PathVariable long id) {
		return itemService.findItemById(id);
	}
	
	@GetMapping
	public List<ItemDto> findAllItems() {
		return itemService.findAllItems();
	}
	
	@PostMapping
	public ResponseEntity<ItemDto> createItem(@Valid @RequestBody ItemDto itemData) {
		ItemDto item = itemService.createItem(itemData);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ItemDto updateItem(@PathVariable long id, @Valid @RequestBody ItemDto itemData) {
		itemData.setId(id);
		return itemService.createItem(itemData);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable long id) {
		itemService.deleteItem(id);
	}
}
