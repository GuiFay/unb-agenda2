package br.unb.agenda3.activities;

import java.util.Collections;
import java.util.List;
import br.unb.agenda3.business.ContactBusiness;
import br.unb.agenda3.entities.Contact;
import br.unb.agenda3.repositories.AgendaRepository;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactListActivity extends ListActivity {

	AgendaRepository agendaRepository = new AgendaRepository();
	List<Contact> listContacts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Creating a Contact list.
		listContacts = agendaRepository.listAll();

		// Inserting some contacts for test. these are ONLY for tests, 
		//TODO: Remove this after the persistence be implemented.
		Contact c1 = new Contact(0, "Joao");
		Contact c2 = new Contact(1, "Maria");
		listContacts.add(c1);
		listContacts.add(c2);

		String[] contacts = new String[listContacts.size()];

		// Ordering the contacts by name.
		ContactBusiness contactBusiness = new ContactBusiness();
		Collections.sort(listContacts, contactBusiness);

		// Populating the contacts array with the result of the list.
		for (int i = 0; i < listContacts.size(); i++) {
			contacts[i] = listContacts.get(i).getName();
			System.out.println(contacts[i]);
		}

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, contacts));

	}

	@Override
	protected void onListItemClick(ListView list, View view, int position,
			long id) {
		super.onListItemClick(list, view, position, id);

		Intent i = new Intent(getApplicationContext(),
				ShowContactActivity.class);
		i.putExtra("contactId", listContacts.get(position).getId());
		startActivity(i);
	}
}
