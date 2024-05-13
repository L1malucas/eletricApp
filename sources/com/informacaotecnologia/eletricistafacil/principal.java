package com.informacaotecnologia.eletricistafacil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class principal extends AppCompatActivity {
    private ImageButton btn_ap;
    private ImageButton btn_qtensao;
    private TextView btn_sobre;
    private ImageButton btn_tpotencia;
    private ImageButton btn_tresistencia;
    private ImageButton btn_tue;
    private ImageButton btn_tug;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_principal);
        this.btn_tresistencia = (ImageButton) findViewById(R.id.btn_tresistencia);
        this.btn_tpotencia = (ImageButton) findViewById(R.id.btn_tpotencia);
        this.btn_tug = (ImageButton) findViewById(R.id.btn_tug);
        this.btn_tue = (ImageButton) findViewById(R.id.btn_tue);
        this.btn_ap = (ImageButton) findViewById(R.id.btn_ap);
        this.btn_sobre = (TextView) findViewById(R.id.btn_sobre);
        this.btn_qtensao = (ImageButton) findViewById(R.id.btn_qtensao);
        this.btn_tug.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                principal.this.startActivity(new Intent(principal.this, tug.class));
            }
        });
        this.btn_tue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                principal.this.startActivity(new Intent(principal.this, tue.class));
            }
        });
        this.btn_ap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                principal.this.startActivity(new Intent(principal.this, materialapoio.class));
            }
        });
        this.btn_sobre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                principal.this.startActivity(new Intent(principal.this, contato.class));
            }
        });
        this.btn_qtensao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                principal.this.startActivity(new Intent(principal.this, quedatensao.class));
            }
        });
        this.btn_tpotencia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                principal.this.startActivity(new Intent(principal.this, tpotencia.class));
            }
        });
        this.btn_tresistencia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                principal.this.startActivity(new Intent(principal.this, tresistencia.class));
            }
        });
    }

    public void openBrowser(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse((String) view.getTag()));
        startActivity(intent);
    }
}
