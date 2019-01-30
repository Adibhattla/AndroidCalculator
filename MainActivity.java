package com.example.divz.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button add;
    private Button minus;
    private Button multiply;
    private Button divide;
    private Button delete;
    private Button dot;
    private Button equals;
    private TextView info;
    private TextView result;
    private final char ADDITION ='+';
    private final char SUBTRACTION ='-';
    private final char MULTIPLY ='*';
    private final char DIVIDE='/';
    private final char EQUALS=0;
    private double val1 =Double.NaN;
    private double val2;
    private double val3;
    private double val4;
    private String temp;
    private char ACTION;
    //Toast toast = " OOPS!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //info.setText(info.getText().toString()+".");
                info.setText(String.valueOf(val3));
                val1=val3;

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()==0){
                    info.setText("0.0");
                }
                compute();
                ACTION=ADDITION;
                temp = String.valueOf((val1) + "+");
                //result.setText(temp);
                info.setText(temp);
                //info.setText(null);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()==0){
                    info.setText("0.0");
                }
                compute();
                ACTION=SUBTRACTION;
                result.setText(String.valueOf(val1)+"-");
                info.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()==0){
                    info.setText("0.0");
                }
                compute();
                ACTION=MULTIPLY;
                result.setText(String.valueOf(val1)+"*");
                info.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()==0){
                    info.setText("0.0");
                }
                compute();
                ACTION=DIVIDE;
                result.setText(String.valueOf(val1)+"/");
                info.setText(null);
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();

                ACTION=EQUALS;
                //info.setText(info.getText().toString()+String.valueOf(val2));
                val1=Double.NaN;
                result.setText("=" + String.valueOf(val3));
               info.setText(null);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()>0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0,name.length()-1));
                }
                else{
                    val1=Double.NaN;
                    val2=Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });


    }
    private void setUI(){
        zero = (Button) findViewById(R.id.button0);
        one = (Button) findViewById(R.id.button1);
        two = (Button) findViewById(R.id.button2);
        three = (Button) findViewById(R.id.button3);
        four= (Button) findViewById(R.id.button4);
        five = (Button) findViewById(R.id.button5);
        six = (Button) findViewById(R.id.button6);
        seven = (Button) findViewById(R.id.button7);
        eight = (Button) findViewById(R.id.button8);
        nine = (Button) findViewById(R.id.button9);
        add= (Button) findViewById(R.id.buttonPlus);
        minus=(Button) findViewById(R.id.buttonMinus);
        multiply= (Button) findViewById(R.id.buttonMultiply);
        divide=   (Button) findViewById(R.id.buttonDivide);
        delete = (Button) findViewById(R.id.buttonDelete);
        dot = (Button) findViewById(R.id.buttonDot);
        equals = (Button) findViewById(R.id.buttonEquals);
        info = (TextView) findViewById(R.id.info);
        result = (TextView) findViewById(R.id.result);
    }

    private void compute(){
        //result.setText(null);
        if(!Double.isNaN(val1)) {

            String xyz = (String) info.getText();
            int len = xyz.length();
            int index = xyz.indexOf(ACTION);
            String abc = xyz.substring(index + 1, len);
            if (abc.length() == 0) {
                abc = "0.0";
            }

                val2 = Double.parseDouble(abc);

                // val2 = Double.parseDouble(info.getText().toString());
                // val2=String.valueOf(val2);
                //  Log.d("val2:",Double.toString(val2));

                switch (ACTION) {
                    case ADDITION:
                        val3 = val1 + val2;
                        result.setText("=" + String.valueOf(val3));
                        // val1=Double.NaN;
                        break;
                    case SUBTRACTION:
                        val3 = val1 - val2;
                        //  val1=Double.NaN;
                        break;
                    case MULTIPLY:
                        val3 = val1 * val2;
                        // val1=Double.NaN;
                        break;
                    case DIVIDE:
                        if (val2 == 0) {
                            val3 = Double.NaN;
                            break;
                        }
                        val3 = val1 / val2;
                        break;
                    case EQUALS:
                        break;
                }
            }
        else {
           val1= Double.parseDouble(info.getText().toString());


        }
    }

}
