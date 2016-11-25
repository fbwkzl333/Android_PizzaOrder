package com.example.donghee.android1125;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2, edit3;   // 입력창 3개
    CheckBox chB1;  // 체크박스
    RadioButton Rdio1, Rdio2;   // 라디오 버튼 2개
    ImageView image;    // 이미지뷰
    Button bt1; // '주문완료' 버튼
    TextView Tview1, Tview2, Tview3;    // 주문개수, 주문금액, 소스선택 여부 출력. 텍스트뷰
    String num1, num2, num3;    // 값 계산용 변수 (피자, 스파게티, 샐러디)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.editText1);
        edit2 = (EditText) findViewById(R.id.editText2);
        edit3 = (EditText) findViewById(R.id.editText3);
        chB1 = (CheckBox) findViewById(R.id.checkBox1);
        Rdio1 = (RadioButton) findViewById(R.id.radioButton1);
        Rdio2 = (RadioButton) findViewById(R.id.radioButton2);
        image = (ImageView) findViewById(R.id.imageView);
        bt1 = (Button) findViewById(R.id.button);
        Tview1 = (TextView) findViewById(R.id.resultview1);
        Tview2 = (TextView) findViewById(R.id.resultview2);
        Tview3 = (TextView) findViewById(R.id.resultview3);

        Rdio1.setChecked(true);  // 라디오그룹의 '피클'을 기본으로 선택해둠

        Rdio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.t1);
            }
        });
        Rdio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(R.drawable.t2);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {  // 주문완료 버튼 클릭 이벤트
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                num3 = edit3.getText().toString();      // 입력값 String 형식으로 num에 담음

                int result1 = Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(num3);     // 입력창1~3 입력값 전부 더함(Int). 주문 개수
                Double result2 = (Double.parseDouble(num1) * 16000) + ((Double.parseDouble(num2)) * 11000) + ((Double.parseDouble(num3)) * 4000);   // 주문 금액 구함(Double)

                if(chB1.isChecked()) {      // 멤버쉽 카드 있을경우 7% 할인
                    result2 = (Double)result2 - ((Double)result2 *0.07);
                }

                Tview1.setText("주문 개수 : "+ result1); // 텍스트뷰1에 주문 개수 출력
                Tview2.setText("주문 금액 : "+ result2); // 텍스트뷰2에 주문 금액 출력

                if(Rdio1.isChecked()) { // 라디오버튼1 (피클) 이 체크가 되있다면
                    Tview3.setText("피클을 선택하셨습니다."); // 텍스트뷰3 에 보여줄 값
                } else {    // 라디오버튼1 (피클) 이 체크가 안되있다면
                    Tview3.setText("소스를 선택하셨습니다.");
                }


            }
        });


    }
}
