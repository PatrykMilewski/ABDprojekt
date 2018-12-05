package com.abd.Project;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "POZYCJA_HARMONOGRAMU")
public class PozycjaHarmonogramu implements Serializable {
	@Id
	Long fkIdHarm;
	@Id
	Long fkIdZad;

}
