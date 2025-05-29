package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	private Consola() {
		
	}
	
	public static void mostrarMenu() {
		
		System.out.println("------------------------------------------------------------------- ");
		System.out.println("Puedes elegir entre las siguientes opciones");
		System.out.println("Opcion: 1- Crear dama por defecto");
		System.out.println("Opcion: 2- Crear dama eligiendo color");
		System.out.println("Opcion: 3- Mover");
		System.out.println("Opcion: 4- Salir");
	}
	

	public static int elegirOpcionMenu() {
		
		int opcion=0;
		
		do {
		mostrarMenu();
		opcion=Entrada.entero();
		}while(opcion<1 || opcion>4);
		return opcion;
	}
	
	
	public static Color elegirColor() {
		
		int opcion=0;
		Color colorElegido;
		
		do {
			System.out.println("Debe elegir un color de los siguientes opciones: ");
			System.out.println("Opcion: 1- Color Blanco");
			System.out.println("Opcion: 2- Color Negro");
			opcion=Entrada.entero();
		}while (opcion<1 || opcion>2);
		
		if (opcion==1) {	
			colorElegido=Color.BLANCO;			
		}else {
			colorElegido=Color.NEGRO;
		}		
		return colorElegido;
	} 
	
	
	public static void mostrarMenuDirecciones(){
		
		System.out.println("                                             ");
		System.out.println("Puedes elegir entre las siguientes opciones: ");
		System.out.println("Opcion: 1- Noreste");
		System.out.println("Opcion: 2- Noroeste");
		System.out.println("Opcion: 3- Suroeste");
		System.out.println("Opcion: 4- Sureste");
	}
	
	public static Direccion elegirDireccion() {
		int opcion=0;
		Direccion direccionElegida;
		
		do {
		mostrarMenuDirecciones();
		opcion=Entrada.entero();
		}while(opcion<1 || opcion>4);
		
		switch (opcion) {
			case 1:
				direccionElegida=Direccion.NORESTE;
			break;
			case 2:
				direccionElegida=Direccion.NOROESTE;
			break;
			case 3:
				direccionElegida=Direccion.SURESTE;
			break;
			case 4:
				direccionElegida=Direccion.SUROESTE;
			break;
			default:
				direccionElegida=Direccion.NORESTE;
			break;	
			
		}
		
		return direccionElegida;
	}
	
	
	public static int elegirPasos() {
		int pasos=0;
		
		do{System.out.println("Introduce el numero de casillas que deseas mover mayor a 1 y menor de 8 ");
		pasos=Entrada.entero();
		}while (pasos<1 || pasos>8);
				
		return pasos;
	}
	
	
	public static void despedirse() {
		System.out.println("Saludos ");
	}	
}
