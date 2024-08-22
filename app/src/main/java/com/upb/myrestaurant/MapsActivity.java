package com.upb.myrestaurant;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.upb.myrestaurant.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Marker;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.hamburguesaaa);

        // Add a marker in Sydney and move the camera
        LatLng obelisco = new LatLng(-34.60376, -58.38162);
        LatLng bombonera = new LatLng(-34.63565, -58.36465);
        LatLng caballito = new LatLng(-34.616666, -58.45);
        LatLng puertoMadero = new LatLng(-34.611944, -58.36472);
        LatLng palermo = new LatLng(-34.588888, -58.430555);


        mMap.addMarker(new MarkerOptions().position(obelisco).title("Londra Obelisco").snippet("Av. 9 de Julio s/n, C1043").icon(icon));
        mMap.addMarker(new MarkerOptions().position(bombonera).title("Londra Bombonera").snippet("Brandsen 805, C1161").icon(icon));
        mMap.addMarker(new MarkerOptions().position(caballito).title("Londra Caballito").snippet("Av. Díaz Vélez 4859, C1405DCD").icon(icon));
        mMap.addMarker(new MarkerOptions().position(puertoMadero).title("Londra Madero").snippet("GORRITI JUANA MANUELA 900, C1107").icon(icon));
        mMap.addMarker(new MarkerOptions().position(palermo).title("Londra Palermo").snippet("French, C1425 ").icon(icon));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(obelisco,10));

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // Display the marker's title and snippet in a Toast
                Toast.makeText(getApplicationContext(), marker.getTitle() + ": " + marker.getSnippet(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}