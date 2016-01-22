package com.peekily.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

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
        CheckBox whippedCheckBox = (CheckBox) findViewById(R.id.checkbox_whipped_cream);
        boolean isWhipped = whippedCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.checkbox_chocolate);
        boolean isChocolate = chocolateCheckBox.isChecked();
        int price = calculatePrice();
        displayMessage(createOrderSummary(price, isWhipped, isChocolate));
    }


    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + num);
    }

    /**
     * This method displays the given quantity value on the screen
     */


    private int calculatePrice() {
        return quantity * 5;
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private String createOrderSummary(int priceOfOrder, boolean addWhipped, boolean addChocolate) {
        return "Name: Kaptain Kosti" +
                "\nAdd Whipped Cream? " + addWhipped +
                "\nAdd Chocolate? " + addChocolate +
                "\nQuantity: " + quantity +
                "\nTotal: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(priceOfOrder) +
                "\nThank you!";
    }

    public void chocolateCheck(View view) {
        CheckBox chocolateCheckBox = (CheckBox) view;

        Log.v("MainActivity", "We are in chocolateCheck and the checkBox value is: " + chocolateCheckBox.isChecked());
        if (chocolateCheckBox.isChecked()) {
            Log.v("MainActivity", "test");
            Toast.makeText(this, "you glutton, you added chocolate", Toast.LENGTH_LONG);
        }

    }

    public void creamCheck(View view) {
        CheckBox creamCheckBox = (CheckBox) view;
        if (creamCheckBox.isChecked()) {
            Toast.makeText(this, "added cream!:D", Toast.LENGTH_LONG);
        }

    }


}