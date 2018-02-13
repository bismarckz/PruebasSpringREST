package com.demo3test.dao.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo3test.vo.HotelVO;

@Repository
public interface HotelRepositoryI extends MongoRepository<HotelVO,String>{
	HotelVO findById(String id);
	
	List<HotelVO> findByPricePerNightLessThan(int maxPrice);
	
	@Query(value = "{address.city:?0}")
	List<HotelVO> findByCity(String city);
	
	
}
