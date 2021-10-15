package br.com.codenation.calculadora;


public class CalculadoraSalario {
	public static void main(String[] args) {
		System.out.println(calcularSalarioLiquido(1031e99));
	}

	// CALCULANDO O VALOR LÍQUIDO ARREDONDADO
	public static long calcularSalarioLiquido(double salarioBase) {
		// System.out.println(salarioBase);
		double salarioInss = calcularInss(salarioBase);
		double salarioIrrf = calcularIrrf(salarioInss);
		return Math.round(salarioIrrf);
	}

	// DESCONTANDO O INSS
	private static double calcularInss(double salarioBase) {
		double salarioDescontado = salarioBase;

		if(salarioBase < 1039 || salarioBase < 0 || salarioBase > 1e10){
			salarioDescontado = 0;
		}

		if (salarioBase <= 1500 && salarioBase > 1039) {
			salarioDescontado = salarioBase - salarioBase*(0.08);
		}

		if (salarioBase > 1500 && salarioBase < 4000) {
			salarioDescontado = salarioBase - salarioBase*(0.09);
		}

		if (salarioBase > 4000 && salarioBase <= 1e10) {
			salarioDescontado = salarioBase - salarioBase*(0.11);
		}

		return salarioDescontado;
	}

	// DESCONTANDO O IRRF
	private static double calcularIrrf(double salarioDescontado) {
		double salarioLiq = salarioDescontado;

		if (salarioDescontado > 3000 && salarioDescontado <= 6000) {
			salarioLiq = salarioDescontado - salarioDescontado*(0.075);
		}

		if (salarioDescontado  > 6000) {
			salarioLiq = salarioDescontado  - salarioDescontado*(0.15);
		}

		return salarioLiq;
	}

}
