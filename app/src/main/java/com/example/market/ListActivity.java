package com.example.market;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Recibir los datos enviados desde el formulario
        String productName = getIntent().getStringExtra("productName");
        String productQuantity = getIntent().getStringExtra("productQuantity");
        String productPrice = getIntent().getStringExtra("productPrice");
        String productDescription = getIntent().getStringExtra("productDescription");

        // Asignar los valores recibidos a los TextViews
        TextView nameTextView = findViewById(R.id.productNameTextView);
        TextView quantityTextView = findViewById(R.id.productQuantityTextView);
        TextView priceTextView = findViewById(R.id.productPriceTextView);
        TextView descriptionTextView = findViewById(R.id.productDescriptionTextView);

        nameTextView.setText("Product Name: " + productName);
        quantityTextView.setText("Quantity: " + productQuantity);
        priceTextView.setText("Price: $" + productPrice);
        descriptionTextView.setText("Description: " + productDescription);
    }
}
