package com.calendar.app.mvvmHelper;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.calendar.app.api.IOnErrorListener;

import static com.calendar.app.mvvmHelper.MyBindingFragment.ERROR_TOKEN_ACTION;

public class MyActivityViewModel<A extends AppCompatActivity> extends ViewModel implements IOnErrorListener, LifecycleObserver {

    protected MutableLiveData<String> data = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorData = new MutableLiveData<>();
    private MutableLiveData<String> errorServiceData = new MutableLiveData<>();

    protected A activity;

    public MyActivityViewModel(A activity) {
        this.activity = activity;
    }

    public MyActivityViewModel() {
    }

    public A getActivity() {
        return activity;
    }

    /**
     * Activity lifecycle
     */
    public boolean onBackKeyPress() {
        return false;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }

    public void onPostCreate(Bundle savedInstanceState) {

    }

    public void onOptionsItemSelected(MenuItem item) {

    }

    public void onConfigurationChanged(Configuration newConfig) {

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    public void onSaveInstanceState(Bundle outState){

    }

    public void onCreateOptionsMenu(Menu menu) {

    }

    public void onPrepareOptionsMenu(Menu menu){

    }

    public void onWindowFocusChanged(boolean hasFocus){

    }

    /**
     * -----------------------
     */

    protected IOnErrorListener getOnErrorListener(){
        return this;
    }

    public LiveData<String> getData() {
        return data;
    }

    public LiveData<Throwable> getErrorData() {
        return errorData;
    }

    public LiveData<String> getErrorServiceData() {
        return errorServiceData;
    }

    @Override
    public void onFailure(String error) {
        errorServiceData.postValue(error);
        updateView();
    }

    @Override
    public void onFailure(Throwable throwable) {
        errorData.postValue(throwable);
        updateView();
    }

    @Override
    public void errorToken() {
        data.postValue(ERROR_TOKEN_ACTION);
        updateView();
    }

    public void updateView(){}
}
