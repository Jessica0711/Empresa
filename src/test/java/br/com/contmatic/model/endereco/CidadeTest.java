package br.com.contmatic.model.endereco;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CidadeTest {

	private Cidade cidade;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Iniciando os teste para a classe Cidade");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Fim dos teste para a classe Cidade");
	}

	@Before
	public void setUp() throws Exception {
		this.cidade = new Cidade("São Paulo", new Estado("São Paulo", new Pais("Brasil")));
	}

	@After
	public void tearDown() throws Exception {
		this.cidade = null;
	}

	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(this.cidade.getNome());
		assertNotNull(this.cidade.getEstado());
	}

	@Test
	public void should_return_true_to_correct_input() {
		assertThat(this.cidade.getNome(), is("São Paulo"));
		assertThat(this.cidade.getEstado().getNome(), is("São Paulo"));
	}

	@Test
	public void should_return_true_to_the_same_hashcode_class_Cidade() {
		Cidade outroCidade = new Cidade("São Paulo", new Estado("São Paulo", new Pais("Brasil")));
		assertEquals(this.cidade.hashCode(), outroCidade.hashCode());
	}

	@Test
	public void should_return_false_to_differents_hashcode_class_Cidade() {
		Cidade outroCidade = new Cidade("Rio de Janeiro", new Estado("Rio de Janeiro", new Pais("Brasil")));
		assertFalse(this.cidade.hashCode() == outroCidade.hashCode());
	}

	@Test
	public void should_return_true_to_same_equals_class_Cidade() {
		Cidade outroCidade = new Cidade("São Paulo", new Estado("São Paulo", new Pais("Brasil")));
		assertTrue(this.cidade.equals(outroCidade));
	}

	@Test
	public void should_return_false_to_equals_with_differents_Cidade() {
		Cidade outroCidade = new Cidade("Rio de Janeiro", new Estado("Rio de Janeiro", new Pais("Brasil")));
		assertFalse(this.cidade.equals(outroCidade));
	}

	@Test
	public void should_return_false_when_equals_compare_with_a_null_class() {
		Cidade outroCidade = null;
		assertFalse(this.cidade.equals(outroCidade));
	}

	@Test
	public void should_return_false_when_equals_compare_class_with_other_object() {
		assertFalse(this.cidade.equals(new Object()));
	}
	
	@Test
	public void should_return_false_when_equals_compare_class_with_a_pais_with_different_nome() {
		Cidade outroCidade = new Cidade("Campinas", new Estado("São Paulo", new Pais("Brasil")));
		assertFalse(this.cidade.equals(outroCidade));
	}

	@Test
	public void should_return_true_when_equals_compare_class_with_same_object() {
		assertTrue(this.cidade.equals(this.cidade));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_nome_is_null() {
		this.cidade.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_nome_is_empty() {
		this.cidade.setNome("  ");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_nome_has_more_than_80_caracters() {
		this.cidade.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_estado_is_null() {
		this.cidade.setEstado(null);
	}

	@Test
	public void should_return_true_if_tostring_contains_nome_and_estado() {
		assertThat(this.cidade.toString(), containsString("São Paulo"));
	}

}
