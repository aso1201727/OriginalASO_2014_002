package com.example.originalaso_2014_002;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

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
		BtnTouroku.setOnClickListener(this);
		
		// ボタンをIDで探してボタンを作る
		Button BtnMente = (Button)findViewById(R.id.BtnMente);
		// ボタン変数をリスナーを登録する。
		BtnMente.setOnClickListener(this);
		
		if(sdb == null) {
			helper = new MySQLiteOpenHelper(getApplicationContext());
		} try {
			sdb = helper.getWritableDatabase();
		} catch(SQLiteException e) {
			//異常終了
			return;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

		switch(v.getId()){
			case R.id.BtnCheck:
				
				String strHitokoto = helper.selectRandomHitokoto(sdb);
				
				Intent intent = new Intent(MainActivity.this, HyoujiActivity.class);
				intent.putExtra("hitokoto",strHitokoto);
				
				startActivity(intent);
				break;
				
			case R.id.BtnTouroku:
				//入力内容を取り出す
				EditText etv = (EditText)findViewById(R.id.edtMsg);
				String inputMsg = etv.getText().toString();
				String sqlstr = "insert into Hitokoto (phrase) values('"+ inputMsg + "')";
				
				try {
					//トランザクションの開始
					sdb.beginTransaction();
					sdb.execSQL(sqlstr);
					//トランザクションの成功
					sdb.setTransactionSuccessful();
				} catch (SQLException e) {
					Log.e("ERROR",e.toString());
				} finally {
					//トランザクションの終了
					sdb.endTransaction();
					etv.setText("");
				}
				break;
			case R.id.BtnMente:
				startActivity(new Intent(MainActivity.this, MenteActivity.class));
				break;
		}
	}

}
