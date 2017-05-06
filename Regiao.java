package com.example.arqdsis.provabonato;

import java.util.ArrayList;

/**
 * @Author Rafael  Ra:201518143
 * Classee para mapear os dados retornados do Json
 * Created by arqdsis on 05/05/2017.
 */
public class Regiao {

    public String acronym;
    public String nome;
    public ArrayList<String> otherAcronyms;
    public ArrayList<String> otherNames;

    public Regiao(String acronym, String nome,  ArrayList<String> otherAcronyms,  ArrayList<String> otherNames){
     this.acronym = acronym;
        this.nome = nome;
        this.otherAcronyms = otherAcronyms;
        this.otherNames = otherNames;
 }
}
