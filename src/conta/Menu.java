package conta;

import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:

				System.out.println("Criar Conta\n");

				System.out.print("Número da Conta: ");
				int numero = leia.nextInt();

				System.out.print("Agência: ");
				int agencia = leia.nextInt();

				System.out.print("Tipo da Conta (1-Conta Corrente | 2-Conta Poupança): ");
				int tipo = leia.nextInt();

				leia.nextLine();

				System.out.print("Titular: ");
				String titular = leia.nextLine();

				System.out.print("Saldo: ");
				float saldo = leia.nextFloat();

				switch (tipo) {

				case 1:

					System.out.print("Limite: ");
					float limite = leia.nextFloat();

					contas.cadastrar(
							new ContaCorrente(
									numero,
									agencia,
									tipo,
									titular,
									saldo,
									limite));

					break;

				case 2:

					System.out.print("Dia do Aniversário da Conta: ");
					int aniversario = leia.nextInt();

					contas.cadastrar(
							new ContaPoupanca(
									numero,
									agencia,
									tipo,
									titular,
									saldo,
									aniversario));

					break;

				default:
					System.out.println("Tipo de Conta inválido!");
				}

				break;

			case 2:

				System.out.println("Listar todas as Contas\n");
				contas.listarTodas();

				break;

			case 3:

				System.out.print("Digite o número da Conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				break;

			case 4:

				System.out.println("Atualização de Conta será implementada na próxima etapa.");

				break;

			case 5:

				System.out.print("Digite o número da Conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);

				break;

			case 6:

				System.out.print("Número da Conta: ");
				numero = leia.nextInt();

				System.out.print("Valor do Saque: ");
				float valorSaque = leia.nextFloat();

				contas.sacar(numero, valorSaque);

				break;

			case 7:

				System.out.print("Número da Conta: ");
				numero = leia.nextInt();

				System.out.print("Valor do Depósito: ");
				float valorDeposito = leia.nextFloat();

				contas.depositar(numero, valorDeposito);

				break;

			case 8:

				System.out.print("Conta Origem: ");
				int origem = leia.nextInt();

				System.out.print("Conta Destino: ");
				int destino = leia.nextInt();

				System.out.print("Valor da Transferência: ");
				float valorTransferencia = leia.nextFloat();

				contas.transferir(origem, destino, valorTransferencia);

				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}
		}
	}

	public static void sobre() {

		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Ana Karoline Costa de Sousa");
		System.out.println("github.com/anakarolinecostasousa-boop/contabancaria");
		System.out.println("*********************************************************");
	}
}