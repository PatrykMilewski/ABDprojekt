package com.abd.Project;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@NonNull
	private final UzytkownikRepo ur;
	@NonNull
	private final ZadanieRepo zr;
	@NonNull
	private final GrupaRepo gr;

	@NonNull
	private final HarmonogramRepo hr;

	@NonNull
	private final RozmowaRepo rr;

	private EntityManager entityManager;

	Controller(UzytkownikRepo ur, ZadanieRepo zr, GrupaRepo gr, HarmonogramRepo hr, RozmowaRepo rr,
			EntityManager entityManager) {
		this.ur = ur;
		this.zr = zr;
		this.gr = gr;
		this.hr = hr;
		this.rr = rr;
		this.entityManager = entityManager;
	}

	@GetMapping("/dodajUzytkDoGrupy/{idU}/{idG}")
	public void add2Grp(@PathVariable("idU") Long idU, @PathVariable("idG") Long idG) {
		try {
			StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("add_user_to_group");
			storedProcedure.registerStoredProcedureParameter("id_usr", Long.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("id_grp", Long.class, ParameterMode.IN);
			storedProcedure.setParameter("id_usr", idU);
			storedProcedure.setParameter("id_grp", idG);
			storedProcedure.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@GetMapping("/usunUzytkZGrupy/{idU}/{idG}")
	public void delFromGrp(@PathVariable("idU") Long idU, @PathVariable("idG") Long idG) {
		try {
			StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("del_user_from_group");
			storedProcedure.registerStoredProcedureParameter("id_usr", Long.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("id_grp", Long.class, ParameterMode.IN);
			storedProcedure.setParameter("id_usr", idU);
			storedProcedure.setParameter("id_grp", idG);
			storedProcedure.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Transactional
	@GetMapping("/StworzGrpIDodajUzytk/{nazwa}/{idG}/{fk}/{idU}")
	public void createGroupAddUsrAddGrpUnder(@PathVariable("nazwa") String nazwa, @PathVariable("idG") Long idG,
			@PathVariable("fk") Long fk, @PathVariable("idU") Long idU) {
		try {
			StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("create_croup");
			storedProcedure.registerStoredProcedureParameter("id", Long.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("nazwa", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("fk", Long.class, ParameterMode.IN);
			storedProcedure.setParameter("id", idG);
			storedProcedure.setParameter("nazwa", nazwa);
			storedProcedure.setParameter("fk", fk);
			storedProcedure.execute();
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println(
					"----------------------------------------Utworzono grupe-----------------------------------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			StoredProcedureQuery storedProcedure2 = entityManager.createStoredProcedureQuery("add_user_to_group");
			storedProcedure2.registerStoredProcedureParameter("id_usr", Long.class, ParameterMode.IN);
			storedProcedure2.registerStoredProcedureParameter("id_grp", Long.class, ParameterMode.IN);
			storedProcedure2.setParameter("id_usr", idU);
			storedProcedure2.setParameter("id_grp", idG);
			storedProcedure2.execute();
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(
					"+++++++++++++++++++++++++++++++++++++++Dodano uzytkownika+++++++++++++++++++++++++++++++++++++");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@GetMapping("/StworzZadDodajDoHarm/{nazwa}/{szczegoly}/{miejsce}/{czas}/{idZ}/{idH}")
	public void createTaskAdd2Harm(@PathVariable("nazwa") String nazwa, @PathVariable("szczegoly") String szczegoly,
			@PathVariable("miejsce") String miejsce, @PathVariable("czas") String czas, @PathVariable("idZ") Long idZ,
			@PathVariable("idH") Long idH) {
		try {
			StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("dodaj_zad_do_harm");
			storedProcedure.registerStoredProcedureParameter("id_h", Long.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("id_z", Long.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("czas", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("m", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("n", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("s", String.class, ParameterMode.IN);
			storedProcedure.setParameter("id_h", idH);
			storedProcedure.setParameter("id_z", idZ);
			storedProcedure.setParameter("czas", czas);
			storedProcedure.setParameter("m", miejsce);
			storedProcedure.setParameter("n", nazwa);
			storedProcedure.setParameter("s", szczegoly);
			storedProcedure.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@GetMapping("/UsunZHarm/{idZ}/{idH}")
	public void delFomHarm(@PathVariable("idZ") Long idZ, @PathVariable("idH") Long idH) {
		try {
			StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("usun_zad_z_harm");
			storedProcedure.registerStoredProcedureParameter("id_h", Long.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("id_z", Long.class, ParameterMode.IN);
			storedProcedure.setParameter("id_h", idH);
			storedProcedure.setParameter("id_z", idZ);
			storedProcedure.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@GetMapping("/uzytkownicy/all")
	public String getUsrs() {
		return ur.findAll().toString();
	}

	@GetMapping("/zadania/all")
	public String getTasks() {
		return zr.findAll().toString();
	}

	@GetMapping("/grupy/all")
	public String getGroups() {
		return gr.findAll().toString();
	}

	@GetMapping("/rozmowy/all")
	public String getChats() {
		return rr.findAll().toString();
	}

	@GetMapping("/uzytkownicy/{id}/zadania")
	public String getTasksForUsr(@PathVariable("id") Long id) {
		return zr.findForUsr(id).toString();
	}

	@GetMapping("/uzytkownicy/{id}/rozmowy")
	public String getChatsForUsr(@PathVariable("id") Long id) {
		List<String> lr = rr.findRozmowyForUser(id);
		return lr.toString();
	}

	@GetMapping("/uzytkownicy/{id}/grupy")
	public String getGroupsForUsr(@PathVariable("id") Long id) {
		return gr.findGroupsForUser(id).toString();
	}

	@GetMapping("/zadania/{id}")
	public String getTasksById(@PathVariable("id") Long id) {
		return zr.findById(id).toString();
	}

	@GetMapping("/grupy/{id}")
	public String getGroupsById(@PathVariable("id") Long id) {
		return gr.findById(id).toString();
	}

	@GetMapping("/rozmowy/{id}")
	public String getChatsForUSR(@PathVariable("id") Long id) {
		return rr.findById(id).toString();
	}

	@GetMapping("/rozmowy/allRozmowy")
	public String getAllR() {
		return rr.findAllRozmowa().toString();
	}

	@GetMapping("/grupy/policz")
	public String countMem() {
		List<Object> lo = gr.countMembers();
		for (int i = 0; i < lo.size(); i++) {
			System.out.println(lo.get(i).toString());
		}
		return Arrays.toString(gr.countMembers().toArray());
	}

}
