package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
     
      Tabuleiro tabuleiro = new Tabuleiro();
      
      tk.writeBoard("Tabuleiro inicial", tabuleiro.getTabuleiro());
      for (int l = 0; l < commands.length; l++) {
          tabuleiro.mover(commands[l]);   
          tk.writeBoard("source: "+commands[l].split(":")[0]+"; target: "+commands[l].split(":")[1], tabuleiro.getTabuleiro());
      }

      tk.stop();
   }

}
