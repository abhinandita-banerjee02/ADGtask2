package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
public class MainActivity extends AppCompatActivity {
    private android.app.DatePickerDialog DatePickerDialog;
    private Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatePicker();
        dateButton=findViewById(R.id.datePickerbutton);
        dateButton.setText(getTodaysdate());
    }
    private String getTodaysdate()
    {
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int dayofMonth=cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(dayofMonth,month,year);
    }
    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener DateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date=makeDateString(dayOfMonth,month,year);
                dateButton.setText(date);
            }
        };
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int dayofMonth=cal.get(Calendar.DAY_OF_MONTH);
        int style= AlertDialog.THEME_HOLO_LIGHT;
        DatePickerDialog=new DatePickerDialog(this, style,DateSetListener,year,month,dayofMonth);
    }
    private String makeDateString(int dayofMonth,int month,int year)
    {
        return  getMonthFormat(month)+""+dayofMonth+""+year;
    }
    private String getMonthFormat(int month)
    {
        if(month==1)
            return "JAN";
        if(month==2)
            return "FEB";
        if(month==3)
            return "MAR";
        if(month==4)
            return "APR";
        if(month==5)
            return "MAY";
        if(month==6)
            return "JUNE";
        if(month==7)
            return "JUL";
        if(month==8)
            return "AUG";
        if(month==9)
            return "SEP";
        if(month==10)
            return "OCT";
        if(month==11)
            return "NOV";
        if(month==12)
            return "DEC";
        return "JAN";



    }
    public void openDatePicker(View View)
    {
        DatePickerDialog.show();
    }
}