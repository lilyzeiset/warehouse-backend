package com.skillstorm.project.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.skillstorm.project.dtos.ItemDto;

/**
 * Represents an item contained in a warehouse
 * @author Lily Zeiset
 *
 */
@Entity @Table(name = "item")
public class Item {

	/**
	 * Primary key
	 */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	/**
	 * Name of item
	 */
	@Column
	private String name;
	
	/**
	 * Description of item
	 */
	@Column
	private String description;
	
	/**
	 * Warehouse containing this item
	 */
	@ManyToOne
	@JoinColumn(name = "warehouse_id")
	private Warehouse warehouse;
	

	public Item() {
		super();
	}

	public Item(long id, String name, String description, Warehouse warehouse) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.warehouse = warehouse;
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
		Item other = (Item) obj;
		return id == other.id;
	}
	
	public ItemDto toDto() {
		return new ItemDto(id, name, description, warehouse.getId());
	}
	
	
}
