package com.example.chosunmbti;

import static com.example.chosunmbti.SubActivity.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class SubActivity4 extends AppCompatActivity {

    private RadioGroup rg_12;
    private RadioButton rb_left12;
    private RadioButton rb_right12;

    private RadioGroup rg_13;
    private RadioButton rb_left13;
    private RadioButton rb_right13;

    private RadioGroup rg_14;
    private RadioButton rb_left14;
    private RadioButton rb_right14;

    private AppCompatButton backbtn5;
    private AppCompatButton btn5;

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplicationContext(),"검사중에는 뒤로가기가 불가합니다", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub4);

        Intent intent = getIntent();
        ArrayList<String> arrayList = intent.getStringArrayListExtra("result4");

        rg_12 = findViewById(R.id.rg_12);
        rb_left12 = findViewById(R.id.rb_left12);
        rb_right12 = findViewById(R.id.rb_right12);

        rg_13 = findViewById(R.id.rg_13);
        rb_left13 = findViewById(R.id.rb_left13);
        rb_right13 = findViewById(R.id.rb_right13);

        rg_14 = findViewById(R.id.rg_14);
        rb_left14 = findViewById(R.id.rb_left14);
        rb_right14 = findViewById(R.id.rb_right14);

        backbtn5 = findViewById(R.id.backbtn5);
        btn5 = findViewById(R.id.btn5);

        rg_12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left12.isChecked() ? "T" : "F");
            }
        });

        rg_13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_right13.isChecked() ? "T" : "F");
            }
        });

        rg_14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left14.isChecked() ? "T" : "F");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_left12.isChecked() == false && rb_right12.isChecked() == false
                        || rb_left13.isChecked() == false && rb_right13.isChecked() == false
                        || rb_left14.isChecked() == false && rb_right14.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "미체크 항목이 있습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SubActivity4.this, SubActivity5.class);
                    intent.putStringArrayListExtra("result5", result);
                    startActivity(intent);
                }
            }
        });

        backbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}