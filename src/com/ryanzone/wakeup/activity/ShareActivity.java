package com.ryanzone.wakeup.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.ryanzone.wakeup.R;
import com.ryanzone.wakeup.activity.base.RTActivity;

public class ShareActivity extends RTActivity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public void init() {
		this.findViewById(R.id.btn_step).setOnClickListener(this);
		this.findViewById(R.id.btn_challenge).setOnClickListener(this);
		this.findViewById(R.id.btn_share).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int viewID = v.getId();
		switch (viewID) {
		case R.id.btn_challenge://challenge friends
			
			break;
		case R.id.btn_share://share to wechat
			
			break;
		case R.id.btn_step:
			//close current page
			finish();
			break;

		default:
			break;
		}
	}

	@Override
	public void loadViewLayout() {
		setContentView(R.layout.activity_share);
	}
}
