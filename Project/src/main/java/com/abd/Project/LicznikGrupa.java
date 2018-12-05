package com.abd.Project;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "LICZNIK_GRUPA")
public class LicznikGrupa {
	@Id
	Long id;
	@Column (name = "NAZWA")
	String nazwa;
	@Column (name = "LICZBA")
	int liczba;
	
	@Override
	public String toString() {
		return (nazwa + " " + liczba);
	}
}
