package org.iesalandalus.programacion.damas.modelo;

import java.util.Random;

import javax.naming.OperationNotSupportedException;

public class Dama {

		private Color color;
		private Posicion posicion;
		private boolean esDamaEspecial=false;
		int pasos=0;
		
		
		public Color getColor() {
			return color;
		}
		
		
		public void setColor(Color color) {
			if(color!=null) {this.color = color;
			}else {
				throw new IllegalArgumentException ("El color no puede ser nulo");
			}
		}
		
		
		public Posicion getPosicion() {
			return posicion;
		}
		
		
		public void setPosicion(Posicion posicion) {
			if(posicion!=null) {this.posicion = posicion;
			}else {
				throw new IllegalArgumentException ("El posicion no puede ser nulo");
			}
		}
		
		
		
		public Dama() {
			
			int filaAleatoria;
			char columnaAleatoria;
			Posicion posicionInicial;
			Random random=new Random();
			int numeroAleatorio;
			

			
			filaAleatoria=random.nextInt(3)+1;
			if(filaAleatoria%2!=0) {
				numeroAleatorio=random.nextInt(4)+1;
				switch(numeroAleatorio) {
					case 1:
						columnaAleatoria='a';
					break;
					case 2:
						columnaAleatoria='c';
					break;
					case 3:
						columnaAleatoria='e';
					break;
					case 4:
						columnaAleatoria='g';
					break;
					default:
						columnaAleatoria='a';
					break;
					}
			}else{
					
					numeroAleatorio=random.nextInt(4)+1;
					switch(numeroAleatorio) {
						case 1:
							columnaAleatoria='b';
						break;
						case 2:
							columnaAleatoria='d';
						break;
						case 3:
							columnaAleatoria='f';
						break;
						case 4:
							columnaAleatoria='h';
						break;
						default:
							columnaAleatoria='a';
						break;
					}
			}
			this.color=Color.BLANCO;
			this.esDamaEspecial=false;
			this.posicion=new Posicion (filaAleatoria,columnaAleatoria);
			
		}
		
		
		public Dama(Color color) {
			
			int filaAleatoria;
			char columnaAleatoria;
			Posicion posicionInicial;
			Random random=new Random();
			int numeroAleatorio;
			
			
			if(color!=null) {
				
				this.color=color;
				this.esDamaEspecial=false;
			
				
				if (color.equals(Color.BLANCO)) {	
					posicionInicial=crearPosicionInicial();
					filaAleatoria=random.nextInt(3)+1;
					posicionInicial.setFila(filaAleatoria);
					
					
				}else {
					posicionInicial=crearPosicionInicial();
					filaAleatoria=random.nextInt(3)+6;
					posicionInicial.setFila(filaAleatoria);
				
				}
				
				if(filaAleatoria%2!=0) {
					numeroAleatorio=random.nextInt(4)+1;
					switch(numeroAleatorio) {
						case 1:
							columnaAleatoria='a';
						break;
						case 2:
							columnaAleatoria='c';
						break;
						case 3:
							columnaAleatoria='e';
						break;
						case 4:
							columnaAleatoria='g';
						break;
						default:
							columnaAleatoria='a';
						break;
					}
					posicionInicial.setColumna(columnaAleatoria);
					
				}else {
					numeroAleatorio=random.nextInt(4)+1;
					switch(numeroAleatorio) {
						case 1:
							columnaAleatoria='b';
						break;
						case 2:
							columnaAleatoria='d';
						break;
						case 3:
							columnaAleatoria='f';
						break;
						case 4:
							columnaAleatoria='h';
						break;
						default:
							columnaAleatoria='a';
						break;
					}
					posicionInicial.setColumna(columnaAleatoria);
				}
			}else {
				throw new NullPointerException("ERROR: El color no puede ser nulo.");
			}
			
		}
		
		
		private Posicion crearPosicionInicial() {
			
			this.posicion=new Posicion(4,'d');
			
			return posicion;
			
		}
		
		public void mover(Direccion direccion,int pasos) throws OperationNotSupportedException  {
			
			if (pasos<1 || pasos>8) {
				throw new NullPointerException ("Error direccion nula");
			}else if(esDamaEspecial==false && pasos>1){
				throw new OperationNotSupportedException ("ERROR: Las damas normales solo se pueden mover 1 casilla.");
			}else {this.pasos=pasos;}
			
			
			
			
			if (direccion!=null) {
				
				if(esDamaEspecial==false) {
					
					if (color.equals(Color.BLANCO)) {
						
						
						if(direccion.equals(Direccion.NORESTE)){
							posicion.setFila(posicion.getFila()+1);
							posicion.setColumna((char)(posicion.getColumna()+1));
							if(posicion.getFila()==8) {
								esDamaEspecial=true;
								System.out.println("Dama especial");
							}
						}
							
						if(direccion.equals(Direccion.NOROESTE)) {
							posicion.setFila(posicion.getFila()+1);
							posicion.setColumna((char)(posicion.getColumna()-1));
							if(posicion.getFila()==8) {
								esDamaEspecial=true;
								System.out.println("Dama especial");
							}
						}
						
						if(direccion.equals(Direccion.SURESTE)||(direccion.equals(Direccion.SUROESTE))){
							throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
							}
						}
					
					if (color.equals(Color.NEGRO)) {
						
						
						if(direccion.equals(Direccion.SURESTE)){
							posicion.setFila(posicion.getFila()-1);
							posicion.setColumna((char)(posicion.getColumna()+1));
							if(posicion.getFila()==1) {
								esDamaEspecial=true;
							}
						}
							
						if(direccion.equals(Direccion.SUROESTE)) {
							posicion.setFila(posicion.getFila()-1);
							posicion.setColumna((char)(posicion.getColumna()-1));
							if(posicion.getFila()==1) {
								esDamaEspecial=true;
							}
						}
						
						if(direccion.equals(Direccion.NOROESTE)||(direccion.equals(Direccion.NORESTE))){
							throw new OperationNotSupportedException("ERROR: Movimiento no permitido.");
							}
						}
					
				}else {
						
						if(direccion.equals(Direccion.NORESTE)){
							posicion.setFila(posicion.getFila()+pasos);
							posicion.setColumna((char)(posicion.getColumna()+pasos));
							}
						if(direccion.equals(Direccion.NOROESTE)) {
							posicion.setFila(posicion.getFila()+pasos);
							posicion.setColumna((char)(posicion.getColumna()-pasos));
							}
						if(direccion.equals(Direccion.SURESTE)) {
							posicion.setFila(posicion.getFila()-pasos);
							posicion.setColumna((char)(posicion.getColumna()+pasos));
							}
						if (direccion.equals(Direccion.SUROESTE)){
							posicion.setFila(posicion.getFila()-pasos);
							posicion.setColumna((char)(posicion.getColumna()-pasos));
							}		
					}
			}else {
				throw new NullPointerException ("ERROR: La dirección no puede ser nula.");
				}		
				
			}
	

		@Override
		public String toString() {
			return "color=" + color + ", posicion=(fila=" + posicion.getFila() + ", columna="+posicion.getColumna()+")";
		}
		
		
		
		
				
}
