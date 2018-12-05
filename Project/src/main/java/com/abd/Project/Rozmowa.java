package com.abd.Project;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "ROZMOWA")
public class Rozmowa {

	@Id
	Long id;
	@Column(name = "d")
	LocalDate d;
	@Column(name = "t", length = 20)
	String t;
	
	@Override
	public String toString() {
		return (this.id + " " + t + " " + d);
	}
}
