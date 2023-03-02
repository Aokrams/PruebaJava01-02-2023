package com.prueba1.prueba1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prueba1.prueba1.models.Alumno;
import com.prueba1.prueba1.models.Curso;


@SpringBootApplication
public class Prueba1Application {


	// CASO PRACTICO

	// 1 = crear los objetos profesor, curso, alumno
	// 2 = pedir los datos de curso (guardarlos en el objeto curso)
	// 3 = pedir las notas de los estudiantes (guardarlos en el objeto alumno)
	// 4 = corroborar que los valores ingresados sean validos
	// 5 = crear la funcion para sacar los promedios, la nota mas alta, la mas baja, y el promedio del curso
	// 6 = crear el menu con las opciones parq eu el usuario pueda interacturar

	// funcion para sacar el promedio de cada nota
	public static double promedioNotasAlumno(ArrayList <Double> notas){
		double nota = 0;
		for ( int i = 0; i < notas.size(); i++){
			nota = nota + notas.get(i);
		}
		return nota / notas.size();
	}

	// funcion para sacar la mejor nota
	// conparo un numero bajo con todas los promedios y saco el mas alto
	public static double mejorNota(int cantidadAlumnos, ArrayList <Double> promediosJuntos){
		double mayor = 0;
		for ( int x = 0; x < promediosJuntos.size(); x++){
			if (promediosJuntos.get(x) > mayor) {
				mayor = promediosJuntos.get(x);
			}
		}
		return mayor;
	}

	// funcion para sacar la peor nota
	// comparo un numero alto con todas las notas y saco la mas baja
	public static Double peorNota(int cantidadAlumnos, ArrayList <Double> promediosJuntos){
		double menor = 7;
		for ( int x = 0; x < promediosJuntos.size(); x++){
			if (promediosJuntos.get(x) < menor) {
				menor = promediosJuntos.get(x);
			}
		}
		return menor;
	}




