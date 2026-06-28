package com.contratoservicoapi.repository;

import com.contratoservicoapi.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
