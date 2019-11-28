package com.carlosmtz.wsjerseytest.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carlosmtz.wsjerseytest.beans.Empleado;

@RestController
public class JerseyTestController {

	@GetMapping("/getEmpleado")
	public Empleado getEmpleado() {
		return new Empleado("Carlos", 35);
	}
	
	@GetMapping("/getEdad")
	public int getEdad() {
		return 35;
	}
	
	@GetMapping("/getNombre")
	public String getNombre() {
		return "Carlos";
	}
	
	@PostMapping("postEmpleado")
	public int postEmpleado(@RequestBody Empleado empleado) {
		System.out.println(empleado);
		return 1;
	}

}
