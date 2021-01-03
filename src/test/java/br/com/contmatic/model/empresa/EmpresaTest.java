package br.com.contmatic.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.produto.Produto;

public class EmpresaTest {

	private Empresa empresa;

	private List<Funcionario> funcionarios;

	private List<Produto> produtos;

	@BeforeClass
	public static void setUp_before_class() {
		System.out.println("Iniciando o teste da classe Empresa");
	}

	@Before
	public void setUp() {
		empresa = new Empresa("Contmatic", "50931090000102");
		empresa.setDataAlteracao(DateTime.parse("2020-12-05"));
		empresa.setDataCadastro(DateTime.parse("2020-12-05"));
		empresa.setCriadoPor("jessica");
		empresa.setIpCriadoPor("127.0.0.1");
		empresa.setUltimaModificacao("jessica");
		empresa.setIpUltimaModificacao("127.0.0.1");
	}

	@Before
	public void setUp_endereco() {
		empresa.setEndereco(new Endereco(1, "01234567"));
	}

	@Before
	public void setUp_funcionarios() {
		funcionarios = new ArrayList<Funcionario>();
		Funcionario funcionario1 = new Funcionario("Maria Silva", "30564609056", BigDecimal.valueOf(1500.00),
				"Vendedora");
		Funcionario funcionario2 = new Funcionario("João Santos", "78753312007", BigDecimal.valueOf(1500.00),
				"Vendedor");
		funcionarios.add(funcionario1);
		funcionarios.add(funcionario2);
		empresa.setFuncionarios(funcionarios);
	}

	@Before
	public void setUp_produtos() {
		produtos = new ArrayList<Produto>();
		Produto produto01 = new Produto("Shorts", "Camaleon", BigDecimal.valueOf(59.99), 3544L);
		Produto produto02 = new Produto("Calça", "Camaleon", BigDecimal.valueOf(79.99), 3466L);
		produtos.add(produto01);
		produtos.add(produto02);
		empresa.setProdutos(produtos);
	}

	@Test
	public void should_return_true_to_not_null() {
		assertNotNull(empresa.getNome());
		assertNotNull(empresa.getCnpj());
		assertNotNull(empresa.getEndereco());
		assertNotNull(empresa.getFuncionarios());
		assertNotNull(empresa.getProdutos());
		assertNotNull(empresa.getDataAlteracao());
		assertNotNull(empresa.getDataCadastro());
		assertNotNull(empresa.getCriadoPor());
		assertNotNull(empresa.getUltimaModificacao());
		assertNotNull(empresa.getIpCriadoPor());
		assertNotNull(empresa.getIpUltimaModificacao());
	}

	@Test
	public void should_return_true_to_correct_input_nome() {
		assertThat(empresa.getNome(), is("Contmatic"));
	}

	@Test
	public void should_return_false_to_wrong_input_nome() {
		assertThat(empresa.getNome(), not("Softmatic"));
	}

	@Test
	public void should_return_true_to_correct_input_cnpj() {
		assertThat(empresa.getCnpj(), is("50931090000102"));
	}

	@Test
	public void should_return_false_to_wrong_input_cnpj() {
		assertThat(empresa.getCnpj(), not(is("123456788")));
	}

	@Test
	public void should_return_true_to_correct_input_endereco() {
		Endereco endereco = new Endereco(1, "01234567");
		assertThat(empresa.getEndereco(), is(endereco));
	}

	@Test
	public void should_return_false_to_wrong_input_endereco() {
		Endereco endereco = new Endereco(1, "01212888");
		assertThat(empresa.getEndereco(), not(endereco));
	}

	@Test
	public void should_return_true_to_correct_input_funcionarios() {
		empresa.setFuncionarios(funcionarios);
		assertTrue(empresa.getFuncionarios().equals(funcionarios));
	}

