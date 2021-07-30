package br.com.cobello.aluraflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa os Videos
 * @author Felipe
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Video 
{
	@Id @GeneratedValue
	private long id;
	private String titulo;
	private String descricao;
	private String url;
	@ManyToOne
	@JoinColumn(name="categoriaId", referencedColumnName = "id", insertable = false, updatable = false)
	private Categoria categoria;
}
