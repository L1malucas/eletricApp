package com.informacaotecnologia.eletricistafacil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class tug extends AppCompatActivity {
    double aream;
    private Button btn_calcdim;
    double calculoarea;
    /* access modifiers changed from: private */
    public EditText edt_areadim;
    Spinner sArea;
    Spinner sTensao;
    /* access modifiers changed from: private */
    public TextView txt_Tdisjtomad;
    /* access modifiers changed from: private */
    public TextView txt_Tilumdisj;
    /* access modifiers changed from: private */
    public TextView txt_disjtomad;
    /* access modifiers changed from: private */
    public TextView txt_fiotomad;
    /* access modifiers changed from: private */
    public TextView txt_ilumdisj;
    /* access modifiers changed from: private */
    public TextView txt_iluminfio;
    /* access modifiers changed from: private */
    public TextView txt_iluminlumes;
    /* access modifiers changed from: private */
    public TextView txt_iluminwatts;
    /* access modifiers changed from: private */
    public TextView txt_respper;
    /* access modifiers changed from: private */
    public TextView txt_tomada;
    /* access modifiers changed from: private */
    public TextView txt_wtomada;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_tug);
        Bundle extras = getIntent().getExtras();
        this.btn_calcdim = (Button) findViewById(R.id.btn_caldim);
        this.txt_respper = (TextView) findViewById(R.id.txt_respper);
        this.txt_iluminwatts = (TextView) findViewById(R.id.txt_iluminwatts);
        this.txt_iluminlumes = (TextView) findViewById(R.id.txt_iluminlumes);
        this.edt_areadim = (EditText) findViewById(R.id.edt_areadim);
        this.txt_tomada = (TextView) findViewById(R.id.txt_tomada);
        this.txt_wtomada = (TextView) findViewById(R.id.txt_wtomada);
        this.txt_iluminfio = (TextView) findViewById(R.id.txt_iluminfio);
        this.txt_ilumdisj = (TextView) findViewById(R.id.txt_ilumdisj);
        this.txt_fiotomad = (TextView) findViewById(R.id.txt_fiotomad);
        this.txt_disjtomad = (TextView) findViewById(R.id.txt_disjtomad);
        this.txt_Tilumdisj = (TextView) findViewById(R.id.txt_Tilumdisj);
        this.txt_Tdisjtomad = (TextView) findViewById(R.id.txt_Tdisjtomad);
        this.sArea = (Spinner) findViewById(R.id.spinarea1);
        this.sArea.setAdapter(ArrayAdapter.createFromResource(this, R.array.Sarea, 17367048));
        this.sTensao = (Spinner) findViewById(R.id.spintensao);
        this.sTensao.setAdapter(ArrayAdapter.createFromResource(this, R.array.Stensao, 17367048));
        this.edt_areadim.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                tug.this.edt_areadim.setText("");
                tug.this.txt_respper.setVisibility(4);
                tug.this.txt_iluminwatts.setVisibility(4);
                tug.this.txt_iluminlumes.setVisibility(4);
                tug.this.txt_iluminfio.setVisibility(4);
                tug.this.txt_ilumdisj.setVisibility(4);
                tug.this.txt_tomada.setVisibility(4);
                tug.this.txt_wtomada.setVisibility(4);
                tug.this.txt_fiotomad.setVisibility(4);
                tug.this.txt_disjtomad.setVisibility(4);
                tug.this.txt_Tilumdisj.setVisibility(4);
                tug.this.txt_Tdisjtomad.setVisibility(4);
                return false;
            }
        });
        this.btn_calcdim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String obj = tug.this.sTensao.getSelectedItem().toString();
                String obj2 = tug.this.sArea.getSelectedItem().toString();
                if (tug.this.sArea.getSelectedItem().toString().trim().equals("Local") || tug.this.sTensao.getSelectedItem().toString().trim().equals("Tensão")) {
                    Toast.makeText(tug.this.getBaseContext(), "Seletcione os campos Local e Tensão", 1).show();
                } else if (tug.this.edt_areadim.getText().toString().trim().equals("")) {
                    Toast.makeText(tug.this.getBaseContext(), "Preencha o campo Área", 1).show();
                    tug.this.txt_respper.setText("");
                    tug.this.txt_respper.setVisibility(4);
                    tug.this.txt_iluminwatts.setText("");
                    tug.this.txt_iluminwatts.setVisibility(4);
                    tug.this.txt_iluminlumes.setText("");
                    tug.this.txt_iluminlumes.setVisibility(4);
                    tug.this.txt_iluminfio.setText("");
                    tug.this.txt_iluminfio.setVisibility(4);
                    tug.this.txt_ilumdisj.setText("");
                    tug.this.txt_ilumdisj.setVisibility(4);
                    tug.this.txt_tomada.setText("");
                    tug.this.txt_tomada.setVisibility(4);
                    tug.this.txt_wtomada.setText("");
                    tug.this.txt_wtomada.setVisibility(4);
                    tug.this.txt_fiotomad.setText("");
                    tug.this.txt_fiotomad.setVisibility(4);
                    tug.this.txt_disjtomad.setText("");
                    tug.this.txt_disjtomad.setVisibility(4);
                    tug.this.txt_Tilumdisj.setVisibility(4);
                    tug.this.txt_Tilumdisj.setText("");
                    tug.this.txt_Tdisjtomad.setVisibility(4);
                    tug.this.txt_Tdisjtomad.setText("");
                } else {
                    ((InputMethodManager) tug.this.getSystemService("input_method")).hideSoftInputFromWindow(tug.this.edt_areadim.getWindowToken(), 0);
                    tug.this.txt_respper.setVisibility(4);
                    tug.this.txt_iluminwatts.setVisibility(0);
                    tug.this.txt_iluminlumes.setVisibility(0);
                    tug.this.txt_iluminfio.setVisibility(0);
                    tug.this.txt_ilumdisj.setVisibility(0);
                    tug.this.txt_tomada.setVisibility(0);
                    tug.this.txt_wtomada.setVisibility(0);
                    tug.this.txt_fiotomad.setVisibility(0);
                    tug.this.txt_disjtomad.setVisibility(0);
                    tug.this.txt_Tilumdisj.setVisibility(0);
                    tug.this.txt_Tdisjtomad.setVisibility(0);
                    tug.this.aream = Double.parseDouble(tug.this.edt_areadim.getText().toString());
                    tug.this.txt_respper.setText(tug.this.calculoperimetro(tug.this.aream).toString());
                    tug.this.txt_iluminwatts.setText(String.valueOf(tug.this.iluminacaow(tug.this.aream)));
                    tug.this.txt_iluminlumes.setText(Double.valueOf(tug.this.iluminacaol((int) Double.parseDouble(tug.this.txt_iluminwatts.getText().toString()))).toString());
                    if (tug.this.sTensao.getSelectedItem().toString().trim().equals("220V")) {
                        tug.this.txt_iluminfio.setText(Double.valueOf(tug.this.iluminacaofio(tug.this.aream)).toString());
                        tug.this.txt_ilumdisj.setText(Double.valueOf(tug.this.iluminacaodisj(tug.this.aream)).toString());
                    } else {
                        tug.this.txt_iluminfio.setText(Double.valueOf(tug.this.iluminacao_fio(tug.this.aream)).toString());
                        tug.this.txt_ilumdisj.setText(Double.valueOf(tug.this.iluminacao_disj(tug.this.aream)).toString());
                    }
                    if (tug.this.sArea.getSelectedItem().toString().trim().equals("Copa e Cozinha") || tug.this.sArea.getSelectedItem().toString().trim().equals("Cozinha-Bancada") || tug.this.sArea.getSelectedItem().toString().trim().equals("Área de Serviço e Lavanderia")) {
                        if (tug.this.sTensao.getSelectedItem().toString().trim().equals("220V")) {
                            tug.this.txt_tomada.setText(Double.valueOf(tug.this.casatomada(tug.this.aream)).toString());
                            tug.this.txt_wtomada.setText(Double.valueOf(tug.this.casawtomada(tug.this.aream)).toString());
                            tug.this.txt_fiotomad.setText(Double.valueOf(tug.this.casaftomada(tug.this.aream)).toString());
                            tug.this.txt_disjtomad.setText(Double.valueOf(tug.this.casadisjtomada(tug.this.aream)).toString());
                            tug.this.txt_Tilumdisj.setText("Bipolar");
                            tug.this.txt_Tdisjtomad.setText("Bipolar");
                            return;
                        }
                        tug.this.txt_tomada.setText(Double.valueOf(tug.this.casatomada(tug.this.aream)).toString());
                        tug.this.txt_wtomada.setText(Double.valueOf(tug.this.casawtomada(tug.this.aream)).toString());
                        tug.this.txt_fiotomad.setText(Double.valueOf(tug.this.casafftomada(tug.this.aream)).toString());
                        tug.this.txt_disjtomad.setText(Double.valueOf(tug.this.casadisjjtomada(tug.this.aream)).toString());
                        tug.this.txt_Tilumdisj.setText("Unipolar");
                        tug.this.txt_Tdisjtomad.setText("Unipolar");
                    } else if (tug.this.sArea.getSelectedItem().toString().trim().equals("Banheiro") || tug.this.sArea.getSelectedItem().toString().trim().equals("Subsolo, Garagem e Varanda") || tug.this.sArea.getSelectedItem().toString().trim().equals("Área de Serviço e Lavanderia")) {
                        if (tug.this.sTensao.getSelectedItem().toString().trim().equals("220V")) {
                            tug.this.txt_tomada.setText(Double.valueOf(tug.this.casatomad()).toString());
                            tug.this.txt_wtomada.setText(Double.valueOf(tug.this.casawtomada()).toString());
                            tug.this.txt_fiotomad.setText(Double.valueOf(tug.this.casaatomada()).toString());
                            tug.this.txt_disjtomad.setText(Double.valueOf(tug.this.casaaatomada()).toString());
                            tug.this.txt_Tilumdisj.setText("Bipolar");
                            tug.this.txt_Tdisjtomad.setText("Bipolar");
                            return;
                        }
                        tug.this.txt_tomada.setText(Double.valueOf(tug.this.casatomad()).toString());
                        tug.this.txt_wtomada.setText(Double.valueOf(tug.this.casawtomada()).toString());
                        tug.this.txt_fiotomad.setText(Double.valueOf(tug.this.casaatomada()).toString());
                        tug.this.txt_disjtomad.setText(Double.valueOf(tug.this.casaaaatomada()).toString());
                        tug.this.txt_Tilumdisj.setText("Unipolar");
                        tug.this.txt_Tdisjtomad.setText("Unipolar");
                    } else if (tug.this.sArea.getSelectedItem().toString().trim().equals("Sala, Quartos e Demais Dependencias") || tug.this.sArea.getSelectedItem().toString().trim().equals("Sala Comercial")) {
                        if (tug.this.sTensao.getSelectedItem().toString().trim().equals("220V")) {
                            tug.this.txt_tomada.setText(Double.valueOf(tug.this.casa_tomada(tug.this.aream)).toString());
                            tug.this.txt_wtomada.setText(Double.valueOf(tug.this.casa_wtomada(tug.this.aream)).toString());
                            tug.this.txt_fiotomad.setText(Double.valueOf(tug.this.casaffftomada(tug.this.aream)).toString());
                            tug.this.txt_disjtomad.setText(Double.valueOf(tug.this.casadisjjjtomada(tug.this.aream)).toString());
                            tug.this.txt_Tilumdisj.setText("Bipolar");
                            tug.this.txt_Tdisjtomad.setText("Bipolar");
                            return;
                        }
                        tug.this.txt_tomada.setText(Double.valueOf(tug.this.casa_tomada(tug.this.aream)).toString());
                        tug.this.txt_wtomada.setText(Double.valueOf(tug.this.casa_wtomada(tug.this.aream)).toString());
                        tug.this.txt_fiotomad.setText(Double.valueOf(tug.this.casafffftomada(tug.this.aream)).toString());
                        tug.this.txt_disjtomad.setText(Double.valueOf(tug.this.casadisjjjjtomada(tug.this.aream)).toString());
                        tug.this.txt_Tilumdisj.setText("Unipolar");
                        tug.this.txt_Tdisjtomad.setText("Unipolar");
                    } else if (tug.this.sTensao.getSelectedItem().toString().trim().equals("220V")) {
                        tug.this.txt_tomada.setText(Double.valueOf(tug.this.loja(tug.this.aream)).toString());
                        tug.this.txt_wtomada.setText(Double.valueOf(tug.this.loja_wtomada(tug.this.aream)).toString());
                        tug.this.txt_fiotomad.setText(Double.valueOf(tug.this.lojafio(tug.this.aream)).toString());
                        tug.this.txt_disjtomad.setText(Double.valueOf(tug.this.lojadisj(tug.this.aream)).toString());
                        tug.this.txt_Tilumdisj.setText("Bipolar");
                        tug.this.txt_Tdisjtomad.setText("Bipolar");
                    } else {
                        tug.this.txt_tomada.setText(Double.valueOf(tug.this.loja(tug.this.aream)).toString());
                        tug.this.txt_wtomada.setText(Double.valueOf(tug.this.loja_wtomada(tug.this.aream)).toString());
                        tug.this.txt_fiotomad.setText(Double.valueOf(tug.this.loja_fio(tug.this.aream)).toString());
                        tug.this.txt_disjtomad.setText(Double.valueOf(tug.this.loja_disj(tug.this.aream)).toString());
                        tug.this.txt_Tilumdisj.setText("Unipolar");
                        tug.this.txt_Tdisjtomad.setText("Unipolar");
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public double iluminacaow(double aream2) {
        if (aream2 <= 6.0d) {
            return 100.0d;
        }
        return (double) ((((int) Math.abs((aream2 - 6.0d) / 4.0d)) * 60) + 100);
    }

    /* access modifiers changed from: private */
    public double iluminacaol(int iluminacaow) {
        return (double) (iluminacaow * 15);
    }

    /* access modifiers changed from: private */
    public double iluminacaofio(double aream2) {
        double iluminacaofio;
        if (aream2 <= 6.0d) {
            iluminacaofio = 100.0d;
        } else {
            iluminacaofio = (double) ((((int) Math.abs((aream2 - 6.0d) / 4.0d)) * 60) + 100);
        }
        return Math.ceil((iluminacaofio / 220.0d) / 10.0d);
    }

    /* access modifiers changed from: private */
    public double iluminacao_fio(double aream2) {
        double iluminacao_fio;
        if (aream2 <= 6.0d) {
            iluminacao_fio = 100.0d;
        } else {
            iluminacao_fio = (double) ((((int) Math.ceil((aream2 - 6.0d) / 4.0d)) * 60) + 100);
        }
        return Math.ceil((iluminacao_fio / 110.0d) / 10.0d);
    }

    /* access modifiers changed from: private */
    public double iluminacaodisj(double aream2) {
        double iluminacaodisj;
        if (aream2 <= 6.0d) {
            iluminacaodisj = 100.0d;
        } else {
            iluminacaodisj = 100.0d + (60.0d * ((double) ((int) Math.abs((aream2 - 6.0d) / 4.0d))));
        }
        double iluminacaodisj2 = iluminacaodisj / 220.0d;
        double disjuntor = Math.ceil(iluminacaodisj2 / Math.ceil(iluminacaodisj2 / 10.0d));
        if (disjuntor <= 0.5d) {
            return 0.5d;
        }
        if ((disjuntor <= 1.0d) && (disjuntor > 0.5d)) {
            return 1.0d;
        }
        if ((disjuntor <= 2.0d) && (disjuntor > 1.0d)) {
            return 2.0d;
        }
        if ((disjuntor <= 3.0d) && (disjuntor > 2.0d)) {
            return 3.0d;
        }
        if ((disjuntor <= 4.0d) && (disjuntor > 3.0d)) {
            return 4.0d;
        }
        if ((disjuntor <= 6.0d) && ((disjuntor > 4.0d ? 1 : (disjuntor == 4.0d ? 0 : -1)) > 0)) {
            return 6.0d;
        }
        return 10.0d;
    }

    /* access modifiers changed from: private */
    public double iluminacao_disj(double aream2) {
        double iluminacao_disj;
        if (aream2 <= 6.0d) {
            iluminacao_disj = 100.0d;
        } else {
            iluminacao_disj = 100.0d + (60.0d * ((double) ((int) Math.abs((aream2 - 6.0d) / 4.0d))));
        }
        double iluminacao_disj2 = iluminacao_disj / 110.0d;
        double disjuntor = Math.ceil(iluminacao_disj2 / Math.ceil(iluminacao_disj2 / 10.0d));
        if (disjuntor <= 0.5d) {
            return 0.5d;
        }
        if ((disjuntor <= 1.0d) && (disjuntor > 0.5d)) {
            return 1.0d;
        }
        if ((disjuntor <= 2.0d) && (disjuntor > 1.0d)) {
            return 2.0d;
        }
        if ((disjuntor <= 3.0d) && (disjuntor > 2.0d)) {
            return 3.0d;
        }
        if ((disjuntor <= 4.0d) && (disjuntor > 3.0d)) {
            return 4.0d;
        }
        if ((disjuntor <= 6.0d) && ((disjuntor > 4.0d ? 1 : (disjuntor == 4.0d ? 0 : -1)) > 0)) {
            return 6.0d;
        }
        return 10.0d;
    }

    /* access modifiers changed from: private */
    public Double calculoperimetro(double aream2) {
        return Double.valueOf(4.0d * Math.sqrt(aream2));
    }

    /* access modifiers changed from: private */
    public double casatomada(double aream2) {
        double calcper = 4.0d * Math.sqrt(aream2);
        if (calcper <= 3.5d) {
            return 1.0d;
        }
        return Math.ceil(calcper / 3.5d);
    }

    /* access modifiers changed from: private */
    public double casawtomada(double aream2) {
        double calcperw = 4.0d * Math.sqrt(aream2);
        if (calcperw <= 10.5d) {
            return Math.ceil(calcperw / 3.5d) * 600.0d;
        }
        return ((Math.ceil(calcperw / 3.5d) * 100.0d) - 300.0d) + 1800.0d;
    }

    /* access modifiers changed from: private */
    public double casaftomada(double aream2) {
        double casaftomada;
        double calcperw = 4.0d * Math.sqrt(aream2);
        if (calcperw <= 10.5d) {
            casaftomada = (calcperw / 3.5d) * 600.0d;
        } else {
            casaftomada = (((calcperw / 3.5d) * 100.0d) - 300.0d) + 1800.0d;
        }
        return Math.ceil((casaftomada / 220.0d) / 20.0d);
    }

    /* access modifiers changed from: private */
    public double casafftomada(double aream2) {
        double casafftomada;
        double calcperw = 4.0d * Math.sqrt(aream2);
        if (calcperw <= 10.5d) {
            casafftomada = (calcperw / 3.5d) * 600.0d;
        } else {
            casafftomada = (((calcperw / 3.5d) * 100.0d) - 300.0d) + 1800.0d;
        }
        return Math.ceil((casafftomada / 110.0d) / 20.0d);
    }

    /* access modifiers changed from: private */
    public double casadisjtomada(double aream2) {
        double casadisjtomada;
        double calcperw = 4.0d * Math.sqrt(aream2);
        if (calcperw <= 10.5d) {
            casadisjtomada = Math.ceil(calcperw / 3.5d) * 600.0d;
        } else {
            casadisjtomada = ((Math.ceil(calcperw / 3.5d) * 100.0d) - 300.0d) + 1800.0d;
        }
        double casadisjtomada2 = casadisjtomada / 220.0d;
        double disjuntor = Math.ceil(casadisjtomada2 / Math.ceil(casadisjtomada2 / 20.0d));
        if (disjuntor <= 0.5d) {
            return 0.5d;
        }
        if ((disjuntor <= 1.0d) && (disjuntor > 0.5d)) {
            return 1.0d;
        }
        if ((disjuntor <= 2.0d) && (disjuntor > 1.0d)) {
            return 2.0d;
        }
        if ((disjuntor <= 3.0d) && (disjuntor > 2.0d)) {
            return 3.0d;
        }
        if ((disjuntor <= 4.0d) && (disjuntor > 3.0d)) {
            return 4.0d;
        }
        if ((disjuntor <= 6.0d) && (disjuntor > 4.0d)) {
            return 6.0d;
        }
        if ((disjuntor <= 10.0d) && (disjuntor > 6.0d)) {
            return 10.0d;
        }
        if ((disjuntor <= 13.0d) && (disjuntor > 10.0d)) {
            return 13.0d;
        }
        if ((disjuntor <= 16.0d) && (disjuntor > 13.0d)) {
            return 16.0d;
        }
        if ((disjuntor <= 20.0d) && ((disjuntor > 16.0d ? 1 : (disjuntor == 16.0d ? 0 : -1)) > 0)) {
            return 20.0d;
        }
        return casadisjtomada2;
    }

    /* access modifiers changed from: private */
    public double casadisjjtomada(double aream2) {
        double casadisjjtomada;
        double calcperw = 4.0d * Math.sqrt(aream2);
        if (calcperw <= 10.5d) {
            casadisjjtomada = Math.ceil(calcperw / 3.5d) * 600.0d;
        } else {
            casadisjjtomada = ((Math.ceil(calcperw / 3.5d) * 100.0d) - 300.0d) + 1800.0d;
        }
        double casadisjjtomada2 = casadisjjtomada / 110.0d;
        double disjuntor = Math.ceil(casadisjjtomada2 / Math.ceil(casadisjjtomada2 / 20.0d));
        if (disjuntor <= 0.5d) {
            return 0.5d;
        }
        if ((disjuntor <= 1.0d) && (disjuntor > 0.5d)) {
            return 1.0d;
        }
        if ((disjuntor <= 2.0d) && (disjuntor > 1.0d)) {
            return 2.0d;
        }
        if ((disjuntor <= 3.0d) && (disjuntor > 2.0d)) {
            return 3.0d;
        }
        if ((disjuntor <= 4.0d) && (disjuntor > 3.0d)) {
            return 4.0d;
        }
        if ((disjuntor <= 6.0d) && (disjuntor > 4.0d)) {
            return 6.0d;
        }
        if ((disjuntor <= 10.0d) && (disjuntor > 6.0d)) {
            return 10.0d;
        }
        if ((disjuntor <= 13.0d) && (disjuntor > 10.0d)) {
            return 13.0d;
        }
        if ((disjuntor <= 16.0d) && (disjuntor > 13.0d)) {
            return 16.0d;
        }
        if ((disjuntor <= 20.0d) && ((disjuntor > 16.0d ? 1 : (disjuntor == 16.0d ? 0 : -1)) > 0)) {
            return 20.0d;
        }
        return casadisjjtomada2;
    }

    /* access modifiers changed from: private */
    public double casa_tomada(double aream2) {
        double calcper_ = 4.0d * Math.sqrt(aream2);
        if (calcper_ <= 5.0d) {
            return 1.0d;
        }
        return Math.ceil(calcper_ / 5.0d);
    }

    /* access modifiers changed from: private */
    public double casa_wtomada(double aream2) {
        double calcper_w = 4.0d * Math.sqrt(aream2);
        if (calcper_w <= 15.0d) {
            return Math.ceil(calcper_w / 5.0d) * 600.0d;
        }
        return ((Math.ceil(calcper_w / 5.0d) * 100.0d) - 300.0d) + 1800.0d;
    }

    /* access modifiers changed from: private */
    public double casaffftomada(double aream2) {
        double casaffftomada;
        double calcperw = 4.0d * Math.sqrt(aream2);
        if (calcperw <= 15.0d) {
            casaffftomada = (calcperw / 5.0d) * 600.0d;
        } else {
            casaffftomada = (((calcperw / 5.0d) * 100.0d) - 300.0d) + 1800.0d;
        }
        return Math.ceil((casaffftomada / 220.0d) / 20.0d);
    }

    /* access modifiers changed from: private */
    public double casafffftomada(double aream2) {
        double casafffftomada;
        double calcperw = 4.0d * Math.sqrt(aream2);
        if (calcperw <= 15.0d) {
            casafffftomada = (calcperw / 5.0d) * 600.0d;
        } else {
            casafffftomada = (((calcperw / 5.0d) * 100.0d) - 300.0d) + 1800.0d;
        }
        return Math.ceil((casafffftomada / 110.0d) / 20.0d);
    }

    /* access modifiers changed from: private */
    public double casadisjjjtomada(double aream2) {
        double casadisjjjtomada;
        double calcperw = 4.0d * Math.sqrt(aream2);
        if (calcperw <= 15.0d) {
            casadisjjjtomada = Math.ceil(calcperw / 5.0d) * 600.0d;
        } else {
            casadisjjjtomada = ((Math.ceil(calcperw / 5.0d) * 100.0d) - 300.0d) + 1800.0d;
        }
        double casadisjjjtomada2 = casadisjjjtomada / 220.0d;
        double disjuntor = Math.ceil(casadisjjjtomada2 / Math.ceil(casadisjjjtomada2 / 20.0d));
        if (disjuntor <= 0.5d) {
            return 0.5d;
        }
        if ((disjuntor <= 1.0d) && (disjuntor > 0.5d)) {
            return 1.0d;
        }
        if ((disjuntor <= 2.0d) && (disjuntor > 1.0d)) {
            return 2.0d;
        }
        if ((disjuntor <= 3.0d) && (disjuntor > 2.0d)) {
            return 3.0d;
        }
        if ((disjuntor <= 4.0d) && (disjuntor > 3.0d)) {
            return 4.0d;
        }
        if ((disjuntor <= 6.0d) && (disjuntor > 4.0d)) {
            return 6.0d;
        }
        if ((disjuntor <= 10.0d) && (disjuntor > 6.0d)) {
            return 10.0d;
        }
        if ((disjuntor <= 13.0d) && (disjuntor > 10.0d)) {
            return 13.0d;
        }
        if ((disjuntor <= 16.0d) && (disjuntor > 13.0d)) {
            return 16.0d;
        }
        if ((disjuntor <= 20.0d) && ((disjuntor > 16.0d ? 1 : (disjuntor == 16.0d ? 0 : -1)) > 0)) {
            return 20.0d;
        }
        return casadisjjjtomada2;
    }

    /* access modifiers changed from: private */
    public double casadisjjjjtomada(double aream2) {
        double casadisjjjjtomada;
        double calcperw = 4.0d * Math.sqrt(aream2);
        if (calcperw <= 15.0d) {
            casadisjjjjtomada = Math.ceil(calcperw / 5.0d) * 600.0d;
        } else {
            casadisjjjjtomada = ((Math.ceil(calcperw / 5.0d) * 100.0d) - 300.0d) + 1800.0d;
        }
        double casadisjjjjtomada2 = casadisjjjjtomada / 110.0d;
        double disjuntor = Math.ceil(casadisjjjjtomada2 / Math.ceil(casadisjjjjtomada2 / 20.0d));
        if (disjuntor <= 0.5d) {
            return 0.5d;
        }
        if ((disjuntor <= 1.0d) && (disjuntor > 0.5d)) {
            return 1.0d;
        }
        if ((disjuntor <= 2.0d) && (disjuntor > 1.0d)) {
            return 2.0d;
        }
        if ((disjuntor <= 3.0d) && (disjuntor > 2.0d)) {
            return 3.0d;
        }
        if ((disjuntor <= 4.0d) && (disjuntor > 3.0d)) {
            return 4.0d;
        }
        if ((disjuntor <= 6.0d) && (disjuntor > 4.0d)) {
            return 6.0d;
        }
        if ((disjuntor <= 10.0d) && (disjuntor > 6.0d)) {
            return 10.0d;
        }
        if ((disjuntor <= 13.0d) && (disjuntor > 10.0d)) {
            return 13.0d;
        }
        if ((disjuntor <= 16.0d) && (disjuntor > 13.0d)) {
            return 16.0d;
        }
        if ((disjuntor <= 20.0d) && ((disjuntor > 16.0d ? 1 : (disjuntor == 16.0d ? 0 : -1)) > 0)) {
            return 20.0d;
        }
        return casadisjjjjtomada2;
    }

    /* access modifiers changed from: private */
    public double loja(double aream2) {
        return Math.ceil(aream2 / 20.0d);
    }

    /* access modifiers changed from: private */
    public double loja_wtomada(double aream2) {
        double ceil = Math.ceil(aream2 / 20.0d);
        if (aream2 <= 60.0d) {
            return Math.ceil(aream2 / 20.0d) * 600.0d;
        }
        return ((Math.ceil(aream2 / 20.0d) * 100.0d) - 300.0d) + 1800.0d;
    }

    /* access modifiers changed from: private */
    public double lojafio(double aream2) {
        double lojafio;
        double d = aream2 / 20.0d;
        if (aream2 <= 60.0d) {
            lojafio = (aream2 / 20.0d) * 600.0d;
        } else {
            lojafio = (((aream2 / 20.0d) * 100.0d) - 300.0d) + 1800.0d;
        }
        return Math.ceil((lojafio / 220.0d) / 20.0d);
    }

    /* access modifiers changed from: private */
    public double loja_fio(double aream2) {
        double loja_fio;
        double d = aream2 / 20.0d;
        if (aream2 <= 60.0d) {
            loja_fio = (aream2 / 20.0d) * 600.0d;
        } else {
            loja_fio = (((aream2 / 20.0d) * 100.0d) - 300.0d) + 1800.0d;
        }
        return Math.ceil((loja_fio / 110.0d) / 20.0d);
    }

    /* access modifiers changed from: private */
    public double lojadisj(double aream2) {
        double lojadisj;
        double d = aream2 / 20.0d;
        if (aream2 <= 60.0d) {
            lojadisj = Math.ceil(aream2 / 20.0d) * 600.0d;
        } else {
            lojadisj = ((Math.ceil(aream2 / 20.0d) * 100.0d) - 300.0d) + 1800.0d;
        }
        double lojadisj2 = lojadisj / 220.0d;
        double disjuntor = Math.ceil(lojadisj2 / Math.ceil(lojadisj2 / 20.0d));
        if (disjuntor <= 0.5d) {
            return 0.5d;
        }
        if ((disjuntor <= 1.0d) && (disjuntor > 0.5d)) {
            return 1.0d;
        }
        if ((disjuntor <= 2.0d) && (disjuntor > 1.0d)) {
            return 2.0d;
        }
        if ((disjuntor <= 3.0d) && (disjuntor > 2.0d)) {
            return 3.0d;
        }
        if ((disjuntor <= 4.0d) && (disjuntor > 3.0d)) {
            return 4.0d;
        }
        if ((disjuntor <= 6.0d) && (disjuntor > 4.0d)) {
            return 6.0d;
        }
        if ((disjuntor <= 10.0d) && (disjuntor > 6.0d)) {
            return 10.0d;
        }
        if ((disjuntor <= 13.0d) && (disjuntor > 10.0d)) {
            return 13.0d;
        }
        if ((disjuntor <= 16.0d) && (disjuntor > 13.0d)) {
            return 16.0d;
        }
        if ((disjuntor <= 20.0d) && ((disjuntor > 16.0d ? 1 : (disjuntor == 16.0d ? 0 : -1)) > 0)) {
            return 20.0d;
        }
        return lojadisj2;
    }

    /* access modifiers changed from: private */
    public double loja_disj(double aream2) {
        double loja_disj;
        double d = aream2 / 20.0d;
        if (aream2 <= 60.0d) {
            loja_disj = Math.ceil(aream2 / 20.0d) * 600.0d;
        } else {
            loja_disj = ((Math.ceil(aream2 / 20.0d) * 100.0d) - 300.0d) + 1800.0d;
        }
        double loja_disj2 = loja_disj / 110.0d;
        double disjuntor = Math.ceil(loja_disj2 / Math.ceil(loja_disj2 / 20.0d));
        if (disjuntor <= 0.5d) {
            return 0.5d;
        }
        if ((disjuntor <= 1.0d) && (disjuntor > 0.5d)) {
            return 1.0d;
        }
        if ((disjuntor <= 2.0d) && (disjuntor > 1.0d)) {
            return 2.0d;
        }
        if ((disjuntor <= 3.0d) && (disjuntor > 2.0d)) {
            return 3.0d;
        }
        if ((disjuntor <= 4.0d) && (disjuntor > 3.0d)) {
            return 4.0d;
        }
        if ((disjuntor <= 6.0d) && (disjuntor > 4.0d)) {
            return 6.0d;
        }
        if ((disjuntor <= 10.0d) && (disjuntor > 6.0d)) {
            return 10.0d;
        }
        if ((disjuntor <= 13.0d) && (disjuntor > 10.0d)) {
            return 13.0d;
        }
        if ((disjuntor <= 16.0d) && (disjuntor > 13.0d)) {
            return 16.0d;
        }
        if ((disjuntor <= 20.0d) && ((disjuntor > 16.0d ? 1 : (disjuntor == 16.0d ? 0 : -1)) > 0)) {
            return 20.0d;
        }
        return loja_disj2;
    }

    /* access modifiers changed from: private */
    public double casatomad() {
        return 1.0d;
    }

    /* access modifiers changed from: private */
    public double casawtomada() {
        return 600.0d;
    }

    /* access modifiers changed from: private */
    public double casaatomada() {
        return 1.0d;
    }

    /* access modifiers changed from: private */
    public double casaaatomada() {
        return 10.0d;
    }

    /* access modifiers changed from: private */
    public double casaaaatomada() {
        return 18.0d;
    }
}
