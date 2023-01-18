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

public class SubActivity2 extends AppCompatActivity {

    private RadioGroup rg_6;
    private RadioButton rb_left6;
    private RadioButton rb_right6;

    private RadioGroup rg_7;
    private RadioButton rb_left7;
    private RadioButton rb_right7;

    private RadioGroup rg_8;
    private RadioButton rb_left8;
    private RadioButton rb_right8;

    private AppCompatButton backbtn3;
    private AppCompatButton btn3;

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplicationContext(),"검사중에는 뒤로가기가 불가합니다", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        Intent intent = getIntent();
        ArrayList<String> arrayList = intent.getStringArrayListExtra("result2");

        rg_6 = findViewById(R.id.rg_6);
        rb_left6 = findViewById(R.id.rb_left6);
        rb_right6 = findViewById(R.id.rb_right6);

        rg_7 = findViewById(R.id.rg_7);
        rb_left7 = findViewById(R.id.rb_left7);
        rb_right7 = findViewById(R.id.rb_right7);

        rg_8 = findViewById(R.id.rg_8);
        rb_left8 = findViewById(R.id.rb_left8);
        rb_right8 = findViewById(R.id.rb_right8);

        backbtn3 = findViewById(R.id.backbtn3);
        btn3 = findViewById(R.id.btn3);

        rg_6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_right6.isChecked() ? "J" : "P");
            }
        });

        rg_7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left7.isChecked() ? "E" : "I");
            }
        });

        rg_8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_right8.isChecked() ? "E" : "I");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_left6.isChecked() == false && rb_right6.isChecked() == false
                        || rb_left7.isChecked() == false && rb_right7.isChecked() == false
                        || rb_left8.isChecked() == false && rb_right8.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "미체크 항목이 있습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SubActivity2.this, SubActivity3.class);
                    intent.putStringArrayListExtra("result3", result);
                    startActivity(intent);
                }
            }
        });

        backbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}