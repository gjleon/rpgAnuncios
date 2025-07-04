package br.com.rpganuncios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "player_ad")
@AllArgsConstructor
@Getter
@Setter
public class PlayerAd {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Player name must be provided")
    private String playerName;

    @NotBlank(message = "Player age must be provided")
    private String playerAge;

    private int playerCount;

    private String experience;

    @NotBlank(message = "System name must be provided")
    private String systemName;

    private String tableGenres;

    private String availableDateTime;

    private boolean acceptsPaidTable;

    private String platform;

    private String additionalInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAccount userAccount;


}
