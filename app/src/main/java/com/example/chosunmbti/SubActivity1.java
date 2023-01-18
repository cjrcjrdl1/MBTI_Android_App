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

public class SubActivity1 extends AppCompatActivity {

    private RadioGroup rg_4;
    private RadioButton rb_left4;
    private RadioButton rb_right4;

    private RadioGroup rg_5;
    private RadioButton rb_left5;
    private RadioButton rb_right5;

    private AppCompatButton backbtn2;
    private AppCompatButton btn2;

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(getApplicationContext(),"검사중에는 뒤로가기가 불가합니다", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        Intent intent = getIntent();
        ArrayList<String> arrayList = intent.getStringArrayListExtra("result1");

        rg_4 = findViewById(R.id.rg_4);
        rb_left4 = findViewById(R.id.rb_left4);
        rb_right4 = findViewById(R.id.rb_right4);

        rg_5 = findViewById(R.id.rg_5);
        rb_left5 = findViewById(R.id.rb_left5);
        rb_right5 = findViewById(R.id.rb_right5);

        backbtn2 = findViewById(R.id.backbtn2);
        btn2 = findViewById(R.id.btn2);

        rg_4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_right4.isChecked() ? "J" : "P");
            }
        });

        rg_5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                result.add(rb_left5.isChecked() ? "J" : "P");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rb_left4.isChecked() == false && rb_right4.isChecked() == false
                        || rb_left5.isChecked() == false && rb_right5.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "미체크 항목이 있습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SubActivity1.this, SubActivity2.class);
                    intent.putStringArrayListExtra("result2", result);
                    startActivity(intent);
                }
            }
        });

        backbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}