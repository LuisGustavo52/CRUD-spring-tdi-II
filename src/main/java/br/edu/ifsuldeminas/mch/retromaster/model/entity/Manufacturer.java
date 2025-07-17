package br.edu.ifsuldeminas.mch.retromaster.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O nome do fabricante não pode ser vazio.")
    private String name;

    @NotNull(message = "A data de fundação não pode ser nula.")
    private Date foundationDate;

    @NotBlank(message = "O CNPJ não pode ser vazio.")
    private String cnpj;

    @NotNull(message = "É necessário informar se fabrica no Brasil.")
    private boolean manufacturesInBrazil;

    // --- Getters e Setters ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isManufacturesInBrazil() {
        return manufacturesInBrazil;
    }

    public void setManufacturesInBrazil(boolean manufacturesInBrazil) {
        this.manufacturesInBrazil = manufacturesInBrazil;
    }
}