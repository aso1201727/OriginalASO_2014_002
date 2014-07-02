package com.example.originalaso_2014_002;

import android.app.Activity;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MenteActivity extends Activity implements View.OnClickListener, OnItemClickListener {
	
	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;
	
	int selectedID = -1;
	int lastPosition = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mente);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		
		Button btnDelete = (Button)findViewById(R.id.Delete);
		Button btnBack = (Button)findViewById(R.id.Back);
		ListView lstHitokoto = (ListView)findViewById(R.id.lstView);
		
		btnDelete.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		
		lstHitokoto.setOnClickListener(this);
		
		this.setDBValuetoList(lstHitokoto);
	}
	
	private void setDBValuetoList(ListView lstHitokoto) {
		SQLiteCursor cursor = null;
		
		if(sdb == null) {
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try {
			sdb = helper.getWritableDatabase();
		} catch(SQLiteException e) {
			Log.e("ERROR", e.toString());
		}
		
		cursor = this.helper.selectHitokoto(sdb);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long vievid) {
		// TODO 自動生成されたメソッド・スタブ
		
		if(this.selectedID!=-1){
			parent.getChildAt(this.lastPosition).setBackgroundColor(0);
		}
		
		view.setBackgroundColor(android.graphics.Color.LTGRAY);
		
		SQLiteCursor cursor = (SQLiteCursor)parent.getItemAtPosition(position);
		this.selectedID = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
		this.lastPosition = position;
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		
		switch(v.getId()) {
		case R.id.Delete:
			
			if(this.selectedID != -1) {
				//this.deleteFromHitokoto(this.selectedID);
				ListView lstHitokoto = (ListView)findViewById(R.id.lstView);
				
			}
		}
	}
}
