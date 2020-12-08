package br.com.microservices.fornecedor.repository;

import br.com.microservices.fornecedor.model.InfoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfoRepository extends JpaRepository <InfoFornecedor, Long> {
    Optional<InfoFornecedor> findByEstado(String estado);
}
