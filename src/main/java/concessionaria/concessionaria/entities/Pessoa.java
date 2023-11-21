package concessionaria.concessionaria.entities;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
import lombok.Data;


@Data
@MappedSuperclass
public abstract class Pessoa {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;
    private String nome;
    @Column(nullable = false, length = 11)
    private String cpf;
    private LocalDate data_nascimento;
    @Column(length = 11)
    private String telefone;
    private boolean isAtivo;
}
