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
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo nickName deve ser preenchido")
    @NotNull(message = "o campo nickName não pode ser nulo")
    @Size(max = 255)
    private String nickName;

    @Email(message = "Email invalido favor inserir um email valido")
    @NotBlank(message = "O campo email deve ser preenchido")
    @NotNull(message = "o campo email não pode ser nulo")
    @Size(max = 255)
    private String email;

    @NotBlank(message = "O campo senha deve ser preenchido")
    @NotNull(message = "o campo senha não pode ser nulo")
    private String senha;

    @NotBlank(message = "O campo nick do Discord deve ser preenchido")
    @NotNull(message = "o campo nick do Discord não pode ser nulo")
    private String nickDiscord;

    @OneToMany
    private List<AnuncioMesa> anuncioMesas = new ArrayList<>();

    @OneToMany
    private List<JogadorAnuncio> jogadorAnuncios = new ArrayList<>();
}
