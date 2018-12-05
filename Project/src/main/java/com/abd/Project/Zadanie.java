package com.abd.Project;

import javax.persistence.*;



import java.time.LocalDate;

@Entity
@Table(name="ZADANIE")
public class Zadanie {
    @Id
    Long id;
	
    String czasTrwania;
    
	String miejsce;
	
	String nazwa;
	
	String szczegoly;
	
	@Override
	public String toString(){
		return (this.id + " " + czasTrwania + " " + miejsce + " " + nazwa + " " + szczegoly);
	}
	
}
