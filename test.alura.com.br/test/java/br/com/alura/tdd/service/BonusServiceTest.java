package br.com.alura.tdd.service;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionariosC0mSalarioMuitoAlto() {
		BonusService service = new BonusService();
		
		//maneira mais correta de service usar
		//assertThrows(IllegalArgumentException.class, 
			//() -> service.calcularBonus(new Funcionario("Vinicius Lemes", LocalDate.now(), new BigDecimal("25000"))));
		//aqui é se você quiser verificar se está vindo a mensagem
		try {
			service.calcularBonus(new Funcionario("Vinicius Lemes", LocalDate.now(), new BigDecimal("25000")));
			fail("Exception não lançada!");
		} catch (Exception e) {
			assertEquals("Funcionario a partir de R$10000 não recebe bonus!", e.getMessage());
		}
	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalrio() {
		BonusService service = new BonusService();
		BigDecimal bonus = service
				.calcularBonus(new Funcionario("Vinicius Lemes", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusSeForAte10000EParaDarCerto() {
		BonusService service = new BonusService();
		BigDecimal bonus = service
				.calcularBonus(new Funcionario("Vinicius Lemes", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

	@Test
	void bonusSeForAte600EParaDarCerto() {
		BonusService service = new BonusService();
		BigDecimal bonus = service
				.calcularBonus(new Funcionario("Victor Lemes de Oliveira", LocalDate.now(), new BigDecimal("600")));

		assertEquals(new BigDecimal("60.00"), bonus);
	}

	@Test
	void bonusSeForAte700EParaDarCerto() {
		BonusService service = new BonusService();
		BigDecimal bonus = service
				.calcularBonus(new Funcionario("Vinicius Lemes", LocalDate.now(), new BigDecimal("700")));

		assertEquals(new BigDecimal("70.00"), bonus);

	}

	@Test
	void bonusParaDarErrado() {
		BonusService service = new BonusService();
		BigDecimal bonus = service
				.calcularBonus(new Funcionario("Victor Lems", LocalDate.now(), new BigDecimal("800")));

		assertEquals(new BigDecimal("80.00"), bonus);
		System.out.println(bonus);
	}
}
