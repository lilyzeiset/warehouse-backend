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
import com.skillstorm.project.dtos.WarehouseDto;
import com.skillstorm.project.services.WarehouseService;

/**
 * Handles incoming http requests at the /warehouse endpoint
 * @author Lily Zeiset
 *
 */
@RestController
@RequestMapping("/warehouse")
@CrossOrigin
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;
	
	/**
	 * Finds a warehouse by its id
	 * @param id The id of the warehouse
	 * @return Data of the found warehouse
	 */
	@GetMapping("/{id}")
	public WarehouseDto findWarehouseById(@PathVariable long id) {
		return warehouseService.findWarehouseById(id);
	}
	
	/**
	 * Finds all warehouses in the database
	 * @return List of all the warehouses' data
	 */
	@GetMapping
	public List<WarehouseDto> findAllWarehouses() {
		return warehouseService.findAllWarehouses();
	}
	
	/**
	 * Finds all items in a particular warehouse
	 * @param id The id of the warehouse
	 * @return List of the items' data
	 */
	@GetMapping("/{id}/items")
	public List<ItemDto> findAllItemsByWarehouseId(@PathVariable long id) {
		return warehouseService.findAllItemsByWarehouseId(id);
	}
	
	/**
	 * Finds the current capacity of a warehouse
	 * @param id The id of the warehouse
	 * @return the warehouse's current capacity
	 */
	@GetMapping("/{id}/capacity")
	public int getCurrentCapacityById(@PathVariable long id) {
		return warehouseService.getCurrentCapacityById(id);
	}
	
	/**
	 * Creates a new warehouse
	 * @param warehouseData The data of the warehouse to be created
	 * @return The data of the created warehouse wrapped in a 201 Created status
	 */
	@PostMapping
	public ResponseEntity<WarehouseDto> createWarehouse(@Valid @RequestBody WarehouseDto warehouseData) {
		WarehouseDto item = warehouseService.createWarehouse(warehouseData);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}
	
	/**
	 * Updates an existing warehouse
	 * @param id The id of the warehouse to be updated
	 * @param warehouseData The new data for the warehouse
	 * @return The data of the updated warehouse
	 */
	@PutMapping("/{id}")
	public WarehouseDto updateWarehouse(@PathVariable long id, @Valid @RequestBody WarehouseDto warehouseData) {
		warehouseData.setId(id);
		return warehouseService.createWarehouse(warehouseData);
	}
	
	/**
	 * Deletes a warehouse
	 * @param id The id of the warehouse to be deleted
	 */
	@DeleteMapping("/{id}")
	public void deleteWarehouse(@PathVariable long id) {
		warehouseService.deleteWarehouse(id);
	}
}
