package com.calendar.app.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.calendar.app.R;
import com.calendar.app.model.DayInfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarAdapter extends BaseAdapter {

    private List<DayInfo> dayInfos = new ArrayList<>();
    private Calendar calendar;
    private int firstDayOgMonth = 0;

    public CalendarAdapter() {
        super();
    }

    public void setList(Calendar calendar) {
        this.calendar = calendar;
        initFirstDayOfMonth();
        setDayInfos();
        notifyDataSetChanged();
    }

    private void initFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(calendar.getTime());
        cal.set(Calendar.DAY_OF_MONTH, 1);
        firstDayOgMonth = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (firstDayOgMonth == 0) {
            firstDayOgMonth = 7;
        }
    }

    private void setDayInfos() {
        dayInfos.clear();
        for (int i = 2; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + firstDayOgMonth + 1; i++) {
            if (i > firstDayOgMonth) {
                dayInfos.add(new DayInfo(i - firstDayOgMonth));
            } else {
                dayInfos.add(new DayInfo(0));
            }
        }
    }

    @Override
    public int getCount() {
        return dayInfos.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderItem viewHolder;

        if(convertView == null){
            LayoutInflater inflater = ((Activity) parent.getContext()).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_calendar_day, parent, false);

            viewHolder = new ViewHolderItem();
            viewHolder.textViewItem = convertView.findViewById(R.id.tv_text);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        if (dayInfos.get(position).getDateNumber() == 0) {
            viewHolder.textViewItem.setText("");
            convertView.setEnabled(false);
        } else {
            convertView.setEnabled(true);
            viewHolder.textViewItem.setText(String.valueOf(dayInfos.get(position).getDateNumber()));
        }
        return convertView;
    }

    static class ViewHolderItem{
        TextView textViewItem;
    }
}
