package org.iesalandalus.programacion.damas.modelo;

public enum Color {
	
	BLANCO("Blanco"),NEGRO("Negro");
	
	public String cadenaAMostrar;
	
	private Color (String cadenaAMostrar) {	
		this.cadenaAMostrar=cadenaAMostrar;	
	}
	
	public String toString() {	
		return cadenaAMostrar;
	}

}
