package com.demo3test.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;





@Document(collection = "Hotels") // crea un objeto tipo documento para mongodb y lo guadra el acolecion hotels
public class HotelVO {

	@Id
	private String id;
	private String name;
	@Indexed(direction =IndexDirection.ASCENDING)
	private int pricePerNight;
	private AddressVO address;
	private List<ReviewVO> reviews;
	
	protected HotelVO() {this.reviews = new ArrayList<>();}

	public HotelVO(String name, int pricePerNight, AddressVO address, List<ReviewVO> reviews) {
		this.name = name;
		this.pricePerNight = pricePerNight;
		this.address = address;
		this.reviews = reviews;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public AddressVO getAddress() {
		return address;
	}

	public void setAddress(AddressVO address) {
		this.address = address;
	}

	public List<ReviewVO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewVO> reviews) {
		this.reviews = reviews;
	}
	
	
}
