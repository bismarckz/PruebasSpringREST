package com.demo3test.vo;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Addresses")
public class AddressVO {
		
		@Id
		@Indexed(direction =IndexDirection.ASCENDING)
		private String Id;
		private String city;
		
		private String country;
		
		public AddressVO(String city, String country) {
			super();
			this.city = city;
			this.country = country;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		
	
}
