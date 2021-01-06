package br.com.contmatic.model.produto;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProdutoTest {

	private Produto produto;

	@BeforeClass
	public static void setUp_before_class() {
		System.out.println("Iniciado os teste para a classe Produto");
	}

	@Before
	public void setUp() {
		produto = new Produto("Shorts", "Camaleon", new BigDecimal("39.99"), 3444L);
		produto.setDataAlteracao(DateTime.parse("2020-12-05"));
		produto.setDataCadastro(DateTime.parse("2020-12-05"));
		produto.setCriadoPor("jessica");
		produto.setIpCriadoPor("127.0.0.1");
		produto.setUltimaModificacao("jessica");
		produto.setIpUltimaModificacao("127.0.0.1");
	}

	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(produto.getNome());
		assertNotNull(produto.getMarca());
		assertNotNull(produto.getPreco());
		assertNotNull(produto.getCodigo());
		assertNotNull(produto.getDataAlteracao());
		assertNotNull(produto.getDataCadastro());
		assertNotNull(produto.getCriadoPor());
		assertNotNull(produto.getUltimaModificacao());
		assertNotNull(produto.getIpCriadoPor());
		assertNotNull(produto.getIpUltimaModificacao());
	}

	@Test
	public void should_return_true_to_correct_inputs() {
		assertThat(produto.getNome(), is("Shorts"));
		assertThat(produto.getMarca(), is("Camaleon"));
		assertTrue(produto.getPreco().compareTo(BigDecimal.valueOf(39.99)) == 0);
		assertTrue(produto.getCodigo() == (3444));
	}

	@Test
	public void should_return_false_to_wrong_inputs() {
		assertThat(produto.getNome(), not("Camiseta"));
		assertThat(produto.getMarca(), not("2KB"));
		assertFalse(produto.getPreco().compareTo(BigDecimal.valueOf(40.00)) == 0);
		assertThat(produto.getCodigo(), not(3445));
	}

	@Test
	public void should_return_true_to_the_same_hashcode_class_produto() {
		Produto outroProduto = new Produto("Shorts", "Camaleon", new BigDecimal("39.99"), 3444L);
		assertEquals(produto.hashCode(), outroProduto.hashCode());
	}

	@Test
	public void should_return_false_to_differents_hashcode_class_Produto() {
		Produto outroProduto = new Produto("Shorts", "B2K", new BigDecimal("46.99"), 3445L);
		assertFalse(produto.hashCode() == outroProduto.hashCode());
	}

	@Test
	public void should_return_true_to_the_same_equals_class_produto() {
		Produto outro_produto = new Produto("Shorts", "Camaleon", new BigDecimal("39.99"), 3444L);
		assertTrue(produto.equals(outro_produto));
	}

	@Test
	public void should_return_true_different_equals_class_produto() {
		Produto outro_produto = new Produto("Shorts", "Camaleon", new BigDecimal("59.99"), 3544L);
		assertFalse(produto.equals(outro_produto));
	}

	@Test
	public void should_return_false_to_equals_with_a_null_class() {
		Produto outro_produto = null;
		assertFalse(produto.equals(outro_produto));
	}

	@Test
	public void should_return_false_to_equals_with_same_object() {
		assertTrue(produto.equals(produto));
	}

	@Test
	public void should_return_false_when_equals_compare_class_with_a_number() {
		assertFalse(produto.equals(new Object()));
	}

	@Test
	public void should_return_true_if_tostring_contains_all_the_fields() {
		assertThat(produto.toString(), containsString("Produto"));
		assertThat(produto.toString(), containsString("marca"));
		assertThat(produto.toString(), containsString("codigo"));
		assertThat(produto.toString(), containsString("preco"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_name_is_null() {
		produto.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_name_is_empty() {
		produto.setNome("");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_name_has_more_than_60_caracters() {
		produto.setNome("nome maior do que sessenta caracteres. Nome maior do que sessenta caracteres");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_marca_is_null() {
		produto.setMarca(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_marca_is_empty() {
		produto.setMarca("");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_marca_has_more_than_60_caracters() {
		produto.setMarca("nome maior do que sessenta caracteres. Nome maior do que sessenta caracteres");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_preco_is_null() {
		produto.setPreco(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_marca_is_less_than_0() {
		produto.setPreco(new BigDecimal("-39.99"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_codigo_is_null() {
		produto.setCodigo(null);
	}

	@After
	public void tearDown() {
		produto = null;
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Fim dos teste para a classe Produto");
	}

}
