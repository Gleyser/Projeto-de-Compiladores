package compiler.tipo;

import java.util.*;

/**
 * @author Gleyser Guimarães Gleyser Guimarães e José Aparecido
 *
 * Essa classe implementa o sistema de tipos da linguagem de programação Pascal, em especial para a tratativa de tipos em funções e parâmetros.  
 */

public class TipoFuncao extends Tipo {
	
	Tipo tipoDoRetorno;
	List<Tipo> tipoDosParametros;

	public TipoFuncao(Tipo tipoRetorno) {
		this(tipoRetorno, new ArrayList<Tipo>());
	}
	
	public TipoFuncao(Tipo tipoDoRetorno, List<Tipo> allParametros) {
		super(Tipo.FUNCAO, tipoDoRetorno.width, tipoDoRetorno.nome);
		this.tipoDoRetorno = tipoDoRetorno;
		tipoDosParametros = allParametros;
	}
	
	public void addParamTipo(List<Tipo> tipo) {
		tipoDosParametros.addAll(tipo);
	}
	
	public Tipo getTipoDoRetorno() {
		return tipoDoRetorno;
	}
	
	public void setTipoDoRetorno(Tipo tipo) {
		tipoDoRetorno = tipo;
	}
	
	public List<Tipo> getTipoDosParametros() {
		return tipoDosParametros;
	}
	
	public String getNome() {
		return nome;
	}

}
