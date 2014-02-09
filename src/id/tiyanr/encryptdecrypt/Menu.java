package id.tiyanr.encryptdecrypt;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;

public class Menu extends ListActivity {

	Intent move;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] menu = new String[] { "Encrypt", "Decrypt", "About Me" };
		this.setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, menu));
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			alert();
		}
		return super.onKeyDown(keyCode, event);
	}

	public void alert() {
		AlertDialog.Builder alertOut = new AlertDialog.Builder(Menu.this);
		alertOut.setMessage("Apakah anda ingin keluar dari aplikasi ?")
				.setPositiveButton("Keluar", new AlertDialog.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						end();
					}

				})
				.setNegativeButton("Tidak", new AlertDialog.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}

				});
		AlertDialog window = alertOut.create();
		window.setTitle("Peringatan");
		window.setIcon(R.drawable.warning);
		window.show();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		switch (position) {
		case 0:
			move = new Intent(this, Encrypt.class);
			startActivity(move);
			end();
			break;
		case 1:
			move = new Intent(this, Decrypt.class);
			startActivity(move);
			end();
			break;
		case 2:
			move = new Intent(this, AboutMe.class);
			startActivity(move);
			end();
			break;
		default:
			break;
		}
	}

	public void end() {
		finish();
		onDestroy();
	}

}
