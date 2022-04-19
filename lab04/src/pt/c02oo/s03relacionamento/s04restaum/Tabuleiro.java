package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	private Peca[][] tabuleiro = new Peca[7][7];
	
	Tabuleiro(){
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				if(valida(i,j)) tabuleiro[i][j] = new Peca();
			}
		}
	}
	
	public char[][] getTabuleiro() { 
		char[][] tabuleiroTexto = new char[7][7];
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				if(tabuleiro[i][j] != null) tabuleiroTexto[i][j] = 'P';
				else {
					if(valida(i, j) || (i == 3 && j == 3)) tabuleiroTexto[i][j] = '-';
					else tabuleiroTexto[i][j] = ' ';
				}
			}
		}
		return tabuleiroTexto; 
	}
	
	private boolean valida (int a, int b) {
		if(a < 2 && b < 2) return false;
		if(a > 4 && b < 2) return false;
		if(a < 2 && b > 4) return false;
		if(a > 4 && b > 4) return false;
		if(a == 3 && b == 3) return false;
		return true;
	}
	
	public Peca getPeca (int[] coord) {
		if(coord[0] == -1 || coord[1] == -1) return null;
		return tabuleiro[coord[1]][coord[0]];
	}
	
	private int[][] comandoParaIndice(String comando){
		String[] comandosSeparados = comando.split(":");
		int[][] comandos = new int[3][2];
		for(int i = 0; i < 2; i++) {
			comandos[i][0] = ((int)(comandosSeparados[i].toCharArray()[0]))-97;
			comandos[i][1] = Integer.parseInt(comandosSeparados[1].split("")[1]) - 1 ;
		}
		if(Math.abs(comandos[0][0] - comandos[1][0]) <= 2 && Math.abs(comandos[0][1] - comandos[1][1]) <= 2) {
			comandos[2][0] = (comandos[0][0] + comandos[1][0])/2;
			comandos[2][1] = (comandos[0][1] + comandos[1][1])/2;
		} else {
			comandos[2] = new int[]{ -1, -1};
		}
		return comandos;
	}

	public boolean mover(String comando) {
		//cada lista da matriz é um par ordenado (char convertido para inteiro, inteiro)
		int[][] comandos = comandoParaIndice(comando);
		Peca pecaMovedora = getPeca(comandos[0]);
		if(pecaMovedora == null) return false;
		if(pecaMovedora.mover(getPeca(comandos[1]), getPeca(comandos[2])) != null) {
			tabuleiro[comandos[0][1]][comandos[0][0]] = null;
			tabuleiro[comandos[1][1]][comandos[1][0]] = pecaMovedora;
			tabuleiro[comandos[2][1]][comandos[2][0]] = null;
			return true;
		}
		return false;
	}
}
