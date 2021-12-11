package com.codeforgeyt.onetomanywebservice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.codeforgeyt.onetomanywebservice.model.dto.CartDto;
import com.codeforgeyt.onetomanywebservice.model.dto.ItemDto;

//@Data
@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "cart_id")
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public static Cart from(CartDto cartDto){
    	Item item = null;
    	List<Item> listItems = new ArrayList<>();
    	List<ItemDto> itemDtoList =cartDto.getItemsDto();
    	for(ItemDto itemDto: itemDtoList) {
    		item = new Item();
    		item.setSerialNumber(itemDto.getSerialNumber());
    		listItems.add(item);
    	}
        Cart cart = new Cart();
        cart.setName(cartDto.getName());
       // cart.setItems(listItems); 
        return cart;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
    
    
}
