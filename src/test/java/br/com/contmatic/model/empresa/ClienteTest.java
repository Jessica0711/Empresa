package br.com.contmatic.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.endereco.Endereco;

public class ClienteTest {

	private Cliente cliente;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Inicio dos teste para a classe Cliente");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Fim dos testes para a classe cliente");
	}

	@Before
	public void setUp() {
		cliente = new Cliente("João Santos", "47561448880", new Endereco(07, "12345678"));
		cliente.setDataAlteracao(DateTime.parse("2020-12-05"));
		cliente.setDataCadastro(DateTime.parse("2020-12-05"));
		cliente.setCriadoPor("jessica");
		cliente.setIpCriadoPor("127.0.0.1");
		cliente.setUltimaModificacao("jessica");
		cliente.setIpUltimaModificacao("127.0.0.1");
	}

	@After
	public void tearDown() {
		cliente = null;
	}

	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(cliente.getNome());
		assertNotNull(cliente.getCpf());
		assertNotNull(cliente.getEndereco());
		assertNotNull(cliente.getDataAlteracao());
		assertNotNull(cliente.getDataCadastro());
		assertNotNull(cliente.getCriadoPor());
		assertNotNull(cliente.getUltimaModificacao());
		assertNotNull(cliente.getIpCriadoPor());
		assertNotNull(cliente.getIpUltimaModificacao());
	}

	@Test
	public void should_return_true_to_correct_inputs() {
		assertThat(cliente.getNome(), is("João Santos"));
		assertThat(cliente.getCpf(), is("47561448880"));
		Endereco endereco = new Endereco(07, "12345678");
		assertThat(cliente.getEndereco(), is(endereco));
	}

	@Test
	public void should_return_true_to_the_same_hashcode_class_empresa() {
		Cliente outroCliente = new Cliente("João Santos", "47561448880");
		assertEquals(cliente.hashCode(), outroCliente.hashCode());
	}

	@Test
	public void should_return_false_to_differents_hashcode_class_empresa() {
		Cliente outroCliente = new Cliente("João Santos", "33567717014");
		assertFalse(cliente.hashCode() == outroCliente.hashCode());
	}

	@Test
	public void should_return_true_to_same_equals_class_cliente() {
		Cliente outroCliente = new Cliente("João Santos", "47561448880");
		assertTrue(cliente.equals(outroCliente));
	}

	@Test
	public void should_return_false_to_equals_with_differents_cliente() {
		Cliente outroCliente = new Cliente("João Santos", "33567717014");
		assertFalse(cliente.equals(outroCliente));
	}

	@Test
	public void should_return_false_when_equals_compare_with_a_null_class() {
		Cliente outroCliente = null;
		assertFalse(cliente.equals(outroCliente));
	}

	@Test
	public void should_return_false_when_equals_compare_class_with_another_object() {
		assertFalse(cliente.equals(new Object()));
	}

	@Test
	public void should_return_true_when_equals_compare_class_with_same_object() {
		assertTrue(cliente.equals(cliente));
	}

	@Test(timeout = 100)
	public void should_return_false_to_equals_null() {
		assertFalse(cliente.equals(null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_to_nome_null() {
		cliente.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_nome_is_empty() {
		cliente.setNome("  ");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_name_has_more_than_60_caracters() {
		cliente.setNome("nome maior do que sessenta caracteres. Nome maior do que sessenta caracteres");
	}

	public void should_return_a_exception_when_cpf_is_null() {
		cliente.setCpf(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cpf_is_a_sequence_with_the_same_algoritmo() {
		cliente.setCpf("33333333333");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cpf_is_invalid() {
		cliente.setCpf("12345678901");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cpf_is_empty() {
		cliente.setCpf(" ");
	}

	@Test
	public void should_return_true_if_tostring_contains_cliente_and_cpf_and_endereco() {
		assertThat(cliente.toString(), containsString("Cliente"));
		assertThat(cliente.toString(), containsString("cpf"));
		assertThat(cliente.toString(), containsString("Endereco"));
	}

}