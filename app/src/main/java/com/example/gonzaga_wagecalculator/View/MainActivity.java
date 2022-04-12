package com.example.gonzaga_wagecalculator.View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gonzaga_wagecalculator.Model.Variables;
import com.example.gonzaga_wagecalculator.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnReg, btnProb, btnPT, btnProceed;
    EditText enterEmployeeName, enterHours;
    TextView txtEmployeeType;

    //calling classes
    Variables var = new Variables();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hides Title Bar and Action Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        //set ID's
        btnReg = findViewById(R.id.btnReg);
        btnProb = findViewById(R.id.btnProb);
        btnPT = findViewById(R.id.btnPT);
        btnProceed = findViewById(R.id.btnProceed);
        enterEmployeeName = findViewById(R.id.enterEmployeeName);
        enterHours = findViewById(R.id.enterHours);
        txtEmployeeType = findViewById(R.id.txtEmployeeType);

        //set listeners here
        btnReg.setOnClickListener(this);
        btnProb.setOnClickListener(this);
        btnPT.setOnClickListener(this);
        btnProceed.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnReg:
                var.setEmployeeType("Regular");
                txtEmployeeType.setText("Employee type: Regular");
                break;
            case R.id.btnProb:
                var.setEmployeeType("Probationary");
                txtEmployeeType.setText("Employee type: Probationary");
                break;
            case R.id.btnPT:
                var.setEmployeeType("Part time");
                txtEmployeeType.setText("Employee type: Part time");
                break;
            case R.id.btnProceed:
                if (var.getEmployeeType() == "") {
                    Toast.makeText(MainActivity.this, "Please answer all fields", Toast.LENGTH_SHORT).show();
                } else {
                    var.setName(String.valueOf(enterEmployeeName.getText()));
                    var.setHours(Double.parseDouble(enterHours.getText().toString()));

                    //passing info to Activity 2
                    Intent i = new Intent(this, MainActivity2.class);
                    i.putExtra("keyName", var.getName());
                    i.putExtra("keyType", var.getEmployeeType());
                    i.putExtra("keyHours", var.getHours());
                    startActivity(i);
                }
                break;
        }
    }
}