package com.willian.trabalho.builder;

import com.willian.trabalho.entity.Pergunta;
import com.willian.trabalho.enums.OptionEnum;
import com.willian.trabalho.enums.QuestionTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe construtora de perguntas
 */
public class QuestionsBuilder {

    public List<Pergunta> build() {
        List<Pergunta> perguntas = new ArrayList<>();
        perguntas.add(new Pergunta("Qual o seu jogo favorito?", QuestionTypeEnum.SINGLE).addOption("uno", false));
        perguntas.add(new Pergunta("Qual o seu hotel favorito?", QuestionTypeEnum.SINGLE).addOption("plaza", false));
        perguntas.add(new Pergunta("Qual o seu carro favorito?", QuestionTypeEnum.SINGLE).addOption("audi", false));
        perguntas.add(new Pergunta("1 + 1 = 2?", QuestionTypeEnum.MULTIPLE)
                .addOption(OptionEnum.YES.getOption(), true)
                .addOption(OptionEnum.NO.getOption(), false)
        );

        return perguntas;
    }
}
