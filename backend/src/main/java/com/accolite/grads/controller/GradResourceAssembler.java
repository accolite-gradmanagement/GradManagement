package com.accolite.grads.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.accolite.grads.model.Grad;

@Component
public class GradResourceAssembler implements ResourceAssembler<Grad, Resource<Grad>> {

	@Override
	public Resource<Grad> toResource(Grad entity) {
		// TODO Auto-generated method stub
		return new Resource<Grad>(entity, 
				linkTo(methodOn(GradController.class).one(entity.getId())).withSelfRel(), 
						linkTo(methodOn(GradController.class).all()).withRel("Grads"));
	}

}