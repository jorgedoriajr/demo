package com.dev.jdagile.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.jdagile.demo.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	private static List<Cliente> lista = new ArrayList<>();
	
	@GetMapping
	public List<Cliente> listar() {
		return lista;
	}
	
	@PostMapping
	public List<Cliente> salvar(@RequestBody Cliente params) {
		lista.add(params);
		return lista;
	}
	
	@DeleteMapping
	public List<Cliente> deletar(@RequestBody Cliente params) {
		loop:
		for (Cliente cliente : lista) {
			if (lista.contains(cliente)) {
				lista.remove(cliente);
				break loop;
			}
		}
		return lista;
	}
}