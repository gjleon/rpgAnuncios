package br.com.rpganuncios.repository;

import br.com.rpganuncios.entity.JogadorAnuncio;
import br.com.rpganuncios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface JogadorAnuncioRepository extends JpaRepository<JogadorAnuncio, UUID> {
}
