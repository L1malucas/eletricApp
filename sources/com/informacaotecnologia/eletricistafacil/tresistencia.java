package com.informacaotecnologia.eletricistafacil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tresistencia extends AppCompatActivity {
    private Button btn_caclp;
    double correntep;
    /* access modifiers changed from: private */
    public EditText edt_correntep;
    /* access modifiers changed from: private */
    public EditText edt_resistenciap;
    /* access modifiers changed from: private */
    public EditText edt_tensaop;
    double potenciap;
    double tensaop;
    /* access modifiers changed from: private */
    public TextView txt_resp0;
    /* access modifiers changed from: private */
    public TextView txt_resp1;
    /* access modifiers changed from: private */
    public TextView txt_resp2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_tresistencia);
        this.btn_caclp = (Button) findViewById(R.id.btn_calcp);
        this.txt_resp1 = (TextView) findViewById(R.id.txt_resp1);
        this.txt_resp0 = (TextView) findViewById(R.id.txt_resp0);
        this.txt_resp2 = (TextView) findViewById(R.id.txt_resp2);
        this.edt_resistenciap = (EditText) findViewById(R.id.edt_resistenciap);
        this.edt_tensaop = (EditText) findViewById(R.id.edt_tensaop);
        this.edt_correntep = (EditText) findViewById(R.id.edt_correntep);
        this.edt_resistenciap.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                tresistencia.this.edt_resistenciap.setText("");
                tresistencia.this.txt_resp0.setVisibility(4);
                tresistencia.this.txt_resp1.setVisibility(4);
                tresistencia.this.txt_resp2.setVisibility(4);
                return false;
            }
        });
        this.edt_tensaop.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                tresistencia.this.edt_tensaop.setText("");
                tresistencia.this.txt_resp0.setVisibility(4);
                tresistencia.this.txt_resp1.setVisibility(4);
                tresistencia.this.txt_resp2.setVisibility(4);
                return false;
            }
        });
        this.edt_correntep.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                tresistencia.this.edt_correntep.setText("");
                tresistencia.this.txt_resp0.setVisibility(4);
                tresistencia.this.txt_resp1.setVisibility(4);
                tresistencia.this.txt_resp2.setVisibility(4);
                return false;
            }
        });
        this.btn_caclp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tresistencia.this.edt_resistenciap.getText().toString().trim().equals("") && tresistencia.this.edt_tensaop.getText().toString().trim().equals("") && tresistencia.this.edt_correntep.getText().toString().trim().equals("")) {
                    Toast.makeText(tresistencia.this.getBaseContext(), "Adicione Valores Somente em DUAS Caixas", 1).show();
                } else if (tresistencia.this.edt_resistenciap.getText().toString().trim().equals("") && tresistencia.this.edt_tensaop.getText().toString().trim().equals("")) {
                    Toast.makeText(tresistencia.this.getBaseContext(), "Adicione Valores Somente em DUAS Caixas", 1).show();
                } else if (tresistencia.this.edt_resistenciap.getText().toString().trim().equals("") && tresistencia.this.edt_correntep.getText().toString().trim().equals("")) {
                    Toast.makeText(tresistencia.this.getBaseContext(), "Adicione Valores Somente em DUAS Caixas", 1).show();
                } else if (tresistencia.this.edt_tensaop.getText().toString().trim().equals("") && tresistencia.this.edt_correntep.getText().toString().trim().equals("")) {
                    Toast.makeText(tresistencia.this.getBaseContext(), "Adicione Valores Somente em DUAS Caixas", 1).show();
                } else if (tresistencia.this.edt_resistenciap.getText().toString().trim().equals("")) {
                    tresistencia.this.txt_resp0.setVisibility(0);
                    tresistencia.this.txt_resp1.setVisibility(0);
                    tresistencia.this.txt_resp2.setVisibility(0);
                    Double resistencia = resistenciap(tresistencia.this.edt_tensaop, tresistencia.this.edt_correntep);
                    tresistencia.this.txt_resp0.setText("A Resistencia é:");
                    tresistencia.this.txt_resp1.setText(resistencia.toString());
                    tresistencia.this.txt_resp2.setText("OHMs");
                } else if (tresistencia.this.edt_tensaop.getText().toString().trim().equals("")) {
                    tresistencia.this.txt_resp0.setVisibility(0);
                    tresistencia.this.txt_resp1.setVisibility(0);
                    tresistencia.this.txt_resp2.setVisibility(0);
                    Double tensao = tensaop(tresistencia.this.edt_resistenciap, tresistencia.this.edt_correntep);
                    tresistencia.this.txt_resp0.setText("A Tensão é:");
                    tresistencia.this.txt_resp1.setText(tensao.toString());
                    tresistencia.this.txt_resp2.setText("Volts");
                } else if (tresistencia.this.edt_correntep.getText().toString().trim().equals("")) {
                    tresistencia.this.txt_resp0.setVisibility(0);
                    tresistencia.this.txt_resp1.setVisibility(0);
                    tresistencia.this.txt_resp2.setVisibility(0);
                    Double corrente = correntep(tresistencia.this.edt_tensaop, tresistencia.this.edt_resistenciap);
                    tresistencia.this.txt_resp0.setText("A Corrente é:");
                    tresistencia.this.txt_resp1.setText(corrente.toString());
                    tresistencia.this.txt_resp2.setText("Ampéres");
                } else {
                    Toast.makeText(tresistencia.this.getBaseContext(), "Adicione Valores em DUAS Caixas", 1).show();
                }
            }

            private Double resistenciap(EditText edt_tensaop, EditText edt_correntep) {
                return Double.valueOf(Double.parseDouble(edt_tensaop.getText().toString()) / Double.parseDouble(edt_correntep.getText().toString()));
            }

            private Double tensaop(EditText edt_corrente, EditText edt_resistenciap) {
                return Double.valueOf(Double.parseDouble(edt_corrente.getText().toString()) * Double.parseDouble(edt_resistenciap.getText().toString()));
            }

            private Double correntep(EditText edt_tensaop, EditText edt_resistenciap) {
                return Double.valueOf(Double.parseDouble(edt_tensaop.getText().toString()) / Double.parseDouble(edt_resistenciap.getText().toString()));
            }
        });
    }
}
