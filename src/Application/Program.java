package Application;

import java.util.Locale;
import java.util.Scanner;

import Entities.Atleta;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.print("Qual a quantidade de atletas? ");
		int n = sc.nextInt();
		
		Atleta[] atleta = new Atleta[n];
		double somaPeso = 0.0, 
				mediaPeso = 0.0, 
				porcentagemHomens = 0.0, 
				alturaMediaMulheres = 0.0, 
				somaAlturaMulheres = 0.0,
				maior = 0.0;
		
		String maisAlto = "";
		int contHomens = 0;
		int contMulheres = 0;
		
		for(int i = 0; i < atleta.length; i++) {
			System.out.println("Digite os dados do atleta numero " + (i +1) + ":");
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Sexo: ");
			char sexo = sc.next().charAt(0);
			
			while(sexo != 'm' && sexo != 'f') {
				System.out.print("Valor inválido! Favor digitar F ou M: ");
				sexo = sc.next().charAt(0);
			}
			
			
			
			System.out.print("Altura: ");
			double altura = sc.nextDouble();
			
			while(altura <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				altura = sc.nextDouble();
			}
					
			System.out.print("Peso: ");
			double peso = sc.nextDouble();
			
			while(peso <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				peso = sc.nextDouble();
			}
			
			if(sexo == 'm') {
				contHomens++;
			}else if(sexo == 'f') {
				contMulheres++;
			}
			
			atleta[i] = new Atleta(nome, sexo, altura, peso);
			somaPeso += atleta[i].getPeso();
			
			if(atleta[i].getAltura() > maior) {
				maior = atleta[i].getAltura();
				maisAlto = atleta[i].getNome();
			}
			
			if(sexo == 'f') {
				somaAlturaMulheres += atleta[i].getAltura();
			}
		}
		
		System.out.println("RELATÓRIO: ");
		mediaPeso = somaPeso / n;
		System.out.printf("Peso médio dos atletas: %.2f%n", mediaPeso);		
		System.out.printf("Atleta mais alto: %s%n", maisAlto);
		porcentagemHomens = (contHomens / n) * 100.0;
		System.out.printf("Porcentagem dos homens: %.2f %%%n", porcentagemHomens);
		alturaMediaMulheres = somaAlturaMulheres / contMulheres;
		System.out.printf("Altura média das mulheres: %.2f%n", alturaMediaMulheres);
		
		sc.close();
	}

}
