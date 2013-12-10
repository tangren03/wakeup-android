package com.ryanzone.wakeup.activity;

import android.os.Bundle;
import android.view.Menu;

import com.ryanzone.wakeup.R;
import com.ryanzone.wakeup.activity.base.RTActivity;
/**
 * Ever activity should extends from RTActivity
 * MainActivity.java
 * @author Ryan
 * Create at 2013-12-8 下午2:14:22
 */
public class MainActivity extends RTActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

}
