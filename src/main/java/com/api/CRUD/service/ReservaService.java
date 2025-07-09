package com.api.CRUD.service;

import com.api.CRUD.model.Reserva;
import com.api.CRUD.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}
