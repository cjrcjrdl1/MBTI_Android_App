package com.example.chosunmbti;

import static com.example.chosunmbti.SubActivity.MBTI;
import static com.example.chosunmbti.SubActivity.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;

public class SubActivity7 extends AppCompatActivity {
    private TextView resultTv;
    private Button btn8;
    private TextView introTv;
    private TextView pointTv;
    private TextView jobTv;
    private ProgressBar pbar1;
    private ProgressBar pbar2;
    private ProgressBar pbar3;
    private ProgressBar pbar4;

    private final long finishtimeed = 1000;
    private long presstime = 0;

    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - presstime;

        if (0 <= intervalTime && finishtimeed >= intervalTime) {
            finishAffinity(); // 액티비티 전체 종료
        } else {
            presstime = tempTime;
            Toast.makeText(getApplicationContext(), "한번 더 누르시면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub7);

        Intent intent = getIntent();

        resultTv = findViewById(R.id.resultTv);
        btn8 = findViewById(R.id.btn8);
        introTv = findViewById(R.id.introTv);
        pointTv = findViewById(R.id.pointTv);
        jobTv = findViewById(R.id.jobTv);
        pbar1 = findViewById(R.id.pbar1);
        pbar2 = findViewById(R.id.pbar2);
        pbar3 = findViewById(R.id.pbar3);
        pbar4 = findViewById(R.id.pbar4);

        int e = Collections.frequency(result, "E");
        if (e >= 3) {
            MBTI.add("E");
        } else {
            MBTI.add("I");
        }

        int s = Collections.frequency(result, "S");
        if (s >= 3) {
            MBTI.add("S");
        } else {
            MBTI.add("N");
        }

        int t = Collections.frequency(result, "T");
        if (t >= 3) {
            MBTI.add("T");
        } else {
            MBTI.add("F");
        }

        int j = Collections.frequency(result, "J");
        if (j >= 3) {
            MBTI.add("J");
        } else {
            MBTI.add("P");
        }

        String str = MBTI.toString().replaceAll("\\[|\\]", "").replaceAll(", ","");

        resultTv.setText(str);

        pbar1.setProgress(e);
        pbar2.setProgress(s);
        pbar3.setProgress(t);
        pbar4.setProgress(j);

        switch (str) {
            case "ESTJ":
                introTv.setText("현실적, 구체적, 사실적이며 어떠한 활동을 조직화하고 주도해 나가는 지도력이 있다.\n\n실질적이고 현실 감각이 뛰어나며 일을 조직하고 계획하여 추진시키는 능력이 있고 행정, 의료, 법조, 군대, 경찰, 재무, 특히나 모든 것을 망라한 한 단어로 '조직관리' 분야에 뛰어난 재능을 지녔으며, 체계적으로 사업체나 조직체를 이끌어 나간다.");
                pointTv.setText("사업가형");
                jobTv.setText("ESTJ 유형의 사람들은 단시간에 실용적인 결정을 내릴 수 있어 지도자의 역할을 잘 수행한다.");
                break;
            case "ESTP":
                introTv.setText("사실적이고 관대하며 개방적이고 사람이나 사물에 대한 선입견이 별로 없고, 강한 현실 감각으로 타협책을 모색하고 문제를 해결하는 능력이 뛰어나다.");
                pointTv.setText("수완좋은 활동가형");
                jobTv.setText("ESTP 유형은 위험을 무릅쓰고서라도 흥미로운 일을 찾아 나서는 성향이 있어 지략이 요구되는 직업에 끌리는 경향이 있다.");
                break;
            case "ESFJ":
                introTv.setText("동정심이 많고 다른 사람에게 관심을 쏟으며 나눔과 베풂을 중시한다.\n\n타고난 협력자로서 동료애가 많고 친절하며 능동적인 구성원이고, 이야기 하기를 즐기며 정리정돈을 잘하고, 참을성이 많고 다른 사람들을 잘 도와준다.");
                pointTv.setText("친선도모형");
                jobTv.setText("ESFJ 유형의 사람들은 타인을 돕고 싶어 하는 특성이 있어 사회에 도움이 되는 역할에 이끌린다고 한다.");
                break;
            case "ESFP":
                introTv.setText("사교적이고 활동적이며 수용력이 강하고 친절하며 낙천적이고, 어떤 상황이든 잘 적응하며 현실적이고 실제적이다.\n\n주위의 사람이나 일어나는 일에 대하여 관심이 많으며 사람이나 사물을 다루는 사실적인 상식이 풍부하다.");
                pointTv.setText("사고적인 유형");
                jobTv.setText("ESFP 유형은 상식을 중요시하며 다른 사람들과 상호작용하고 자기 자신을 표현하는 일에서 훌륭한 성과를 발휘할 수 있다.");
                break;
            case "ENTJ":
                introTv.setText("타고난 리더라도 불리는 이 유형은 권위와 자신감으로 재능을 구현하고, 공통된 목표 뒤에서 사람들을 끌어모으는 통솔력을 행사한다.");
                pointTv.setText("지도자형");
                jobTv.setText("ENTJ 유형은 논리적이고 분석적이기 때문에 조직성 및 효율성이 요구되는 권위적인 직업에 끌리는 경향이 있다.");
                break;
            case "ENTP":
                introTv.setText("특유의 능글거리면서 경쾌한 성격과 문제의 본질을 파악하고 논리적으로 판단하려는 기질이 있고, 어느곳에서나 적응력이 빠른 성격이다.");
                pointTv.setText("발명가형");
                jobTv.setText("ENTP 유형에는 뛰어난 창의력의 소유자가 많기 때문에 이들은 독창성이 요구되는 직무에 적합한 경우가 많다.");
                break;
            case "ENFJ":
                introTv.setText("온화하고 적극적이며 책임감이 강하고 사교성이 풍부하고 동정심이 많다.\n\n상당히 이타적이고 민첩하고 인화를 중요시하며 참을성이 많고, 다른 사람들의 생각이나 의견에 진지한 관심을 가지고 공동선을 위하여 다른 사람의 의견에 대체로 동의한다.");
                pointTv.setText("언변능숙형");
                jobTv.setText("ENFJ 유형은 타인을 사랑하며 자신의 의견을 표현할 수 있고 협동심이 요구되는 역할을 잘 수행한다.");
                break;
            case "ENFP":
                introTv.setText("정열적이고 활기가 넘치며 상상력이 풍부하고 온정적이고 창의적이며 항상 새로운 가능성을 찾고 시도하는 유형이다.\n\n문제 해결에 재빠르고 관심이 있는 일은 수행해내는 능력과 열성이 있고, 반복되는 일상적인 일을 참지 못하고 열성이 나지 않는다.");
                pointTv.setText("스파크형");
                jobTv.setText("ENFP 유형은 수평적 분위기에서의 협업 프로젝트, 업무 실현을 직접 확인할 수 있는 일, 창의성과 자율성을 뽐낼 수 있는 크리에이티브 한 일이 어울린다.");
                break;
            case "ISTJ":
                introTv.setText("실제 사실에 대하여 정확하고 체계적으로 기억하며 일 처리에 있어서도 신중하고 책임감이 있다.\n\n집중력이 강한 현실 감각을 지녔으며 조직적이고 침착하다.\n\n보수적인 경향이 있으며, 문제를 해결하는데 과거의 경험을 잘 적용하며, 반복되는 일상적인 일에 대한 인내력이 강하다.");
                pointTv.setText("세상의 소금형");
                jobTv.setText("ISTJ 유형에는 책임감이 강하고 일을 열심히 하는 사람이 많다. 이들은 비밀스럽지만, 신뢰성이 요구되는 직종에 종사하면 훌륭한 성과를 낼 수 있다.");
                break;
            case "ISTP":
                introTv.setText("과묵하며 절제된 호기심으로 인생을 관찰하고, 상황을 파악하는 민감성과 도구를 다루는 뛰어난 능력이 있다.\n\n말수가 적으며, 객관적이고 합리적으로 인생을 관찰하는 유형이고, 인식형(P) 중에서는 판단(J) 성향이 가장 강하거나 판단(J)형과 인식(P)형이 반반으로 나오는 경우가 다소 있다.");
                pointTv.setText("백과사전형");
                jobTv.setText("ISTP 유형은 대화보다는 행동을 선호하며 도구 활용 능력이 훌륭한 경우가 많다.");
                break;
            case "ISFJ":
                introTv.setText("조용하고 차분하며 따뜻하고 친근하다.\n\n책임감과 인내력 또한 매우 강하고, 본인의 친한 친구나 가족에게 애정이 가득하다.\n\n이들은 언제나 진솔하려 노력하고 가볍지 않기 때문에 관계를 맺기에 가장 어려우나 가장 믿음직스러운 유형이다.");
                pointTv.setText("임금 뒤편의 권력형");
                jobTv.setText("ISFJ 유형은 타인을 돕는 것을 즐김으로 서비스를 제공하는 직업에 적합한 경우가 많다고 한다.");
                break;
            case "ISFP":
                introTv.setText("말없이 다정하고 온화하며 사람들에게 친절하고 상대방을 잘 알게 될 때까지 내면의 모습이 잘 보이지 않는다.\n\n의견 충돌을 피하고, 인화를 중시하며, 인간과 관계되는 일을 할 때 자신의 감정과 타인의 감정에 지나치게 세심하고 민감한 경향이 있다.");
                pointTv.setText("성인군자형");
                jobTv.setText("ISFP 유형은 눈에 보이지 않는 방식으로 사람을 도우며 동정심과 세심함이 요구되는 역할에 적합하다.");
                break;
            case "INTJ":
                introTv.setText("거의 모든 일에 의문을 던지고, 더 좋은 방법을 찾는 과정에서 거절당하거나 규칙을 깨는 일을 두려워하지 않는다.\n\n또 단지 창의적인 데에서 그치지 않고 성취해내기를 원해, 새로운 아이디어에 통찰력과 뛰어난 논리력, 강한 의지를 더해 일을 추진한다.");
                pointTv.setText("과학자형");
                jobTv.setText("INTJ 유형은 항상 무언가를 하고싶어한다. 이들은 이론적인 사고가 주요 업무 역량인 직무에서 빛을 발할수 있다.");
                break;
            case "INTP":
                introTv.setText("논리와 분석으로 문제를 해결하기 좋아하며, 먼저 대화를 시작하지 않는 편이나 관심이 있는 분야에 대해서는 대화를 즐긴다.\n\n이해가 빠르고 직관적으로 통찰하는 능력이 있으며 지적 호기심이 많아, 분석적이고 논리적이다.");
                pointTv.setText("아이디어 뱅크형");
                jobTv.setText("INTP 유형은 이론적이고 정확한 대상을 선호하기 때문에 이와 관련된 업무 역량이 요구되는 직업에서 훌륭한 성과를 얻을 가능성이 크다.");
                break;
            case "INFJ":
                introTv.setText("전 세계의 1.5% 미만을 차지하는 극 소수의 유형.\n\n인내심이 많고 통찰력과 직관력이 매우 뛰어나며 화합을 추구하고, 창의력이 좋으며, 성숙한 경우엔 강한 직관력으로 타인에게 말없이 영향력을 끼친다.");
                pointTv.setText("예언자형");
                jobTv.setText("INFJ 유형은 원칙과 신의에 의해 움직이는 사려 깊고 창의적인 사람들이 다수 포함되어 있다고 한다. 이 때문에 이들은 의사소통을 중심으로 한 업무에서 뛰어난 능력을 보이는 경우가 많다.");
                break;
            case "INFP":
                introTv.setText("세계 인구의 4%가 이 유형에 속하며 차분하고 창의적이며 낭만적인 성향으로 보이지만 내면은 내적신념이 깊은 열정적인 중재자 유형이다.\n\n목가적이고 부드러운 성향을 가지고 있으며 사려깊고 상냥한 언어를 사용한다.");
                pointTv.setText("잔다라크형");
                jobTv.setText("INFP 유형은 자기자신이 가지고 있는 가치에 동기 부여를 받으며 이들은 포옹력 및 적응력이 요구되는 직무에 적합하다고 한다.");
                break;
        }

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (str) {
                    case "ESTJ":
                        Intent intent1 = new Intent(SubActivity7.this, ESTJ.class);
                        startActivity(intent1);
                        break;
                    case "ESTP":
                        Intent intent2 = new Intent(SubActivity7.this, ESTP.class);
                        startActivity(intent2);
                        break;
                    case "ESFJ":
                        Intent intent3 = new Intent(SubActivity7.this, ESFJ.class);
                        startActivity(intent3);
                        break;
                    case "ESFP":
                        Intent intent4 = new Intent(SubActivity7.this, ESFP.class);
                        startActivity(intent4);
                        break;
                    case "ENTJ":
                        Intent intent5 = new Intent(SubActivity7.this, ENTJ.class);
                        startActivity(intent5);
                        break;
                    case "ENTP":
                        Intent intent6 = new Intent(SubActivity7.this, ENTP.class);
                        startActivity(intent6);
                        break;
                    case "ENFJ":
                        Intent intent7 = new Intent(SubActivity7.this, ENFJ.class);
                        startActivity(intent7);
                        break;
                    case "ENFP":
                        Intent intent8 = new Intent(SubActivity7.this, ENFP.class);
                        startActivity(intent8);
                        break;
                    case "ISTJ":
                        Intent intent9 = new Intent(SubActivity7.this, ISTJ.class);
                        startActivity(intent9);
                        break;
                    case "ISTP":
                        Intent intent10 = new Intent(SubActivity7.this, ISTP.class);
                        startActivity(intent10);
                        break;
                    case "ISFJ":
                        Intent intent11 = new Intent(SubActivity7.this, ISFJ.class);
                        startActivity(intent11);
                        break;
                    case "ISFP":
                        Intent intent12 = new Intent(SubActivity7.this, ISFP.class);
                        startActivity(intent12);
                        break;
                    case "INTJ":
                        Intent intent13 = new Intent(SubActivity7.this, INTJ.class);
                        startActivity(intent13);
                        break;
                    case "INTP":
                        Intent intent14 = new Intent(SubActivity7.this, INTP.class);
                        startActivity(intent14);
                        break;
                    case "INFJ":
                        Intent intent15 = new Intent(SubActivity7.this, INFJ.class);
                        startActivity(intent15);
                        break;
                    case "INFP":
                        Intent intent16 = new Intent(SubActivity7.this, INFP.class);
                        startActivity(intent16);
                        break;
                }
            }
        });



    }
}