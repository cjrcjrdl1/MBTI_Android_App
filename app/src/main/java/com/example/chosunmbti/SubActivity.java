package com.example.chosunmbti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
    public static ArrayList<String> result = new ArrayList<String>();
    public static ArrayList<String> MBTI = new ArrayList<String>();

    private RadioGroup rg_1;
    private RadioButton rb_left1;
    private RadioButton rb_right1;

    private RadioGroup rg_2;
    private RadioButton rb_left2;
    private RadioButton rb_right2;

    private RadioGroup rg_3;
    private RadioButton rb_left3;
    private RadioButton rb_right3;

    private AppCompatButton btn1;

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplicationContext(),"검사중에는 뒤로가기가 불가합니다", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();

        rg_1 = findViewById(R.id.rg_1);
        rb_left1 = findViewById(R.id.rb_left1);
        rb_right1 = findViewById(R.id.rb_right1);
        btn1 = findViewById(R.id.btn1);

        rg_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left1.isChecked() ? "S" : "N");
            }
        });

        rg_2 = findViewById(R.id.rg_2);
        rb_left2 = findViewById(R.id.rb_left2);
        rb_right2 = findViewById(R.id.rb_right2);

        rg_2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_right2.isChecked() ? "S" : "N");
            }
        });

        rg_3 = findViewById(R.id.rg_3);
        rb_left3 = findViewById(R.id.rb_left3);
        rb_right3 = findViewById(R.id.rb_right3);

        rg_3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_right3.isChecked() ? "S" : "N");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_left1.isChecked() == false && rb_right1.isChecked() == false
                        || rb_left2.isChecked() == false && rb_right2.isChecked() == false
                        || rb_left3.isChecked() == false && rb_right3.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "미체크 항목이 있습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SubActivity.this, SubActivity1.class);
                    intent.putStringArrayListExtra("result1", result);
                    startActivity(intent);
                }
            }
        });
    }
}