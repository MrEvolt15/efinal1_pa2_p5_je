package com.uce.edu.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Propietario;
import com.uce.edu.demo.service.ICuentaBancariaService;
import com.uce.edu.demo.service.ITrasnferenciaService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	@Autowired
	private ICuentaBancariaService bancariaService;
	@Autowired
	private ITrasnferenciaService iTrasnferenciaService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Propietario p1 = new Propietario();
		p1.setNombre("Joel");
		p1.setApellido("Espinosa");
		p1.setCedula("1726");
		Propietario p2 = new Propietario();
		p2.setNombre("Andres");
		p2.setApellido("Lugma");
		p2.setCedula("1234");

		CuentaBancaria cta1 = new CuentaBancaria();
		cta1.setNumero("111");
		cta1.setSaldo(BigDecimal.valueOf(200));
		cta1.setTipo("ahorros");
		cta1.setPropietario(p1);

		CuentaBancaria cta2 = new CuentaBancaria();
		cta2.setNumero("222");
		cta2.setSaldo(BigDecimal.valueOf(100));
		cta2.setTipo("corriente");
		cta2.setPropietario(p2);

		this.bancariaService.guardar(cta2);
		this.bancariaService.guardar(cta1);
		this.iTrasnferenciaService.realizar("111", "222", BigDecimal.valueOf(20));
		
	}

}
