package com.peekily.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));
    }


    public void increment(View view){
        quantity = quantity +1;
        displayQuantity(quantity);

    }
    public void decrement(View view){
        quantity = quantity -1;
        displayQuantity(quantity);

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int num) {
        TextView quantityTextView = (TextView)  findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + num);
    }
    /**
     * This method displays the given quantity value on the screen
     */


    private int calculatePrice(){
        return quantity*5;
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView =(TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private String createOrderSummary(int priceOfOrder){
        return "Name: Kaptain Kunal\n" +
                "Quantity: " + quantity +"\n" +
                "Total: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(priceOfOrder) +"\n" +
                "Thank you!";
    }



}