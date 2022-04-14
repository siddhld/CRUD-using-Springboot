package com.sidd.proj.PersonAddress.Entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address {

	private String cityName;
	private String pincode;
	private String houseNo;
}
