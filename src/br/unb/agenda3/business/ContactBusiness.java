package br.unb.agenda3.business;

import java.util.Comparator;

import br.unb.agenda3.entities.Contact;

public class ContactBusiness implements Comparator<Contact> {

	public int compare(Contact contact1, Contact contact2) {
		return contact1.getName().compareTo(contact2.getName());
	}

}
