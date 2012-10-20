package br.unb.agenda3.repositories;

import java.util.ArrayList;
import java.util.List;

import br.unb.agenda3.entities.Contact;

public class AgendaRepository {

	private List<Contact> agenda;

	public AgendaRepository() {
		this.agenda = new ArrayList<Contact>();
	}

	public void add(Contact contato) {
		this.agenda.add(contato);
	}

	public List<Contact> listAll() {
		return agenda;
	}

	public Contact findBy(Integer id) {
		for (Contact contato : agenda) {
			if (contato.getId().equals(id))
				return contato;
		}

		return null;
	}

	public Contact findBy(String name) {
		for (Contact contato : agenda) {
			if (contato.getName().equals(name))
				return contato;
		}

		return null;
	}

	public void update(Contact contato) {
		this.agenda.set(contato.getId(), contato);
	}

	public void remove(Integer id) {
		this.agenda.remove(id);
	}

}
