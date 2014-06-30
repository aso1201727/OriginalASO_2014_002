package com.example.originalaso_2014_002;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
	
	public static Object selectHitokoto;
	/**
	 * @param context 呼び出しコンテクスト
	 * @param name 利用DB名
	 * @param factory カーソルファクトリー
	 * @param version DBバージョン
	 */
	public MySQLiteOpenHelper(Context context) {
		super(context, "20140021201727.sqlite3", null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ
		db.execSQL("CREATE TABLE IF NOT EXISTS " +
					"Hitokoto (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , phrase TEXT )");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	/**
	 * @param SQLiteDatabase インサート先のDBのインスタンス変数
	 * @param inputMeg インサートするメッセージ
	 */
	public String selectHitokoto(SQLiteDatabase db) {
		
		String rtString = null;
		
		String sqlstr = "select _id, phrase from Hitokoto ORDER BY RANDOM(); ";
			try {
				//トランザクションの開始
				SQLiteCursor corsor = (SQLiteCursor)db.rawQuery(sqlstr,null);
				if(corsor.getCount()!=0) {
					//カーソルの位置を先頭にする
					corsor.moveToFirst();
					rtString = corsor.getString(1);
				}
				corsor.close();
				
			} catch (SQLException e) {
				Log.e("ERROR", e.toString());
			} finally {
				
			}
			return rtString;
	}
	/**
	 * @param SQLiteDatabase インサート先のDBのインスタンス変数
	 * @param inputMeg インサートするメッセージ
	 */
	public void DeleteHitokoto(SQLiteDatabase db, int id) {
		
		String sqlstr = "DELETE FROM Hitokoto where _id = " + id + ";";
		
			try {
				//トランザクションの開始
				db.beginTransaction();
				db.execSQL(sqlstr);
				//トランザクション成功
				db.setTransactionSuccessful();
			} catch (SQLException e) {
				Log.e("ERROR", e.toString());
			} finally {
				db.endTransaction();
			}
	}
}
