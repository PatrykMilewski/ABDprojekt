package com.abd.Project;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "ROZMOWA_GLOSOWA")
public class RozmowaGlosowa extends Rozmowa {
	@Id
	Long id;
	int czasTrwania;
	Long fkIdRozmowa;
	String typ;
	
	@Override
	public String toString() {
		return (this.id + " " + czasTrwania + " " + fkIdRozmowa + " " + typ);
	}

}
