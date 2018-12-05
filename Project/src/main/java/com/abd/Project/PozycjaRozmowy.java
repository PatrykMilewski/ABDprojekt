package com.abd.Project;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "POZYCJA_ROZMOWY")
public class PozycjaRozmowy implements Serializable {
	@Id
	Long fkIdRozmowa;
	@Id
	Long fkIdUzytk;

}
