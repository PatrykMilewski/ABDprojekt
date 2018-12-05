package com.abd.Project;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "POZYCJA_GRUPY")
public class PozycjaGrupy implements Serializable {
	@Id
	Long fkIdGrupa;
	@Id
	Long fkIdUzytk;

}
