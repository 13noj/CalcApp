package jp.techacademy.hirotoshi.yoshioka.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double v1 = intent.getDoubleExtra("VALUE1", 0);
        double v2 = intent.getDoubleExtra("VALUE2", 0);
        String operator = intent.getStringExtra("OPERATOR");
        TextView textView = (TextView) findViewById(R.id.textView);

        double answer = 0.0;

        if(operator.equals("+")==true)
        {
            answer = v1 + v2;
        }

        else if(operator.equals("-")==true)
        {
            answer = v1 - v2;
        }
        else if(operator.equals("*")==true)
        {
            answer = v1 * v2;
        }
        else if(operator.equals("/")==true)
        {
            answer = v1 / v2;
        }
        textView.setText(String.valueOf(answer));
    }
}
