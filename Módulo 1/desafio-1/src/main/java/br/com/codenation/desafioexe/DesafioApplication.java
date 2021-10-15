package br.com.codenation.desafioexe;

import jdk.nashorn.internal.ir.Symbol;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static void main(String[] args) {
		// Parte 1
		System.out.println("Os primeiros números Integer da série de Fibonacci até 350 são" + fibonacci());

		//Parte 2
		int number = 14;
		System.out.println("O número " + number + " faz parte da sequência Fibonacci... " + isFibonacci(number));
	}
	// Integer valor que referencia um objeto que  o valor primitivo Int
	public static List<Integer> fibonacci() {
		// criar uma instância  a partir de uma interface List com o uso da classe ArrayList
		List<Integer> listFibonacci = new ArrayList<>();

		// declaração das variáveis
		int LIMIT = 350;
		int i = 0;
		int posicion = 1;

		// A sequência de Fibonacci começa sempre com 0 e 1;
		listFibonacci.add(0);
		listFibonacci.add(1);

		// CONTROLE DE FLUXO WHILE
		while(i < LIMIT){
			i = listFibonacci.get(posicion) + listFibonacci.get(posicion - 1);
			listFibonacci.add(i);
			posicion++;
		}

		return listFibonacci;
	}


	public static Boolean isFibonacci(Integer a) {
		int verify = fibonacci().indexOf(a);
		boolean isFibo = true;

		// CONTROLE DE FLUXO
		if(verify < 0){
			isFibo = false;
		}

		return isFibo;
	}

}