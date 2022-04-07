package pt.c02oo.s02classe.s03lombriga;

public class Lombriga {
    int tamanhoLombriga, tamanhoAquario;
    int posicaoInicial;
    char[] representacao;
    boolean esquerda;

    AquarioLombriga ( int tamanhoAquario, int tamanhoLombriga, int posicaoInicial){
        this.tamanhoLombriga = tamanhoLombriga;
        this.tamanhoAquario = tamanhoAquario;
        this.posicaoInicial = posicaoInicial;
        this.esquerda = true;
        this.representacao = new char[tamanhoAquario];
    }
    
    public void crescer() {
    	if(this.esquerda && (this.tamanhoAquario-this.posicaoInicial+1-this.tamanhoLombriga) > 0) {
    		this.tamanhoLombriga++;
    	} else if (!this.esquerda && (this.posicaoInicial - this.tamanhoLombriga) > 0){
    		this.tamanhoLombriga++;
    	}
    }
    
    public void virar() {
    	if(this.esquerda) {
    		this.posicaoInicial = this.posicaoInicial + this.tamanhoLombriga - 1;
    	} else {
    		this.posicaoInicial = this.posicaoInicial - this.tamanhoLombriga + 1;
    	}
    	this.esquerda = !this.esquerda;
    }
    
    public void mover() {
    	if(this.esquerda) {
    		if(this.posicaoInicial == 1) this.virar();
    		else this.posicaoInicial--;
    	} else {
    		if(this.posicaoInicial == this.tamanhoAquario) this.virar();
    		else this.posicaoInicial++;
    	}
    }
    
    public String apresenta() {
        for(int i = 0; i<tamanhoAquario; i++){
            this.representacao[i] = '#';
        }
    	if(this.esquerda) {
	        this.representacao[posicaoInicial-1] = 'O';
	        for(int i = 0; i<tamanhoLombriga-1; i++){
	            if(posicaoInicial+i < tamanhoAquario) 
	                this.representacao[posicaoInicial+i] = '@';
	        }
    	} else {
    		this.representacao[posicaoInicial-1] = 'O';
    		for(int i = 0; i<tamanhoLombriga-1; i++){
	            if(posicaoInicial-2-i >= 0) 
	                this.representacao[posicaoInicial-2-i] = '@';
	        }
    	}
    	String string = new String(this.representacao);
    	return string; 
    }
}
