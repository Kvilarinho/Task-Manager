package org.example.functionalities;

public class Done implements Function {


    @Override
    public boolean run() {

        return true;
    }

    /*
    DONE <id>
    Marca tarefa como concluída.
    Resposta: OK ou NOT_FOUND
     */
}
