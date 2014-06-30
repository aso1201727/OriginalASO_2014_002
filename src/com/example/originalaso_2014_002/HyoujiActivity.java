package com.example.originalaso_2014_002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HyoujiActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hyouji);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		
		Intent intent = this.getIntent();
		String strHitokoto = intent.getStringExtra("hitokoto");
		
		TextView txvHITOKOTO = (TextView)findViewById(R.id.etx_hitokoto);
		txvHITOKOTO.setText(strHitokoto);
	}
}
