package compiler.tipo;

import java.util.HashMap;

/**
 * @author Gleyser Guimarães e José Aparecido
 *
 * Essa classe implementa o sistema de tipos da linguagem de programação Pascal. 
 */
public class Tipo {
	
	public static final int CHAR = 1;
	public static final int INTEGER = 2;
	public static final int REAL = 3;
	public static final int BOOLEAN = 4;
	public static final int TIPO_VOID = 5;
	public static final int ERRO = 6;
 	public static final int NOME = 7;
	public static final int ARRAY = 8;
	public static final int STRING = 9;
	public static final int BYTE = 10;
	public static final int SHORTINT = 11;
	public static final int DOUBLE = 12;
	public static final int LONGINT = 13;
	public static final int WORD = 14;
	public static final int REFERENCIA = 90;
	public static final int PRODUCT = 91;
	public static final int FUNCAO = 93;
	public static final int NIL = 0;

	
	
	static HashMap<String, Tipo> todosOsTipos = new HashMap<String, Tipo>();

	int tag;
	int width = 0;
	String nome;
	
	public Tipo(int tag, int width, String nome) {
		this.tag = tag;
		this.width = width;
		this.nome = nome;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getTag() {
		return tag;
	}
	
	public String getVal() {
		return nome;
	}
	
	public static void criaTipos() {
		todosOsTipos.put(INTEGER+"", new Tipo(INTEGER, 2, "integer"));
		todosOsTipos.put(LONGINT+"", new Tipo(LONGINT, 4, "longint"));
		todosOsTipos.put(SHORTINT+"", new Tipo(SHORTINT, 1, "integer"));
		todosOsTipos.put(REAL+"", new Tipo(REAL, 6, "real"));
		todosOsTipos.put(DOUBLE+"", new Tipo(DOUBLE, 8, "double"));
		todosOsTipos.put(WORD+"", new Tipo(WORD, 2, "word"));
		todosOsTipos.put(BYTE+"", new Tipo(BYTE, 1, "byte"));
		todosOsTipos.put(CHAR+"", new Tipo(CHAR, 1, "char"));
		todosOsTipos.put(STRING+"", new Tipo(STRING, 8, "string"));
		todosOsTipos.put(BOOLEAN+"", new Tipo(BOOLEAN, 1, "boolean"));
		todosOsTipos.put(TIPO_VOID+"", new Tipo(TIPO_VOID, 0, "void"));
		todosOsTipos.put(NIL+"", new Tipo(NIL, 0, "nil"));
		todosOsTipos.put(ERRO+"", new Tipo(ERRO, 0, "error"));
	}
	
	public static Tipo getTipo(int tag) {
		return todosOsTipos.get(""+tag);
	}
	
	/*
	 * Essa função recebe o nome e retorna o tipo correspondente. Tem que usar o mesmo nome usado em criaTipos()
	 */
	public static Tipo getTipo(String nome) {
		for(Tipo tipo : todosOsTipos.values()) {
			if(tipo.getVal().equals(nome))
				return tipo;
		}
		return null;
	}
	
	public static Tipo maximo(Tipo t1, Tipo t2) {
		return t1.width > t2.width ? t1 : t2;
	}
}
