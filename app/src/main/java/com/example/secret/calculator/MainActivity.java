package com.example.secret.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button0,
            buttonAC, buttonAdd, buttonMinus, buttonMultiply,
            buttonDivide, buttonDel, buttonEqual, buttonDecimal,
            buttonNegative, buttonHistory;

    private EditText edtDisplay, edtAnswer;

    private float mNumber1, mNumber2;

    private boolean mAdd, mMinus, mTimes, mDivide;

    DatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable for database
        edtAnswer = (EditText) findViewById(R.id.editText2);
        mDatabaseHelper = new DatabaseHelper(this);
        buttonHistory = (Button) findViewById(R.id.button20);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button10);
        buttonAC = (Button) findViewById(R.id.button13);
        buttonAdd = (Button) findViewById(R.id.button14);
        buttonMinus = (Button) findViewById(R.id.button15);
        buttonMultiply = (Button) findViewById(R.id.button16);
        buttonDivide = (Button) findViewById(R.id.button17);
        buttonDel = (Button) findViewById(R.id.button18);
        buttonEqual = (Button) findViewById(R.id.button11);
        buttonDecimal = (Button) findViewById(R.id.button12);
        buttonNegative = (Button) findViewById(R.id.button19);
        edtDisplay = (EditText) findViewById(R.id.editText);

        //restricts user from entering own input
        edtDisplay.setInputType(InputType.TYPE_NULL);
        edtDisplay.setKeyListener(null);
        edtAnswer.setInputType(InputType.TYPE_NULL);
        edtAnswer.setKeyListener(null);

        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListCalculationActivity.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDisplay.setText(edtDisplay.getText() + "1");
                edtAnswer.setText(null);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDisplay.setText(edtDisplay.getText() + "2");
                edtAnswer.setText(null);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDisplay.setText(edtDisplay.getText() + "3");
                edtAnswer.setText(null);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDisplay.setText(edtDisplay.getText() + "4");
                edtAnswer.setText(null);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDisplay.setText(edtDisplay.getText() + "5");
                edtAnswer.setText(null);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDisplay.setText(edtDisplay.getText() + "6");
                edtAnswer.setText(null);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDisplay.setText(edtDisplay.getText() + "7");
                edtAnswer.setText(null);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDisplay.setText(edtDisplay.getText() + "8");
                edtAnswer.setText(null);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDisplay.setText(edtDisplay.getText() + "9");
                edtAnswer.setText(null);
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtDisplay.setText(edtDisplay.getText() + "0");
                edtAnswer.setText(null);
            }
        });

        buttonNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //prevent syntax error
                if (edtDisplay.getText().toString().contains(".")) {
                    Toast.makeText(MainActivity.this, "The Negative Symbol should come before Decimal Point! ", Toast.LENGTH_SHORT)
                            .show();
                }
                //prevent user from entering more than one negative symbol
                else if(edtDisplay.getText().toString().contains("-")){
                    String len = edtDisplay.getText().toString();
                    //just change the value when length less or equal to one
                    if (edtDisplay.length() <= 1){
                        len = len.substring(0, len.length()-1);
                        edtDisplay.setText(len);
                    }
                    //if there is a number, make it positive by default
                    else{
                        len = len.replace("-","");
                        edtDisplay.setText(len);
                    }
                }
                else if(!edtDisplay.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "The Negative Symbol should come before Number ", Toast.LENGTH_SHORT)
                            .show();
                }
                else{
                    edtDisplay.setText(edtDisplay.getText() + "-");
                    edtAnswer.setText(null);
                }
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if display is not empty
                if (!edtDisplay.getText().toString().equals("")) {
                    //store current number into it for checking
                    String number = edtDisplay.getText().toString();
                    //if there is number, backspace
                    if (edtDisplay.length() > 0) {
                        //minus index value by 1,  updated display accordingly
                        number = number.substring(0, number.length() - 1);
                        edtDisplay.setText(number);
                    }
                }
                //if display is empty
                else {
                    Toast.makeText(MainActivity.this, "There is No Number to be Deleted!", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when no decimal point yet, insert it
                if(!edtDisplay.getText().toString().contains(".")){
                    edtDisplay.setText(edtDisplay.getText() + ".");
                    edtAnswer.setText(null);
                }
                //else, don't insert if already clicked
                else{
                    Toast.makeText(MainActivity.this, "Decimal Point already Clicked!", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if no number before operation then pop up toast
                if (edtDisplay.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter a Number First!", Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    //check for syntax error
                    if(edtDisplay.getText().toString().equals("-") || edtDisplay.getText().toString().equals(".") ){
                        Toast.makeText(MainActivity.this, "Please Enter a Number First!", Toast.LENGTH_SHORT)
                                .show();
                    }
                    //inform user about calculation and store value
                    else{
                        Toast.makeText(MainActivity.this, "Addition Sign Has Been Clicked!", Toast.LENGTH_SHORT)
                                .show();
                        //converting the string value into float value
                        mNumber1 = Float.parseFloat(edtDisplay.getText() + "");
                        mAdd = true;
                        edtDisplay.setText(null);
                    }
                }
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if no number before operation then pop up toast
                if (edtDisplay.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter a Number First!", Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    //check for syntax error
                    if(edtDisplay.getText().toString().equals("-") || edtDisplay.getText().toString().equals(".") ){
                        Toast.makeText(MainActivity.this, "Please Enter a Number First!", Toast.LENGTH_SHORT)
                                .show();
                    }
                    //inform user about calculation and store value
                    else{
                        Toast.makeText(MainActivity.this, "Subtraction Sign Has Been Clicked!", Toast.LENGTH_SHORT)
                                .show();
                        mNumber1 = Float.parseFloat(edtDisplay.getText() + "");
                        mMinus = true;
                        edtDisplay.setText(null);
                    }
                }
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if no number before operation then pop up toast
                if (edtDisplay.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter a Number First!", Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    //check for syntax error
                    if(edtDisplay.getText().toString().equals("-") || edtDisplay.getText().toString().equals(".") ){
                        Toast.makeText(MainActivity.this, "Please Enter a Number First!", Toast.LENGTH_SHORT)
                                .show();
                    }
                    //inform user about calculation and store value
                    else{
                        Toast.makeText(MainActivity.this, "Multiplication Sign Has Been Clicked!", Toast.LENGTH_SHORT)
                                .show();
                        mNumber1 = Float.parseFloat(edtDisplay.getText() + "");
                        mTimes = true;
                        edtDisplay.setText(null);
                    }
                }
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if no number before operation then pop up toast
                if (edtDisplay.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter a Number First!", Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    //check for syntax error
                    if(edtDisplay.getText().toString().equals("-") || edtDisplay.getText().toString().equals(".") ){
                        Toast.makeText(MainActivity.this, "Please Enter a Number First!", Toast.LENGTH_SHORT)
                                .show();
                    }
                    //inform user about calculation and store value
                    else{
                        Toast.makeText(MainActivity.this, "Division Sign Has Been Clicked!", Toast.LENGTH_SHORT)
                                .show();
                        mNumber1 = Float.parseFloat(edtDisplay.getText() + "");
                        mDivide = true;
                        edtDisplay.setText(null);
                    }
                }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when edtDisplay has no input
                if (edtDisplay.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "There Is No Operation to be Carried Out!", Toast.LENGTH_SHORT)
                            .show();
                }
                //if there is things to be calculated
                else {
                    if(edtDisplay.getText().toString().equals("-") || edtDisplay.getText().toString().equals(".") ){
                        Toast.makeText(MainActivity.this, "Please Enter a Number First!", Toast.LENGTH_SHORT)
                                .show();
                    }
                    else{
                        //retrieve second number to carry out operation
                        mNumber2 = Float.parseFloat(edtDisplay.getText() + "");

                        if (mAdd == true) {
                            Toast.makeText(MainActivity.this, "Answer Shown!", Toast.LENGTH_SHORT)
                                    .show();
                            edtAnswer.setText(mNumber1 + " + " + mNumber2 + " = " + (mNumber1 + mNumber2));
                            mAdd = false;
                            StoreData();
                            edtDisplay.setText(null);
                        } else if (mMinus == true) {
                            Toast.makeText(MainActivity.this, "Answer Shown!", Toast.LENGTH_SHORT)
                                    .show();
                            edtAnswer.setText(mNumber1 + " - " + mNumber2 + " = " + (mNumber1 - mNumber2));
                            mMinus = false;
                            StoreData();
                            edtDisplay.setText(null);
                        } else if (mTimes == true) {
                            Toast.makeText(MainActivity.this, "Answer Shown!", Toast.LENGTH_SHORT)
                                    .show();
                            edtAnswer.setText(mNumber1 + " \u00D7 " + mNumber2 + " = " + (mNumber1 * mNumber2));
                            mTimes = false;
                            StoreData();
                            edtDisplay.setText(null);
                        } else if (mDivide == true) {
                            if (mNumber2 == 0){
                                edtAnswer.setText("Infinity");
                            }
                            Toast.makeText(MainActivity.this, "Answer Shown!", Toast.LENGTH_SHORT)
                                        .show();
                            edtAnswer.setText(mNumber1 + " \u00F7 " + mNumber2 + " = " + (mNumber1 / mNumber2));
                            mDivide = false;
                            StoreData();
                            edtDisplay.setText(null);
                        }
                    }
                }
            }
        });

        //reset to default
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Calculator has been Cleared, All Functions Reseted!", Toast.LENGTH_SHORT)
                        .show();
                mAdd = false;
                mMinus = false;
                mTimes = false;
                mDivide = false;
                edtDisplay.setText(null);
                edtAnswer.setText(null);
            }
        });
    }

    //function to insert data into database
    public void AddData(String newEntry){
        boolean isInserted = mDatabaseHelper.addCalc(newEntry);

        if(isInserted){
            Toast.makeText(MainActivity.this, "Calculation Saved!", Toast.LENGTH_SHORT)
                    .show();
        }
        //error handling
        else{
            Toast.makeText(MainActivity.this, "ERROR!", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void StoreData(){
        // storing the calculation into the database
        String newEntry = edtAnswer.getText().toString();
        if(edtAnswer.length() != 0){
            AddData(newEntry);
        }
        else{
            Toast.makeText(MainActivity.this, "There must be a calculation first!", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
