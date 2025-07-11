package br.com.rpganuncios.repository;

import br.com.rpganuncios.entity.PlayerAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PlayerAdRepository extends JpaRepository<PlayerAd, Long> {
}
