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

public class SubActivity6 extends AppCompatActivity {

    private RadioGroup rg_18;
    private RadioButton rb_left18;
    private RadioButton rb_right18;

    private RadioGroup rg_19;
    private RadioButton rb_left19;
    private RadioButton rb_right19;

    private RadioGroup rg_20;
    private RadioButton rb_left20;
    private RadioButton rb_right20;

    private AppCompatButton backbtn7;
    private AppCompatButton btn7;

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplicationContext(),"검사중에는 뒤로가기가 불가합니다", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub6);

        Intent intent = getIntent();
        ArrayList<String> arrayList = intent.getStringArrayListExtra("result6");

        rg_18 = findViewById(R.id.rg_18);
        rb_left18 = findViewById(R.id.rb_left18);
        rb_right18 = findViewById(R.id.rb_right18);

        rg_19 = findViewById(R.id.rg_19);
        rb_left19 = findViewById(R.id.rb_left19);
        rb_right19 = findViewById(R.id.rb_right19);

        rg_20 = findViewById(R.id.rg_20);
        rb_left20 = findViewById(R.id.rb_left20);
        rb_right20 = findViewById(R.id.rb_right20);

        backbtn7 = findViewById(R.id.backbtn7);
        btn7 = findViewById(R.id.btn7);

        rg_18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_right18.isChecked() ? "S" : "N");
            }
        });

        rg_19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left19.isChecked() ? "J" : "P");
            }
        });

        rg_20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left20.isChecked() ? "J" : "P");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_left18.isChecked() == false && rb_right18.isChecked() == false
                        || rb_left19.isChecked() == false && rb_right19.isChecked() == false
                        || rb_left20.isChecked() == false && rb_right20.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "미체크 항목이 있습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SubActivity6.this, SubActivity7.class);
                    intent.putStringArrayListExtra("result7", result);
                    startActivity(intent);
                }
            }
        });

        backbtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}