package com.ryanzone.wakeup.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.ryanzone.wakeup.R;
import com.ryanzone.wakeup.activity.base.RTActivity;
/**
 * Start page
 * SplashActivity.java
 * @author Ryan
 * Create at 2013-12-10 下午8:06:05
 */
public class SplashActivity extends RTActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,      
                WindowManager.LayoutParams. FLAG_FULLSCREEN);  
		
		
	}
	
	Handler splashHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			openActivity(MainActivity.class);
			finish();
		}
		
	};

	@Override
	public void init() {
		splashHandler.removeMessages(0);
		splashHandler.sendEmptyMessageDelayed(0, 2000);
	}

    @Override
    public void loadViewLayout() {
        setContentView(R.layout.activity_splash);
    }
}
