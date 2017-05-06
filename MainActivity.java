package com.example.arqdsis.provabonato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private String array_spinner[];
    public static final String SERVIDOR = "https://restcountries.eu/rest/v2/region/{region}";
    public static final String APLICACAO = "provaBonato";
    public static final String RECURSO = "region";
    public static final String LISTA = "com.example.arqdsis.provabonato";


    /**
     * @param savedInstanceState
     * @Author Rafael  Ra:201518143
     * @method mapeia o id da tela com a variavel s, trazendo o conteudo selecionado no combo box
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        array_spinner = new String[5];
        array_spinner[0] = "Africa";
        array_spinner[1] = "Americas";
        array_spinner[2] = "Asia";
        array_spinner[3] = "Europe";
        array_spinner[4] = "Oceania";
        Spinner s = (Spinner) findViewById(R.id.listaContinentes);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);
    }

    /**
     * @param view
     * @Author Rafael  Ra:201518143
     * @Method quando o usuario clicar no botao da tela o onclick vai chamar esse metodo que vai usar para
     * acessar a url do site passando a regiao selecionada no combobox
     */
    public void buscarRegiao(View view) {
        Intent intent = new Intent(this, ListarRegiao.class);
        Spinner spinner = (Spinner) findViewById(R.id.listaContinentes);
        String text = spinner.getSelectedItem().toString();
        requester = new RegiaoRequeste();
        if (requester.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lista = requester.get(SERVIDOR + APLICACAO + RECURSO, text);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Lista: " + lista);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            intent.putExtra(LISTA, lista);
                            startActivity(intent);
                        }
                    });

                }
            }).start();

        }
    }
}
