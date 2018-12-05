package com.abd.Project;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "ROZMOWA_GLOSOWA")
public class RozmowaWideo extends RozmowaGlosowa {
	@Id
	Long id;
	String rozdzielczosc;
	String typ;
	Long fkIdRozmGl;

	@Override
	public String toString() {
		return (this.id + " " + rozdzielczosc + " " + typ + " " + fkIdRozmGl);
	}
}
