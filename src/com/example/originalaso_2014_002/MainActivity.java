package com.example.originalaso_2014_002;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	// クラスで使用するそれぞれのインスタンスの宣言
	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		
		super.onResume();
		// ボタンをIDで探してボタンを作る
		Button BtnCheck = (Button)findViewById(R.id.BtnCheck);
		// ボタン変数をリスナーを登録する。
		BtnCheck.setOnClickListener(this);
		
		// ボタンをIDで探してボタンを作る
		Button BtnTouroku = (Button)findViewById(R.id.BtnTouroku);
		// ボタン変数をリスナーを登録する。
		BtnCheck.setOnClickListener(this);
		
		if(sdb == null) {
			helper = new MySQLiteOpenHelper(getApplicationContext());
		} try {
			sdb = helper.getWritableDatabase();
		} catch(SQLiteException e) {
			//異常終了
			return;
		}
				
		// ボタンをIDで探してボタンを作る
		Button BtnMente = (Button)findViewById(R.id.BtnMente);
		// ボタン変数をリスナーを登録する。
		BtnCheck.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

		switch(v.getId()){
			case R.id.BtnCheck:
				startActivity(new Intent(MainActivity.this, HyoujiActivity.class));
				break;
			case R.id.BtnTouroku:
				
				break;
			case R.id.BtnMente:
				startActivity(new Intent(MainActivity.this, HyoujiActivity.class));
				break;
		}
	}

}
