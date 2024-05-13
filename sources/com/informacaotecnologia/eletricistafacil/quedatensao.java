package com.informacaotecnologia.eletricistafacil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class quedatensao extends AppCompatActivity {
    private Button btn_caldimq;
    double distanciaq;
    /* access modifiers changed from: private */
    public EditText edt_distanciaq;
    /* access modifiers changed from: private */
    public EditText edt_perdatensao;
    /* access modifiers changed from: private */
    public EditText edt_potenciaq;
    double perdatensao;
    double potenciaq;
    Spinner spintensaoq;
    /* access modifiers changed from: private */
    public TextView txt_correnteq;
    /* access modifiers changed from: private */
    public TextView txt_disjuntorq;
    /* access modifiers changed from: private */
    public TextView txt_fioq;
    /* access modifiers changed from: private */
    public TextView txt_tdisj;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_quedatensao);
        Bundle extras = getIntent().getExtras();
        this.btn_caldimq = (Button) findViewById(R.id.btn_caldimq);
        this.edt_potenciaq = (EditText) findViewById(R.id.edt_potenciaq);
        this.txt_disjuntorq = (TextView) findViewById(R.id.txt_disjuntorq);
        this.txt_fioq = (TextView) findViewById(R.id.txt_fioq);
        this.edt_distanciaq = (EditText) findViewById(R.id.edt_distanciaq);
        this.edt_perdatensao = (EditText) findViewById(R.id.edt_perdatensao);
        this.txt_correnteq = (TextView) findViewById(R.id.txt_correnteq);
        this.txt_tdisj = (TextView) findViewById(R.id.txt_tdisj);
        this.spintensaoq = (Spinner) findViewById(R.id.spintensaoq);
        this.spintensaoq.setAdapter(ArrayAdapter.createFromResource(this, R.array.Stensaoq, 17367048));
        this.edt_potenciaq.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                quedatensao.this.edt_potenciaq.setText("");
                quedatensao.this.txt_disjuntorq.setVisibility(4);
                quedatensao.this.txt_fioq.setVisibility(4);
                quedatensao.this.txt_correnteq.setVisibility(4);
                quedatensao.this.txt_tdisj.setVisibility(4);
                return false;
            }
        });
        this.edt_distanciaq.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                quedatensao.this.edt_distanciaq.setText("");
                quedatensao.this.txt_disjuntorq.setVisibility(4);
                quedatensao.this.txt_fioq.setVisibility(4);
                quedatensao.this.txt_correnteq.setVisibility(4);
                quedatensao.this.txt_tdisj.setVisibility(4);
                return false;
            }
        });
        this.edt_perdatensao.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                quedatensao.this.edt_perdatensao.setText("");
                quedatensao.this.txt_disjuntorq.setVisibility(4);
                quedatensao.this.txt_fioq.setVisibility(4);
                quedatensao.this.txt_correnteq.setVisibility(4);
                quedatensao.this.txt_tdisj.setVisibility(4);
                return false;
            }
        });
        this.btn_caldimq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String obj = quedatensao.this.spintensaoq.getSelectedItem().toString();
                if (quedatensao.this.spintensaoq.getSelectedItem().toString().trim().equals("Tensão")) {
                    Toast.makeText(quedatensao.this.getBaseContext(), "Selecione a Tênsão", 1).show();
                } else if (quedatensao.this.edt_potenciaq.getText().toString().trim().equals("")) {
                    Toast.makeText(quedatensao.this.getBaseContext(), "Adicione a Potência do Equipamento", 1).show();
                } else if (quedatensao.this.edt_distanciaq.getText().toString().trim().equals("")) {
                    Toast.makeText(quedatensao.this.getBaseContext(), "Adicione a Distância do cabo", 1).show();
                } else if (quedatensao.this.edt_perdatensao.getText().toString().trim().equals("")) {
                    Toast.makeText(quedatensao.this.getBaseContext(), "Adicione a queda de Tênsão do circuito de 3 ou 4 %", 1).show();
                    quedatensao.this.txt_correnteq.setText("");
                    quedatensao.this.txt_correnteq.setVisibility(4);
                    quedatensao.this.txt_fioq.setText("");
                    quedatensao.this.txt_fioq.setVisibility(4);
                    quedatensao.this.txt_disjuntorq.setText("");
                    quedatensao.this.txt_disjuntorq.setVisibility(4);
                    quedatensao.this.txt_tdisj.setVisibility(4);
                } else {
                    quedatensao.this.potenciaq = Double.parseDouble(quedatensao.this.edt_potenciaq.getText().toString());
                    quedatensao.this.distanciaq = Double.parseDouble(quedatensao.this.edt_distanciaq.getText().toString());
                    quedatensao.this.perdatensao = Double.parseDouble(quedatensao.this.edt_perdatensao.getText().toString());
                    if (quedatensao.this.perdatensao > 4.0d) {
                        quedatensao.this.txt_disjuntorq.setText("0");
                        quedatensao.this.txt_fioq.setText("0");
                        quedatensao.this.txt_correnteq.setText("0");
                        quedatensao.this.txt_tdisj.setText("0");
                        Toast.makeText(quedatensao.this.getBaseContext(), "Adicione a queda de Tênsão do circuito de 3 ou 4 %", 1).show();
                    } else if (quedatensao.this.perdatensao < 3.0d) {
                        quedatensao.this.txt_disjuntorq.setText("0");
                        quedatensao.this.txt_fioq.setText("0");
                        quedatensao.this.txt_correnteq.setText("0");
                        quedatensao.this.txt_tdisj.setText("0");
                        Toast.makeText(quedatensao.this.getBaseContext(), "Adicione a queda de Tênsão do circuito de 3 ou 4 %", 1).show();
                    } else if (quedatensao.this.spintensaoq.getSelectedItem().toString().trim().equals("220V")) {
                        quedatensao.this.txt_fioq.setVisibility(0);
                        quedatensao.this.txt_disjuntorq.setVisibility(0);
                        quedatensao.this.txt_correnteq.setVisibility(0);
                        quedatensao.this.txt_tdisj.setVisibility(0);
                        quedatensao.this.txt_disjuntorq.setText(Double.valueOf(quedatensao.this.disjc220(quedatensao.this.potenciaq)).toString());
                        quedatensao.this.txt_tdisj.setText("Bipolar");
                        quedatensao.this.txt_fioq.setText(Double.valueOf(quedatensao.this.fioc220(quedatensao.this.potenciaq, quedatensao.this.distanciaq, quedatensao.this.perdatensao)).toString());
                        quedatensao.this.txt_tdisj.setText("Bipolar");
                        quedatensao.this.txt_correnteq.setText(Double.valueOf(quedatensao.this.corrente220(quedatensao.this.potenciaq, quedatensao.this.perdatensao)).toString());
                        quedatensao.this.txt_tdisj.setText("Bipolar");
                    } else {
                        quedatensao.this.txt_fioq.setVisibility(0);
                        quedatensao.this.txt_disjuntorq.setVisibility(0);
                        quedatensao.this.txt_correnteq.setVisibility(0);
                        quedatensao.this.txt_tdisj.setVisibility(0);
                        quedatensao.this.txt_disjuntorq.setText(Double.valueOf(quedatensao.this.disjc110(quedatensao.this.potenciaq)).toString());
                        quedatensao.this.txt_tdisj.setText("Unipolar");
                        quedatensao.this.txt_fioq.setText(Double.valueOf(quedatensao.this.fioc110(quedatensao.this.potenciaq, quedatensao.this.distanciaq, quedatensao.this.perdatensao)).toString());
                        quedatensao.this.txt_tdisj.setText("Unipolar");
                        quedatensao.this.txt_correnteq.setText(Double.valueOf(quedatensao.this.corrente110(quedatensao.this.potenciaq, quedatensao.this.perdatensao)).toString());
                        quedatensao.this.txt_tdisj.setText("Unipolar");
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public double corrente220(double potenciatue, double perdatensao2) {
        return Math.ceil(potenciatue / 227.0d);
    }

    /* access modifiers changed from: private */
    public double corrente110(double potenciatue, double perdatensao2) {
        return Math.ceil(potenciatue / 127.0d);
    }

    /* access modifiers changed from: private */
    public double disjc220(double potenciaq2) {
        double carga = potenciaq2 / 227.0d;
        if (carga <= 0.5d) {
            return 0.5d;
        }
        if (carga <= 1.0d) {
            return 1.0d;
        }
        if (carga <= 2.0d) {
            return 2.0d;
        }
        if (carga <= 3.0d) {
            return 3.0d;
        }
        if (carga <= 4.0d) {
            return 4.0d;
        }
        if (carga <= 6.0d) {
            return 6.0d;
        }
        if (carga <= 10.0d) {
            return 10.0d;
        }
        if (carga <= 13.0d) {
            return 13.0d;
        }
        if (carga <= 16.0d) {
            return 16.0d;
        }
        if (carga <= 20.0d) {
            return 20.0d;
        }
        if (carga <= 25.0d) {
            return 25.0d;
        }
        if (carga <= 32.0d) {
            return 32.0d;
        }
        if (carga <= 40.0d) {
            return 40.0d;
        }
        if (carga <= 50.0d) {
            return 50.0d;
        }
        if (carga <= 63.0d) {
            return 63.0d;
        }
        if (carga <= 70.0d || carga <= 70.0d) {
            return 70.0d;
        }
        if (carga <= 80.0d) {
            return 80.0d;
        }
        if (carga <= 100.0d) {
            return 100.0d;
        }
        if (carga <= 125.0d) {
            return 125.0d;
        }
        this.edt_distanciaq.setText("");
        this.edt_perdatensao.setText("");
        this.edt_potenciaq.setText("");
        this.txt_disjuntorq.setVisibility(4);
        this.txt_fioq.setVisibility(4);
        this.txt_correnteq.setVisibility(4);
        this.txt_tdisj.setVisibility(4);
        Toast.makeText(getBaseContext(), "Informe uma Potência e Distancia válida ou menor ", 1).show();
        return 0.0d;
    }

    /* access modifiers changed from: private */
    public double fioc220(double potenciaq2, double distanciaq2, double perdatensao2) {
        double fio = 0.0d;
        double corrente = potenciaq2 / 227.0d;
        if (corrente <= 21.0d) {
            fio = 2.5d;
        } else if (corrente <= 28.0d) {
            fio = 4.0d;
        } else if (corrente <= 36.0d) {
            fio = 6.0d;
        } else if (corrente <= 50.0d) {
            fio = 10.0d;
        } else if (corrente <= 66.0d) {
            fio = 16.0d;
        } else if (corrente <= 89.0d) {
            fio = 25.0d;
        } else if (corrente <= 111.0d) {
            fio = 35.0d;
        } else if (corrente <= 134.0d) {
            fio = 50.0d;
        } else if (corrente <= 171.0d) {
            fio = 70.0d;
        } else if (corrente <= 207.0d) {
            fio = 95.0d;
        } else if (corrente <= 239.0d) {
            fio = 120.0d;
        } else if (corrente <= 272.0d) {
            fio = 150.0d;
        } else if (corrente <= 310.0d) {
            fio = 185.0d;
        } else if (corrente <= 364.0d) {
            fio = 240.0d;
        } else if (corrente <= 419.0d) {
            fio = 300.0d;
        } else if (corrente <= 502.0d) {
            fio = 400.0d;
        } else if (corrente <= 578.0d) {
            fio = 500.0d;
        }
        double disj = ((corrente * distanciaq2) * 2.0d) / (58.0d * (perdatensao2 * 2.27d));
        if (fio > disj) {
            double d = fio;
        } else if (disj <= 2.5d) {
            fio = 2.5d;
        } else if (disj <= 4.0d) {
            fio = 4.0d;
        } else if (disj <= 6.0d) {
            fio = 6.0d;
        } else if (disj <= 10.0d) {
            fio = 10.0d;
        } else if (disj <= 16.0d) {
            fio = 16.0d;
        } else if (disj <= 25.0d) {
            fio = 25.0d;
        } else if (disj <= 35.0d) {
            fio = 35.0d;
        } else if (disj <= 50.0d) {
            fio = 50.0d;
        } else if (disj <= 70.0d) {
            fio = 70.0d;
        } else if (disj <= 95.0d) {
            fio = 95.0d;
        } else if (disj <= 120.0d) {
            fio = 120.0d;
        } else if (disj <= 150.0d) {
            fio = 150.0d;
        } else if (disj <= 185.0d) {
            fio = 185.0d;
        } else if (disj <= 240.0d) {
            fio = 240.0d;
        } else if (disj <= 300.0d) {
            fio = 300.0d;
        } else if (disj <= 400.0d) {
            fio = 400.0d;
        } else if (disj <= 500.0d) {
            fio = 500.0d;
        } else {
            this.edt_distanciaq.setText("");
            this.edt_perdatensao.setText("");
            this.edt_potenciaq.setText("");
            this.txt_disjuntorq.setVisibility(4);
            this.txt_fioq.setVisibility(4);
            this.txt_correnteq.setVisibility(4);
            this.txt_tdisj.setVisibility(4);
            Toast.makeText(getBaseContext(), "Informe uma Potência e Distancia válida ou menor ", 1).show();
        }
        return fio;
    }

    /* access modifiers changed from: private */
    public double disjc110(double potenciaq2) {
        double carga = potenciaq2 / 127.0d;
        if (carga <= 0.5d) {
            return 0.5d;
        }
        if (carga <= 1.0d) {
            return 1.0d;
        }
        if (carga <= 2.0d) {
            return 2.0d;
        }
        if (carga <= 3.0d) {
            return 3.0d;
        }
        if (carga <= 4.0d) {
            return 4.0d;
        }
        if (carga <= 6.0d) {
            return 6.0d;
        }
        if (carga <= 10.0d) {
            return 10.0d;
        }
        if (carga <= 13.0d) {
            return 13.0d;
        }
        if (carga <= 16.0d) {
            return 16.0d;
        }
        if (carga <= 20.0d) {
            return 20.0d;
        }
        if (carga <= 25.0d) {
            return 25.0d;
        }
        if (carga <= 32.0d) {
            return 32.0d;
        }
        if (carga <= 40.0d) {
            return 40.0d;
        }
        if (carga <= 50.0d) {
            return 50.0d;
        }
        if (carga <= 63.0d) {
            return 63.0d;
        }
        if (carga <= 70.0d || carga <= 70.0d) {
            return 70.0d;
        }
        if (carga <= 80.0d) {
            return 80.0d;
        }
        if (carga <= 100.0d) {
            return 100.0d;
        }
        if (carga <= 125.0d) {
            return 125.0d;
        }
        this.edt_distanciaq.setText("");
        this.edt_perdatensao.setText("");
        this.edt_potenciaq.setText("");
        this.txt_disjuntorq.setVisibility(4);
        this.txt_fioq.setVisibility(4);
        this.txt_correnteq.setVisibility(4);
        this.txt_tdisj.setVisibility(4);
        Toast.makeText(getBaseContext(), "Informe uma Potência e Distancia válida ou menor ", 1).show();
        return 0.0d;
    }

    /* access modifiers changed from: private */
    public double fioc110(double potenciaq2, double distanciaq2, double perdatensao2) {
        double corrente = potenciaq2 / 127.0d;
        double fio = 0.0d;
        if (corrente <= 21.0d) {
            fio = 2.5d;
        } else if (corrente <= 28.0d) {
            fio = 4.0d;
        } else if (corrente <= 36.0d) {
            fio = 6.0d;
        } else if (corrente <= 50.0d) {
            fio = 10.0d;
        } else if (corrente <= 66.0d) {
            fio = 16.0d;
        } else if (corrente <= 89.0d) {
            fio = 25.0d;
        } else if (corrente <= 111.0d) {
            fio = 35.0d;
        } else if (corrente <= 134.0d) {
            fio = 50.0d;
        } else if (corrente <= 171.0d) {
            fio = 70.0d;
        } else if (corrente <= 207.0d) {
            fio = 95.0d;
        } else if (corrente <= 239.0d) {
            fio = 120.0d;
        } else if (corrente <= 272.0d) {
            fio = 150.0d;
        } else if (corrente <= 310.0d) {
            fio = 185.0d;
        } else if (corrente <= 364.0d) {
            fio = 240.0d;
        } else if (corrente <= 419.0d) {
            fio = 300.0d;
        } else if (corrente <= 502.0d) {
            fio = 400.0d;
        } else if (corrente <= 578.0d) {
            fio = 500.0d;
        }
        double disj = ((corrente * distanciaq2) * 2.0d) / (58.0d * (perdatensao2 * 1.27d));
        if (fio > disj) {
            double d = fio;
        } else if (disj <= 2.5d) {
            fio = 2.5d;
        } else if (disj <= 4.0d) {
            fio = 4.0d;
        } else if (disj <= 6.0d) {
            fio = 6.0d;
        } else if (disj <= 10.0d) {
            fio = 10.0d;
        } else if (disj <= 16.0d) {
            fio = 16.0d;
        } else if (disj <= 25.0d) {
            fio = 25.0d;
        } else if (disj <= 35.0d) {
            fio = 35.0d;
        } else if (disj <= 50.0d) {
            fio = 50.0d;
        } else if (disj <= 70.0d) {
            fio = 70.0d;
        } else if (disj <= 95.0d) {
            fio = 95.0d;
        } else if (disj <= 120.0d) {
            fio = 120.0d;
        } else if (disj <= 150.0d) {
            fio = 150.0d;
        } else if (disj <= 185.0d) {
            fio = 185.0d;
        } else if (disj <= 240.0d) {
            fio = 240.0d;
        } else if (disj <= 300.0d) {
            fio = 300.0d;
        } else if (disj <= 400.0d) {
            fio = 400.0d;
        } else if (disj <= 500.0d) {
            fio = 500.0d;
        } else {
            this.edt_distanciaq.setText("");
            this.edt_perdatensao.setText("");
            this.edt_potenciaq.setText("");
            this.txt_disjuntorq.setVisibility(4);
            this.txt_fioq.setVisibility(4);
            this.txt_correnteq.setVisibility(4);
            this.txt_tdisj.setVisibility(4);
            Toast.makeText(getBaseContext(), "Informe uma Potência e Distancia válida ou menor ", 1).show();
        }
        return fio;
    }
}
