package uescc.com.clientesipam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button btnNuevo;
    // Variable estatica, se puede acceder a ella desde otra activity escribiendo el nombre de la actividad
    // en este caso MainActivity.clientes es usada en el metodo crearCliente de CrearClienteActivity

    public static List<Cliente> clientes ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientes = new ArrayList<>();
        btnNuevo = (Button) findViewById(R.id.btnCrearNuevo);
        final Intent intent = new Intent(this, CrearClienteActivity.class);


        btnNuevo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(intent);
            }
        });

    }
}
