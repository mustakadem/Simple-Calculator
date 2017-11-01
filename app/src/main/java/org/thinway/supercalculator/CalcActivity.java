package org.thinway.supercalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    // Widgets
    private TextView resultTextView;
    private Button addBtn;
    private Button subtractBtn;
    private Button multiplyBtn;
    private Button divBtn;
    private Button sevenBtn;
    private Button eightBtn;
    private Button nineBtn;
    private Button acBtn;
    private Button fourBtn;
    private Button fiveBtn;
    private Button sixBtn;
    private Button deleteBtn;
    private Button oneBtn;
    private Button twoBtn;
    private Button threeBtn;
    private Button pointBtn;
    private Button zeroBtn;
    private Button signBtn;
    private Button equalBtn;

    // Data
    private double mAccumulator;
    private char mOp;
    private boolean pulsado;
    private boolean pulsarIgual;
    private double controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newcalc);

        connectWidgets();
        connectEventsToWidgets();

        initializeValues();
    }

    /**
     * Initialize all non-widget members attributes.
     */
    private void initializeValues() {
        mAccumulator = 0;
        mOp = 0;
        resultTextView.setText("0");
        pulsado = false;
        pulsarIgual = false;
        controlador = 0;
    }

    /**
     * Set OnClickListener on all interface button.
     */
    private void connectEventsToWidgets() {
        addBtn.setOnClickListener(this);
        subtractBtn.setOnClickListener(this);
        multiplyBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);
        sevenBtn.setOnClickListener(this);
        eightBtn.setOnClickListener(this);
        nineBtn.setOnClickListener(this);
        acBtn.setOnClickListener(this);
        fourBtn.setOnClickListener(this);
        fiveBtn.setOnClickListener(this);
        sixBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        oneBtn.setOnClickListener(this);
        twoBtn.setOnClickListener(this);
        threeBtn.setOnClickListener(this);
        pointBtn.setOnClickListener(this);
        zeroBtn.setOnClickListener(this);
        signBtn.setOnClickListener(this);
        equalBtn.setOnClickListener(this);
    }

    /**
     * Connect all the widgets to their correspondent element of the interface
     */
    private void connectWidgets() {
        resultTextView = (TextView) findViewById(R.id.text_view_result);
        addBtn = (Button) findViewById(R.id.btn_add);
        subtractBtn = (Button) findViewById(R.id.btn_subtract);
        multiplyBtn = (Button) findViewById(R.id.btn_multiply);
        divBtn = (Button) findViewById(R.id.btn_div);
        sevenBtn = (Button) findViewById(R.id.btn_seven);
        eightBtn = (Button) findViewById(R.id.btn_eight);
        nineBtn = (Button) findViewById(R.id.btn_nine);
        acBtn = (Button) findViewById(R.id.btn_ac);
        fourBtn = (Button) findViewById(R.id.btn_four);
        fiveBtn = (Button) findViewById(R.id.btn_five);
        sixBtn = (Button) findViewById(R.id.btn_six);
        deleteBtn = (Button) findViewById(R.id.btn_delete);
        oneBtn = (Button) findViewById(R.id.btn_one);
        twoBtn = (Button) findViewById(R.id.btn_two);
        threeBtn = (Button) findViewById(R.id.btn_three);
        pointBtn = (Button) findViewById(R.id.btn_point);
        zeroBtn = (Button) findViewById(R.id.btn_zero);
        signBtn = (Button) findViewById(R.id.btn_sign);
        equalBtn = (Button) findViewById(R.id.btn_equal);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        switch (v.getId()) {
            case R.id.btn_zero:
            case R.id.btn_one:
            case R.id.btn_two:
            case R.id.btn_three:
            case R.id.btn_four:
            case R.id.btn_five:
            case R.id.btn_six:
            case R.id.btn_seven:
            case R.id.btn_eight:
            case R.id.btn_nine:
                readNumber(button);
                break;
            case R.id.btn_add:
            case R.id.btn_subtract:
            case R.id.btn_multiply:
            case R.id.btn_div:
                applyOp(button);
                break;
            case R.id.btn_ac:
                initializeValues();
                break;
            case R.id.btn_sign:
                changeSign();
                break;
            case R.id.btn_point:
                addPoint();
                break;
            case R.id.btn_delete:
                deleteNumber();
                break;
            case R.id.btn_equal:
                makeOperation();
                break;
            default:
                // Error
        }
    }

    /**
     * Apply the selected operation
     */
    private void makeOperation() {
        double secondNumber = Double.parseDouble(resultTextView.getText().toString());
        double total = 0;
        if (!pulsarIgual) {
            controlador = secondNumber;
        }
        if (pulsarIgual) {
            mAccumulator = controlador;
        }


        switch (mOp) {
            case '+':
                total = mAccumulator + secondNumber;
                pulsarIgual = true;
                break;
            case '-':
                total = mAccumulator - secondNumber;
                pulsarIgual = true;
                break;
            case '*':
                total = mAccumulator * secondNumber;
                pulsarIgual = true;
                break;
            case '/':
                total = mAccumulator / secondNumber;
                pulsarIgual = true;
                break;
            default:
        }

        long totalInt = (long) total;

        if (total == (double) totalInt) {
            resultTextView.setText(totalInt + "");
        } else {
            resultTextView.setText(total + "");
        }
    }

    private void applyOp(Button button) {
        mOp = button.getText().toString().charAt(0);
        mAccumulator = Double.parseDouble(resultTextView.getText().toString());
        pulsado = true;
    }

    private void deleteNumber() {
        String actualNumber = resultTextView.getText().toString();

        if (actualNumber.length() == 1 || actualNumber.length() == 2 && Integer.parseInt(actualNumber) < 0) {
            resultTextView.setText("0");
        } else if (!resultTextView.getText().toString().equals("0")) {
            resultTextView.setText(resultTextView.getText().subSequence(0, resultTextView.getText().length() - 1) + "");

        }
    }

    private void addPoint() {
        if (resultTextView.getText().toString().indexOf('.') == -1) {
            resultTextView.setText(
                    resultTextView.getText().toString() + '.'
            );
        }
    }

    private void changeSign() {
        int actualNumber = Integer.parseInt(resultTextView.getText().toString());
        actualNumber*=-1;
        resultTextView.setText(String.valueOf(actualNumber));


    }


    private void readNumber(Button button) {
        if (pulsado) {
            resultTextView.setText("");
        }
        String digit = button.getText().toString();
        String actualNumber = resultTextView.getText().toString();
        boolean intNumber = (actualNumber.indexOf('.') == -1) ? true : false;

        Log.d("CalcActivity", "mAccumulator = " + mAccumulator + " | mOp = " + mOp);


        if (intNumber) {
            if (actualNumber.equals("0")) {
                resultTextView.setText(digit);
            } else {
                resultTextView.setText(
                        resultTextView.getText().toString() + digit);
            }
        } else {
            resultTextView.setText(
                    resultTextView.getText().toString() + digit);
        }
        pulsado = false;
    }
}
