package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
	int tamanhoAquario, tamanhoLombriga;
	int posicaoInicial;
	String comandos;
	int numeroComandos, comandoAtual;
	AquarioLombriga lombriga;
	
	Animacao (String comandosAnimacao){
		tamanhoAquario = Integer.parseInt(comandosAnimacao.substring(0,2));
		tamanhoLombriga = Integer.parseInt(comandosAnimacao.substring(2,4));
		posicaoInicial = Integer.parseInt(comandosAnimacao.substring(4,6));
		comandos = comandosAnimacao.substring(6);
		numeroComandos = comandos.length();
		comandoAtual = 0;
		lombriga = new AquarioLombriga(tamanhoAquario, tamanhoLombriga, posicaoInicial);
	}
	
	public void passo() {
		comandoAtual++;
		switch(comandos.toCharArray()[comandoAtual-1]) {
			case 'M': {
				lombriga.mover();
				break;
			} 
			case 'C':{
				lombriga.crescer();
				break;
			}
			case 'V':{
				lombriga.virar();
				break;
			}
		}
		//System.out.println( comandos.toCharArray()[comandoAtual-1]);
	}
	
	public String apresenta() {
		//return String.format("Aquario:%d - Lombriga: %d - Inicio: %d - %s", tamanhoAquario, tamanhoLombriga, posicaoInicial, comandos);
		return lombriga.apresenta();
	}
}
