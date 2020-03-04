package com.calendar.app.fragment;

import android.widget.GridView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import com.calendar.app.adapter.CalendarAdapter;
import com.calendar.app.mvvmHelper.MyFragmentViewModel;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class MonthFragmentVM extends MyFragmentViewModel {

    private CalendarAdapter calendarAdapter;
    private Calendar calendar = Calendar.getInstance();
    private String[] daysOfWeek;

    public final ObservableField<String> monthName = new ObservableField<>();

    public MonthFragmentVM(){
        calendarAdapter = new CalendarAdapter();
        daysOfWeek = DateFormatSymbols.getInstance(Locale.getDefault()).getShortWeekdays();
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
        monthName.set(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
        calendarAdapter.setList(this.calendar);
    }

    @BindingAdapter("gridLayout")
    public static void setGridLayout(GridView gridLayout, final MonthFragmentVM viewModel){
        gridLayout.setAdapter(viewModel.calendarAdapter);
    }

    public String getDayOfWeek(int daysNum){
        return daysOfWeek[daysNum];
    }
}
