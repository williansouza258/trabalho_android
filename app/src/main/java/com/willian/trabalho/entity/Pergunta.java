//region usings
package com.willian.trabalho.entity;
import android.util.Log;
import com.willian.trabalho.enums.tipo_pergunta_Enum;
import java.util.ArrayList;
import java.util.List;
//endregion

public class Pergunta {

    private String questao;
    private List<Opcao> opcoes = new ArrayList<>();
    private tipo_pergunta_Enum tipo;
    private Resposta resposta;

    public String get_pergunta() {
        return questao;
    }

    public List<Opcao> get_opcoes() {
        return opcoes;
    }

    public tipo_pergunta_Enum get_tipo() {
        return tipo;
    }

    public Pergunta(String questoes, tipo_pergunta_Enum tipo) {
        this.questao = questoes;
        this.tipo = tipo;
    }

  // adiciona opção de resposta
    public Pergunta add_opcao(String conteudo, boolean certo) {
        if (this.opcoes.size() > 2) {
            Log.e("Pergunta", "A pergunta excedeu o limite de duas opções");
        }
        this.opcoes.add(new Opcao(conteudo, certo));
        return this;
    }

  //seta resposta
    public void set_resposta(String resposta) {
        this.resposta = new Resposta(resposta);
    }

    public Resposta get_resposta() {
        return this.resposta;
    }

    public boolean confere_resposta(String resposta) {
        if (opcoes.isEmpty()) {
            return false;
        }

        for (Opcao opcao: opcoes) {
            if (opcao.texto == resposta && opcao.isCorrect) {
                return true;
            }
        }
        return false;
//        return opcoes.contains(new Opcao(resposta, true));
    }
}
