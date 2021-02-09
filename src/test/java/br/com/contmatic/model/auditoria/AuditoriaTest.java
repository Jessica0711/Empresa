package br.com.contmatic.model.auditoria;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.DateTime.parse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuditoriaTest {

	private Auditoria auditoria;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Iniando os teste para a classe Auditoria");
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Finalizado os teste para a classe Auditoria");
	}

	@Before
	public void setUp() {
		auditoria = new Auditoria();
		auditoria.setDataAlteracao(parse("2020-12-05"));
		auditoria.setDataCadastro(parse("2020-12-05"));
		auditoria.setCriadoPor("jessica");
		auditoria.setIpCriadoPor("127.0.0.1");
		auditoria.setUltimaModificacao("jessica");
		auditoria.setIpUltimaModificacao("127.0.0.1");
	}

	@After
	public void tearDown() {
		auditoria = null;
	}

	@Test
	public void should_return_true_to_auditoria_is_not_null() {
		assertNotNull(auditoria.getDataAlteracao());
		assertNotNull(auditoria.getDataCadastro());
		assertNotNull(auditoria.getCriadoPor());
		assertNotNull(auditoria.getUltimaModificacao());
		assertNotNull(auditoria.getIpCriadoPor());
		assertNotNull(auditoria.getIpUltimaModificacao());
	}

	@Test
	public void should_return_true_to_correct_inputs() {
		assertThat(auditoria.getDataAlteracao(), is(parse("2020-12-05")));
		assertThat(auditoria.getDataCadastro(), is(parse("2020-12-05")));
		assertThat(auditoria.getCriadoPor(), is("jessica"));
		assertThat(auditoria.getIpCriadoPor(), is("127.0.0.1"));
		assertThat(auditoria.getUltimaModificacao(), is("jessica"));
		assertThat(auditoria.getIpUltimaModificacao(), is("127.0.0.1"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_dataCadastro_is_null() {
		auditoria.setDataCadastro(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_dataAlteracao_is_null() {
		auditoria.setDataAlteracao(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_criadoPor_is_null() {
		auditoria.setCriadoPor(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_ultimaModificacao_is_empty() {
		auditoria.setUltimaModificacao("");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_criadoPor_is_empty() {
		auditoria.setCriadoPor("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_ultimaModificacao_is_null() {
		auditoria.setUltimaModificacao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_ipCriadoPor_is_empty() {
		auditoria.setIpCriadoPor("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_ipUltimaModificacao_is_null() {
		auditoria.setIpUltimaModificacao(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_when_ipCriadoPor_is_null() {
		auditoria.setIpCriadoPor(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_ipUltimaModificacao_is_empty() {
		auditoria.setIpUltimaModificacao("");
	}

	@Test
	public void should_return_true_if_tostring_contains_all_the_fields() {
		assertThat(this.auditoria.toString(), containsString("127.0.0.1"));
		assertThat(this.auditoria.toString(), containsString("jessica"));
	}
}
