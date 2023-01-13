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

public class SubActivity3 extends AppCompatActivity {

    private RadioGroup rg_9;
    private RadioButton rb_left9;
    private RadioButton rb_right9;

    private RadioGroup rg_10;
    private RadioButton rb_left10;
    private RadioButton rb_right10;

    private RadioGroup rg_11;
    private RadioButton rb_left11;
    private RadioButton rb_right11;

    private AppCompatButton backbtn4;
    private AppCompatButton btn4;

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplicationContext(),"검사중에는 뒤로가기가 불가합니다", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);

        Intent intent = getIntent();
        ArrayList<String> arrayList = intent.getStringArrayListExtra("result3");

        rg_9 = findViewById(R.id.rg_9);
        rb_left9 = findViewById(R.id.rb_left9);
        rb_right9 = findViewById(R.id.rb_right9);

        rg_10 = findViewById(R.id.rg_10);
        rb_left10 = findViewById(R.id.rb_left10);
        rb_right10 = findViewById(R.id.rb_right10);

        rg_11 = findViewById(R.id.rg_11);
        rb_left11 = findViewById(R.id.rb_left11);
        rb_right11 = findViewById(R.id.rb_right11);

        backbtn4 = findViewById(R.id.backbtn4);
        btn4 = findViewById(R.id.btn4);

        rg_9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left9.isChecked() ? "E" : "I");
            }
        });

        rg_10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left10.isChecked() ? "E" : "I");
            }
        });

        rg_11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left11.isChecked() ? "E" : "I");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_left9.isChecked() == false && rb_right9.isChecked() == false
                        || rb_left10.isChecked() == false && rb_right10.isChecked() == false
                        || rb_left11.isChecked() == false && rb_right11.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "미체크 항목이 있습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SubActivity3.this, SubActivity4.class);
                    intent.putStringArrayListExtra("result4", result);
                    startActivity(intent);
                }
            }
        });

        backbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}