	public static void main(String[] args) {

		// defino las variable que ocupare mas adelante
		Scanner teclado = new Scanner(System.in);
		HashMap <String, ArrayList<Double>> alumnosNotas = new HashMap<String, ArrayList<Double>>();
		Alumno alumnoDefault = new Alumno();
		Curso cursoDefault = new Curso();
		int canAlum;

		// ingreso el nombre del profesor al objeto curso
		System.out.println("Ingrese el nombre del profesor");
		cursoDefault.setNombre(teclado.nextLine());

		// ingreso el nombre del curso al obejto curso
		System.out.println("Ingrese el nombre del curso");
		cursoDefault.setNombreCurso(teclado.nextLine());

		// me aseguro de que sea un numero valido
		do {
			System.out.println("Ingrese la cantidad de alumnos en el curso");
			canAlum = teclado.nextInt();
			if (canAlum <= 0){
				System.out.println("Vuelva a ingresar un numero valido");
			}
		}while (canAlum <= 0);
		
		// ingreso la cantidad de alumnos al objeto curso
		cursoDefault.setCantAlumnosCurso(canAlum);
		
		
		
		

		// defino un array donde iran todos los alumnos
		ArrayList <Alumno> todosAlumnos = new ArrayList<Alumno>();
		for ( int i = 1; i <= canAlum; i++){
			
			alumnoDefault = new Alumno();
			ArrayList <Double> notasAlumno = new ArrayList<Double>();

			System.out.println("Ingrese el nombre del alumno");
			teclado.nextLine();
			String nomAlu = teclado.nextLine();
			alumnoDefault.setNombreAlumno(nomAlu);

			System.out.println("Ingrese la materia del alumno " + alumnoDefault.getNombreAlumno());
			alumnoDefault.setMateria(teclado.nextLine());

			int cantidadNotas;
			do{
				System.out.println("Ingrese cuantas notas tendra en esta materia");
				cantidadNotas = teclado.nextInt();
				if(cantidadNotas <= 0){
					System.out.println("Vuelva a ingresar un numero valido");
				}
			}while (cantidadNotas <= 0);
			
			
			// hago que ingrese las notas en un hashmap 
			for ( int y = 1; y <= cantidadNotas; y++){
				Double nota;
				do{
					System.out.print("Ingresa nota " + y + " del alumno "+ alumnoDefault.getNombreAlumno() +": ");
					nota = teclado.nextDouble();
					if(nota < 1 || nota > 7){
						System.out.println("Vuelva a ingresar un numero valido");
					}
				}while (nota < 1 || nota > 7);

				notasAlumno.add(nota);
				alumnoDefault.setNotas(notasAlumno);
			}
			alumnosNotas.put(nomAlu, notasAlumno);
			System.out.println("Los datos han sido ingresados");
			todosAlumnos.add(alumnoDefault);

		}
		// muestro en pantalla el curso y sus alumnos
		System.out.println(cursoDefault);
		System.out.println(todosAlumnos);
		


		// empiezo con el menu que dara opciones
		// opcion es 1 para que se pueda ejecutar
		int opcion = 1;
		while (opcion != 0){
			do{
				System.out.println("------------- Menu :3 -------------");
				System.out.println("Ingrese 1 si quiere saber el promedio de cada estudiante");
				System.out.println("Ingrese 2 si quiere saber cual es la mejor nota");
				System.out.println("Ingrese 3 si quiere saber cual es la peor nota");
				System.out.println("Ingrese 4 si quiere saber cual es el promedio general del curso");
				System.out.println("Ingrese 0 si quiere salir del menu");
				System.out.println("");
				opcion = teclado.nextInt();
			} while (opcion < 0 || opcion > 4);

			// si presiona 1 se iniciara la funcion que dara el promedio de los alumnos
			if (opcion == 1){
				for (String i : alumnosNotas.keySet()){
					Double promedioAlumno = promedioNotasAlumno(alumnosNotas.get(i));
					System.out.println("El promedio del alumno " + i + " es de:" + promedioAlumno);
				}
			}
			// si presiona 2 se iniciara la funcion que dara la mejor nota
			else if (opcion == 2){
				// aqui crea un array de los promedios para que luego busque cual es el mas alto con la funcion
				ArrayList <Double> promediosTodos = new ArrayList<Double>();
				for ( String i : alumnosNotas.keySet()){
					promediosTodos.add(promedioNotasAlumno(alumnosNotas.get(i)));
				}
				System.out.println("La mejor nota es: " + mejorNota(canAlum, promediosTodos));
			}
			// si presiona 3 se iniciara la funcion que dara la peor nota
			else if (opcion == 3){
				// aqui crea un array de los promedios para que luego busque cual es el mas bajo con la funcion
				ArrayList <Double> promediosTodos = new ArrayList<Double>();
				for ( String i : alumnosNotas.keySet()){
					promediosTodos.add(promedioNotasAlumno(alumnosNotas.get(i)));
				}
				System.out.println("La peor nota es: " + peorNota(canAlum, promediosTodos));
			}
			// si presiona 4 se iniciara la funcion que dara el romedio de todos los alumnos
			else if (opcion == 4){
				// aqui crea un array de los promedios para que luego saque el promedio
				ArrayList <Double> promediosTodos = new ArrayList<Double>();
				for ( String i : alumnosNotas.keySet()){
					promediosTodos.add(promedioNotasAlumno(alumnosNotas.get(i)));
				}
				double suma = 0;
				for ( int i = 0; i < promediosTodos.size(); i++){
					suma = suma + promediosTodos.get(i);
				}
				double promedioGeneral = suma / promediosTodos.size();
				System.out.println("El promedio general es: " + promedioGeneral);
			}
			// si presiona 0 el menu se cerrara 
			else {
				System.out.println("Hasta la proxima");
			}
			}

		}




		



	
}
	


