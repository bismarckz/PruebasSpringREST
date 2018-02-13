package com.demo3test;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo3test.dao.interfaces.HotelRepositoryI;
import com.demo3test.vo.AddressVO;
import com.demo3test.vo.HotelVO;
import com.demo3test.vo.ReviewVO;



@Component
public class DbSeeder implements CommandLineRunner {
	private HotelRepositoryI hotelrepository;
	
	public DbSeeder(HotelRepositoryI hotelrepository) {
		this.hotelrepository = hotelrepository;
	}
	
	
	@Override
	public void run(String...strings) throws Exception {
	
		HotelVO marriot = new HotelVO(
					"Marriot",
					130,
					new AddressVO("Mexico","Cuahutla"),
					Arrays.asList(
								new ReviewVO ("Yazmin",9,true),
								new ReviewVO ("Briseida",9,false)
								)
				);// Termina un hotel
		
		HotelVO marriot2 = new HotelVO(
				"Marriot2",
				900,
				new AddressVO("Mexico","Cuernavaca"),
				Arrays.asList(
							new ReviewVO ("Mario",9,true)
							)
			);// Termina un hotel
		
		
		HotelVO marriot3 = new HotelVO(
				"Marriot3",
				1401,
				new AddressVO("Mexico","Cuernavaca"),
				Arrays.asList(
							new ReviewVO ("Itzel",2,true),
							new ReviewVO ("Andres",6,false),
							new ReviewVO ("Andres",4,false)
							)
			);// Termina un hotel
		
		
		//Borra toda los hoteles
		this.hotelrepository.deleteAll();
		
		
		//agrega los hoteles de arriba a la base de datos 
		List<HotelVO> hotels = Arrays.asList(marriot,marriot2,marriot3);
		this.hotelrepository.save(hotels);
		
	}

}
