package br.com.rpganuncios.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "login must be provided")
    @NotNull(message = "login cannot be null")
    @Size(max = 255)
    private String login;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email must be provided")
    @NotNull(message = "Email cannot be null")
    @Size(max = 255)
    private String email;

    @NotBlank(message = "Password must be provided")
    @NotNull(message = "Password cannot be null")
    private String password;

    @NotBlank(message = "Discord nickname must be provided")
    @NotNull(message = "Discord nickname cannot be null")
    private String nickDiscord;

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private List<TableAd> tableAds = new ArrayList<>();

    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private List<PlayerAd> playerAds = new ArrayList<>();
}
