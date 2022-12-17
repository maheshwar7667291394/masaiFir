package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FIR {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer firId;
	
	private String CrimeDetails;
	private String policeStation;
	

	
	private LocalDateTime timeStamp=LocalDateTime.now();
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private User userDetailsUser;
	
	public FIR() {}
	
	

	public Integer getFirId() {
		return firId;
	}
public FIR(Integer firId, String crimeDetails, String policeStation, LocalDateTime timeStamp, User userDetailsUser) {
	super();
	this.firId = firId;
	CrimeDetails = crimeDetails;
	this.policeStation = policeStation;
	this.timeStamp = timeStamp;
	this.userDetailsUser = userDetailsUser;
}



	public void setFirId(Integer firId) {
		this.firId = firId;
	}

	public String getCrimeDetails() {
		return CrimeDetails;
	}

	public void setCrimeDetails(String crimeDetails) {
		CrimeDetails = crimeDetails;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public User getUserDetailsUser() {
		return userDetailsUser;
	}

	public void setUserDetailsUser(User userDetailsUser) {
		this.userDetailsUser = userDetailsUser;
	}
	
	
	
	

}
