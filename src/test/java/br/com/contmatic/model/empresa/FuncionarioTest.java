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

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder(NAME_ASCENDING)
public class FuncionarioTest {
	private Funcionario funcionario;

	@BeforeClass
	public static void setUp_before_class() {
		System.out.println("Iniando os teste para a classe Funcionario");
	}

	@Before
	public void setUp() {
		funcionario = new Funcionario("Maria Silva", "47561448880", new BigDecimal("1500.00"), "Vendedora");
		funcionario.setDataAlteracao(DateTime.parse("2020-12-05"));
		funcionario.setDataCadastro(DateTime.parse("2020-12-05"));
		funcionario.setCriadoPor("jessica");
		funcionario.setIpCriadoPor("127.0.0.1");
		funcionario.setUltimaModificacao("jessica");
		funcionario.setIpUltimaModificacao("127.0.0.1");
	}

	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(funcionario.getNome());
		assertNotNull(funcionario.getSalario());
		assertNotNull(funcionario.getCargo());
		assertNotNull(funcionario.getCPF());
		assertNotNull(funcionario.getDataAlteracao());
		assertNotNull(funcionario.getDataCadastro());
		assertNotNull(funcionario.getCriadoPor());
		assertNotNull(funcionario.getUltimaModificacao());
		assertNotNull(funcionario.getIpCriadoPor());
		assertNotNull(funcionario.getIpUltimaModificacao());
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
		assertTrue(funcionario.getSalario().compareTo(BigDecimal.valueOf(1500.00)) == 0);
	}

	@Test
	public void should_return_false_to_wrong_input_salario() {
		assertFalse(funcionario.getSalario().compareTo(BigDecimal.valueOf(1550.00)) == 0);
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
		assertThat(funcionario.getCPF(), is("47561448880"));
	}

	@Test
	public void should_return_true_to_hashcode_with_same_funcionario() {
		Funcionario outroFuncionario = new Funcionario("Maria Silva", "47561448880", BigDecimal.valueOf(1500.00),
				"Vendedora");
		assertEquals(funcionario.hashCode(), outroFuncionario.hashCode());
	}

	@Test
	public void should_return_false_to_hashcode_with_different_funcionario() {
		Funcionario outroFuncionario = new Funcionario("Maria Silva", "30564609056", BigDecimal.valueOf(1500.00),
				"Gerente");
		assertFalse(funcionario.hashCode() == outroFuncionario.hashCode());
	}

	@Test
	public void should_return_true_to_equals_with_same_funcionario() {
		Funcionario outroFuncionario = new Funcionario("Maria Silva", "47561448880", BigDecimal.valueOf(1500.00),
				"Vendedora");
		assertTrue(funcionario.equals(outroFuncionario));
	}

	@Test
	public void should_return_false_with_equals_different_funcionario() {
		Funcionario outroFuncionario = new Funcionario("Maria Silva", "30564609056", BigDecimal.valueOf(1550.00),
				"Vendedora");
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

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_name_is_null() {
		funcionario.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_name_is_empty() {
		funcionario.setNome("  ");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_name_has_more_than_60_caracters() {
		funcionario.setNome("nome maior do que sessenta caracteres. Nome maior do que sessenta caracteres");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_cpf_is_null() {
		funcionario.setCPF(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cpf_is_a_sequence_with_the_same_algoritmo() {
		funcionario.setCPF("22222222222");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cpf_is_invalid() {
		funcionario.setCPF("12345678901");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cpf_is_empty() {
		funcionario.setCPF(" ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_salario_is_null() {
		funcionario.setSalario(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_salario_is_less_than_0() {
		funcionario.setSalario(new BigDecimal("-50.00"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_cargo_is_null() {
		funcionario.setCargo(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cargo_is_empty() {
		funcionario.setCargo("  ");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cargo_has_more_than_60_caracters() {
		funcionario.setCargo("cargo maior do que sessenta caracteres. Cargo maior do que sessenta caracteres");
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