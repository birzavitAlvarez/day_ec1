package com.day.day;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Dia;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class DiaRepository {
	private static final Map<String, Dia> dias = new HashMap<>();

	@PostConstruct
	public void initData() {
		Dia lunes = new Dia();
		lunes.setName("lunes");
		lunes.setTraduccion("monday");
		dias.put(lunes.getName(), lunes);
        
        Dia martes = new Dia();
		martes.setName("martes");
		martes.setTraduccion("tuesday");
		dias.put(martes.getName(), martes);

        Dia miercoles = new Dia();
		miercoles.setName("miercoles");
		miercoles.setTraduccion("wednesday");
		dias.put(miercoles.getName(), miercoles);

        Dia jueves = new Dia();
		jueves.setName("jueves");
		jueves.setTraduccion("thursday");
		dias.put(jueves.getName(), jueves);

        Dia viernes = new Dia();
		viernes.setName("viernes");
		viernes.setTraduccion("friday");
		dias.put(viernes.getName(), viernes);

        Dia sabado = new Dia();
		sabado.setName("sabado");
		sabado.setTraduccion("saturday");
		dias.put(sabado.getName(), sabado);

        Dia domingo = new Dia();
		domingo.setName("domingo");
		domingo.setTraduccion("sunday");
		dias.put(domingo.getName(), domingo);
		

	}

	public Dia findDia(String name) {
		Assert.notNull(name, "The day's name must not be null");
		return dias.get(name);
	}
}