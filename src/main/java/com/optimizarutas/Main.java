package com.optimizarutas;

import com.optimizarutas.domain.Pedido;
import com.optimizarutas.domain.Vehiculo;
import com.optimizarutas.presentation.FormatoHora;
import com.optimizarutas.domain.Ubicacion;
import com.optimizarutas.domain.Deposito;
import com.optimizarutas.domain.Escenario;
import com.optimizarutas.domain.Ruta;
import com.optimizarutas.domain.MatrizTiempos;

import java.util.OptionalInt;
import java.util.List;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        FormatoHora formatoHora = FormatoHora.DOCE_HORAS;
        Pedido pedido = new Pedido(
                "A",
                new Ubicacion(12.1364, -86.2514),
                3,
                LocalTime.of(8, 20),
                LocalTime.of(8, 50),
                1800
        );
        System.out.println("Pedido: " + pedido.getId());
        System.out.println("Demanda: " + pedido.getDemanda());
        System.out.println(
                "Ventana: "
                        + formatoHora.formatear(pedido.getInicioVentana())
                        + " - "
                        + formatoHora.formatear(pedido.getFinVentana())
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
        System.out.println("Capacidad: " + vehiculo.getCapacidad());
        System.out.println(
                "Jornada: "
                        + formatoHora.formatear(vehiculo.getInicioJornada())
                        + " - "
                        + formatoHora.formatear(vehiculo.getFinJornada())
        );

        Deposito deposito = new Deposito(
                "DEP-0123",
                new Ubicacion(87.0923, -153.98)
        );
        System.out.println("Deposito: " + deposito.getId());
        System.out.println("Ubicación: " + deposito.getUbicacion().getLatitud()
                + " - " + deposito.getUbicacion().getLongitud());

        Escenario escenario = new Escenario(
                "ESC-0123",
                deposito,
                List.of(vehiculo),
                List.of(pedido)
        );
        System.out.println("Escenario: " + escenario.getId());
        System.out.println("Deposito: " + escenario.getDeposito().getId());
        System.out.println("Vehiculo: " + escenario.getVehiculos().size());
        System.out.println("Pedido: " + escenario.getPedidos().size());

        Ruta ruta = new Ruta(
                vehiculo,
                deposito,
                List.of(pedido)
        );

        System.out.println("Vehiculo: " + ruta.getVehiculo().getId());
        System.out.println("Salida: " + ruta.getDeposito().getId());

        int posicion = 1;

        for (Pedido parada : ruta.getPedidos()) {
            System.out.println("Parada " + posicion + ":" + parada.getId());

            posicion++;
        }

        System.out.println("Regreso: " + ruta.getDeposito().getId());


        MatrizTiempos matriz = new  MatrizTiempos(
                new int[][] {
                        {0, 600},
                        {900, 0}
                }
        );

        OptionalInt tiempoIda = matriz.getTiempoSegundos(0, 1);

        if (tiempoIda.isPresent()) {
         System.out.println("Déposito -> A: " + tiempoIda.getAsInt() + " segundos"
          );
        } else {
         System.out.println("No existe conexión del depósito a A.");
        }

        OptionalInt tiempoRegreso = matriz.getTiempoSegundos(1, 1);

        if (tiempoRegreso.isPresent()) {
         System.out.println(
                 "A -> Depósito " +  tiempoRegreso.getAsInt() + " segundos"
         );
        } else {
         System.out.println("No existe conexión de A al depósito.");
        }
    }
}
