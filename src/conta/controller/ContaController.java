package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	@Override
	public void procurarPorNumero(int numero) {

		Conta conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.visualizar();
		} else {
			System.out.println("\nA Conta número " + numero + " não foi encontrada!");
		}
	}

	@Override
	public void listarTodas() {

		if (listaContas.isEmpty()) {
			System.out.println("\nNenhuma conta cadastrada.");
			return;
		}

		for (Conta conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {

		listaContas.add(conta);

		System.out.println("\nA Conta número " + conta.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {

		Conta buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta != null) {

			listaContas.set(listaContas.indexOf(buscaConta), conta);

			System.out.println("\nA Conta número " + conta.getNumero() + " foi atualizada com sucesso!");

		} else {

			System.out.println("\nA Conta número " + conta.getNumero() + " não foi encontrada!");
		}
	}

	@Override
	public void deletar(int numero) {

		Conta conta = buscarNaCollection(numero);

		if (conta != null) {

			listaContas.remove(conta);

			System.out.println("\nA Conta número " + numero + " foi apagada com sucesso!");

		} else {

			System.out.println("\nA Conta número " + numero + " não foi encontrada!");
		}
	}

	
	public Conta buscarNaCollection(int numero) {

		for (Conta conta : listaContas) {

			if (conta.getNumero() == numero) {
				return conta;
			}
		}

		return null;
	}
}