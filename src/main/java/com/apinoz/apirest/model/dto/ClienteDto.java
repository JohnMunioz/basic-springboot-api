package com.apinoz.apirest.model.dto;


import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@ToString
@Builder
public class ClienteDto implements Serializable {

    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaRegistro;

}

