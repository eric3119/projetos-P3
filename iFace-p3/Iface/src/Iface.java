import java.util.Scanner;

class Iface {

	private static int MAX = 10;

	private static String[] nome = new String[MAX];
	private static String[] login = new String[MAX];
	private static String[] senha = new String[MAX];

	private static String[][] atributos = new String[5][MAX];
	private static String[][] recuperacao = new String[2][MAX];


	private static int[][] amigos = new int[MAX][MAX];
	private static String[][] mensagensUsr = new String[MAX][MAX];

	private static String[][] comunidades = new String[2][MAX];
	private static int[] proprietario = new int[MAX];
	private static int[][] membros = new int[MAX][MAX];
	private static String[][] mensagensComu = new String[MAX][MAX];

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		for (int i = 0; i < MAX; i++) {
			proprietario[i] = -1;
		}

		int opcao, naoSair = 1;

		while (naoSair == 1) {

			System.out.println("1-Criar conta\n" +
					"2-Logar\n" +
					"3-Recuperar Informacoes\n" +
					"4-Remover Conta\n" +
					"0-Encerrar\n");


			opcao = input.nextInt();
			input.nextLine();

			int idUser = -1;

			switch (opcao) {
				case 1:
					System.out.println("Nova conta");
					idUser = criarConta();
					break;
				case 2:
					System.out.println("Login");
					idUser = logar();
					break;
				case 3:
					idUser = recupInfo();
					break;
				case 4:
					System.out.println("Remover Conta");
					rmConta();
					break;
				case 0:
					naoSair = 0;
					break;
				default:
					System.out.println("opcao invalida");
			}

			while (idUser != -1) {

				System.out.println("\n1-Editar perfil\n" +
						"2-Adicionar amigo\n" +
						"3-Enviar mensagem\n" +
						"4-Criar comunidade\n" +
						"5-Tornar-se membro\n" +
						"0-Sair\n");
				opcao = input.nextInt();
				input.nextLine();

				switch (opcao) {
					case 1:
						System.out.println("Editar Perfil");
						editarPerfil(idUser);
						break;
					case 2:
						addAmigos(idUser);
						break;
					case 3:
						System.out.println("Enviar mensagem");
						enviarMsg(idUser);
						break;
					case 4:
						System.out.println("Criar comunidade");
						criarComu(idUser);
						break;
					case 5:
						System.out.println("Tornar-se membro");
						addMembr(idUser);
						break;
					case 0:
						idUser = -1;
						break;
					default:
						System.out.println("opcao invalida");
				}

				if (idUser == -1) {
					System.out.println("desconectado\n");
				}
			}

		}
	}

	private static int logar() {
		System.out.print("login: ");
		String user = input.nextLine();

		System.out.print("senha: ");
		String passwrd = input.nextLine();

		int idUser = buscarLogin(user);

		if (idUser == -1) {
			System.out.println("\nlogin nao cadastrado\n");
			return -1;
		}
		if (!senha[idUser].equals(passwrd)) {
			System.out.println("\nsenha incorreta\n");
			return -1;
		}
		return idUser;
	}

	private static int buscarLogin(String user) {

		int i = 0;

		while (i < MAX) {

			if (login[i] != null && login[i].equals(user))
				break;

			i++;
		}

		return (i != MAX) ? i : -1;
	}

	private static int buscarUsuario(String user) {
		int i = 0;

		while (i < MAX) {

			if (nome[i] != null && nome[i].equals(user))
				break;

			i++;
		}

		return (i != MAX) ? i : -1;
	}

	private static int buscarComunidade(String comu, int user) {
		for (int i = 0; i < MAX; i++) {
			if (membros[i][user] == 1 && comunidades[0][i] != null && comunidades[0][i].equals(comu))
				return i;
		}
		return -1;
	}

	private static int buscarComunidade(String comu) {
		for (int i = 0; i < MAX; i++) {
			if (comunidades[0][i] != null && comunidades[0][i].equals(comu))
				return i;
		}
		return -1;
	}

	private static int criarConta() {

		int pos = 0;

		while (pos < MAX) {

			if (nome[pos] == null)
				break;

			pos++;
		}

		if (pos != MAX) {
			System.out.print("nome: ");

			String temp = input.nextLine();

			while (buscarUsuario(temp) != -1) {
				System.out.printf("\nusuario %s ja cadastrado. escolha outro nome\nnome: ", temp);
				temp = input.nextLine();
			}
			nome[pos] = temp;

			System.out.print("\nlogin: ");

			temp = input.nextLine();

			while (buscarLogin(temp) != -1) {
				System.out.print("\nusuario ja cadastrado. escolha outro login\nnome: ");
				temp = input.nextLine();
			}

			login[pos] = temp;

			System.out.print("\nsenha: ");
			senha[pos] = input.nextLine();

			System.out.println("palavra de recuperacao");

			recuperacao[0][pos] = input.nextLine();

			System.out.println("resposta de recuperacao");

			recuperacao[1][pos] = input.nextLine();
		}
		return pos;
	}

	private static void editarPerfil(int pos) {

		System.out.println("\n1-editar nome\n" +
				"2-alterar senha\n" +
				"3-novo atributo\n" +
				"4-editar atributo\n");

		int opcao = input.nextInt();
		input.nextLine();

		switch (opcao) {
			case 1:
				System.out.print("novo nome: ");
				nome[pos] = input.nextLine();
				break;
			case 2:
				System.out.print("nova senha: ");
				senha[pos] = input.nextLine();
				break;
			case 3:
				novoAtrib(pos);
				break;
			case 4:
				editAtr(pos);
				break;
			default:
				System.out.println("opcao invalida");
		}
	}

	private static void novoAtrib(int idUser) {

		System.out.println("nome do atributo: ");

		String desc = input.nextLine();

		System.out.println("valor do atributo: ");

		String val = input.nextLine();

		for (int i = 0; i < 5; i++) {
			if (atributos[i][idUser] == null) {
				atributos[i][idUser] = desc + "#" + val;
				return;
			}
		}
	}

	private static void editAtr(int idUser) {

		String temp[][] = new String[5][2];
		String valor;

		int tam, pos;

		for (int i = 0; i < 5; i++) {

			valor = "";
			if (atributos[i][idUser] != null) {

				tam = atributos[i][idUser].length();

				for (pos = 0; pos < tam; pos++) {

					if (atributos[i][idUser].charAt(pos) != '#') {
						valor += atributos[i][idUser].charAt(pos);
					} else {

						temp[i][0] = valor;

						valor = "";
						break;
					}
				}

				for (; pos < tam; pos++) {
					valor += atributos[i][idUser].charAt(pos);
				}
				temp[i][1] = valor;
			}
		}

		for (int i = 0; i < 5; i++) {
			if (temp[i][0] != null)
				System.out.printf("%d-%s : %s\n", i, temp[i][0], temp[i][1]);
		}

		int opcao = input.nextInt();
		input.nextLine();
		System.out.print("novo valor: ");

		temp[opcao][1] = input.nextLine();

		atributos[opcao][idUser] = temp[opcao][0] + "#" + temp[opcao][1];

	}

	private static void addAmigos(int indUser) {

		System.out.print("adicionar: ");

		String nomeAdd = input.nextLine();

		int indAdd = buscarUsuario(nomeAdd);

		if (indAdd != -1 && indAdd != indUser) {

			if (amigos[indUser][indAdd] == 0) {//add novo amigo

				amigos[indUser][indAdd] = 3;//pendente
				amigos[indAdd][indUser] = 2;//solicitacao recebida

			} else if (amigos[indUser][indAdd] == 2) {//confirmar solicitacao

				amigos[indUser][indAdd] = 1;
				amigos[indAdd][indUser] = 1;

			} else if (amigos[indUser][indAdd] == 3) {
				System.out.println("A solicitacao ja foi enviada");
			}
		} else
			System.out.printf("%s\n", (indAdd == -1) ? "nao encontrado" : "nao permitido");
	}

	private static void enviarMsg(int indUser) {

		System.out.println("1-para usuarios\n2-para comunidades");

		int opcao = input.nextInt();
		input.nextLine();

		System.out.print("Nome: ");
		String dest = input.nextLine();

		if (opcao == 1) {//para usuarios
			int indDest = buscarUsuario(dest);

			if (indDest != -1 && amigos[indUser][indDest] == 1) {
				System.out.print("Mensagem: ");

				if (mensagensUsr[indUser][indDest] != null)
					mensagensUsr[indUser][indDest] += "\\" + input.nextLine();
				else
					mensagensUsr[indUser][indDest] = input.nextLine();

			} else
				System.out.println("nao encontrado/convite de amizade nao solicitado ou pendente");

		} else if (opcao == 2) {//para comunidades
			int indDest = buscarComunidade(dest, indUser);

			if (indDest != -1) {
				System.out.print("Mensagem: ");

				if (mensagensComu[indUser][indDest] != null)
					mensagensComu[indUser][indDest] += "\\" + input.nextLine();
				else
					mensagensComu[indUser][indDest] = input.nextLine();

			} else
				System.out.println("usuario nao e membro da comunidade");
		}


	}

	private static void criarComu(int indUser) {
		int i;

		for (i = 0; i < MAX; i++) {
			if (comunidades[0][i] == null)
				break;
		}

		if (i != MAX) {
			System.out.print("nome: ");
			String nomeComu = input.nextLine();

			System.out.println("\ndescricao");
			String desc = input.nextLine();

			proprietario[i] = indUser;
			comunidades[0][i] = nomeComu;
			comunidades[1][i] = desc;
		} else {
			System.out.println("limite maximo atingido");
		}
	}

	private static void addMembr(int indUser) {

		System.out.print("Nome da comunidade: ");
		String comu = input.nextLine();

		int indComu = buscarComunidade(comu);

		if (indComu != -1) {
			if (proprietario[indComu] == indUser) {
				System.out.println("\n\nUsuario proprietario da comunidade");
				return;
			}
			membros[indComu][indUser] = 1;
		} else {
			System.out.println("comunidade nao encontrada");
		}
	}

	private static int recupInfo() {

		System.out.print("Login: ");

		String user = input.nextLine();

		int indUser = buscarLogin(user);

		if (indUser == -1)
			System.out.println("\nnao cadastrado");
		else {

			if (verifSeguranca(indUser)) {
				System.out.print("\nAcesso recuperado\n");
				return indUser;
			} else {
				System.out.println("\nNao autorizado\n");
			}

		}

		return -1;
	}

	private static boolean verifSeguranca(int user) {
		System.out.println("palavra secreta");

		if (!recuperacao[0][user].equals(input.nextLine())) {
			return false;
		}

		System.out.println("resposta");

		return recuperacao[1][user].equals(input.nextLine());
	}

	private static void rmConta() {

		int indUser = logar();

		if (indUser == -1)
			return;

		// limpar propriedade de comunidades
		for (int i = 0; i < MAX; i++) {

			if (proprietario[i] == indUser) {
				proprietario[i] = -1;

				comunidades[0][i] = null;
				comunidades[1][i] = null;

				for (int j = 0; j < MAX; j++) {
					membros[i][j] = 0;
					mensagensComu[j][i] = null;
				}

			}
		}


		nome[indUser] = null;
		login[indUser] = null;
		senha[indUser] = null;

		// limpar relacionamentos mensagens e atributos
		for (int i = 0; i < MAX; i++) {
			if (amigos[indUser][i] != 0) {
				amigos[indUser][i] = 0;
				amigos[i][indUser] = 0;
			}
			membros[i][indUser] = 0;

			mensagensUsr[indUser][i] = null;
			mensagensUsr[i][indUser] = null;

			mensagensComu[indUser][i] = null;
		}

		for (int i = 0; i < 5; i++) {
			atributos[i][indUser] = null;
		}

		recuperacao[0][indUser] = null;
		recuperacao[1][indUser] = null;
	}
}
