package br.com.contmatic.model.empresa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.model.auditoria.AuditoriaTest;
import br.com.contmatic.model.endereco.CidadeTest;
import br.com.contmatic.model.endereco.EnderecoTest;
import br.com.contmatic.model.endereco.EstadoTest;
import br.com.contmatic.model.endereco.PaisTest;
import br.com.contmatic.model.produto.ProdutoTest;

@RunWith(Suite.class)
@SuiteClasses({ EmpresaTest.class, FuncionarioTest.class, ProdutoTest.class, EnderecoTest.class, ClienteTest.class,
		AuditoriaTest.class, PaisTest.class, CidadeTest.class, EstadoTest.class })
public class RunnerTest {
}
