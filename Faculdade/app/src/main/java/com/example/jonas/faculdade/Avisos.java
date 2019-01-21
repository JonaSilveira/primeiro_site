package com.example.jonas.faculdade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Avisos extends AppCompatActivity {
    TextView nometxt, salva, raiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos);
        raiz  = (TextView)findViewById(R.id.raiz);
        nometxt = (TextView)findViewById(R.id.edtNomeArq);
        salva = (TextView)findViewById(R.id.edtSalvar);

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
        File arquivo;
        byte[] dadod;
        try{
            //pega o nome do arquivo a ser gravado
            lerNomeTxt = nometxt.getText().toString();
            arquivo = new File(Environment.getExternalStorageDirectory(), lerNomeTxt);
            FileOutputStream out;
            out = new FileOutputStream(arquivo);
            out.write(salva.getText().toString().getBytes());
            out.flush();
            out.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
