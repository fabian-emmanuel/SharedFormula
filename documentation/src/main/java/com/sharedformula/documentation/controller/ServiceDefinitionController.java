package com.sharedformula.documentation.controller;

import com.sharedformula.documentation.config.ServiceDefinitionsContext;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.basepath-doc}/")
public class ServiceDefinitionController {
	private final ServiceDefinitionsContext definitionContext;
	
	@GetMapping("/{service-name}")
	public String getServiceDefinition(@PathVariable("service-name") String serviceName){
		return definitionContext.getSwaggerDefinition(serviceName);
	}
}
