package com.optimizarutas;

import com.optimizarutas.domain.Pedido;


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
    }
}
