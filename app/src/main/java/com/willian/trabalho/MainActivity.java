//region usings
package com.willian.trabalho;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.willian.trabalho.builder.C_Pergunta;
import com.willian.trabalho.entity.Pergunta;
import com.willian.trabalho.enums.tipo_pergunta_Enum;
import com.willian.trabalho.enums.optionEnum;
import java.util.ArrayList;
import java.util.List;
//endregion

public class MainActivity extends AppCompatActivity {

    public static List<Pergunta> perguntas = new ArrayList<>();
    private final C_Pergunta CPergunta = new C_Pergunta();
    private Pergunta pergunta = null;

    private int index = 0;
    private TextView pergunta_tv;
    private EditText resposta_et;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle salvarEstado) {
        super.onCreate(salvarEstado);
        setContentView(R.layout.activity_main);
        perguntas = CPergunta.build();

        ConstraintLayout tela = findViewById(R.id.tela);
        pergunta_tv = findViewById(R.id.pergunta_tv);
        resposta_et = findViewById(R.id.resposta_et);

        tela.setOnTouchListener(new resposta_tela(getApplicationContext()) {


            @Override
            public void onSwipeBottom() { // Sim / Confirmar
                super.onSwipeBottom();
                if (pergunta.get_tipo() == tipo_pergunta_Enum.MULTIPLE && pergunta.get_resposta() == null) {
                    pergunta.set_resposta(optionEnum.YES.getOption());
                    Toast.makeText(getApplicationContext(), getString(R.string.resposta_escolhida, getString(R.string.sim)), Toast.LENGTH_LONG).show();
                }
                 if (pergunta.get_tipo() == tipo_pergunta_Enum.SINGLE && pergunta.get_resposta() == null){
                    String resposta = resposta_et.getText().toString();
                    if (TextUtils.isEmpty(resposta)) {
                        resposta_et.requestFocus();
                        resposta_et.setError(getString(R.string.resposta_vazia));
                    } else {
                        pergunta.set_resposta(resposta);
                        Toast.makeText(getApplicationContext(), getString(R.string.resposta_escolhida, resposta_et.getText()), Toast.LENGTH_LONG).show();
                    }
                } else if (pergunta.get_resposta() != null) {
                    Toast.makeText(getApplicationContext(), getString(R.string.ja_respondida), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void m_direita() {

                carrega_pergunta("right");
            }

            @Override
            public void m_esquerda() {
                carrega_pergunta("left");
            }

            @Override
            public void m_cima() { // Não
                super.m_cima();
                if (pergunta.get_tipo() == tipo_pergunta_Enum.MULTIPLE && pergunta.get_resposta() == null) {
                    pergunta.set_resposta(optionEnum.NO.getOption());
            }
                    Toast.makeText(getApplicationContext(), getString(R.string.resposta_escolhida, getString(R.string.nao)), Toast.LENGTH_LONG).show();
//                } else if (pergunta.get_resposta() != null) {
//                    Toast.makeText(getApplicationContext(), getString(R.string.resposta_vazia), Toast.LENGTH_LONG).show();
                }
        });
    }

//    carregar peguntas
//    verifica sentido que o usuario move a tela
    private void carrega_pergunta(String sentido) {
        resetar_index();

        pergunta = perguntas.get(this.index);
        pergunta_tv.setText(pergunta.get_pergunta());

        resposta_et.setVisibility(EditText.INVISIBLE);
        if (pergunta.get_tipo() == tipo_pergunta_Enum.SINGLE) {
            resposta_et.setVisibility(EditText.VISIBLE);
            if (pergunta.get_resposta() != null) {
                resposta_et.setEnabled(false);
            }
        }

        if (sentido.equals("right")) {
            prox_pergunta();
        }

        if (sentido.equals("left")) {
            ant_pergunta ();
        }

    }

//reseta o index de perguntas
    private void resetar_index() {
//        int teste = perguntas.size();
//        int indeaaa = index;

        if (index > (perguntas.size() - 1) ) {
            index = 2;
        }
       
        if(index < 0){
            index = 0;
        }
    }

 // voltar pergunta
    private void ant_pergunta() {
        index++;
    }
// avançar pergunta
    private void prox_pergunta() {
        index--;
    }
}

