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

    EditText edit1, edit2, edit3;
    CheckBox chB1;
    RadioButton Rdio1, Rdio2;
    ImageView image;
    Button bt1;
    TextView Tview1, Tview2, Tview3;
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
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();
                String num3 = edit3.getText().toString();

                int result1 = Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(num3);
                Double result2 = (Double.parseDouble(num1) * 16000) + ((Double.parseDouble(num2)) * 11000) + ((Double.parseDouble(num3)) * 4000);

                if(chB1.isChecked()) {      // 멤버쉽 카드 있을경우 7% 할인
                    result2 = (Double)result2 - ((Double)result2 *0.07);
                } else

                Tview1.setText("주문 개수 : "+ result1); // 텍스트뷰1 주문 개수
                Tview2.setText("주문 금액 : "+ result2); // 텍스트뷰2 주문 금액

                if(Rdio1.isChecked()) { // 소스 선택에 따른 텍스트뷰3
                    Tview3.setText("피클을 선택하셨습니다.");
                } else {
                    Tview3.setText("소스를 선택하셨습니다.");
                }


            }
        });


    }
}
