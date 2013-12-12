package com.ryanzone.wakeup.activity;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import com.ryanzone.wakeup.R;
import com.ryanzone.wakeup.activity.base.RTActivity;
import com.ryanzone.wakeup.adapter.TimeSelectAdapter;
import com.ryanzone.wakeup.utils.Common;
/**
 * Ever activity should extends from RTActivity
 * MainActivity.java
 * @author Ryan
 * Create at 2013-12-8 下午2:14:22
 */
public class SettingActivity extends RTActivity {

    private ListView lvHour;
    private ListView lvMinute;
    private TimeSelectAdapter hourAdapter;
    private TimeSelectAdapter minuteAdapter;
    private int currentPosition = Integer.MAX_VALUE/2+1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		initView();
		initData();
	}


    private void initView() {
        
    }

    private void initData() {
        lvHour = (ListView) findViewById(R.id.lvHour);  
        lvMinute = (ListView) findViewById(R.id.lvMinute);  
        
        hourAdapter = new TimeSelectAdapter(this, Common.getTimeStrings(5, 9));  
        minuteAdapter = new TimeSelectAdapter(this, Common.getTimeStrings(0, 59));  
        
        lvHour.setAdapter(hourAdapter);  
        lvHour.setSelection(Integer.MAX_VALUE/2+1);  
        lvMinute.setAdapter(minuteAdapter);  
        lvMinute.setSelection(Integer.MAX_VALUE/2+1); 
        lvMinute.setOnScrollListener(new OnScrollListener() {
            
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                System.out.println("scrollState=" + scrollState);
                if (scrollState == SCROLL_STATE_IDLE) {
                    lvMinute.setSelection(currentPosition + 1); 
                }
            }
            
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                                 int totalItemCount) {
                currentPosition = firstVisibleItem;
            }


        });
    }
}
