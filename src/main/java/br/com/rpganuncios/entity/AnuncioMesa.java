package br.com.rpganuncios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "anuncio_mesa")
@AllArgsConstructor
@Getter
@Setter
public class AnuncioMesa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome da campanha deve ser preenchido")
    @Size(max = 255)
    private String nomeCampanha;

    @NotBlank(message = "O campo sistema deve ser preenchido")
    private String nomeSistema;

    @NotBlank(message = "O campo gênero deve ser preenchido")
    private String generoMesa;

    @NotBlank(message = "O campo de horário da mesa deve ser preenchido")
    private String horaDiaMesa;

    @NotBlank(message = "O campo de sinopse deve ser preenchido")
    private String sinopse;

    @NotNull(message = "O numero maximo de vagas deve ser informado")
    private int vagasMaxima;

    @NotNull(message = "O numero de vagas preenchidas deve ser informado")
    private int vagaCompleta;


    private boolean mesaPaga;

    private String regraMesa;

    private String valorMesa;

    private String plataforma;

    private String linkFormulario;

    private String mediaUrl;

    private String outros;

}
