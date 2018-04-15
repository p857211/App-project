package edu.hul233psu.commonstock;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserInput extends AppCompatActivity {

    Button calculatebutton;
    EditText stock1;
    EditText stock2;
    EditText stock3;
    EditText stock4;

    EditText bond1;
    EditText bond2;
    EditText bond3;

    EditText forwardc1;
    EditText forwardc2;
    EditText forwardc3;
    EditText forwardc4;

    EditText call1;
    EditText call2;
    EditText call3;
    EditText call4;

    EditText put1;
    EditText put2;
    EditText put3;
    EditText put4;

    EditText percentinput;

    public static float stockinitvalue;
    public static float bondinitvalue;
    public static float forwardcinitvalue;
    public static float callinitvalue;
    public static float putinitvalue;

    public static float stocknumber;
    public static float bondnumber;
    public static float forwardcnumber;
    public static float callnumber;
    public static float putnumber;

    public static float stockfuturelow;
    public static float forwardcfuturelow;
    public static float callfuturelow;
    public static float putfuturelow;

    public static float stockfuturehigh;
    public static float bondfuture;
    public static float forwardcfuturehigh;
    public static float callfuturehigh;
    public static float putfuturehigh;

    public static float percent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calculatebutton = findViewById(R.id.calculate);
        stock1 = findViewById(R.id.editText32);
        stock2 = findViewById(R.id.editText30);
        stock3 = findViewById(R.id.editText31);
        stock4 = findViewById(R.id.editText29);

        bond1 = findViewById(R.id.editText36);
        bond2 = findViewById(R.id.editText35);
        bond3 = findViewById(R.id.editText34);

        forwardc1 = findViewById(R.id.editText44);
        forwardc2 = findViewById(R.id.editText42);
        forwardc3 = findViewById(R.id.editText41);
        forwardc4 = findViewById(R.id.editText43);

        call1 = findViewById(R.id.editText48);
        call2 = findViewById(R.id.editText46);
        call3 = findViewById(R.id.editText47);
        call4 = findViewById(R.id.editText45);

        put1 = findViewById(R.id.editText6);
        put2 = findViewById(R.id.editText3);
        put3 = findViewById(R.id.editText);
        put4 = findViewById(R.id.editText4);
        percentinput = findViewById(R.id.editText49);
        updateUI();
        updatecalc();

        calculatebutton.setOnClickListener(CalculateListener); //Wires the button to the UI Listener

    }

    public void updateUI() {
        if (portfolioOptions.isstocks == false) {
            stock1.setEnabled(false);
            stock2.setEnabled(false);
            stock3.setEnabled(false);
            stock4.setEnabled(false);
        } else {
            stock1.setEnabled(true);
            stock2.setEnabled(true);
            stock3.setEnabled(true);
            stock4.setEnabled(true);
        }
        if (portfolioOptions.isbonds == false) {
            bond1.setEnabled(false);
            bond2.setEnabled(false);
            bond3.setEnabled(false);
        } else {
            bond1.setEnabled(true);
            bond2.setEnabled(true);
            bond3.setEnabled(true);
        }
        if (portfolioOptions.isforwardcontract == false) {
            forwardc1.setEnabled(false);
            forwardc2.setEnabled(false);
            forwardc3.setEnabled(false);
            forwardc4.setEnabled(false);
        } else {
            forwardc1.setEnabled(true);
            forwardc2.setEnabled(true);
            forwardc3.setEnabled(true);
            forwardc4.setEnabled(true);
        }
        if (portfolioOptions.iscall == false) {
            call1.setEnabled(false);
            call2.setEnabled(false);
            call3.setEnabled(false);
            call4.setEnabled(false);
        } else {
            call1.setEnabled(true);
            call2.setEnabled(true);
            call3.setEnabled(true);
            call4.setEnabled(true);
        }
        if (portfolioOptions.isput == false) {
            put1.setEnabled(false);
            put2.setEnabled(false);
            put3.setEnabled(false);
            put4.setEnabled(false);
        } else {
            put1.setEnabled(true);
            put2.setEnabled(true);
            put3.setEnabled(true);
            put4.setEnabled(true);
        }

    }

    public void updatecalc(){
        String stockNumber = stock1.getText().toString();
        String bondNumber = bond1.getText().toString();
        String forwardcNumber = forwardc1.getText().toString();
        String callNumber = call1.getText().toString();
        String putNumber = put1.getText().toString();

        String stockInitValue = stock2.getText().toString();
        String bondInitValue = bond2.getText().toString();
        String forwardcInitValue = forwardc2.getText().toString();
        String callInitValue = call2.getText().toString();
        String putInitValue = put2.getText().toString();

        String stockFutureLow = stock3.getText().toString();
        String forwardcFutureLow = forwardc3.getText().toString();
        String callFutureLow = call3.getText().toString();
        String putFutureLow = put3.getText().toString();

        String stockFutureHigh = stock4.getText().toString();
        String bondFuture = bond3.getText().toString();
        String forwardcFutureHigh = forwardc4.getText().toString();
        String callFutureHigh = call4.getText().toString();
        String putFutureHigh = put4.getText().toString();
        String percentS = percentinput.getText().toString();

        if (stockNumber.equals("")) {
            stocknumber = 0;
        }
        else {
            stocknumber = Integer.parseInt(stockNumber);
        }
        if (bondNumber.equals("")) {
            bondnumber = 0;
        }
        else{
            bondnumber = Integer.parseInt(bondNumber);
        }
        if (forwardcNumber.equals("")) {
            forwardcnumber = 0;
        }
        else{
            forwardcnumber = Integer.parseInt(forwardcNumber);
        }
        if (callNumber.equals("")) {
            callnumber = 0;
        }
        else{
            callnumber = Integer.parseInt(callNumber);
        }
        if (putNumber.equals("")) {
            putnumber = 0;
        }
        else{
            putnumber = Integer.parseInt(putNumber);
        }


        if (stockInitValue.equals("")) {
            stockinitvalue = 0;
        }
        else{
            stockinitvalue = Integer.parseInt(stockInitValue);
        }
        if (bondInitValue.equals("")) {
            bondinitvalue = 0;
            }
        else{
            bondinitvalue = Integer.parseInt(bondInitValue);
        }
        if (forwardcInitValue.equals("")) {
            forwardcinitvalue = 0;
        }
        else{
            forwardcinitvalue = Integer.parseInt(forwardcInitValue);
        }
        if (callInitValue.equals("")) {
            callinitvalue = 0;
        }
        else{
            callinitvalue = Integer.parseInt(callInitValue);
        }
        if (putInitValue.equals("")) {
            putinitvalue = 0;
        }
        else{
            putinitvalue = Integer.parseInt(putInitValue);
        }


        if (stockFutureLow.equals("")) {
            stockfuturelow = 0;
        }
        else{
            stockfuturelow = Integer.parseInt(stockFutureLow);
        }
        if (forwardcFutureLow.equals("")) {
            forwardcfuturelow = 0;
        }
        else{
            forwardcfuturelow = Integer.parseInt(forwardcFutureLow);
        }
        if (callFutureLow.equals("")) {
            callfuturelow = 0;
        }
        else{
            callfuturelow = Integer.parseInt(callFutureLow);
        }
        if (putFutureLow.equals("")) {
            putfuturelow = 0;
        }
        else{
            putfuturelow = Integer.parseInt(putFutureLow);
        }


        if (stockFutureHigh.equals("")) {
            stockfuturehigh = 0;
        }
        else{
            stockfuturehigh = Integer.parseInt(stockFutureHigh);
        }
        if (bondFuture.equals("")) {
            bondfuture = 0;
        }
        else {
            bondfuture = Integer.parseInt(bondFuture);
        }
        if (forwardcFutureHigh.equals("")) {
            forwardcfuturehigh = 0;
        }
        else{
            forwardcfuturehigh = Integer.parseInt(forwardcFutureHigh);
        }
        if (callFutureHigh.equals("")) {
            callfuturehigh = 0;
        }
        else{
            callfuturehigh = Integer.parseInt(callFutureHigh);
        }
        if (putFutureHigh.equals("")) {
            putfuturehigh = 0;
        }
        else{
            putfuturehigh = Integer.parseInt(putFutureHigh);
        }
        if (percentS.equals("")) {
            percent = 0;
        }
        else{
            percent = Integer.parseInt(percentS);
        }
    }

    public void goToStockResults(View view) {
        Intent intent = new Intent(this, Stock_Results.class);
        startActivity(intent);
    }

    private View.OnClickListener CalculateListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            updatecalc();
            goToStockResults(view); //Code that causes the AlertDialog to be displayed
        }
    };

}