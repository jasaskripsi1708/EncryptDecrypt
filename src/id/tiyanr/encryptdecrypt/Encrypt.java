package id.tiyanr.encryptdecrypt;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Encrypt extends Activity implements OnClickListener {

	Button encrypt, menu;
	EditText plainText, key, chiperText;
	Intent move;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_encrypt);

		plainText = (EditText) findViewById(R.id.editPlainText);
		key = (EditText) findViewById(R.id.editKey);
		chiperText = (EditText) findViewById(R.id.editChiperText);
		encrypt = (Button) findViewById(R.id.buttonEncrypt);
		menu = (Button) findViewById(R.id.buttonMenu);

		encrypt.setOnClickListener(this);
		menu.setOnClickListener(this);
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
		AlertDialog.Builder alertOut = new AlertDialog.Builder(Encrypt.this);
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
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.buttonEncrypt:
			try {
				String crypto = Parent.encrypt(key.getText().toString(),
						plainText.getText().toString());
				chiperText.setText(crypto);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
		case R.id.buttonMenu:
			move = new Intent(this, Menu.class);
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
