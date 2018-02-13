package com.demo3test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo3test.dao.interfaces.HotelRepositoryI;
import com.demo3test.vo.HotelVO;




@RestController
@RequestMapping("hotels")
public class HotelController {
	private HotelRepositoryI hotelRepository;
	
	public HotelController(HotelRepositoryI hotelRepository) {
		this.hotelRepository = hotelRepository;
		
	}
	
	@GetMapping("/all")
	public List<HotelVO> getAll(){
		
		List<HotelVO> hotels = this.hotelRepository.findAll();
		return hotels;
		
	}
	
	
	@PutMapping
	public void insert(@RequestBody HotelVO hotel) {
		this.hotelRepository.insert(hotel);
	}
	
	
	@PutMapping
	public void update(@RequestBody HotelVO hotel) {
		this.hotelRepository.save(hotel);
	}
	
	
	@PutMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		this.hotelRepository.delete(id);
	}
	
	@GetMapping("/{id}")
	public HotelVO getById(@PathVariable("id") String id){
		
		HotelVO hotel = this.hotelRepository.findById(id);
		return hotel;
	}
	
	@GetMapping("/price/{maxPrice}")
	public List<HotelVO> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
		
		List<HotelVO> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
		return hotels;
	}
	
	
	@GetMapping("/address/{city}")
	public List<HotelVO> getByCity(@PathVariable("city")String city){
		
		List<HotelVO> hotels = this.hotelRepository.findByCity(city);
		return hotels;
	}
	
	
	
	
}