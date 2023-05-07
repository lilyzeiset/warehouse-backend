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

@RestController
@RequestMapping("/warehouse")
@CrossOrigin
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;
	
	@GetMapping("/{id}")
	public WarehouseDto findWarehouseById(@PathVariable long id) {
		return warehouseService.findWarehouseById(id);
	}
	
	@GetMapping
	public List<WarehouseDto> findAllWarehouses() {
		return warehouseService.findAllWarehouses();
	}
	
	@GetMapping("/{id}/items")
	public List<ItemDto> findAllItemsByWarehouseId(@PathVariable long id) {
		return warehouseService.findAllItemsByWarehouseId(id);
	}
	
	@GetMapping("/{id}/capacity")
	public int getCurrentCapacityById(@PathVariable long id) {
		return warehouseService.getCurrentCapacityById(id);
	}
	
	@PostMapping
	public ResponseEntity<WarehouseDto> createWarehouse(@Valid @RequestBody WarehouseDto warehouseData) {
		WarehouseDto item = warehouseService.createWarehouse(warehouseData);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public WarehouseDto updateWarehouse(@PathVariable long id, @Valid @RequestBody WarehouseDto warehouseData) {
		warehouseData.setId(id);
		return warehouseService.createWarehouse(warehouseData);
	}
	
	@DeleteMapping("/{id}")
	public void deleteWarehouse(@PathVariable long id) {
		warehouseService.deleteWarehouse(id);
	}
}
