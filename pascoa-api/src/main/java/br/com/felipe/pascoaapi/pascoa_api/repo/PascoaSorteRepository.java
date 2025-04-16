package br.com.felipe.pascoaapi.pascoa_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipe.pascoaapi.pascoa_api.domain.PascoaSorte;

public interface PascoaSorteRepository extends JpaRepository<PascoaSorte, Integer> {
	PascoaSorte findByUsuario(String usuario);

}
