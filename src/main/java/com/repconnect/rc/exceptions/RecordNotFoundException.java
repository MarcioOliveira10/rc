package com.repconnect.rc.exceptions;

public class RecordNotFoundException  extends RuntimeException{

    public RecordNotFoundException(Integer id){
        super("Registro não encontrado com o id: " + id);
    }

}
