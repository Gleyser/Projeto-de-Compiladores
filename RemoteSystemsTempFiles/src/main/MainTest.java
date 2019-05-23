package main;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import compiler.generated.Parser;
import compiler.generated.Scanner;

public class MainTest {
	public static Scanner scanner = null;

	public static void main(String[] args) throws IOException {
		String filePath = "test/programa";
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(filePath)));

			Parser parser = new Parser(scanner);
			parser.parse();
			if (Parser.errors == 0) {
				System.out.println("Processo de compila��o conclu�do com sucesso!");
				try {
					FileOutputStream fStream;
					PrintWriter mStream;
					fStream = new FileOutputStream("test/result.s");
					mStream = new PrintWriter(fStream);
					mStream.println(Parser.code);
					mStream.flush();
					mStream.close();
					System.out.println("\nCodigo escrito em test/result.s");
				} catch (IOException e) {
					e.printStackTrace(System.out);
					System.exit(1);
				}
			} else {
				System.out.println("Erros foram detectados e c�digo n�o foi produzido.");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
