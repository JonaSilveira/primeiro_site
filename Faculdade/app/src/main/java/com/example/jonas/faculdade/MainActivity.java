package com.example.jonas.faculdade;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.botaocamera);
        Button aviso = (Button)findViewById(R.id.botaoaviso);
        iv = (ImageView)findViewById(R.id.img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

            }
        });
        aviso.setOnClickListener(this);

    }

    protected void onActivityResult(int resultCode, int requestCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        Bitmap bt = (Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(bt);
    }

    public void onClick(View v){
        Intent it = new Intent(this, AvisoActivity.class);
        startActivity(it);

    }
}
