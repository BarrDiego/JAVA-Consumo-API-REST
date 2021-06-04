package com.MyOrg.WSApp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.MyOrg.WSApp.client.ApiClient;
import com.MyOrg.WSApp.model.CityWeather;

@Controller
public class CityController {
	
	@RequestMapping(value="/mi_busqueda", method = RequestMethod.GET)
	public ModelAndView buscarCiudad(HttpServletRequest req, HttpServletResponse res) {
		
		ModelAndView mav = new ModelAndView("mi_busqueda");
		mav.addObject("cityWeather", new CityWeather());
		
		return mav;
		
	}
	
	@RequestMapping(value="/mi_resultado", method = RequestMethod.POST)
	public ModelAndView devolverClima(@ModelAttribute("cityWeather") CityWeather cityWeather, HttpServletRequest req, HttpServletResponse res) {
		
		ModelAndView mav = null;
		
		String ciudad = cityWeather.getCity();
		String provincia = cityWeather.getState();
		String pais = cityWeather.getCountry();
		ApiClient ac =  new ApiClient();
		
		
		if(cityWeather != null) {
			
			mav = new ModelAndView("/mi_busqueda");
			mav.addObject("ciudad",ciudad);
			
			
		}
		
		
		return mav;
	}
	
	

}
