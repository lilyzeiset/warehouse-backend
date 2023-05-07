package com.skillstorm.project.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.skillstorm.project.dtos.WarehouseDto;

/**
 * Represents a single warehouse.
 * @author lily
 *
 */
@Entity @Table(name = "warehouse")
public class Warehouse {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "warehouse_id")
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private String address;
	
	@Column(name = "max_capacity")
	private int maxCapacity;

	public Warehouse() {
		super();
	}

	public Warehouse(long id, String name, String description, String address, int maxCapacity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.maxCapacity = maxCapacity;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		return id == other.id;
	}
	
	public WarehouseDto toDto() {
		return new WarehouseDto(id, name, description, address, maxCapacity);
	}

}