	@Test
	public void should_return_false_to_wrong_input_funcionarios() {
		empresa.setFuncionarios(funcionarios);
		assertFalse(empresa.getFuncionarios().equals(produtos));
	}

	@Test
	public void should_return_true_to_correct_input_produtos() {
		empresa.setProdutos(produtos);
		assertTrue(empresa.getProdutos().equals(produtos));
	}

	@Test
	public void should_return_false_to_wrong_input_produtos() {
		empresa.setProdutos(produtos);
		assertFalse(empresa.getProdutos().equals(funcionarios));
	}

	@Test
	public void should_return_true_to_the_same_hashcode_class_empresa() {
		Empresa outraEmpresa = new Empresa("Contmatic", "50931090000102");
		assertEquals(empresa.hashCode(), outraEmpresa.hashCode());
	}

	@Test
	public void should_return_false_to_different_hashcode_class_empresa() {
		Empresa outraEmpresa = new Empresa("Contmatic", "60223379000120");
		assertFalse(empresa.hashCode() == outraEmpresa.hashCode());
	}

	@Test
	public void should_return_true_to_same_equals_class_empresa() {
		Empresa outraEmpresa = new Empresa("Contmatic", "50931090000102");
		assertTrue(empresa.equals(outraEmpresa));
	}

	@Test
	public void should_return_false_to_equals_with_differents_empresa() {
		Empresa outraEmpresa = new Empresa("Softmatic", "60223379000120");
		assertFalse(empresa.equals(outraEmpresa));
	}

	@Test
	public void should_return_false_when_equals_compare_with_a_null_class() {
		Empresa outraEmpresa = null;
		assertFalse(empresa.equals(outraEmpresa));
	}

	@Test
	public void should_return_false_when_equals_compare_class_with_another_object() {
		assertFalse(empresa.equals(new Object()));
	}

	@Test
	public void should_return_true_when_equals_compare_class_with_same_object() {
		assertTrue(empresa.equals(empresa));
	}

	@Test(timeout = 100)
	public void should_return_false_to_equals_null() {
		assertFalse(empresa.equals(null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_to_nome_null() {
		empresa.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_to_empty_nome() {
		empresa.setNome(" ");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_name_has_more_than_60_caracters() {
		empresa.setNome("nome maior do que sessenta caracteres. Nome maior do que sessenta caracteres");
	}

	public void should_return_a_exception_when_cpf_is_null() {
		empresa.setCnpj(null);
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cpf_is_a_sequence_with_the_same_algoritmo() {
		empresa.setCnpj("33333333333333");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cpf_is_invalid() {
		empresa.setCnpj("12345678901234");
	}

	@Test(expected = IllegalStateException.class)
	public void should_return_a_exception_when_cpf_is_empty() {
		empresa.setCnpj(" ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_to_endereco_null() {
		empresa.setEndereco(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_return_a_exception_to_funcionarios_null() {
		empresa.setFuncionarios(null);
	}

	@Test
	public void should_return_true_if_tostring_contains_empresa() {
		assertThat(empresa.toString(), containsString("Empresa"));
	}

	@Test
	public void should_return_true_if_tostring_contains_cnpj() {
		assertThat(empresa.toString(), containsString("cnpj"));
	}

	@Test
	public void should_return_true_if_tostring_contains_endereco() {
		assertThat(empresa.toString(), containsString("endereco"));
	}

	@Test
	public void should_return_true_if_tostring_contains_funcionarios() {
		assertThat(empresa.toString(), containsString("funcionarios"));
	}

	@Test
	public void should_return_true_if_tostring_contains_produtos() {
		assertThat(empresa.toString(), containsString("produtos"));
	}

	@Test
	@Ignore
	public void should_return_true_to_correct_output_of_tostring() {
		assertThat(empresa.toString(), is("Empresa: Contmatic, CNPJ: 123456789"));
	}

	@After
	public void tearDown() {
		empresa = null;
	}

	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Finalizado os teste para a classe Empresa");
	}
}
