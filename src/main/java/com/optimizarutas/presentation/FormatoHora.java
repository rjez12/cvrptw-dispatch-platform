package com.optimizarutas.presentation;

import java.rmi.registry.LocateRegistry;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public enum FormatoHora {
    DOCE_HORAS("hh:mm a"),
    VEINTICUATRO_HORAS("HH:MM");

    private final DateTimeFormatter formateador;

    FormatoHora(String patron) {
        this.formateador = DateTimeFormatter.ofPattern(
                patron,
                Locale.ENGLISH
        );
    }

    public String formatear(LocalTime hora) {
        if (hora == null) {
            throw new IllegalArgumentException(
                    "Especificar la hora es obligatorio para continuar."
            );
        }
        return formateador.format(hora);
    }
}
