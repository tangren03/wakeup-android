package com.ryanzone.wakeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ryanzone.wakeup.R;

public class TimeSelectAdapter extends BaseAdapter {
    private Context context;
    private String[] strs     = null;
    LayoutInflater   inflater = null;

    public TimeSelectAdapter(Context context, String[] strings) {
        this.context = context;
        //listview中循环显示的数据 
        strs = strings;
        inflater = LayoutInflater.from(context);
    }

    public TimeSelectAdapter() {

    }

    @Override
    public int getCount() {
        //返回int可以保存的最大值，此值为2147483647  
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // TODO Auto-generated method stub  
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.time_text, null);
            holder.text = (TextView) view.findViewById(R.id.text);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //strs[position%strs.length]实现listview中数据的循环  
        if (position == selectItem) {  
            holder.text.setTextColor(context.getResources().getColor(R.color.red));
        } else {
            holder.text.setTextColor(context.getResources().getColor(R.color.white));
        } 
        holder.text.setText(strs[position % strs.length]);

        return view;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    private int selectItem = -1;
}

class ViewHolder {
    public TextView text;
}
