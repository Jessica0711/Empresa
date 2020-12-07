package br.com.contmatic.model.auditoria;

import static org.junit.Assert.assertNotNull;

import org.joda.time.DateTime;
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
	public void setUp() throws Exception {
		auditoria = new Auditoria();
		auditoria.setDataAlteracao(DateTime.parse("2020-12-05"));
		auditoria.setDataCadastro(DateTime.parse("2020-12-05"));
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
}
