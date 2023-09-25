package com.example.login.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;

@Entity(name = "usuario")
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "NOME", nullable = false)
    @Size(min = 3, message = "Nome Inválido")
    private String nome;

    @NotEmpty(message = "O e-mail deve ser informado")
    @Email(message = "Email Inválido")
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "A senha deve ser informado")
    @Column(name = "SENHA", nullable = false)
    @Size(min = 4)
    private String senha;

    private boolean ativo;
}
