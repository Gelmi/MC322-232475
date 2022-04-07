package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

   public static void main(String[] args) {
      Toolkit tk = Toolkit.start();
      
      String lombrigas[] = tk.recuperaLombrigas();
      
	  for (int l = 0; l < lombrigas.length; l++) { 
		  Animacao animacao = new
		  Animacao(lombrigas[l]); tk.gravaPasso("=====");
		  tk.gravaPasso(animacao.apresenta()); 
		  while(animacao.comandoAtual < animacao.numeroComandos) { 
			  animacao.passo();
			  tk.gravaPasso(animacao.apresenta()); 
		  } 
	  }
		 
		
		/*
		 * Lombriga lombriga = new Lombriga(8, 4, 3);
		 * tk.gravaPasso(lombriga.apresenta()+' '+lombriga.tamanhoLombriga);
		 * lombriga.crescer();
		 * tk.gravaPasso(lombriga.apresenta()+" "+lombriga.tamanhoLombriga);
		 * lombriga.virar(); tk.gravaPasso(lombriga.apresenta()+'
		 * '+lombriga.tamanhoLombriga); lombriga.mover();
		 * tk.gravaPasso(lombriga.apresenta()+" "+lombriga.tamanhoLombriga);
		 * lombriga.mover(); tk.gravaPasso(lombriga.apresenta()+'
		 * '+lombriga.tamanhoLombriga); 
		 */
	  tk.stop();
   }

}
