package com.abd.Project;

import javax.persistence.*;


@Entity
@Table(name="HARMONOGRAM")
public class Harmonogram {

	@Id
	Long id;
	Long FK_ID_UZYTK;
	
	@Override
	public String toString() {
		return (this.id + " " + FK_ID_UZYTK);
	}
}
