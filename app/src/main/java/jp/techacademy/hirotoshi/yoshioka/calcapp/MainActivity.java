package jp.techacademy.hirotoshi.yoshioka.calcapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);

        mEditText1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        mEditText2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    @Override
    public void onClick(View v) {

        String text1 = mEditText1.getText().toString();
        String text2 = mEditText2.getText().toString();

        if (text1.equals("") | text2.equals("") ){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("エラー");
            builder.setMessage("数字を入力して下さい！");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        double v1 = Double.parseDouble(text1);
        double v2 = Double.parseDouble(text2);

        String operator = null;

        if (v.getId() == R.id.button1) {
            operator = "+";
        } else if (v.getId() == R.id.button2) {
            operator = "-";
        } else if (v.getId() == R.id.button3) {
            operator = "*";
        } else if (v.getId() == R.id.button4) {
            operator = "/";
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", v1);
        intent.putExtra("VALUE2", v2);
        intent.putExtra("OPERATOR", operator);
        startActivity(intent);
        Log.d("test", operator);
    }


}
