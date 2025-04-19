import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        for(String candidato: candidatos) {
            entrandoEmContado(candidato);
        }
    }
    static void entrandoEmContado(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu= atender();
            continuarTentando = !atendeu;
            if(continuarTentando) {
                tentativasRealizadas++;
            }else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
        }while(continuarTentando && tentativasRealizadas <3);
        
        if(atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        }else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato +", NÚMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
        }
    }
    //método auxiliar
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados() {
        String [] candidatos = {"FELPE","MARCIA","JULIA","PAULO","AUGUSTO"};

        System.out.println("Imprimindo lista d candidatos informando o indice do elemento");

        for(int indice =0; indice < candidatos.length;indice++) {
            System.out.println("O candidato de nº" + (indice+1) + " é o " + candidatos[indice]);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"FELPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) { 
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}