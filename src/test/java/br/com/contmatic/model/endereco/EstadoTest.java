package br.com.contmatic.model.endereco;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EstadoTest {

	private Estado estado;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Iniciando os teste para a classe Estado");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Fim dos teste para a classe Estado");
	}

	@Before
	public void setUp() throws Exception {
		this.estado = new Estado("São Paulo", new Pais("Brasil"));
		List<Cidade> cidades = new ArrayList<>();
		cidades.add(new Cidade("São Paulo", new Estado("São Paulo", new Pais("Brasil"))));
		this.estado.setCidades(cidades);
	}

	@After
	public void tearDown() throws Exception {
		this.estado = null;
	}

	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(this.estado.getNome());
		assertNotNull(this.estado.getPais());
		assertNotNull(this.estado.getCidades());
	}

	@Test
	public void should_return_true_to_correct_input() {
		assertThat(this.estado.getNome(), is("São Paulo"));
		assertThat(this.estado.getPais().getNome(), is("Brasil"));
		assertThat(this.estado.getCidades().iterator().next().getNome(), is("São Paulo"));
	}

	@Test
	public void should_return_true_to_the_same_hashcode_class_Cidade() {
		Estado outroEstado = new Estado("São Paulo", new Pais("Brasil"));
		;
		assertEquals(this.estado.hashCode(), outroEstado.hashCode());
	}

	@Test
	public void should_return_false_to_differents_hashcode_class_Cidade() {
		Estado outroEstado = new Estado("Rio de Janeiro", new Pais("Brasil"));
		assertFalse(this.estado.hashCode() == outroEstado.hashCode());
	}

	@Test
	public void should_return_true_to_same_equals_class_Cidade() {
		Estado outroEstado = new Estado("São Paulo", new Pais("Brasil"));
		;
		assertTrue(this.estado.equals(outroEstado));
	}

	@Test
	public void should_return_false_to_equals_with_differents_Cidade() {
		Estado outroEstado = new Estado("Rio de Janeiro", new Pais("Brasil"));
		assertFalse(this.estado.equals(outroEstado));
	}

	@Test
	public void should_return_false_when_equals_compare_with_a_null_class() {
		Estado outroEstado = null;
		assertFalse(this.estado.equals(outroEstado));
	}

	@Test
	public void should_return_false_when_equals_compare_class_with_other_object() {
		assertFalse(this.estado.equals(new Object()));
	}

	@Test
	public void should_return_false_when_equals_compare_class_with_a_pais_with_different_nome() {
		Estado outroEstado = new Estado("São Paulo", new Pais("Argentina"));
		assertFalse(this.estado.equals(outroEstado));
	}

	@Test
	public void should_return_true_when_equals_compare_class_with_same_object() {
		assertTrue(this.estado.equals(this.estado));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_nome_is_null() {
		this.estado.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_nome_is_empty() {
		this.estado.setNome("  ");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_nome_has_more_than_80_caracters() {
		this.estado.setNome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_pais_is_null() {
		this.estado.setPais(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_cidades_is_null() {
		this.estado.setCidades(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cidades_is_empty() {
		this.estado.setCidades(new ArrayList<Cidade>());
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cidades_has_differents_estados() {
		List<Cidade> cidades = new ArrayList<>();
		cidades.add(new Cidade("Rio de Janeiro", new Estado("Rio de Janeiro", new Pais("Brasil"))));
		this.estado.setCidades(cidades);
	}
	
	@Test
	public void should_return_true_if_tostring_is_correct() {
		assertThat(this.estado.toString(), containsString("São Paulo"));
		assertThat(this.estado.toString(), containsString("Brasil"));
	}
}
