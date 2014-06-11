package com.example.originalaso_2014_002;

import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class HyoujiActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hyouji);
		
		/**
		 * @param SQLiteDatabase インサート先のDBのインスタンス変数
		 * @param inputMeg インサートするメッセージ
		 */
		public String selectHitokoto(SQLiteDatabase db) {
			String rtString = null;
			
			String sqlstr = "select _id, phrase form Hitokoto ORDER BY RANDOM(); ";
				try {
					//トランザクションの開始
					SQLiteCursor corsor = (SQLiteCursor)db.rawQuery(sqlstr,null);
					if(corsor.getCount()!=0) {
						//カーソルの位置を先頭にする
						corsor.moveToFirst();
						rtString = corsor.getString(1);
					}
				} catch (SQLException e) {
					
				} finally {
					
				}
		}
	}
	
	

}
