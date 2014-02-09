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

public class Decrypt extends Activity implements OnClickListener {

	Button decrypt, menu;
	EditText chiperText, key, plainText;
	Intent move;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decrypt);

		chiperText = (EditText) findViewById(R.id.editChiperText);
		key = (EditText) findViewById(R.id.editKey);
		plainText = (EditText) findViewById(R.id.editPlainText);
		menu = (Button) findViewById(R.id.buttonMenu);
		decrypt = (Button) findViewById(R.id.buttonDecrypt);

		menu.setOnClickListener(this);
		decrypt.setOnClickListener(this);
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
		AlertDialog.Builder alertOut = new AlertDialog.Builder(Decrypt.this);
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
		case R.id.buttonMenu:
			move = new Intent(this, Menu.class);
			startActivity(move);
			end();
			break;
		case R.id.buttonDecrypt:
			try {
				String decrypto = Parent.decrypt(key.getText().toString(),
						chiperText.getText().toString());
				plainText.setText(decrypto);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		default:
			break;
		}

	}

	public void end() {
		finish();
		onDestroy();
	}

}
