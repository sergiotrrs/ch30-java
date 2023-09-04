package org.generation;

import java.util.ArrayList;

public class Sedes {
	String nombreSede;
	String pais;
	ArrayList< Participante > participantes;
	
	Sedes ( String nombre, String pais){
		this.nombreSede = nombre;
		this.pais = pais;
	}
	
	void agregarParticipante(Participante persona  ) {
		participantes.add( persona  );
	}
	
	String mostrarParticipantes() {	
		String textoCompleto = "";
		for (Participante participante : participantes) {
			textoCompleto += participante.detalles() + "\n";
		}
		return textoCompleto;
		
	}

}
