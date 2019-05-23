package compiler.tabela;

import java.util.*;

/**
 * @author Gleyser Guimarães e José Aparecido
 *
 * Essa classe implementa a tabela de simbolos. A funcao dela é guardar os simbolos lidos e apoiar as etapas seguintes. 
 */

public class TabelaDeSimbolos {

	public static TabelaDeSimbolos escopoAtual;
	static TabelaDeSimbolos raiz = new TabelaDeSimbolos(null);
	static int contadorDeTabelas;

	HashMap<String, Simbolo> tabela;
	TabelaDeSimbolos anterior;
	List<String> variaveis;

	public TabelaDeSimbolos(TabelaDeSimbolos anterior) {
		tabela = new HashMap<String, Simbolo>();
		this.anterior = anterior;
		variaveis = new ArrayList<String>();
	}

	public static TabelaDeSimbolos getRoot() {
		return raiz;
	}
	
	public boolean isRoot() {
		return anterior == null;
	}

	public static void inicializa() {
		contadorDeTabelas = 0;
		escopoAtual = raiz;
	}

	public static boolean inserir(String nome, Simbolo s) {
		if (!escopoAtual.tabela.containsKey(nome)) {
			escopoAtual.tabela.put(nome, s);
			return true;
		}
		return false;
	}

	public static void inserirSimbolo(String nome, Simbolo s) {
		TabelaDeSimbolos e = escopoAtual.anterior;
		e.tabela.put(nome, s);
	}

	/* O metodo inserirVariavel() da tabela de simbolos recebe um simbolo e um nome retorna true se tiver inserido o simbolo. False caso contrario. 
	*/
	public static boolean inserirVariavel(String nome, Simbolo s) {
		if (!escopoAtual.tabela.containsKey(nome)) {
			escopoAtual.tabela.put(nome, s);
			escopoAtual.variaveis.add(nome);
			return true;
		}
		return false;
	}

	/* Retorna o simbolo dado um nome. Considera o escopoAtual como tabelaDeSimbolos 
	*/
	public static Simbolo get(String nome) {
		return get(nome, escopoAtual);
	}
	
	public static Simbolo get(String nome, TabelaDeSimbolos tab) {
		for (TabelaDeSimbolos t = tab; t != null; t = t.anterior) {
			Simbolo s = (Simbolo) (t.tabela.get(nome));
			if (s != null) {
				return s;
			}
		}
		return null;
	}

	static void push(TabelaDeSimbolos tab) {
		contadorDeTabelas++;
		escopoAtual = new TabelaDeSimbolos(tab);
	}

	public static void push() {
		push(escopoAtual);
	}

	public static void pop() {
		escopoAtual = escopoAtual.anterior;
		contadorDeTabelas++;
	}

}