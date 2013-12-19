package com.ryanzone.wakeup.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.ryanzone.wakeup.R;
import com.ryanzone.wakeup.activity.base.RTActivity;
/**
 * Ever activity should extends from RTActivity
 * MainActivity.java
 * @author Ryan
 * Create at 2013-12-8 下午2:14:22
 */
public class MainActivity extends RTActivity implements OnClickListener{
	private Button btn_add_clock;
	private TextView tv_date;
	private TextView tv_location;
	private TextView tv_weather;
	private TextView tv_time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public void init() {
		tv_date = (TextView)this.findViewById(R.id.tv_date);
		tv_location = (TextView)this.findViewById(R.id.tv_location);
		tv_weather = (TextView)this.findViewById(R.id.tv_weather);
		tv_time = (TextView)this.findViewById(R.id.tv_time);
		btn_add_clock = (Button)MainActivity.this.findViewById(R.id.btn_add);
		btn_add_clock.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_add) {
		    openActivity(SettingActivity.class);
		}
	}

    @Override
    public void loadViewLayout() {
        setContentView(R.layout.activity_main);
    }

}
