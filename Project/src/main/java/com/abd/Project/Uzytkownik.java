package com.abd.Project;

import javax.persistence.*;

@Entity
@Table(name = "UZYTKOWNIK")
public class Uzytkownik {
	@Id
	Long id;
	String imie;
	String nazwisko;

	@Override
	public String toString() {
		return (this.id + " " + imie + " " + nazwisko);
	}
}
