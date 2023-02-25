import javax.swing.JOptionPane;

public class DesafioFinalJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cont = 0;
	
		String simbolo = "";
		int l = 0;
		int c = 0;
		boolean Valid = false;
		String[][] velha = new String[3][3];

		ImprimeMatriz(velha);

		do {
			cont += 1;
			simbolo = VezJogador(cont);
			if (Valid == false) {
				l = PedeLinha(simbolo);
				c = PedeColuna(simbolo);
				ValidarEspaco(l, c, velha, simbolo);
				Valid = Vitorias(velha,  cont, simbolo );
				ImprimePosicao(velha);
			}
		} while (cont < 9);
	}
	
	public static void ImprimeMatriz(String velha[][]) {
		//Imprimindo as posições da matriz pro usuario escolher uma casa 
		String aux = "";
		JOptionPane.showMessageDialog(null, "Estas são as posições:");

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				velha[i][j] = "-";
				aux += "Linha: " + (i + 1) + "  " + "Coluna: " + (j + 1) + "  ";
			}
			aux += "\n";
		}

		JOptionPane.showMessageDialog(null, aux);
	}

	public static String VezJogador(int cont) {
		//validação da  vez do jogador
		String simbolo = "";

		if ((cont % 2) == 0) {
			simbolo = "X";
		} else {
			simbolo = "O";
		}

		return simbolo;
	}

	public static int PedeLinha(String simbolo) {
//pedir em qual linha quer jogar
		int posicaoLinha = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Jogador "+simbolo+", Informe em qual LINHA gostaria de colocar"));
		while ((posicaoLinha != 1) && (posicaoLinha != 2) && (posicaoLinha != 3)) {
			posicaoLinha = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Objeto inválido, informe em qual LINHA gostaria de colocar"));
			
		}
		return posicaoLinha;
	}
	//alterar conforme PedeLinha
	public static int PedeColuna(String simbolo) {
		//pedir em quaL coluna quer jogar 
		int posicaoColuna = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Jogador "+simbolo+" Informe em qual COLUNA gostaria de colocar"));
		while ((posicaoColuna != 1) && (posicaoColuna != 2) && (posicaoColuna != 3)) {
			posicaoColuna = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Objeto inválido, informe em qual COLUNA gostaria de colocar"));
		}

		return posicaoColuna;
	}

	public static void ImprimePosicao( String velha[][]) {

		String aux = ""; // para cada invocação de metodo o aux se iniciarizará vazio, sendo assim,
		// não vai repetir as tabelas conforme estava dando erro e mostrando varias
		// tabelas.

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				aux += velha[i][j] + "  ";
			}
			aux += "\n";
		}

		JOptionPane.showMessageDialog(null, aux);

	
	}

	public static void ValidarEspaco(int l, int c, String velha[][], String simbolo) {
		boolean Valid;
//verificando os espaços do tabuleiro, se estiver vazio ok, se não estiver informa erro e pede novamente
		do {

			Valid = false;

			if ((velha[l - 1][c - 1].equals("X")) || (velha[l - 1][c - 1].equals("O"))) {
				Valid = true;
			}

			if (Valid == true) {
				
				JOptionPane.showMessageDialog(null, "A posição que você digitou já existe!", "Erro",
						(JOptionPane.INFORMATION_MESSAGE));

				l = PedeLinha(simbolo);
				c = PedeColuna(simbolo);

			}

		} while (Valid != false);

		velha[l - 1][c - 1] = simbolo;
	}

	//usar variavel simbolo como parâmetro; tirar else if de todas as situações e usar simbolo para generalizar;
	public static boolean Vitorias(String velha[][], int cont, String simbolo) {
		//verificação das vitorias
		boolean Valid = false;
		
		for (int i = 0; i < 3; i++) {
			if (velha[i][0].equals(simbolo) && (velha[i][1].equals(simbolo) && (velha[i][2].equals(simbolo)))) {
				JOptionPane.showMessageDialog(null, "O jogador "+simbolo+" ganhou!");
				Valid = true;	
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (velha[0][i].equals(simbolo) && (velha[1][i].equals(simbolo) && (velha[2][i].equals(simbolo)))) {
				JOptionPane.showMessageDialog(null, "O jogador "+simbolo+"ganhou!");
				Valid = true;
			}
		}

		if (velha[0][0].equals(simbolo) && (velha[1][1].equals(simbolo) && (velha[2][2].equals(simbolo)))) {
			JOptionPane.showMessageDialog(null, "O jogador "+simbolo+" ganhou!");
			Valid = true;
		
		}	
		if (velha[0][2].equals(simbolo) && (velha[1][1].equals(simbolo) && (velha[2][0].equals(simbolo)))) {
			JOptionPane.showMessageDialog(null, "O jogador "+simbolo+" ganhou!");
			Valid = true;
	
		//verificando se deu velha
		}else if ((Valid== false)  && (cont>=9)) {
		JOptionPane.showMessageDialog(null, "Deu velha!");	
		}
		
	return Valid;
	
	}
}
