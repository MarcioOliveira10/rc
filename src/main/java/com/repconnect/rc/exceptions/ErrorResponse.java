package com.repconnect.rc.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record ErrorResponse(Integer status, String message, String stackTrace, List<ValidationError> errors) {

    public ErrorResponse{
        // Verifica se a lista de erros é nula e a inicializa se necessário
        if(Objects.isNull(errors)){
            errors = new ArrayList<>();
        }
    }

    public ErrorResponse addValidationError(String field, String message){
        // Cria uma nova lista de erros com o novo erro adicionado
        List<ValidationError> newErrors = new ArrayList<>(this.errors);
        newErrors.add(new ValidationError(field,message));
        // Retorna uma nova instância de ErrorResponse com a lista atualizada de erros
        return new ErrorResponse(this.status(), this.message(), this.stackTrace(),newErrors);
    }

}
