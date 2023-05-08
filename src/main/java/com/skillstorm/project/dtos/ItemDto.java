package com.skillstorm.project.dtos;

import javax.validation.constraints.NotBlank;

/**
 * Data transfer object for an item
 * @author Lily Zeiset
 *
 */
public class ItemDto {

	private long id;
	@NotBlank
	private String name;
	private String description;
	private long warehouseId;
	
	public ItemDto() {
		super();
	}

	public ItemDto(long id, String name, String description, long warehouseId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.warehouseId = warehouseId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(long warehouseId) {
		this.warehouseId = warehouseId;
	}
	
}
