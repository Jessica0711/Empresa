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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.model.produto.Produto;

public class ProdutoTest {

	private Produto produto;

	@BeforeClass
	public static void setUp_before_class() {
		System.out.println("Iniciado os teste para a classe Produto");
	}

	@Before
	public void setUp() {
		String nome = "Shorts";
		String marca = "Camaleon";
		BigDecimal preco = new BigDecimal("39.99");
		long codigoProduto = 3444;
		produto = new Produto(nome, marca, preco, codigoProduto);
	}

	@Test
	public void should_return_true_to_nome_is_not_null() {
		assertNotNull(produto.getNome());
	}

	@Test
	public void should_return_true_to_marca_is_not_null() {
		assertNotNull(produto.getMarca());
	}

	@Test
	public void should_return_true_to_preco_is_not_null() {
		assertNotNull(produto.getPreco());
	}

	@Test
	public void should_return_true_to_produto_is_not_null() {
		assertNotNull(produto.getcodigo());
	}

	@Test
	public void should_return_true_to_correct_input_nome() {
		assertThat(produto.getNome(), is("Shorts"));
	}

	@Test
	public void should_return_false_to_wrong_input_nome() {
		assertThat(produto.getNome(), not("Camiseta"));
	}

	@Test
	public void should_return_true_to_correct_input_marca() {
		assertThat(produto.getMarca(), is("Camaleon"));
	}

	@Test
	public void should_return_false_to_wrong_input_marca() {
		assertThat(produto.getMarca(), not("2KB"));
	}

	@Test
	public void should_return_true_to_correct_input_preco() {
		assertTrue(produto.getPreco().compareTo(BigDecimal.valueOf(39.99))==0);
	}

	@Test
	public void should_return_false_to_wrong_input_preco() {
		assertFalse(produto.getPreco().compareTo(BigDecimal.valueOf(40.00))==0);
	}

	@Test
	public void should_return_true_to_correct_input_codigoProduto() {
		assertTrue(produto.getcodigo() == (3444));
	}

	@Test
	public void should_return_false_to_wrong_input_codigoProduto() {
		assertThat(produto.getcodigo(), not(3445));
	}

	@Test
	public void should_return_true_to_the_same_hashcode_class_produto() {
		Produto outroProduto = new Produto("Shorts", "Camaleon", new BigDecimal("39.99"), 3444);
		assertEquals(produto.hashCode(), outroProduto.hashCode());
	}

	@Test
	public void should_return_false_to_differents_hashcode_class_Produto() {
		Produto outroProduto = new Produto("Shorts", "B2K", new BigDecimal("46.99"), 3445);
		assertFalse(produto.hashCode() == outroProduto.hashCode());
	}

	@Test
	public void should_return_true_to_the_same_equals_class_produto() {
		Produto outro_produto = new Produto("Shorts", "Camaleon", new BigDecimal("39.99"), 3444);
		assertTrue(produto.equals(outro_produto));
	}

	@Test
	public void should_return_true_different_equals_class_produto() {
		Produto outro_produto = new Produto("Shorts", "Camaleon", new BigDecimal("59.99"), 3544);
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
	public void should_return_true_if_tostring_contains_nome() {
		assertThat(produto.toString(), containsString("Produto"));
	}

	@Test
	public void should_return_true_if_tostring_contains_marca() {
		assertThat(produto.toString(), containsString("marca"));
	}

	@Test
	public void should_return_true_if_tostring_contains_codigo() {
		assertThat(produto.toString(), containsString("codigo"));
	}

	@Test
	public void should_return_true_if_tostring_contains_preco() {
		assertThat(produto.toString(), containsString("preço"));
	}

	@Test(expected = Exception.class)
	public void should_return_a_exception_when_name_is_null() {
		produto.setNome(null);
	}

	@Test(expected = Exception.class)
	public void should_return_a_exception_when_marca_is_null() {
		produto.setMarca(null);
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
