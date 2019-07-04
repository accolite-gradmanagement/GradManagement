package com.accolite.grads.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.grads.exception.GradNotFoundException;
import com.accolite.grads.model.Grad;
import com.accolite.grads.repository.GradRepository;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
public class GradController {
	private final GradRepository repository;
	
	private final GradResourceAssembler assembler;
	
	public GradController(GradResourceAssembler assembler, GradRepository repository) {
		this.repository = repository;
		this.assembler = assembler;
	}
	
	@GetMapping("/grads")
	Resources<Resource<Grad>> all() {

	  List<Resource<Grad>> grads = repository.findAll().stream()
	    .map(this.assembler::toResource)
	    .collect(Collectors.toList());

	  return new Resources<>(grads,
	    linkTo(methodOn(GradController.class).all()).withSelfRel());
	}

	@PostMapping("/grads")
	ResponseEntity<?> newGrad(@RequestBody Grad newGrad) throws URISyntaxException {
		System.out.println("Post is called");
		
		Resource<Grad> resource = this.assembler.toResource(repository.save(newGrad));
		
		return ResponseEntity
			    .created(new URI(resource.getId().expand().getHref()))
			    .body(resource);
	}

	// Single item

	@GetMapping("/grads/{id}")
	Resource<Grad> one(@PathVariable Long id) {

		Grad grad = repository.findById(id)
				.orElseThrow(() -> new GradNotFoundException(id));
		
		return this.assembler.toResource(grad);
	}

	@PutMapping("/grads/{id}")
	ResponseEntity<?> replaceGrad(@RequestBody Grad newGrad, @PathVariable Long id) throws URISyntaxException {

		Grad updatedGrad = repository.findById(id)
				.map(grad -> {
					
					BeanUtils.copyProperties(newGrad, grad);
					grad.setId(id);
					
					return repository.save(grad);
				})
				.orElseGet(() -> {
					newGrad.setId(id);
					return repository.save(newGrad);
				});
		
		Resource<Grad> resource = assembler.toResource(updatedGrad);

		return ResponseEntity
		    .created(new URI(resource.getId().expand().getHref()))
		    .body(resource);
	}

	@DeleteMapping("/grads/{id}")
	ResponseEntity<?> deleteGrad(@PathVariable Long id) {

		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
