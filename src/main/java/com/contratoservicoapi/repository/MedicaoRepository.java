package com.contratoservicoapi.repository;

import com.contratoservicoapi.model.Medicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicaoRepository extends JpaRepository<Medicao, Long> {
}
