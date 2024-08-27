package com.upb.myrestaurant;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class PromocionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones);

        // Configuración del botón Bono de primera compra
        Button botonPrimeraCompra = findViewById(R.id.botonPrimeraCompra);
        botonPrimeraCompra.setOnClickListener(v -> {
            String discountCode = generarCodigoRandom();
            showMessage("Obtuviste un 10% de descuento por tu primera compra, envía este código \"" + discountCode + "\" al momento de realizar el pedido");
        });

        EditText etDiscountCode = findViewById(R.id.textoCodigo);
        Button btnApplyDiscount = findViewById(R.id.botonAplicar);
        btnApplyDiscount.setOnClickListener(v -> {
            int porcentaje = generarDescuentoRandom();
            showMessage("Obtuviste un " + porcentaje + "% de descuento para tu próxima compra");
        });
    }
        // Método para generar un código de descuento aleatorio
        private String generarCodigoRandom() {
            int length = 8;
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random = new Random();
            StringBuilder code = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                code.append(chars.charAt(random.nextInt(chars.length())));
            }
            return code.toString();
        }

    private int generarDescuentoRandom() {
        return new Random().nextInt(11) + 10; // Genera un porcentaje entre 10% y 20%
    }

    // Método para mostrar un mensaje
    private void showMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("OK", (dialog, id) -> dialog.dismiss())
                .create()
                .show();
    }
}