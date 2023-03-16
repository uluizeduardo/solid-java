package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste{

	@Override
	public void validar(Funcionario funcionario, BigDecimal salario) {
		
		LocalDate dataUltimoAjuste = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		Long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoAjuste, dataAtual);
		
		if(mesesDesdeUltimoReajuste < 6) {
			throw new ValidacaoException("Não é possível reajutar valor em menos de 6 meses");
		}
		
	}
	

}
