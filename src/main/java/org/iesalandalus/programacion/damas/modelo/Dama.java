package org.iesalandalus.programacion.damas.modelo;

import java.util.Random;

import javax.naming.OperationNotSupportedException;

public class Dama {

	private Color color;
	private Posicion posicion;
	private boolean esDamaEspecial=false;





	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		if(color!=null) {this.color = color;
		}else {
			throw new NullPointerException ("Error: El color no puede ser nulo");
		}
	}


	public Posicion getPosicion() {
		return posicion;
	}


	public void setPosicion(Posicion posicion) {
		if(posicion!=null) {this.posicion = posicion;
		}else {
			throw new NullPointerException ("Error: El posicion no puede ser nulo");
		}
	}



	public Dama() {

		this.color=Color.BLANCO;
		this.esDamaEspecial=false;
		this.posicion=crearPosicionInicial();

	}


	public Dama(Color color) {


		if(color!=null) {
			this.color=color;
			this.esDamaEspecial=false;
			this.posicion=crearPosicionInicial();

		}else {
			throw new NullPointerException("ERROR: El color no puede ser nulo.");
		}

	}


	private Posicion crearPosicionInicial() {
		char columnaAleatoria=' ';
		int numeroAleatorio=0;
		int filaAleatoria=0;
		Random random = new Random();

		if (color.equals(Color.NEGRO)) {

			filaAleatoria = random.nextInt(3) + 6;
			if (filaAleatoria % 2 != 0) {
				numeroAleatorio = random.nextInt(4) + 1;
				switch (numeroAleatorio) {
					case 1:
						columnaAleatoria = 'a';
						break;
					case 2:
						columnaAleatoria = 'c';
						break;
					case 3:
						columnaAleatoria = 'e';
						break;
					case 4:
						columnaAleatoria = 'g';
						break;
					default:
						columnaAleatoria = 'a';
						break;
				}
				return new Posicion(filaAleatoria, columnaAleatoria);
			} else {
				numeroAleatorio = random.nextInt(4) + 1;
				switch (numeroAleatorio) {
					case 1:
						columnaAleatoria = 'b';
						break;
					case 2:
						columnaAleatoria = 'd';
						break;
					case 3:
						columnaAleatoria = 'f';
						break;
					case 4:
						columnaAleatoria = 'h';
						break;
					default:
						columnaAleatoria = 'a';
						break;
				}
				return new Posicion(filaAleatoria, columnaAleatoria);
			}
		} else {

			filaAleatoria = random.nextInt(3) + 1;
			if (filaAleatoria % 2 != 0) {
				numeroAleatorio = random.nextInt(4) + 1;
				switch (numeroAleatorio) {
					case 1:
						columnaAleatoria = 'a';
						break;
					case 2:
						columnaAleatoria = 'c';
						break;
					case 3:
						columnaAleatoria = 'e';
						break;
					case 4:
						columnaAleatoria = 'g';
						break;
					default:
						columnaAleatoria = 'a';
						break;
				}
				return new Posicion(filaAleatoria, columnaAleatoria);
			} else {
				numeroAleatorio = random.nextInt(4) + 1;
				switch (numeroAleatorio) {
					case 1:
						columnaAleatoria = 'b';
						break;
					case 2:
						columnaAleatoria = 'd';
						break;
					case 3:
						columnaAleatoria = 'f';
						break;
					case 4:
						columnaAleatoria = 'h';
						break;
					default:
						columnaAleatoria = 'a';
						break;
				}
				return new Posicion(filaAleatoria, columnaAleatoria);

			}
		}
	}


		public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {

			if (direccion == null) {
				throw new NullPointerException("ERROR: La dirección no puede ser nula.");
			}

			if (pasos < 1) {
				throw new IllegalArgumentException("ERROR: El número de pasos debe ser mayor o igual que 1.");
			}


			if (!esDamaEspecial && pasos != 1) {
				throw new OperationNotSupportedException("ERROR: Las damas normales solo se pueden mover 1 casilla.");
			}


			if (!esDamaEspecial) {
				if (color.equals(Color.BLANCO) && !(direccion == Direccion.NORESTE || direccion == Direccion.NOROESTE)) {
					throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
				} else if (color.equals(Color.NEGRO) && !(direccion == Direccion.SURESTE || direccion == Direccion.SUROESTE)) {
					throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
				}
			}


			int nuevaFila = posicion.getFila();
			char nuevaColumna = posicion.getColumna();

			for (int i = 0; i < pasos; i++) {
				switch (direccion) {
					case NORESTE:
						nuevaFila++;
						nuevaColumna++;
						break;
					case NOROESTE:
						nuevaFila++;
						nuevaColumna--;
						break;
					case SURESTE:
						nuevaFila--;
						nuevaColumna++;
						break;
					case SUROESTE:
						nuevaFila--;
						nuevaColumna--;
						break;
				}


				if (nuevaFila < 1 || nuevaFila > 8 || nuevaColumna < 'a' || nuevaColumna > 'h') {
					throw new IllegalArgumentException("ERROR: Movimiento fuera de los límites del tablero.");
				}
			}


			this.posicion = new Posicion(nuevaFila, nuevaColumna);


			if (!esDamaEspecial) {
				if ((color == Color.BLANCO && nuevaFila == 8) || (color == Color.NEGRO && nuevaFila == 1)) {
					esDamaEspecial = true;
				}
			}
		}
	@Override
	public String toString() {
		return "color="+ color + ", posicion=(fila=" + posicion.getFila() + ", columna="+posicion.getColumna()+")";
	}
	
	
		
		
				
}
