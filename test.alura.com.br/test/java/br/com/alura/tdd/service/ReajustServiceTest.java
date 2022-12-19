package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.security.Provider.Service;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajustServiceTest {
	
	private ReajustService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		System.out.println("Início");
		this.service = new ReajustService();
		this.funcionario = new Funcionario("Vinicius", LocalDate.now(), new BigDecimal("1200.00"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("FIM");
	}
	
	@BeforeAll 
	public static void antesDeTodos() {
		System.out.println("Começo");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("Fim de todos");
	}

	@Test
	public void reajusteQuandoForTresPorCento() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1236.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteQuandoForQuinzePorCento() {		
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1380.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteQuandoForVintePorCento() {		
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1440.00"), funcionario.getSalario());
	}
}
	

