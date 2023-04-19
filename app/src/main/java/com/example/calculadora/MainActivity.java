package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private CheckBox checkBox;
    private String aux, numbers;
    private Double result;
    private int posicion;
    private LinearLayout layoutHorizontal;
    private RadioButton rbsuma, rbresta, rbmulti, rbdivi;
    private Button plus, minus, div, mult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        layoutHorizontal = findViewById(R.id.lhori);

        rbsuma = findViewById(R.id.radioButtonSum);
        rbresta = findViewById(R.id.radioRes);
        rbmulti = findViewById(R.id.radioButtonMult);
        rbdivi = findViewById(R.id.radioButtonDivision);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mult = findViewById(R.id.multiply);
        div = findViewById(R.id.slash);

        checkBox = findViewById(R.id.showOptions);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked())
                    layoutHorizontal.setVisibility(View.VISIBLE);
                else{
                    layoutHorizontal.setVisibility(View.INVISIBLE);
                    plus.setEnabled(true);
                    minus.setEnabled(true);
                    div.setEnabled(true);
                    mult.setEnabled(true);
                }

            }
        });

        rbsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbsuma.isChecked())
                    plus.setEnabled(false);


            }
        });

        rbresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbresta.isChecked())
                    minus.setEnabled(false);

            }
        });

        rbmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbmulti.isChecked())
                    mult.setEnabled(false);
            }
        });

        rbdivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbdivi.isChecked())
                    div.setEnabled(false);

            }
        });

    }


    public void doButtonClickClear(View view) {
        textView = findViewById(R.id.textoNum);
        textView.setText("");
    }

    public void doButtonClick0(View view) {
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "0";
        textView.setText(aux);
    }

    public void doButtonClick1(View view) {
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "1";
        textView.setText(aux);
    }

    public void doButtonClick2(View view) {
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "2";
        textView.setText(aux);
    }

    public void doButtonClick3(View view) {
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "3";
        textView.setText(aux);
    }

    public void doButtonClick4(View view) {
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "4";
        textView.setText(aux);
    }

    public void doButtonClick5(View view) {
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "5";
        textView.setText(aux);
    }

    public void doButtonClick6(View view) {
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "6";
        textView.setText(aux);
    }

    public void doButtonClick7(View view) {
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "7";
        textView.setText(aux);
    }

    public void doButtonClick8(View view) {
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "8";
        textView.setText(aux);
    }


    public void doButtonClick9(View view) {
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "9";
        textView.setText(aux);
    }

    public void doButtonClickSlash(View view) {
        numbers = (String) textView.getText();
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "/";
        textView.setText(aux);
    }

    public void doButtonClickMult(View view) {
        numbers = (String) textView.getText();
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "*";
        textView.setText(aux);


    }

    public void doButtonClickMin(View view) {
        numbers = (String) textView.getText();
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "-";
        textView.setText(aux);

    }

    public void doButtonClickPlus(View view) {
        numbers = (String) textView.getText();
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += "+";
        textView.setText(aux);

    }

    public void doButtonClickDoc(View view) {
    //    numbers = (String) textView.getText();
        textView = findViewById(R.id.textoNum);
        aux = (String) textView.getText();
        aux += ".";
        textView.setText(aux);

    }


    @SuppressLint("SetTextI18n")
    public void doButtonClickEqual(View view) {
        result = calcular(getSymbolString(), getFirstString(), getSecondString());
        textView = findViewById(R.id.textoNum);
        textView.setText(result.toString());

    }

    public String getFirstString() {
        int i = 0;
        boolean encontrado = false;
        String aux = "", eltexto = textView.getText().toString();
        do {
            if (eltexto.charAt(i) <= 57 && eltexto.charAt(i) >= 48) {
                aux += eltexto.charAt(i);
            } else {
                encontrado = true;
            }
            i++;
        } while (i < eltexto.length() && !encontrado);

        return aux;
    }

    public String getSecondString() {
        String aux = "", eltexto = textView.getText().toString();
        for (int i = posicion+1; i < eltexto.length(); i++) {
            aux += eltexto.charAt(i);
        }

        return aux;
    }


    public char getSymbolString() {
        int i = 0;
        boolean encontrado = false;
        char aux = ' ';
        String eltexto = textView.getText().toString();

        do {
            if (eltexto.charAt(i) >= 42 && eltexto.charAt(i) <= 47) {
                aux = eltexto.charAt(i);
                posicion = i;
                encontrado = true;
            }
            i++;
        } while (i < eltexto.length() && !encontrado);
        return aux;
    }


    private double calcular(char getSymbol, String aux, String aux2) {
        double result = 0;
        switch (getSymbol) {
            case '+':
                result = suma(aux, aux2);
                break;
            case '-':
                result = resta(aux, aux2);
                break;
            case '/':
                result = div(aux, aux2);
                break;
            case '*':
                result = mult(aux, aux2);
                break;

        }

        return result;
    }

    public double suma(String aux, String aux2) {
        return Double.parseDouble(aux) + Double.parseDouble(aux2);
    }

    public double resta(String aux, String aux2) {
        return Double.parseDouble(aux) - Double.parseDouble(aux2);
    }

    public double mult(String aux, String aux2) {
        return Double.parseDouble(aux) * Double.parseDouble(aux2);
    }

    public double div(String aux, String aux2) {
        return Double.parseDouble(aux) / Double.parseDouble(aux2);
    }


}