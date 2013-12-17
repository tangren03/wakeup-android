package com.ryanzone.wakeup.activity;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ryanzone.wakeup.R;
import com.ryanzone.wakeup.activity.base.RTActivity;
import com.ryanzone.wakeup.adapter.TimeSelectAdapter;
import com.ryanzone.wakeup.utils.Common;

/**
 * Ever activity should extends from RTActivity
 * SettingActivity.java
 * @author walker02
 * Create at 2013-12-12 下午2:14:22
 */
public class SettingActivity extends RTActivity {

    private ListView          lvHour;
    private ListView          lvMinute;
    private GridView          gvWeek;
    private TimeSelectAdapter hourAdapter;
    private TimeSelectAdapter minuteAdapter;
    private GvWeekAdapter     gvWeekAdapter;
    private int               currentPosition = Integer.MAX_VALUE / 2 + 1;
    private PopupWindow       mPopupWindow;
    private List<String>      dayStrings;
    private RelativeLayout rlSettingRoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();
        initData();
    }

    private void initView() {
        rlSettingRoot = (RelativeLayout) findViewById(R.id.rlSettingRoot);
        lvHour = (ListView) findViewById(R.id.lvHour);
        lvMinute = (ListView) findViewById(R.id.lvMinute);
        gvWeek = (GridView) findViewById(R.id.gvWeek);
        findViewById(R.id.btnChoiceMisic).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showPopuWindow(arg0);
            }
        });
    }

    @SuppressLint("NewApi")
    protected void showPopuWindow(View arg0) {
        View popupView = getLayoutInflater().inflate(R.layout.ppw_music_choice, null);
        mPopupWindow = new PopupWindow(popupView, RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setAnimationStyle(R.style.anim_bottom_menu);
        if (mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
        } else {
            mPopupWindow.showAtLocation(arg0, Gravity.BOTTOM, 0, 0);
            rlSettingRoot.setAlpha((float) 0.4);
        }
        
        mPopupWindow.setOnDismissListener(new OnDismissListener() {
            
            @Override
            public void onDismiss() {
                rlSettingRoot.setAlpha(1);
            }
        });
    }

    private void initData() {

        dayStrings = new ArrayList<String>();
        dayStrings.add("MON");
        dayStrings.add("TUR");
        dayStrings.add("WEN");
        dayStrings.add("THR");
        dayStrings.add("FRI");
        dayStrings.add("SAT");
        dayStrings.add("SUN");

        hourAdapter = new TimeSelectAdapter(this, Common.getTimeStrings(5, 9));
        minuteAdapter = new TimeSelectAdapter(this, Common.getTimeStrings(0, 59));
        gvWeekAdapter = new GvWeekAdapter(SettingActivity.this, R.layout.gv_list_item_week,
            dayStrings);

        gvWeek.setAdapter(gvWeekAdapter);
        lvHour.setAdapter(hourAdapter);
        lvHour.setSelection(Integer.MAX_VALUE / 2 + 1);
        lvMinute.setAdapter(minuteAdapter);
        lvMinute.setSelection(Integer.MAX_VALUE / 2 + 1);
        lvMinute.setOnScrollListener(new OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    //change the selection text color by setSelectItem
                    minuteAdapter.setSelectItem(currentPosition + 2);
                    minuteAdapter.notifyDataSetChanged();
                    //select the middle
                    lvMinute.setSelection(currentPosition + 1);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                                 int totalItemCount) {
                //set current Item
                currentPosition = firstVisibleItem;
            }
        });
    }

    /**
     * week adapter
     * @author walker
     */
    class GvWeekAdapter extends ArrayAdapter<String> {
        private Typeface     fontFace;
        private GvWeekHolder holder;
        int                  resourceId;
        LayoutInflater       inflater;

        public GvWeekAdapter(Context context, int resourceId, List<String> objects) {
            super(context, resourceId, objects);
            this.resourceId = resourceId;
            inflater = SettingActivity.this.getLayoutInflater();
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            String bean = getItem(position);
            holder = null;
            if (convertView == null) {
                holder = new GvWeekHolder();
                convertView = inflater.inflate(resourceId, parent, false);
                holder.tvDay = (TextView) convertView.findViewById(R.id.tvWeekOfDay);
                convertView.setTag(holder);
            } else {
                holder = (GvWeekHolder) convertView.getTag();
            }
            if (fontFace == null)
                fontFace = Typeface.createFromAsset(getAssets(), "time_font.otf");
            holder.tvDay.setTypeface(fontFace);
            holder.tvDay.setText(bean);
            return convertView;
        }
    }

    class GvWeekHolder {
        TextView tvDay;
    }
}
