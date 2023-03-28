package com.generation.refugiomental.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.refugiomental.model.Postagens;
import com.generation.refugiomental.repository.PostagensRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagensController {
	
	@Autowired
	private PostagensRepository postagensRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagens>> getAll(){
		return ResponseEntity.ok(postagensRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagens> getById(@PathVariable Long id){
		return postagensRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/atendimento/{atendimento}")
	public ResponseEntity<List<Postagens>> getByAtendimento(@PathVariable String atendimento){
		return ResponseEntity.ok(postagensRepository.findAllByAtendimentoContainingIgnoreCase(atendimento));
	}
	
	@PostMapping
	public ResponseEntity<Postagens> post(@Valid @RequestBody Postagens postagens){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(postagensRepository.save(postagens));
	}
	
	@PutMapping
	public ResponseEntity<Postagens> put(@Valid @RequestBody Postagens postagens){
		return postagensRepository.findById(postagens.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(postagensRepository.save(postagens)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Postagens> postagens = postagensRepository.findById(id);
		if (postagens.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		postagensRepository.deleteById(id);
	}
}
