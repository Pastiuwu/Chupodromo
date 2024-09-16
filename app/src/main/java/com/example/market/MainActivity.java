package com.example.market;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Variables para los campos del formulario
    private EditText productNameEditText;
    private EditText priceEditText;
    private EditText quantityEditText;
    private EditText descriptionEditText;
    private Button createProductButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Configuramos el layout principal

        // Configuración de EdgeToEdge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar los elementos de la vista
        productNameEditText = findViewById(R.id.productNameEditText);
        priceEditText = findViewById(R.id.priceEditText);
        quantityEditText = findViewById(R.id.quantityEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        createProductButton = findViewById(R.id.createProductButton);

        // Configurar el evento del botón para enviar los datos a la lista
        createProductButton.setOnClickListener(v -> {
            // Obtener los valores del formulario
            String productName = productNameEditText.getText().toString();
            String productPrice = priceEditText.getText().toString();
            String productQuantity = quantityEditText.getText().toString();
            String productDescription = descriptionEditText.getText().toString();

            // Validar que los campos no estén vacíos
            if (productName.isEmpty() || productPrice.isEmpty() || productQuantity.isEmpty() || productDescription.isEmpty()) {
                Toast.makeText(MainActivity.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Crear un intent para pasar a la actividad de lista
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productQuantity", productQuantity);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });
    }
}
