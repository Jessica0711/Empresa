package br.com.contmatic.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import br.com.contmatic.model.empresa.Funcionario;

@FixMethodOrder(NAME_ASCENDING)
public class FuncionarioTest {
	private Funcionario funcionario;

	@BeforeClass
	public static void setUp_before_class() {
		System.out.println("Iniando os teste para a classe Funcionario");
	}

	@Before
	public void setUp() {
		String nome = "Maria Silva";
		BigDecimal salario = new BigDecimal("1500.00");
		String cargo = "Vendedora";
		String cpf = "475.614.488-80";
		funcionario = new Funcionario(nome, cpf, salario, cargo);
	}

	@Test
	public void should_return_true_to_nome_not_null() {
		assertNotNull(funcionario.getNome());
	}

	@Test
	public void should_return_true_to_salario_not_null() {
		assertNotNull(funcionario.getSalario());
	}

	@Test
	public void should_return_true_to_cargo_is_not_null() {
		assertNotNull(funcionario.getCargo());
	}

	@Test
	public void should_return_true_to_cpf_is_not_null() {
		assertNotNull(funcionario.getCPF());
	}

	@Test
	public void shuld_return_true_to_correct_input_nome() {
		assertThat(funcionario.getNome(), is("Maria Silva"));
	}

	@Test
	public void shuld_return_false_to_wrong_input_nome() {
		assertThat(funcionario.getNome(), not("Maria Santos"));
	}

	@Test
	public void should_return_true_to_correct_input_salario() {
		assertTrue(funcionario.getSalario().compareTo(BigDecimal.valueOf(1500.00))==0);
	}

	@Test
	public void should_return_false_to_wrong_input_salario() {
		assertFalse(funcionario.getSalario().compareTo(BigDecimal.valueOf(1550.00))==0);
	}

	@Test
	public void should_return_true_to_correct_input_cargo() {
		assertThat(funcionario.getCargo(), is("Vendedora"));
	}

	@Test
	public void should_return_false_to_wrong_input_cargo() {
		assertThat(funcionario.getCargo(), not("Gerente"));
	}

	@Test
	public void should_return_true_to_correct_input_cpf() {
		assertThat(funcionario.getCPF(), is("475.614.488-80"));
	}

	@Test
	public void should_return_true_to_hashcode_with_same_funcionario() {
		Funcionario outroFuncionario = new Funcionario("Maria Silva", "475.614.488-80", BigDecimal.valueOf(1500.00), "Vendedora");
		assertEquals(funcionario.hashCode(), outroFuncionario.hashCode());
	}

	@Test
	public void should_return_false_to_hashcode_with_different_funcionario() {
		Funcionario outroFuncionario = new Funcionario("Maria Silva", "574.614.488-80", BigDecimal.valueOf(1500.00), "Gerente");
		assertFalse(funcionario.hashCode() == outroFuncionario.hashCode());
	}

	@Test
	public void should_return_false_when_hashcode_compare_with_a_null_cpf() {
		Funcionario outroFuncionario = new Funcionario("Maria Silva", null, BigDecimal.valueOf(1500.00), "Gerente");
		assertFalse(funcionario.hashCode() == outroFuncionario.hashCode());
	}

	@Test
	public void should_return_true_to_equals_with_same_funcionario() {
		Funcionario outroFuncionario = new Funcionario("Maria Silva", "475.614.488-80", BigDecimal.valueOf(1500.00), "Vendedora");
		assertTrue(funcionario.equals(outroFuncionario));
	}

	@Test
	public void should_return_false_with_equals_different_funcionario() {
		Funcionario outroFuncionario = new Funcionario("Maria Silva", "574.614.488-80", BigDecimal.valueOf(1550.00), "Vendedora");
		assertFalse(funcionario.equals(outroFuncionario));
	}

	@Test
	public void should_return_false_to_equals_with_a_null_cpf() {
		Funcionario outroFuncionario = new Funcionario("Maria Silva", null, BigDecimal.valueOf(1500.00), "Vendedora");
		assertFalse(funcionario.equals(outroFuncionario));
	}

	@Test
	public void should_return_true_to_equals_with_same_object() {
		assertTrue(funcionario.equals(funcionario));
	}

	@Test
	public void should_return_false_when_equals_compare_class_with_a_number() {
		assertFalse(funcionario.equals(new Object()));
	}

	@Test
	public void should_return_true_when_equals_with_two_cpf_null() {
		Funcionario funcionario01 = new Funcionario("João Santos", null, null, "Vendedora");
		Funcionario funcionario02 = new Funcionario("Maria Silva", null, null, "Vendedora");
		assertTrue(funcionario01.equals(funcionario02));
	}

	@Test
	public void should_return_true_if_tostring_contains_nome() {
		assertThat(funcionario.toString(), containsString("Funcionario(a)"));
	}

	@Test
	public void should_return_true_if_tostring_contains_cpf() {
		assertThat(funcionario.toString(), containsString("CPF"));
	}

	@Test
	public void should_return_true_if_tostring_contains_cargo() {
		assertThat(funcionario.toString(), containsString("cargo"));
	}

	@Test
	public void should_return_true_if_tostring_contains_salario() {
		assertThat(funcionario.toString(), containsString("salario"));
	}

	@Test
	public void should_return_false_when_equal_compare_a_different_name() {
		assertFalse(funcionario.getNome().equals("João"));
	}

	@Test
	public void should_return_false_when_equals_compare_a_class_null() {
		assertFalse(funcionario.equals(null));
	}

	@Test
	public void should_return_false_when_equals_compare_with_another_null_class() {
		Funcionario outroFuncionario = null;
		assertFalse(funcionario.equals(outroFuncionario));
	}

	@Test
	public void should_return_false_when_equals_compare_null_cpf() {
		Funcionario outro_funcionario = new Funcionario("Maria Silva", null, null, "Vendedora");
		assertFalse(funcionario.getCPF().equals(outro_funcionario.getCPF()));
	}
	
	@Test
	public void should_return_false_to_equals_from_a_null_cpf() {
		Funcionario outroFuncionario = new Funcionario("Maria Silva", null, null, "Vendedora");
		assertFalse(outroFuncionario.equals(funcionario));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_name_is_null() {
		funcionario.setNome(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_name_is_empty() {
		funcionario.setNome("  ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_cargo_is_null() {
		funcionario.setCargo(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_cargo_is_empty() {
		funcionario.setCargo("  ");
	}

	@After
	public void tearDown() {
		funcionario = null;
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Finalizado os teste para a classe Funcionario");
	}
}