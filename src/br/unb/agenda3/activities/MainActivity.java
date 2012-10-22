package br.unb.agenda3.activities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		View buttonAddContact = findViewById(R.id.btn_add_contacts);
		buttonAddContact.setOnClickListener(this);
		View buttonListContact = findViewById(R.id.btn_list_contacts);
		buttonListContact.setOnClickListener(this);
//		View buttonEditContact = findViewById(R.id.btn_edit_contacts);
//		buttonEditContact.setOnClickListener(this);
		
	}

	public void onClick(View v) {
		switch (v.getId()){
    	
    	case R.id.btn_add_contacts:
    		Intent intent = new Intent(this, ContactAddActivity.class);
			startActivity(intent);
			break;
		
    	case R.id.btn_list_contacts:
    		Intent intent2 = new Intent(this, ContactListActivity.class);
			startActivity(intent2);
			break;
//			
//    	case R.id.btn_edit_contact:
//    		Intent intent3 = new Intent(this, ContactEditActivity.class);
//			startActivity(intent3);
//			break;
//			
//    	case R.id.btn_search_contact:
//    		Intent intent4 = new Intent(this, ContactSearchActivity.class);
//			startActivity(intent4);
//			break;
//		
//    	case R.id.btn_delete_contact:
//    		Intent intent5 = new Intent(this, ContactDeleteActivity.class);
//			startActivity(intent5);
//			break;
    	}
		
	}
}
