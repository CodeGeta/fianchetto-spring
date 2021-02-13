package com.example.fianchettochesstournamentmanagerserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tournaments_new")
public class NTournament {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String location;
	private int prize;
	private Date startDate = new Date();
	private Date endDate = new Date();
	private String description = null;
	private boolean inProgress = true;


	public NTournament() {

	}

	public NTournament(String name,
					   String description,
					   String location,
					   int prize,
					   Date startDate,
					   Date endDate,
                       boolean inProgress) {
		this.name = name;
		this.location = location;
		this.prize = prize;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.inProgress = inProgress;

	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isInProgress() {
		return inProgress;
	}
	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
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

}
