package com.carlosmtz.clienteJerseyTest;

import com.carlosmtz.clienteJerseyTest.beans.Empleado;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		getObjeto();
		getEntero();
		postObjecto();
	}

	public static void getObjeto() {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/getEmpleado");

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.getEntity(String.class);
		Empleado empleado = new Gson().fromJson(output, Empleado.class);

		System.out.println("Output from Server ....getObjeto \n");
		System.out.println(empleado);
	}

	public static void getEntero() {
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/getEdad");

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.getEntity(String.class);
		int entero = Integer.parseInt(output);

		System.out.println("Output from Server ....getEntero \n");
		System.out.println(entero);
	}

	public static void postObjecto() {
		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/postEmpleado");

		Empleado empleado = new Empleado("Donatello", 3);

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,
				new Gson().toJson(empleado));

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);
	}
}
