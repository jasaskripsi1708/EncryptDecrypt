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

public class AboutMe extends Activity implements OnClickListener {

	Button encrypt, decrypt, menu;
	Intent move;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_me);

		encrypt = (Button) findViewById(R.id.button1);
		decrypt = (Button) findViewById(R.id.button2);
		menu = (Button) findViewById(R.id.button3);

		encrypt.setOnClickListener(this);
		decrypt.setOnClickListener(this);
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
		AlertDialog.Builder alertOut = new AlertDialog.Builder(AboutMe.this);
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
		case R.id.button1:
			move = new Intent(this, Encrypt.class);
			startActivity(move);
			end();
			break;
		case R.id.button2:
			move = new Intent(this, Decrypt.class);
			startActivity(move);
			end();
			break;
		case R.id.button3:
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
