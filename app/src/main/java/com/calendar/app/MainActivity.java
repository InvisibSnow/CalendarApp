package com.calendar.app;

import androidx.lifecycle.ViewModelProvider;
import com.calendar.app.databinding.ActivityMainBinding;
import com.calendar.app.fragment.MonthFragment;
import com.calendar.app.mvvmHelper.MyBindingActivity;

public class MainActivity extends MyBindingActivity<ActivityMainBinding, MainActivityVM> {

    public static final String CHANGE_MONTH = "changeMonth";

    private MonthFragment monthFragment;

    @Override
    public MainActivityVM onCreate() {

        MainActivityVM mainActivityVM = new ViewModelProvider(this).get(MainActivityVM.class);

        monthFragment = (MonthFragment) getSupportFragmentManager().findFragmentById(R.id.month_frag);
        return mainActivityVM;
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void action(String action) {
        super.action(action);
        if(action.equals(CHANGE_MONTH)){
            monthFragment.setCalendar(getViewModel().calendarObservableField.get());
        }
    }
}
