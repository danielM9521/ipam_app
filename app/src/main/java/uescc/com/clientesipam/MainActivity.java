package uescc.com.clientesipam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button btnNuevo;
    ListView listView;

    public static List<Cliente> clientes;
    private AdaptadorClientes adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientes = new ArrayList<Cliente>();

        adaptador = new AdaptadorClientes(this,clientes);

        listView = (ListView) findViewById(R.id.listViewClientes);

        listView.setAdapter(adaptador);

        btnNuevo = (Button) findViewById(R.id.btnCrearNuevo);
        final Intent intent = new Intent(this, CrearClienteActivity.class);



        btnNuevo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(intent);

            }
        });


    }
    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

        listView.setAdapter(adaptador);

    }


    class AdaptadorClientes extends ArrayAdapter<Cliente>
    {
        Activity context;

        public AdaptadorClientes(Activity context, List<Cliente> datos){
            super(context,R.layout.listitem_cliente,datos);

        }

        public View getView(int posicion, View convertView, ViewGroup parent)
        {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_cliente, null);

            TextView lblCodigo = (TextView)item.findViewById(R.id.LblCodigo);
            TextView lblNombre = (TextView)item.findViewById(R.id.LblNombre);
            TextView lblApellidos = (TextView)item.findViewById(R.id.LblApellido);
            TextView lblTipo = (TextView)item.findViewById(R.id.LblTipo);
            TextView lblFormaDePago = (TextView)item.findViewById(R.id.LblFormaDePago);
            TextView lblDui = (TextView)item.findViewById(R.id.LblDUI);

            lblCodigo.setText(clientes.get(posicion).getCodigoCli());
            lblNombre.setText(clientes.get(posicion).getNombreCli());
            lblApellidos.setText(clientes.get(posicion).getApellidoCli());
            lblTipo.setText(clientes.get(posicion).getTipoCli());
            lblFormaDePago.setText(clientes.get(posicion).getPagoCli());
            lblDui.setText(clientes.get(posicion).getDuiCli());

            return (item);
        }



    }
}
