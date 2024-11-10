package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

public class Posicion {
	
	private int fila;
	private char columna;
	
	
	public int getFila() {
		return fila;
	}
	
	public void setFila(int fila) {
		if (fila>=1 && fila<=8) {
			this.fila = fila;
		}else {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		}

	}
	
	public char getColumna() {
		return columna;
	}
	
	public void setColumna(char columna) {
		if(columna>='a' && columna<='h') {
			this.columna = columna;
			}else {
				throw new IllegalArgumentException("ERROR: Columna no válida.");	
			}
	}
	
	public Posicion (int fila, char columna){
		setFila(fila);
		setColumna(columna);
	}
	
	public Posicion (Posicion posicion) {
		if (posicion!=null) {
		setFila(posicion.getFila());
		setColumna(posicion.getColumna());
		}else {
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}

	@Override
	public String toString() {
		return "fila=" + fila + ", columna=" + columna;
	}
	
	

}
