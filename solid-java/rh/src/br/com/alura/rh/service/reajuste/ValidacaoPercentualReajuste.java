package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste{

	@Override
	public void validar(Funcionario funcionario, BigDecimal salario) {
		
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = salario.divide(salarioAtual, RoundingMode.HALF_UP);
		
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste não pode ser superior a 40% do salário!");
		}
		
	}

	
}
