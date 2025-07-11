package br.com.rpganuncios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "table_ad")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TableAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da campanha deve ser preenchido")
    @Size(max = 255)
    private String campaignName;

    @NotBlank(message = "O campo sistema deve ser preenchido")
    private String systemName;

    @NotBlank(message = "O campo gênero deve ser preenchido")
    private String tableGenres;

    @NotBlank(message = "O campo de horário da mesa deve ser preenchido")
    private String scheduledDateTime;

    @NotBlank(message = "O campo de sinopse deve ser preenchido")
    private String synopsis;

    @NotNull(message = "O numero maximo de vagas deve ser informado")
    private int maxSlots;

    @NotNull(message = "O numero de vagas preenchidas deve ser informado")
    private int filledSlots;


    private boolean isPaidTable;

    private String tableRules;

    private String tablePrice;

    private String platform;

    private String formLink;

    private String mediaUrl;

    private String additionalInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;

}
