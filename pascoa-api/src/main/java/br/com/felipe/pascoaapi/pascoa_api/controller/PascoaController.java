package br.com.felipe.pascoaapi.pascoa_api.controller;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipe.pascoaapi.pascoa_api.domain.PascoaSorte;
import br.com.felipe.pascoaapi.pascoa_api.repo.PascoaSorteRepository;

@RestController
@RequestMapping(value = "/pascoa-sorte", produces = "application/json")
public class PascoaController {

	PascoaSorteRepository pascoaSorteRepository;
	
	Logger logger = Logger.getLogger(getClass().getName());

	public PascoaController(PascoaSorteRepository pascoaSorteRepository) {
		this.pascoaSorteRepository = pascoaSorteRepository;
	}

	@GetMapping
	public PascoaSorte getSorte() {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.info("User: " + username + " requisitou NOVO NUMERO DA SORTE.");
		PascoaSorte p = pascoaSorteRepository.findByUsuario(username);
		if(p.getNumeroSorte() == 0) {
			Random rand = new Random();
			int numero = rand.nextInt(1000);
			p.setNumeroSorte(numero);
			pascoaSorteRepository.save(p);
		}
		return p;
	}

	@GetMapping("/reset")
	public ResponseEntity<Void> reset() {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.info("User: " + username + " requisitou RESET.");
		List<PascoaSorte> list = pascoaSorteRepository.findAll();
		list.forEach(e -> {
			e.setNumeroSorte(0);
			pascoaSorteRepository.save(e);
		});

		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/todos")
	public List<PascoaSorte> findAll() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.info("User: " + username + " requisitou TODOS.");
		return pascoaSorteRepository.findAllByOrderByNumeroSorteDesc();
	}

}
