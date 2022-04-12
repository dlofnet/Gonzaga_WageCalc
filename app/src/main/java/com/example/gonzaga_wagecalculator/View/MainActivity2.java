package com.example.gonzaga_wagecalculator.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.gonzaga_wagecalculator.Controller.Functions;
import com.example.gonzaga_wagecalculator.Model.Variables;
import com.example.gonzaga_wagecalculator.R;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {

    TextView txtDate, employee, txtHours, txtOT, txtReg, txtOTWage, txtTotal;

    //calling classes
    Variables var = new Variables();
    Functions functions = new Functions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hides Title Bar and Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        var.setName(i.getStringExtra("keyName"));
        var.setEmployeeType(i.getStringExtra("keyType"));
        var.setHours(i.getDoubleExtra("keyHours", var.getHours()));

        //for Wage Report date
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        txtDate = findViewById(R.id.txtDate);
        employee = findViewById(R.id.employee);
        txtHours = findViewById(R.id.txtHours);
        txtOT = findViewById(R.id.txtOT);
        txtReg = findViewById(R.id.txtReg);
        txtOTWage = findViewById(R.id.txtOTWage);
        txtTotal = findViewById(R.id.txtTotal);

        double overtime = functions.solveOT(var.getHours());
        double Reg = functions.solveRegWage(var.getEmployeeType(), var.getHours(), overtime);
        double otWage = functions.solveOTWage(var.getEmployeeType(), overtime);
        double total = functions.solveTotalWage(Reg, otWage);

        txtDate.setText(currentDate);
        employee.setText(var.getName() + " (" + var.getEmployeeType() + ")");
        txtHours.setText("Hours rendered: " + var.getHours());
        txtOT.setText("Overtime hours: " + overtime);
        txtReg.setText("Regular Wage: " + Reg);
        txtOTWage.setText("Overtime wage: " + otWage);
        txtTotal.setText(String.valueOf(total));
    }
}