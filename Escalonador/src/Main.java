import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import jdk.jshell.spi.ExecutionControl.ExecutionControlException;

public class Main {
	static int quantBaixa, quantAlta, quantMedia;
	static Random random = new Random();
	static Processo processo;
	static ArrayList<Processo> processosFinalizados = new ArrayList<Processo>();
	static ArrayList<Processo> processosDeAltaPrioridade = new ArrayList<Processo>();
	static ArrayList<Processo> processosDeMediaPrioridade = new ArrayList<Processo>();
	static ArrayList<Processo> processosDeBaixaPrioridade = new ArrayList<Processo>();

	public static void novo() {
		try {
		String aux = JOptionPane.showInputDialog(null, "Me  diga a quatidade de processos de baixa prioridade.");
		quantBaixa = Integer.parseInt(aux);
		aux = JOptionPane.showInputDialog(null, "Me diga a quantidade de processos de média prioridade");
		quantMedia = Integer.parseInt(aux);
		aux = JOptionPane.showInputDialog(null, "Me diga a quantidade de processos de Alta prioridade");
		quantAlta = Integer.parseInt(aux);
		}catch( NumberFormatException nn) {
			System.out.println(nn);
		}
		for (int index = 0; index <= quantAlta - 1; index++) {
			processo = new Processo();
			processo.setID(index + "a");
			processo.setTempo(random.nextInt(9) + 1);
			processo.setPrioridade(3);
			processosDeAltaPrioridade.add(processo);

		}

		for (int index = 0; index <= quantMedia - 1; index++) {
			processo = new Processo();
			processo.setID(index + "m");
			processo.setTempo(random.nextInt(9) + 1);
			processo.setPrioridade(2);
			processosDeMediaPrioridade.add(processo);

		}

		for (int index = 0; index <= quantBaixa - 1; index++) {
			processo = new Processo();
			processo.setID(index + "b");
			processo.setTempo(random.nextInt(9) + 1);
			processo.setPrioridade(1);
			processosDeBaixaPrioridade.add(processo);

		}
	}

	public static void pronto() {
		while (processosDeAltaPrioridade.isEmpty() == false || processosDeBaixaPrioridade.isEmpty() == false
				|| processosDeMediaPrioridade.isEmpty() == false) {

			for (int index = 0; index < 3 && processosDeAltaPrioridade.isEmpty() == false; index++) {
				Processo pAux1, pAux2;
				pAux1 = new Processo();
				pAux2 = new Processo();
				processo = new Processo();
				processo = processosDeAltaPrioridade.get(processosDeAltaPrioridade.size() - 1);
				processo = executa(processo);
				if (processo.getTempo() <= 0) {
					try {
						finaliza(processo);
						processosDeAltaPrioridade.remove(processosDeAltaPrioridade.size() - 1);
						processo = processosDeAltaPrioridade.get(processosDeAltaPrioridade.size() - 1);
					} catch (Exception e) {

					}
				}
				pAux1 = processo;
				for (int index1 = 0; index1 <= processosDeAltaPrioridade.size() - 1; index1++) {
					pAux2 = processosDeAltaPrioridade.get(index1);
					processosDeAltaPrioridade.set(index1, pAux1);
					pAux1 = pAux2;
				}
			}

			for (int index = 0; index < 2 && processosDeMediaPrioridade.isEmpty() == false; index++) {
				Processo pAux1, pAux2;
				pAux1 = new Processo();
				pAux2 = new Processo();
				processo = new Processo();
				processo = processosDeMediaPrioridade.get(processosDeMediaPrioridade.size() - 1);
				processo = executa(processo);
				if (processo.getTempo() <= 0) {
					try {
						finaliza(processo);
						processosDeMediaPrioridade.remove(processosDeMediaPrioridade.size() - 1);
						processo = processosDeMediaPrioridade.get(processosDeMediaPrioridade.size() - 1);
					} catch (Exception e) {

					}

				}
				pAux1 = processo;
				for (int index1 = 0; index1 <= processosDeMediaPrioridade.size() - 1; index1++) {
					pAux2 = processosDeMediaPrioridade.get(index1);
					processosDeMediaPrioridade.set(index1, pAux1);
					pAux1 = pAux2;
				}
			}

			for (int index = 0; index < 1 && processosDeBaixaPrioridade.isEmpty() == false; index++) {
				Processo pAux1, pAux2;
				pAux1 = new Processo();
				pAux2 = new Processo();
				processo = new Processo();
				processo = processosDeBaixaPrioridade.get(processosDeBaixaPrioridade.size() - 1);
				processo = executa(processo);

				if (processo.getTempo() <= 0) {
					try {
						finaliza(processo);
						processosDeBaixaPrioridade.remove(processosDeBaixaPrioridade.size() - 1);
						processo = processosDeBaixaPrioridade.get(processosDeBaixaPrioridade.size() - 1);
					} catch (Exception e) {

					}
				}
				pAux1 = processo;
				for (int index1 = 0; index1 <= processosDeBaixaPrioridade.size() - 1; index1++) {
					pAux2 = processosDeBaixaPrioridade.get(index1);
					processosDeBaixaPrioridade.set(index1, pAux1);
					pAux1 = pAux2;
				}
			}

		}

	}

	public static Processo executa(Processo processo) {
		try {
			Thread.sleep(1);

		} catch (InterruptedException e) {

		}
		processo.setTempo(processo.getTempo() - 1);

		return processo;

	}

	public static void finaliza(Processo processo) {
		processosFinalizados.add(processo);
	}

	public static void main(String args[]) {
		novo();
		System.out.println(
				" Processos de baixa prioridade: " + processosDeBaixaPrioridade + "\n Processos de média prioridade: "
						+ processosDeMediaPrioridade + "\n Processos de Alta Priordade: " + processosDeAltaPrioridade);

		pronto();

		System.out.print("\n\n\n" + processosDeBaixaPrioridade + "\n" + processosDeMediaPrioridade + "\n"
				+ processosDeAltaPrioridade + "\n" + processosFinalizados);
		System.out.print("\nAcabou os Processos!!!!!!!!!!!!!!!!!!!!!!");
	}

}
