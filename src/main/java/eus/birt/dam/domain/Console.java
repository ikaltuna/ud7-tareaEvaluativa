package eus.birt.dam.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="console")
public class Console implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String model;
	
	private String nationality;
	
	private String company;
	
	@JsonManagedReference
	@OneToMany (mappedBy = "console",cascade = CascadeType.ALL)
	List <Game> games = new ArrayList<>();

	public Console(String name, String model, String nationality, String company) {
		super();
		this.name = name;
		this.model = model;
		this.nationality = nationality;
		this.company = company;
	}
	
	
}
