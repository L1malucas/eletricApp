package com.informacaotecnologia.eletricistafacil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tpotencia extends AppCompatActivity {
    private Button btn_caclp;
    double correntep;
    /* access modifiers changed from: private */
    public EditText edt_correntep;
    /* access modifiers changed from: private */
    public EditText edt_potenciap;
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
        setContentView((int) R.layout.activity_tpotencia);
        this.btn_caclp = (Button) findViewById(R.id.btn_calcp);
        this.txt_resp1 = (TextView) findViewById(R.id.txt_resp1);
        this.txt_resp0 = (TextView) findViewById(R.id.txt_resp0);
        this.txt_resp2 = (TextView) findViewById(R.id.txt_resp2);
        this.edt_potenciap = (EditText) findViewById(R.id.edt_potenciap);
        this.edt_tensaop = (EditText) findViewById(R.id.edt_tensaop);
        this.edt_correntep = (EditText) findViewById(R.id.edt_correntep);
        this.edt_potenciap.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                tpotencia.this.edt_potenciap.setText("");
                tpotencia.this.txt_resp0.setVisibility(4);
                tpotencia.this.txt_resp1.setVisibility(4);
                tpotencia.this.txt_resp2.setVisibility(4);
                return false;
            }
        });
        this.edt_tensaop.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                tpotencia.this.edt_tensaop.setText("");
                tpotencia.this.txt_resp0.setVisibility(4);
                tpotencia.this.txt_resp1.setVisibility(4);
                tpotencia.this.txt_resp2.setVisibility(4);
                return false;
            }
        });
        this.edt_correntep.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                tpotencia.this.edt_correntep.setText("");
                tpotencia.this.txt_resp0.setVisibility(4);
                tpotencia.this.txt_resp1.setVisibility(4);
                tpotencia.this.txt_resp2.setVisibility(4);
                return false;
            }
        });
        this.btn_caclp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (tpotencia.this.edt_potenciap.getText().toString().trim().equals("") && tpotencia.this.edt_tensaop.getText().toString().trim().equals("") && tpotencia.this.edt_correntep.getText().toString().trim().equals("")) {
                    Toast.makeText(tpotencia.this.getBaseContext(), "Adicione Valores Somente em DUAS Caixas", 1).show();
                } else if (tpotencia.this.edt_potenciap.getText().toString().trim().equals("") && tpotencia.this.edt_tensaop.getText().toString().trim().equals("")) {
                    Toast.makeText(tpotencia.this.getBaseContext(), "Adicione Valores Somente em DUAS Caixas", 1).show();
                } else if (tpotencia.this.edt_potenciap.getText().toString().trim().equals("") && tpotencia.this.edt_correntep.getText().toString().trim().equals("")) {
                    Toast.makeText(tpotencia.this.getBaseContext(), "Adicione Valores Somente em DUAS Caixas", 1).show();
                } else if (tpotencia.this.edt_tensaop.getText().toString().trim().equals("") && tpotencia.this.edt_correntep.getText().toString().trim().equals("")) {
                    Toast.makeText(tpotencia.this.getBaseContext(), "Adicione Valores Somente em DUAS Caixas", 1).show();
                } else if (tpotencia.this.edt_potenciap.getText().toString().trim().equals("")) {
                    tpotencia.this.txt_resp0.setVisibility(0);
                    tpotencia.this.txt_resp1.setVisibility(0);
                    tpotencia.this.txt_resp2.setVisibility(0);
                    Double potencia = potenciap(tpotencia.this.edt_tensaop, tpotencia.this.edt_correntep);
                    tpotencia.this.txt_resp0.setText("A Potência é:");
                    tpotencia.this.txt_resp1.setText(potencia.toString());
                    tpotencia.this.txt_resp2.setText("Watts");
                } else if (tpotencia.this.edt_tensaop.getText().toString().trim().equals("")) {
                    tpotencia.this.txt_resp0.setVisibility(0);
                    tpotencia.this.txt_resp1.setVisibility(0);
                    tpotencia.this.txt_resp2.setVisibility(0);
                    Double tensao = tensaop(tpotencia.this.edt_potenciap, tpotencia.this.edt_correntep);
                    tpotencia.this.txt_resp0.setText("A Tensão é:");
                    tpotencia.this.txt_resp1.setText(tensao.toString());
                    tpotencia.this.txt_resp2.setText("Volts");
                } else if (tpotencia.this.edt_correntep.getText().toString().trim().equals("")) {
                    tpotencia.this.txt_resp0.setVisibility(0);
                    tpotencia.this.txt_resp1.setVisibility(0);
                    tpotencia.this.txt_resp2.setVisibility(0);
                    Double corrente = correntep(tpotencia.this.edt_tensaop, tpotencia.this.edt_potenciap);
                    tpotencia.this.txt_resp0.setText("A Corrente é:");
                    tpotencia.this.txt_resp1.setText(corrente.toString());
                    tpotencia.this.txt_resp2.setText("Ampéres");
                } else {
                    Toast.makeText(tpotencia.this.getBaseContext(), "Adicione Valores em DUAS Caixas", 1).show();
                }
            }

            private Double potenciap(EditText edt_tensaop, EditText edt_correntep) {
                return Double.valueOf(Double.parseDouble(edt_correntep.getText().toString()) * Double.parseDouble(edt_tensaop.getText().toString()));
            }

            private Double tensaop(EditText edt_corrente, EditText edt_potenciap) {
                return Double.valueOf(Double.parseDouble(edt_corrente.getText().toString()) / Double.parseDouble(edt_potenciap.getText().toString()));
            }

            private Double correntep(EditText edt_tensaop, EditText edt_potenciap) {
                return Double.valueOf(Double.parseDouble(edt_potenciap.getText().toString()) / Double.parseDouble(edt_tensaop.getText().toString()));
            }
        });
    }
}
