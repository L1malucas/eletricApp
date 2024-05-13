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

public class tue extends AppCompatActivity {
    private Button btn_caldimtue;
    double distanciatue;
    /* access modifiers changed from: private */
    public EditText edt_potenciatue;
    double potenciatue;
    Spinner spintensaotue;
    /* access modifiers changed from: private */
    public TextView txt_correntetue;
    /* access modifiers changed from: private */
    public TextView txt_disjuntortue;
    /* access modifiers changed from: private */
    public TextView txt_fiotue;
    /* access modifiers changed from: private */
    public TextView txt_tdisj;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_tue);
        Bundle extras = getIntent().getExtras();
        this.btn_caldimtue = (Button) findViewById(R.id.btn_caldimtue);
        this.edt_potenciatue = (EditText) findViewById(R.id.edt_potenciatue);
        this.txt_disjuntortue = (TextView) findViewById(R.id.txt_disjuntortue);
        this.txt_fiotue = (TextView) findViewById(R.id.txt_fiotue);
        this.txt_correntetue = (TextView) findViewById(R.id.txt_correntetue);
        this.txt_tdisj = (TextView) findViewById(R.id.txt_tdisj);
        this.spintensaotue = (Spinner) findViewById(R.id.spintensaotue);
        this.spintensaotue.setAdapter(ArrayAdapter.createFromResource(this, R.array.Stensaotue, 17367048));
        this.edt_potenciatue.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return false;
                }
                tue.this.edt_potenciatue.setText("");
                tue.this.txt_disjuntortue.setVisibility(4);
                tue.this.txt_fiotue.setVisibility(4);
                tue.this.txt_correntetue.setVisibility(4);
                tue.this.txt_tdisj.setVisibility(4);
                return false;
            }
        });
        this.btn_caldimtue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String obj = tue.this.spintensaotue.getSelectedItem().toString();
                if (tue.this.spintensaotue.getSelectedItem().toString().trim().equals("Tensão")) {
                    Toast.makeText(tue.this.getBaseContext(), "Selecione a Tênsão", 1).show();
                } else if (tue.this.edt_potenciatue.getText().toString().trim().equals("")) {
                    Toast.makeText(tue.this.getBaseContext(), "Adicione a Potência do Equipamento", 1).show();
                } else {
                    tue.this.txt_fiotue.setVisibility(0);
                    tue.this.txt_disjuntortue.setVisibility(0);
                    tue.this.txt_correntetue.setVisibility(0);
                    tue.this.txt_tdisj.setVisibility(0);
                    tue.this.potenciatue = Double.parseDouble(tue.this.edt_potenciatue.getText().toString());
                    if (tue.this.spintensaotue.getSelectedItem().toString().trim().equals("220V")) {
                        tue.this.txt_disjuntortue.setText(Double.valueOf(tue.this.disjc220(tue.this.potenciatue)).toString());
                        tue.this.txt_tdisj.setText("Bipolar");
                        tue.this.txt_fiotue.setText(Double.valueOf(tue.this.fioc220(tue.this.potenciatue, tue.this.distanciatue)).toString());
                        tue.this.txt_tdisj.setText("Bipolar");
                        tue.this.txt_correntetue.setText(Double.valueOf(tue.this.corrente220(tue.this.potenciatue)).toString());
                        tue.this.txt_tdisj.setText("Bipolar");
                        return;
                    }
                    tue.this.txt_disjuntortue.setText(Double.valueOf(tue.this.disjc110(tue.this.potenciatue)).toString());
                    tue.this.txt_tdisj.setText("Unipolar");
                    tue.this.txt_fiotue.setText(Double.valueOf(tue.this.fioc110(tue.this.potenciatue, tue.this.distanciatue)).toString());
                    tue.this.txt_tdisj.setText("Unipolar");
                    tue.this.txt_correntetue.setText(Double.valueOf(tue.this.corrente110(tue.this.potenciatue)).toString());
                    tue.this.txt_tdisj.setText("Unipolar");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public double corrente220(double potenciatue2) {
        return Math.ceil(potenciatue2 / 227.0d);
    }

    /* access modifiers changed from: private */
    public double corrente110(double potenciatue2) {
        return Math.ceil(potenciatue2 / 127.0d);
    }

    /* access modifiers changed from: private */
    public double disjc220(double potenciatue2) {
        double carga = potenciatue2 / 227.0d;
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
        this.edt_potenciatue.setText("");
        this.txt_disjuntortue.setVisibility(4);
        this.txt_fiotue.setVisibility(4);
        this.txt_correntetue.setVisibility(4);
        this.txt_tdisj.setVisibility(4);
        Toast.makeText(getBaseContext(), "Informe uma Potência válida ou menor ", 1).show();
        return 0.0d;
    }

    /* access modifiers changed from: private */
    public double fioc220(double potenciatue2, double distanciatue2) {
        double corrente = potenciatue2 / 227.0d;
        double fio = 0.0d;
        if (corrente <= 20.0d) {
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
        } else {
            this.edt_potenciatue.setText("");
            this.txt_disjuntortue.setVisibility(4);
            this.txt_fiotue.setVisibility(4);
            this.txt_correntetue.setVisibility(4);
            this.txt_tdisj.setVisibility(4);
            Toast.makeText(getBaseContext(), "Informe uma Potência válida ou menor ", 1).show();
        }
        return fio;
    }

    /* access modifiers changed from: private */
    public double disjc110(double potenciatue2) {
        double carga = potenciatue2 / 127.0d;
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
        this.edt_potenciatue.setText("");
        this.txt_disjuntortue.setVisibility(4);
        this.txt_fiotue.setVisibility(4);
        this.txt_correntetue.setVisibility(4);
        this.txt_tdisj.setVisibility(4);
        Toast.makeText(getBaseContext(), "Informe uma Potência válida ou menor ", 1).show();
        return 0.0d;
    }

    /* access modifiers changed from: private */
    public double fioc110(double potenciatue2, double distanciatue2) {
        double corrente = potenciatue2 / 127.0d;
        double fio = 0.0d;
        if (corrente <= 20.0d) {
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
        } else {
            this.edt_potenciatue.setText("");
            this.txt_disjuntortue.setVisibility(4);
            this.txt_fiotue.setVisibility(4);
            this.txt_correntetue.setVisibility(4);
            this.txt_tdisj.setVisibility(4);
            Toast.makeText(getBaseContext(), "Informe uma Potência válida ou menor ", 1).show();
        }
        return fio;
    }
}
