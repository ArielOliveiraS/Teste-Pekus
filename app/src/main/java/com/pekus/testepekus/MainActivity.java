package com.pekus.testepekus;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ComunicaGeral
{
    public EditText editTextContador;
    public RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextContador = findViewById(R.id.txtNum);
    }

    public void criarLista(View view) {

        if (!editTextContador.getText().toString().isEmpty()) {

            int number = Integer.parseInt(editTextContador.getText().toString());

            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new RecyclerViewAdapter(number, this, this);
            recyclerView.setAdapter(adapter);
        }
    }

    public void onReceiveData(Class classe, int iId, boolean bResultado, Object... oObjetos) {
        if (classe == RecyclerViewAdapter.class){
            int posicao;
            posicao = (int) oObjetos[0];
           // Toast.makeText(this, "posição obtida" + posicao, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, DetalheActivity.class);
            intent.putExtra("int", posicao);
            startActivity(intent);

        }
    }

    @Override
    public void comunicaGeral(Class classe, int iId, boolean bResultado, Object... oObjetos)
    {
        onReceiveData(classe, iId, bResultado, oObjetos);
    }
}