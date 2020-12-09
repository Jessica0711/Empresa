package br.com.contmatic.model.endereco;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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

public class EnderecoTest {
	private Endereco endereco;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Iniciando os teste para a classe Endereco");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Fim dos teste para a classe Endereco");
	}

	@Before
	public void setUp() {
		endereco = new Endereco("Avenida", 01, "São Paulo", "01234567", "Apt 07", "São Paulo", "São Paulo");
		endereco.setDataAlteracao(DateTime.parse("2020-12-05"));
		endereco.setDataCadastro(DateTime.parse("2020-12-05"));
		endereco.setCriadoPor("jessica");
		endereco.setIpCriadoPor("127.0.0.1");
		endereco.setUltimaModificacao("jessica");
		endereco.setIpUltimaModificacao("127.0.0.1");
	}

	@After
	public void tearDown() {
		endereco = null;
	}

	@Test
	public void should_return_true_to_rua_not_null() {
		assertNotNull(endereco.getRua());
	}

	@Test
	public void should_return_true_to_numero_not_null() {
		assertNotNull(endereco.getNumero());
	}

	@Test
	public void should_return_true_to_bairro_not_null() {
		assertNotNull(endereco.getBairro());
	}

	@Test
	public void should_return_true_to_cep_not_null() {
		assertNotNull(endereco.getCep());
	}

	@Test
	public void should_return_true_to_complemento_not_null() {
		assertNotNull(endereco.getComplemento());
	}

	@Test
	public void should_return_true_to_cidade_not_null() {
		assertNotNull(endereco.getCidade());
	}

	@Test
	public void should_return_true_to_estado_not_null() {
		assertNotNull(endereco.getEstado());
	}
	
	@Test
	public void should_return_true_to_auditoria_is_not_null() {
		assertNotNull(endereco.getDataAlteracao());
		assertNotNull(endereco.getDataCadastro());
		assertNotNull(endereco.getCriadoPor());
		assertNotNull(endereco.getUltimaModificacao());
		assertNotNull(endereco.getIpCriadoPor());
		assertNotNull(endereco.getIpUltimaModificacao());
	}

	@Test
	public void should_return_true_to_correct_input_rua() {
		assertThat(endereco.getRua(), is("Avenida"));
	}

	@Test
	public void should_return_false_to_wrong_input_rua() {
		assertThat(endereco.getRua(), not("Rua um"));
	}

	@Test
	public void should_return_true_to_correct_input_numero() {
		assertThat(endereco.getNumero(), is(1));
	}

	@Test
	public void should_return_false_to_wrong_input_numero() {
		assertThat(endereco.getNumero(), not(2));
	}

	@Test
	public void should_return_true_to_correct_input_bairro() {
		assertThat(endereco.getBairro(), is("São Paulo"));
	}

	@Test
	public void should_return_false_to_wrong_input_bairro() {
		assertThat(endereco.getBairro(), not("Rio de Janeiro"));
	}

	@Test
	public void should_return_true_to_correct_input_cep() {
		assertThat(endereco.getCep(), is("01234567"));
	}

	@Test
	public void should_return_false_to_wrong_input_cep() {
		assertThat(endereco.getCep(), not("43210765"));
	}

	@Test
	public void should_return_true_to_correct_input_complemento() {
		assertThat(endereco.getComplemento(), is("Apt 07"));
	}

	@Test
	public void should_return_false_to_wrong_input_complemento() {
		assertThat(endereco.getComplemento(), not("Apt 08"));
	}

	@Test
	public void should_return_true_to_the_same_hashcode_class_endereco() {
		Endereco outroEndereco = new Endereco("Avenida", 01, "São Paulo", "01234567");
		assertEquals(endereco.hashCode(), outroEndereco.hashCode());
	}

	@Test
	public void should_return_false_to_differents_hashcode_class_endereco() {
		Endereco outroEndereco = new Endereco("Avenida", 01, "São Paulo", "01234555");
		assertFalse(endereco.hashCode() == outroEndereco.hashCode());
	}

	@Test
	public void should_return_true_to_same_equals_class_endereco() {
		Endereco outroEndereco = new Endereco("Avenida", 01, "São Paulo", "01234567");
		assertTrue(endereco.equals(outroEndereco));
	}

	@Test
	public void should_return_false_to_equals_with_differents_endereco() {
		Endereco outroEndereco = new Endereco("Avenida", 01, "São Paulo", "01234777");
		assertFalse(endereco.equals(outroEndereco));
	}

	@Test
	public void should_return_false_when_equals_compare_with_a_null_class() {
		Endereco outroEndereco = null;
		assertFalse(endereco.equals(outroEndereco));
	}

	@Test
	public void should_return_false_when_compare_hashcode_with_differents_numero() {
		Endereco endereco1 = new Endereco("Avenida", 01, "São Paulo", "01234777");
		Endereco endereco2 = new Endereco("Avenida", 02, "São Paulo", "01234777");
		assertFalse(endereco1.equals(endereco2));
	}

	@Test
	public void should_return_false_when_equals_compare_class_with_another_object() {
		assertFalse(endereco.equals(new Object()));
	}

	@Test
	public void should_return_true_when_equals_compare_class_with_same_object() {
		assertTrue(endereco.equals(endereco));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_rua_is_null() {
		endereco.setRua(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_rua_is_empty() {
		endereco.setRua("  ");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_rua_has_more_than_60_caracters() {
		endereco.setRua("rua maior do que sessenta caracteres. Rua maior do que sessenta caracteres");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_numero_is_null() {
		endereco.setNumero(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_numero_is_less_than_0() {
		endereco.setNumero(-2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_bairro_is_null() {
		endereco.setBairro(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_bairro_is_empty() {
		endereco.setBairro("  ");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cidade_has_more_than_60_caracters() {
		endereco.setCidade("cidade maior do que sessenta caracteres. cidade maior do que sessenta caracteres");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_cidade_is_null() {
		endereco.setCidade(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cidade_is_empty() {
		endereco.setCidade("  ");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_bairro_has_more_than_60_caracters() {
		endereco.setBairro("bairro maior do que sessenta caracteres. Bairro maior do que sessenta caracteres");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_cep_is_null() {
		endereco.setCep(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cep_is_empty() {
		endereco.setCep("  ");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cep_is_invalid() {
		endereco.setCep("11111111");
		endereco.setCep("1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_complemento_is_null() {
		endereco.setComplemento(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_complemento_is_empty() {
		endereco.setComplemento("  ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_complemento_has_more_than_50_caracters() {
		endereco.setComplemento("complemento maior do que sessenta caracteres. complemento maior do que 50 caracteres");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_estado_is_null() {
		endereco.setEstado(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_estado_is_empty() {
		endereco.setEstado("  ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_estado_has_more_than_40_caracters() {
		endereco.setEstado("estado maior do que sessenta caracteres. estado maior do que 40 caracteres");
	}
	
	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_estado_has_less_than_2_caracters() {
		endereco.setEstado("e");
	}

	@Test
	public void should_return_true_if_tostring_contains_rua() {
		assertThat(endereco.toString(), containsString("Avenida"));
	}

	@Test
	public void should_return_true_if_tostring_contains_numero() {
		assertThat(endereco.toString(), containsString("1"));
	}

	@Test
	public void should_return_true_if_tostring_contains_bairro() {
		assertThat(endereco.toString(), containsString("São Paulo"));
	}

	@Test
	public void should_return_true_if_tostring_contains_cep() {
		assertThat(endereco.toString(), containsString("cep"));
	}

	@Test
	public void should_return_true_if_tostring_contains_complemento() {
		assertThat(endereco.toString(), containsString("complemento"));
	}
}
