package com.upb.myrestaurant;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class PlatoFuerteActivity extends ListActivity {

    public class Producto {
        private String nombreProducto;
        private String ingredientesProducto;
        private String precioProducto;
        private Integer imagenProducto;
    }

    private PlatoFuerteActivity.MyAdapter adaptador = null;
    private static ArrayList<PlatoFuerteActivity.Producto> arregloProductos = new ArrayList<PlatoFuerteActivity.Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
        adaptador = new PlatoFuerteActivity.MyAdapter(this);
        setListAdapter(adaptador);


        //EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_producto);
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //return insets;
        //});
    }

    private void setData(){
        arregloProductos.clear();


        //Plato Fuerte 1
        PlatoFuerteActivity.Producto platoActual1 = new PlatoFuerteActivity.Producto();
        platoActual1.nombreProducto = this.getResources().getString(R.string.platoFuerte1);
        platoActual1.ingredientesProducto = this.getResources().getString(R.string.ing_fuerte1);
        platoActual1.precioProducto = this.getResources().getString(R.string.prec_fuerte1);
        platoActual1.imagenProducto = R.drawable.hambternera;
        arregloProductos.add(platoActual1);

        //Plato Fuerte 2
        PlatoFuerteActivity.Producto platoActual2 = new PlatoFuerteActivity.Producto();
        platoActual2.nombreProducto = this.getResources().getString(R.string.platoFuerte2);
        platoActual2.ingredientesProducto = this.getResources().getString(R.string.ing_fuerte2);
        platoActual2.precioProducto = this.getResources().getString(R.string.prec_fuerte2);
        platoActual2.imagenProducto = R.drawable.hammilanesa;
        arregloProductos.add(platoActual2);


        //Plato Fuerte 3
        PlatoFuerteActivity.Producto platoActual3 = new PlatoFuerteActivity.Producto();
        platoActual3.nombreProducto = this.getResources().getString(R.string.platoFuerte3);
        platoActual3.ingredientesProducto = this.getResources().getString(R.string.ing_fuerte3);
        platoActual3.precioProducto = this.getResources().getString(R.string.prec_fuerte3);
        platoActual3.imagenProducto = R.drawable.hamchorizo;
        arregloProductos.add(platoActual3);


    }

    public static class MyAdapter extends BaseAdapter {

        private Context myContexto;

        public MyAdapter (Context c){
            myContexto = c;
        }

        @Override
        public int getCount(){
            return arregloProductos.size();
        }

        @Override
        public Object getItem(int arg){
            return arregloProductos.get(arg);
        }

        @Override
        public long getItemId(int arg){
            return 0;
        }

        @Override
        public View getView(int position, View vista, ViewGroup arg2){

            View view = null;

            if (vista == null){
                LayoutInflater inflater = (LayoutInflater) myContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_producto, null);
            }
            else {
                view = vista;
            }

            ImageView imgProducto = (ImageView) view.findViewById(R.id.imageViewProducto);
            imgProducto.setImageDrawable(myContexto.getResources().getDrawable(arregloProductos.get(position).imagenProducto));

            TextView nombrePorducto = (TextView) view.findViewById(R.id.textViewNombreProducto);
            nombrePorducto.setText(arregloProductos.get(position).nombreProducto);

            TextView ingredientesPorducto = (TextView) view.findViewById(R.id.textViewIngredientes);
            ingredientesPorducto.setText(arregloProductos.get(position).ingredientesProducto);

            TextView precioPorducto = (TextView) view.findViewById(R.id.textViewPrecio);
            precioPorducto.setText(arregloProductos.get(position).precioProducto);


            return view;
        }

    }



}