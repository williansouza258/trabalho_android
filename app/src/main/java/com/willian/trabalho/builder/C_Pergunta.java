// region usings
package com.willian.trabalho.builder;
import com.willian.trabalho.entity.Pergunta;
import com.willian.trabalho.enums.tipo_pergunta_Enum;
import com.willian.trabalho.enums.optionEnum;
import java.util.ArrayList;
import java.util.List;
// endregion

public class C_Pergunta {

    public List<Pergunta> build() {
        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta("Fusca é um carro?", tipo_pergunta_Enum.MULTIPLE)
                .add_opcao(optionEnum.YES.getOption(), true)
                .add_opcao(optionEnum.NO.getOption(), false)
        );

        perguntas.add(new Pergunta("O cavalo de Napoleão era branco?", tipo_pergunta_Enum.MULTIPLE)
                .add_opcao(optionEnum.YES.getOption(), true)
                .add_opcao(optionEnum.NO.getOption(), false)
        );

        perguntas.add(new Pergunta("Porto Alegre é capital do RS?", tipo_pergunta_Enum.MULTIPLE)
                .add_opcao(optionEnum.YES.getOption(), true)
                .add_opcao(optionEnum.NO.getOption(), false)
        );

        return perguntas;
    }
}
