package br.com.rpganuncios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "jogador_anuncio")
@AllArgsConstructor
@Getter
@Setter
public class JogadorAnuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome do jogador/jogadores deve ser preenchido")
    private String nomeJogador;

    @NotBlank(message = "A idade do jogador/jogadores deve ser preenchido")
    private String idadeJogador;

    private int quantidadeJogador;

    private String experiencia;

    @NotBlank(message = "O nome(es) do sistema deve ser informado ")
    private String nomeSistema;

    private String generosMEsa;

    private String horaDiaDisponivel;

    private boolean aceitaMesaPaga;

    private String plataforma;

    private String outros;


}
