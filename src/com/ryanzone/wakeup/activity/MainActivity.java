package com.ryanzone.wakeup.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

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
		initView();
	}

    private void initView() {
        findViewById(R.id.tvGoToSetting).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
                openActivity(SettingActivity.class);
            }
        });
    }

}
