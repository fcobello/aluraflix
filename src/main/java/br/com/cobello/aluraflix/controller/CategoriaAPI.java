package br.com.cobello.aluraflix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cobello.aluraflix.entity.Categoria;
import br.com.cobello.aluraflix.entity.Video;
import br.com.cobello.aluraflix.exception.NaoEncontradoException;
import br.com.cobello.aluraflix.pojo.CategoriaRequest;
import br.com.cobello.aluraflix.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;

/**
 * API de Operaões de Categorias
 * 
 * <p>
 * Trata os endpoints
 * <p>
 * <b>/categoria</b><br>
 * <b>/categoria/{id}</b><br>
 * <b>/categoria/{id}/videos</b><br>
 * 
 * @author Felipe
 *
 */
@RestController
@Slf4j
@Validated
public class CategoriaAPI extends BaseAPI {
	
	@Autowired
	CategoriaService service;

	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link PostMapping} para inserir um novo Categoria
	 * 
	 * @param request
	 */
	@PostMapping("/categorias")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria cadastrar(@Valid @RequestBody CategoriaRequest request) {
		
		log.info("Cadastrar um Video [{}]", request);

		return service.registrar(request);
	}
	
	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link PutMapping} para atualizar um novo Categoria
	 * 
	 * @param request
	 * @throws NaoEncontradoException 
	 */
	@PutMapping("/categorias/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Categoria atualizar(@PathVariable long id, @Valid @RequestBody CategoriaRequest request) throws NaoEncontradoException {
		
		log.info("Atualizar um Video [{}]", request);

		return service.atualizar(id, request);
	}
	
	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link DeleteMapping} para deletar um Categoria
	 * 
	 * @param request
	 * @throws NaoEncontradoException 
	 */
	@DeleteMapping("/categorias/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Categoria deletar(@PathVariable long id) throws NaoEncontradoException {
		
		log.info("Deletar um Video [{}]", id);

		return service.deletar(id);
	}

	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link GetMapping} para buscar um Categoria pelo seu id
	 * 
	 * @param id
	 * @return {@link Categoria}
	 * @throws Exception
	 */
	@GetMapping("/categorias/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Categoria buscar(@PathVariable long id) throws Exception {
		
		log.info("Consulta de Video por ID [{}]", id);

		return service.buscar(id);
	}
	
	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link GetMapping} para buscar os videos pelo seu id Categoria
	 * 
	 * @param conta
	 * @return {@link Video}
	 * @throws Exception
	 */
	@GetMapping("/categorias/{id}/videos")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Video> buscarVideos(@PathVariable long id) throws Exception {
		
		log.info("Consulta de Video por ID de categoria [{}]", id);

		return service.buscarVideos(id);
	}

	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link GetMapping} para buscar todos os Categoria
	 * 
	 * @param id
	 * @return {@link List} de {@link Categoria}
	 * @throws NaoEncontradoException
	 */
	@GetMapping("/categorias")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Categoria> buscar() throws NaoEncontradoException {
		
		log.info("Consulta de Videos");

		try {
			return service.buscar();
		} 
		catch (NaoEncontradoException e) {
			log.error(e.getMessage());
			throw e;
		}
	}


}
