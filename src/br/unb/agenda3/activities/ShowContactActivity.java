package br.unb.agenda3.activities;

import br.unb.agenda3.entities.Contact;
import br.unb.agenda3.repositories.AgendaRepository;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowContactActivity extends Activity {
	AgendaRepository agendaRepository = new AgendaRepository();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		configureUI();
	}

	private void configureUI() {
		// Recover the data from the intent extra, in this case, we're
		// recovering the ID of the contact.
		Bundle contactIntent = getIntent().getExtras();
		Integer contactId = contactIntent.getInt("contactId");

		// We set a contact based on his ID.
		Contact contact = agendaRepository.findBy(contactId);

		// We're setting the name and the phone of the contact to the textView.
		TextView contactName = (TextView) findViewById(R.id.txt_contact_name);
		contactName.setText(contact.getName());
		TextView contactTelephone = (TextView) findViewById(R.id.txt_contact_telephone);
		contactTelephone.setText(contact.getPhone());

	}
}
