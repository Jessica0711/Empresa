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

public class PaisTest {

	private Pais pais;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Iniciando os teste para a classe Pais");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Fim dos teste para a classe Pais");
	}

	@Before
	public void setUp() throws Exception {
		this.pais = new Pais("Brasil");
	}

	@After
	public void tearDown() throws Exception {
		this.pais = null;
	}

	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(this.pais.getNome());
	}

	@Test
	public void should_return_true_to_correct_input() {
		assertThat(this.pais.getNome(), is("Brasil"));
	}

	@Test
	public void should_return_true_to_the_same_hashcode_class_Pais() {
		Pais outroPais = new Pais("Brasil");
		assertEquals(this.pais.hashCode(), outroPais.hashCode());
	}

	@Test
	public void should_return_false_to_differents_hashcode_class_Pais() {
		Pais outroPais = new Pais("Argentina");
		assertFalse(this.pais.hashCode() == outroPais.hashCode());
	}

	@Test
	public void should_return_true_to_same_equals_class_Pais() {
		Pais outroPais = new Pais("Brasil");
		assertTrue(this.pais.equals(outroPais));
	}

	@Test
	public void should_return_false_to_equals_with_differents_Pais() {
		Pais outroPais = new Pais("Argentina");
		assertFalse(this.pais.equals(outroPais));
	}

	@Test
	public void should_return_false_when_equals_compare_with_a_null_class() {
		Pais outroPais = null;
		assertFalse(this.pais.equals(outroPais));
	}

	@Test
	public void should_return_false_when_equals_compare_class_with_another_object() {
		assertFalse(this.pais.equals(new Object()));
	}

	@Test
	public void should_return_true_when_equals_compare_class_with_same_object() {
		assertTrue(this.pais.equals(this.pais));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_nome_is_null() {
		this.pais.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_nome_is_empty() {
		this.pais.setNome("  ");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_nome_has_more_than_80_caracters() {
		this.pais.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@Test
	public void should_return_true_if_tostring_contains_rua() {
		assertThat(this.pais.toString(), containsString("Brasil"));
	}

}
