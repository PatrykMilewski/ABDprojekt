package com.abd.Project;

import javax.persistence.*;

@Entity
@Table(name = "GRUPA")
public class Grupa {

	@Id
	Long id;

	String nazwa;
	@Column(name = "FK_ID_GRUPA_NADRZ")
	Long nadgrupa;

	@Override
	public String toString() {
		return (this.id + " " + nazwa + " " + nadgrupa);
	}
}
