package br.com.cobello.aluraflix.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cobello.aluraflix.entity.Video;

/**
 * Interface para as operações de consulta no repositorio de Videos
 * @author Felipe
 *
 */
@Repository
public interface VideoRepository extends CrudRepository<Video, Long> {
	
	List<Video> findAll();
	
	List<Video> findByCategoriaId(long categoriaId);
}
