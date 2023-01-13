package com.example.project;

import static com.example.project.SubActivity.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class SubActivity5 extends AppCompatActivity {

    private RadioGroup rg_15;
    private RadioButton rb_left15;
    private RadioButton rb_right15;

    private RadioGroup rg_16;
    private RadioButton rb_left16;
    private RadioButton rb_right16;

    private RadioGroup rg_17;
    private RadioButton rb_left17;
    private RadioButton rb_right17;

    private AppCompatButton backbtn6;
    private AppCompatButton btn6;

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplicationContext(),"검사중에는 뒤로가기가 불가합니다", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub5);

        Intent intent = getIntent();
        ArrayList<String> arrayList = intent.getStringArrayListExtra("result5");

        rg_15 = findViewById(R.id.rg_15);
        rb_left15 = findViewById(R.id.rb_left15);
        rb_right15 = findViewById(R.id.rb_right15);

        rg_16 = findViewById(R.id.rg_16);
        rb_left16 = findViewById(R.id.rb_left16);
        rb_right16 = findViewById(R.id.rb_right16);

        rg_17 = findViewById(R.id.rg_17);
        rb_left17 = findViewById(R.id.rb_left17);
        rb_right17 = findViewById(R.id.rb_right17);

        backbtn6 = findViewById(R.id.backbtn6);
        btn6 = findViewById(R.id.btn6);

        rg_15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left15.isChecked() ? "T" : "F");
            }
        });

        rg_16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left16.isChecked() ? "T" : "F");
            }
        });

        rg_17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left17.isChecked() ? "S" : "N");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_left15.isChecked() == false && rb_right15.isChecked() == false
                        || rb_left16.isChecked() == false && rb_right16.isChecked() == false
                        || rb_left17.isChecked() == false && rb_right17.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "미체크 항목이 있습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SubActivity5.this, SubActivity6.class);
                    intent.putStringArrayListExtra("result6", result);
                    startActivity(intent);
                }
            }
        });

        backbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}