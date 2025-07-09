package com.api.CRUD.controller;

import com.api.CRUD.model.Reserva;
import com.api.CRUD.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")

/**
 * Controlador REST para gestionar reservas.
 */
@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    /**
     * Endpoint para realizar una reserva de habitación.
     * @param reserva los datos de la reserva.
     * @return mensaje de éxito.
     */
    @PostMapping
    public ResponseEntity<String> realizarReserva(@RequestBody Reserva reserva) {
        reservaService.guardarReserva(reserva);
        return ResponseEntity.ok("✅ Reserva exitosa");
    }
}
