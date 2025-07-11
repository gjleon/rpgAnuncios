package br.com.rpganuncios.repository;

import br.com.rpganuncios.entity.TableAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TableAdRepository extends JpaRepository<TableAd, Long> {
}
