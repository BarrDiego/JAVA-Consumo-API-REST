package com.MyOrg.WSApp.client;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import com.MyOrg.WSApp.model.CityWeather;

import com.google.gson.Gson;




public class ApiClient {
	
	private static final String keyApi = "[YOUR_API_KEY]";
	private static final String URL_BASE =
			"https://api.openweathermap.org/data/2.5/weather?q=London&appid="+keyApi;
	
	//metodo para obtener respuesta generica
	public static String getData() {
		
		Client client = ClientBuilder.newClient();
		WebTarget wt = client.target(URL_BASE);
		
		Response resp = wt.request().get();
		String respuesta = resp.readEntity(String.class);
		return respuesta;
		
		
	}
	
	//asignamos la sobrecarga a la url con las ciudades elegidas por el usuario y hacemos el llamado	
	public static String getDataFromUser(CityWeather cw) {
		
		 String URL_BASE_Charged =
				"https://api.openweathermap.org/data/2.5/weather?q="+cw.getCity()+","+cw.getState()+","+cw.getCountry()+"&appid="+keyApi;
		 Client cl = ClientBuilder.newClient();
		 WebTarget wt = cl.target(URL_BASE_Charged);
		 
		 Response resp = wt.request().get();
		 String respuesta = resp.readEntity(String.class);
		
		return respuesta;
	}
	
	
	
	
public static void main(String[] args)  {
	
		//Verificacion por consola que el backend funciona
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese ciudad:");
		String ciudad = scan.nextLine();
		System.out.println("Ingrese provincia:");
		String provincia = scan.nextLine();
		System.out.println("Ingrese pais");
		String pais = scan.next();
		
		CityWeather cityWeather = new CityWeather(ciudad,provincia,pais);		
		
		System.out.println(getDataFromUser(cityWeather));
	}


}
