package com.justplaingoatappsgmail.phonesilencer.views.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

import com.justplaingoatappsgmail.phonesilencer.R;
import com.justplaingoatappsgmail.phonesilencer.contracts.EventPostContract;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventPostActivity extends AppCompatActivity implements EventPostContract.View, com.wdullaer.materialdatetimepicker.time.TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    @BindView(R.id.timer_name) EditText timerName;
    @BindView(R.id.repeat_spinner) Spinner repeatSpinner;

    @Inject EventPostContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_post);

        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String name = extras.getString("objectName");
            timerName.setText(name);
        }
//        repeatSpinner.getSelectedItem().toString();
    }

    @OnClick(R.id.start_time_id)
    public void startTimeClick() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                EventPostActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @OnClick(R.id.save_button)
    public void saveOnClick() {
        presenter.saveTimer(timerName.getText().toString());
    }

    @Override
    public void showTimerNameError() {

    }

    @Override
    public void showTimerNameConflictError() {

    }

    @Override
    public void showStartTimeError() {

    }

    @Override
    public void showEndTimeError() {

    }

    @Override
    public void showDaysSelectedError() {

    }

    @Override
    public void showRingerModeError() {

    }

    @Override
    public void showRepeatOptionError() {

    }

    @Override
    public void returnToPreviousActivity() {
        Intent returnIntent = new Intent();
//        returnIntent.putExtra("choice", EventActivity.CHOICE_GIVEN);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.closeRealmInstance();
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {

    }

}