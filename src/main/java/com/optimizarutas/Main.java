package com.optimizarutas;

import com.optimizarutas.domain.Pedido;
import com.optimizarutas.domain.Vehiculo;


import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
       Pedido pedido = new Pedido(
               "A",
               3,
               LocalTime.of(8, 20),
               LocalTime.of(8, 50),
               1800
       );
        System.out.println("Pedido: " + pedido.getId());
        System.out.println("Demanda: " + pedido.getDemanda());
        System.out.println("Ventana: "
                + pedido.getInicioVentana() +
                "-" + pedido.getFinVentana()
        );
        System.out.println("Servicio: " + pedido.getDuracionServicioSegundos() +
                " segundos");

        Vehiculo vehiculo = new Vehiculo(
                "JI-25",
                67,
                LocalTime.of(9, 00),
                LocalTime.of(9, 40)
        );
        System.out.println("Vehiculo: " + vehiculo.getId());
        System.out.println("Capacidad " + vehiculo.getCapacidad());
        System.out.println("Jornada: " +vehiculo.getInicioJornada()
        + " - " + vehiculo.getFinJornada());
    }
}
