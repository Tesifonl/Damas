package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Dama;

public class MainApp {
	
	private static Dama dama;
	
	private static void ejecutarOpcion(int opcion) {
		
		switch(opcion) {
		case 1:
			creaDamaDefecto();
		break;
		case 2:
			crearDamaColor();
		break;
		case 3:
			mover();
		break;
		case 4:
			Consola.despedirse();
		break;
		}
	}
	
	private static void creaDamaDefecto() {
		 
		try{ 
			dama=new Dama();
			System.out.println("Dama creada con exito:  "+dama.toString());
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void crearDamaColor () {
		
		Color colorEleccion=Consola.elegirColor();
		
		try{
			dama=new Dama(colorEleccion);
			System.out.println("Dama creada con exito:  "+dama.toString());
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void mover() {
		
		if (dama!=null){
			Direccion direccionEleccion=Consola.elegirDireccion();
			int pasosEleccion=Consola.elegirPasos();
	
			try {
				dama.mover(direccionEleccion, pasosEleccion);
				System.out.println("Movimiento realizado con exito:  "+dama.getColor()+" , "+dama.getPosicion());
			} catch (IllegalArgumentException | OperationNotSupportedException |NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}else{
			System.out.println("Debes crear antes la dama");
		}

	}	
	
	private static void mostrarDama() {
		
		if (!dama.equals(null)) {
			System.out.println("la dama creada es "+dama.toString());
		}else {
			System.out.println("La dama no esta creada, cree una antes de comenzar a moverla ");
		}
	}
	
	public static void main (String[]arg) {
		
		int opcion;
		
		do {
			opcion=Consola.elegirOpcionMenu();
			ejecutarOpcion(opcion);
					
		}while(opcion!=4);
		
	}
}
