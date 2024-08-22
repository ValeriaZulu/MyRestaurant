package com.upb.myrestaurant;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void abrirMenu(View v){

        Intent i;
        i = new Intent(this,MenuActivity.class);
        startActivity(i);
    }

    public void abrirPedido(View v){

        String mensaje = "Hola, quisiera realizar un pedido."; // Mensaje preescrito

        String numero = "+573023655202";
        String url = "https://api.whatsapp.com/send?phone="+ numero + "&text=" + Uri.encode(mensaje);

        String whatsApp = "com.whatsapp";
        PackageManager pm = getPackageManager();
        Intent i = pm.getLaunchIntentForPackage(whatsApp);
        //codigo para abrir chat en un numero especifico
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void abrirReserva(View v){

       String mensaje = "Hola, quisiera hacer una reserva."; // Mensaje preescrito

       String numero = "+573023655202";
       String url = "https://api.whatsapp.com/send?phone="+ numero + "&text=" + Uri.encode(mensaje);

       String whatsApp = "com.whatsapp";
       PackageManager pm = getPackageManager();
       Intent i = pm.getLaunchIntentForPackage(whatsApp);
       //codigo para abrir chat en un numero especifico
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }

    public void abrirSedes(View v){

        Intent i;
        i = new Intent(this,MapsActivity.class);
        startActivity(i);
    }

}