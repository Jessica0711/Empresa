package br.com.contmatic.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

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
		cliente = new Cliente("João Santos", "475.614.488-80");
		Endereco endereco = new Endereco("Avenida 02", 07, "Moema", "12345-678");
		cliente.setEndereco(endereco);
	}

	@After
	public void tearDown() {
		cliente = null;
	}

	@Test
	public void should_return_true_to_nome_not_null() {
		assertNotNull(cliente.getNome());
	}

	@Test
	public void should_return_true_to_cpf_not_null() {
		assertNotNull(cliente.getCpf());
	}

	@Test
	public void should_return_true_to_endereco_not_null() {
		assertNotNull(cliente.getEndereco());
	}

	@Test
	public void should_return_true_to_correct_input_nome() {
		assertThat(cliente.getNome(), is("João Santos"));
	}

	@Test
	public void should_return_false_to_wrong_input_nome() {
		assertThat(cliente.getNome(), not("João Silva"));
	}

	@Test
	public void should_return_true_to_correct_input_cpf() {
		assertThat(cliente.getCpf(), is("475.614.488-80"));
	}

	@Test
	public void should_return_false_to_wrong_input_cpf() {
		assertThat(cliente.getCpf(), not("555.614.488-80"));
	}

	@Test
	public void should_return_true_to_correct_input_endereco() {
		Endereco endereco = new Endereco("Avenida 02", 07, "Moema", "12345-678");
		assertThat(cliente.getEndereco(), is(endereco));
	}

	@Test
	public void should_return_false_to_wrong_input_endereco() {
		Endereco endereco = new Endereco("Avenida 02", 07, "Moema", "12121-888");
		assertThat(cliente.getEndereco(), not(endereco));
	}

	@Test
	public void should_return_true_to_the_same_hashcode_class_empresa() {
		Cliente outroCliente = new Cliente("João Santos", "475.614.488-80");
		assertEquals(cliente.hashCode(), outroCliente.hashCode());
	}

	@Test
	public void should_return_false_to_differents_hashcode_class_empresa() {
		Cliente outroCliente = new Cliente("João Santos", "444.444.888-88");
		assertFalse(cliente.hashCode() == outroCliente.hashCode());
	}

	@Test
	public void should_return_false_when_hashcode_compare_with_a_null_cpf() {
		Cliente outroCliente = new Cliente("Maria", null);
		assertFalse(cliente.hashCode() == outroCliente.hashCode());
	}

	@Test
	public void should_return_true_to_same_equals_class_cliente() {
		Cliente outroCliente = new Cliente("João Santos", "475.614.488-80");
		assertTrue(cliente.equals(outroCliente));
	}

	@Test
	public void should_return_false_to_equals_with_differents_cliente() {
		Cliente outroCliente = new Cliente("João Santos", "444.444.888-88");
		assertFalse(cliente.equals(outroCliente));
	}

	@Test
	public void should_return_false_when_equals_compare_with_a_null_class() {
		Cliente outroCliente = null;
		assertFalse(cliente.equals(outroCliente));
	}

	@Test
	public void should_return_false_to_equals_from_a_null_cpf() {
		Cliente outroCliente = new Cliente("Maria", null);
		assertFalse(outroCliente.equals(cliente));
	}

	@Test
	public void should_return_true_when_equals_with_two_cpf_null() {
		Cliente cliente01 = new Cliente("Maria", null);
		Cliente cliente02 = new Cliente("José", null);
		assertTrue(cliente01.equals(cliente02));
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

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_nome_is_empty() {
		cliente.setNome("  ");
	}

	@Test
	public void should_return_true_if_tostring_contains_cliente() {
		assertThat(cliente.toString(), containsString("Cliente"));
	}

	@Test
	public void should_return_true_if_tostring_contains_cpf() {
		assertThat(cliente.toString(), containsString("CPF"));
	}

	@Test
	public void should_return_true_if_tostring_contains_endereco() {
		assertThat(cliente.toString(), containsString("Endereço"));
	}
}