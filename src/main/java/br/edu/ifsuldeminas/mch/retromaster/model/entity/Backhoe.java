package br.edu.ifsuldeminas.mch.retromaster.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="backhoe")
public class Backhoe {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
    @NotBlank(message = "O modelo da retroescavadeira é obrigatório.")
    @Size(min = 2, max = 50, message = "O modelo deve ter entre 2 e 50 caracteres.")
    private String model;

    @NotNull(message = "O ano de fabricação é obrigatório.")
    @PastOrPresent(message = "O ano de fabricação não pode ser uma data futura.")
    @Temporal(TemporalType.DATE) 
    private Date year;

    @NotNull(message = "O fabricante é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @NotNull(message = "O status é obrigatório")
    private boolean status;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	 
}
