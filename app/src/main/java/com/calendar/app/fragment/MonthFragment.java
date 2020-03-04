package com.calendar.app.fragment;

import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.calendar.app.R;
import com.calendar.app.databinding.FragmentMonthBinding;
import com.calendar.app.mvvmHelper.MyBindingFragment;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class MonthFragment extends MyBindingFragment<MonthFragmentVM, FragmentMonthBinding> {

    @Override
    protected MonthFragmentVM onCreateViewModel(FragmentMonthBinding binding) {
        return new ViewModelProvider(this).get(MonthFragmentVM.class);
    }

    public void setCalendar(Calendar calendar) {
        if(getViewModel() != null)
            getViewModel().setCalendar(calendar);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_month;
    }
}
