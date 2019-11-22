//region usings
package com.willian.trabalho.entity;
//endregion

public class Opcao {

    private String texto;
    private boolean  isCorrect = false;

    public String get_texto() {
        return texto;
    }

    public Opcao(String texto, boolean isCorrect) {
        this.texto = texto;
        this.isCorrect = isCorrect;
    }
}
