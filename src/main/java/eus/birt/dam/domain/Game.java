package eus.birt.dam.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="game")
public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	
	@Column(name="release_date")
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;
	
	private String developer;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn (name = "console_id")
	private Console console;

	//Añade propiedad consoleName a JSON 
	@JsonProperty("consoleName")
	public String getConsoleName() {
	    return console != null ? console.getName() : null;
	}

	public Game(String name,  LocalDate releaseDate, String developer, Console console) {
		super();
		this.name = name;
		this.releaseDate = releaseDate;
		this.developer = developer;
		this.console = console;
	}
}
