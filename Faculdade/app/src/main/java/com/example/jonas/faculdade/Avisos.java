package com.example.jonas.faculdade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Avisos extends AppCompatActivity {
    TextView nometxt, salva, raiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos);
        raiz  = (TextView)findViewById(R.id.raiz);
        nometxt = (EditText)findViewById(R.id.edtNomeArq);
        salva = (EditText)findViewById(R.id.edtSalvar);
        System.out.println(nometxt);
        System.out.println(nometxt.getText());
        System.out.println(nometxt.getText().toString());
        System.out.println(salva);
        System.out.println(salva.getText());
        System.out.println(salva.getText().toString());
        raiz.append(GetRoot());

    }



    public void ClickLimpar(View v){
        nometxt.setText("");
        salva.setText("");
    }

    public void ClicSalvar (View v) {
        nometxt.setText("");
        salva.setText("");
        System.out.println("salvo");
        Salvar();
    }

    private String GetRoot() {
        File root = android.os.Environment.getExternalStorageDirectory();
        return ((File) root).toString();
    }

    private void Salvar(){
        String lerNomeTxt;
        //File arquivo;
        //byte[] dados;
        try{
            //pega o nome do arquivo a ser gravado
            System.out.println("dsddddd"+ nometxt.getText().toString());
            lerNomeTxt = nometxt.getText().toString();
            System.out.println("ddddd"+lerNomeTxt);
            FileWriter fw = new FileWriter("/mnt/sdcard/x/"+lerNomeTxt+".txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(salva.getText().toString());
            System.out.println(lerNomeTxt.toString()+"    "+salva.getText()+"jonas kkk");
            pw.flush();
            pw.close();
            System.out.println("Encerrou");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
