package com.calendar.app;

import androidx.databinding.ObservableField;
import com.calendar.app.mvvmHelper.MyActivityViewModel;
import java.util.Calendar;

import static com.calendar.app.MainActivity.CHANGE_MONTH;

public class MainActivityVM extends MyActivityViewModel<MainActivity> {

    public final ObservableField<Calendar> calendarObservableField = new ObservableField<Calendar>() {
        @Override
        public void set(Calendar cal) {
            currentMonthName.set((String)android.text.format.DateFormat.format("LLLL", cal.getTime()));
            data.postValue(CHANGE_MONTH);
            super.set(cal);
        }
    };

    public final ObservableField<String> currentMonthName = new ObservableField<>();

    public MainActivityVM() {
        initCalendar();
    }

    private void initCalendar() {
        if (null == calendarObservableField.get()) {
            calendarObservableField.set(Calendar.getInstance());
        }
    }

    public void setMonth(int amount) {
        Calendar cal = calendarObservableField.get();
        if (null != cal) {
            cal.add(Calendar.MONTH, amount);
            calendarObservableField.set(cal);
        }
    }
}
