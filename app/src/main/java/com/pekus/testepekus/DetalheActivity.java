package com.pekus.testepekus;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DetalheActivity extends AppCompatActivity
{
    private TextView txtDetalhe;
    private Button btnVoltar;
    private int posicao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        txtDetalhe = findViewById(R.id.detalheTxt);
        btnVoltar = findViewById(R.id.btnVoltar);

            posicao = getIntent().getIntExtra("int", -1);

            posicao += 1;

            txtDetalhe.setText(posicao + "  Item" + posicao);


            btnVoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(DetalheActivity.this, MainActivity.class));
                }
            });



    }
}

