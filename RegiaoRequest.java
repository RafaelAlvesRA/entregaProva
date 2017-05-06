package com.example.arqdsis.provabonato;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author Rafael  Ra:201518143
 * @Method esse metodo acessa o servidor onde está os dados da região e retorna todos os dados populando o a regiao e
 * adicionando no array
 * Created by arqdsis on 05/05/2017.
 */
public class RegiaoRequest {

        OkHttpClient regiao = new OkHttpClient();

        public ArrayList<RegiaoRequest> get (String url, String chave) throws IOException {
            ArrayList<Regiao> lista = new ArrayList<>();

            if(chave != null && chave.length() > 0){
                url += "?chave="+chave;
            }
            System.out.println("URL: "+url);
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();

            String jsonString = response.body().string();
            System.out.println("JSON: "+jsonString);
            ArrayList<String> otherNames = null;
            ArrayList<String> otherAcronyms = null;
            try {
                JSONArray root = new JSONArray(jsonString);
                JSONObject item = null;
                for(int i = 0; i < root.length(); i++){
                    item = (JSONObject)root.get(i);
                    String acronym = item.getString("acronym");
                    String name = item.getString("name");
                    otherAcronyms.add(item.getString("otherAcronyms"));
                    otherAcronyms.add(item.getString("otherNames"));
                    Regiao regiao = new Regiao(acronym, name, otherAcronyms, otherNames);
                    lista.add(regiao);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return lista;
        }
}
