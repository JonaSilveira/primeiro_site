package com.example.jonas.faculdade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class AvisoActivity extends AppCompatActivity {

    TextView raiz, salva, escreve, nometxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_aviso);
            raiz = (TextView)findViewById(R.id.raiz);
            nometxt = (TextView)findViewById(R.id.edtNomeArq);
            salva = (TextView)findViewById(R.id.edtSalvar);

            raiz.append(GetRoot());

        }
        catch(Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }

    }

    private String GetRoot() {
        File root = android.os.Environment.getExternalStorageDirectory();
        return ((File) root).toString();
    }
}
