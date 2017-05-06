package com.example.arqdsis.provabonato;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListarRegiao extends AppCompatActivity {
    Activity atividade;
    ArrayList<String> lista;

    /**
     * @Author Rafael Ra:201518143
     * @param savedInstanceState
     * @Method Pega a intent que a mainActivity mandou em um array que será mandando para a tela, exibindo no listView;
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_regiao);
        atividade = this;
        Intent intent = getIntent();
        String lista = intent.getStringExtra(MainActivity.LISTA);
        ArrayAdapter<Regiao> adapter = new ArrayAdapter<Regiao>(this, android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }

    /**
     * @Author Rafael Ra:201518143
     * @param view
     * @Method quando um usuário clicar em uma das linhas do listView, será chamado esse metódo
     * pegando a linha selecionada para acessar o serviço REST para acessar a informação do país
     */
    public void buscarPais(View view){
        Intent intent = new Intent(this, pais.class);


    }

}
