package com.crudlover.api.DTO;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public record CarDTO(

        @NotBlank String modelo,

        @NotBlank String fabricante,

        @Past Date dataFabricacao,

        @Min(0) int valor,

        @Min(1) int anoModelo) {

}
