//region usings
package com.willian.trabalho.entity;
//endregion

public class Opcao {

    public String texto;
    public boolean  isCorrect = false;

    public String get_texto() {
        return texto;
    }

    public Opcao(String texto, boolean isCorrect) {
        this.texto = texto;
        this.isCorrect = isCorrect;
    }
}
