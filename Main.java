/**
* ========================================*
* @author: Vítor Silva Pastor Gonzalez
* Matrícula: 763659
* 2022
* PUC-Minas
* ========================================*
*/

//IMPORTS

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

/*
*=========================================*
*            CLASS GAME
* ========================================*
*/

class Game {

	// variaveis
	private int app_id;
	private String name;
	private Date release_date;
	private String owners;
	private int age;
	private float price;
	private int dlcs;
	private String[] languages = new String[1000];
	private String website;
	private boolean windows;
	private boolean mac;
	private boolean linux;
	private float upvotes;
	private int avg_pt;
	private String developers;
	private String[] genres = new String[1000];

	// formatação para data
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.US);
	static int cont = 0;

	// CONSTRUTORES
	public Game() {

		this.app_id = -1;
		this.name = "admin";
		this.owners = "admin";
		this.age = -1;
		this.price = -1;
		this.dlcs = -1;
		this.languages = null;
		this.website = "admin";
		this.windows = false;
		this.mac = false;
		this.linux = false;
		this.upvotes = -1;
		this.avg_pt = -1;
		this.developers = "admin";
		this.genres = null;
	}

	/**
	 * @param app_id
	 * @param name
	 * @param owners
	 * @param age
	 * @param price
	 * @param dlcs
	 * @param website
	 * @param windows
	 * @param mac
	 * @param linux
	 * @param upvotes
	 * @param avg_pt
	 * @param developers
	 */
	public Game(int app_id, String name, String owners, int age, float price, int dlcs, String website, boolean windows,
			boolean mac, boolean linux, float upvotes, int avg_pt, String developers) {

		this.app_id = app_id;
		this.name = name;
		this.owners = owners;
		this.age = age;
		this.price = price;
		this.dlcs = dlcs;
		this.website = website;
		this.windows = windows;
		this.mac = mac;
		this.linux = linux;
		this.upvotes = upvotes;
		this.avg_pt = avg_pt;
		this.developers = developers;
	}

	// MÉTODOS E FUNÇÕES
	// SET
	public void setAppId(int new_id) {
		this.app_id = new_id;
	}

	public void setName(String new_name) {
		this.name = new_name;
	}

	public void setData(Date new_data) {
		this.release_date = new_data;
	}

	public void setOwners(String new_owners) {
		this.owners = new_owners;
	}

	public void setAge(int new_age) {
		this.age = new_age;
	}

	public void setPrice(float new_price) {
		this.price = new_price;
	}

	public void setDlcs(int new_dlcs) {
		this.dlcs = new_dlcs;
	}

	public void setLanguages(String[] new_languages) {
		this.languages = new_languages;
	}

	public void setWebsite(String new_website) {
		this.website = new_website;
	}

	public void setMac(boolean new_mac) {
		this.mac = new_mac;
	}

	public void setLinux(boolean new_linux) {
		this.linux = new_linux;
	}

	public void setWindows(boolean new_windows) {
		this.windows = new_windows;
	}

	public void setUpvotes(float new_upvotes) {
		this.upvotes = new_upvotes;
	}

	public void setAvgPt(int new_avgpt) {
		this.avg_pt = new_avgpt;
	}

	public void setDevelopers(String new_developers) {
		this.developers = new_developers;
	}

	public void setGenres(String[] new_genres) {
		this.genres = new_genres;
	}

	// GET

	public int getAppId() {
		return this.app_id;
	}

	public String getName() {
		return this.name;
	}

	public Date getData() {
		return this.release_date;
	}

	public String getOwners() {
		return this.owners;
	}

	public int getAge() {
		return this.age;
	}

	public float getPrice() {
		return this.price;
	}

	public int getDlcs() {
		return this.dlcs;
	}

	public String[] getLanguages() {
		return this.languages;
	}

	public String getWebsite() {
		return this.website;
	}

	public boolean getWindows() {
		return this.windows;
	}

	public boolean getMac() {
		return this.mac;
	}

	public boolean getLinux() {
		return this.linux;
	}

	public float getUpvotes() {
		return this.upvotes;
	}

	public int getAvgPt() {
		return this.avg_pt;
	}

	public String getDevelopers() {
		return this.developers;
	}

	public String[] getGenres() {
		return this.genres;
	}

	// CLONE
	/**
	 * @return
	 */
	public Game clonar() {

		Game gameCloned = new Game();

		gameCloned.app_id = this.app_id;
		gameCloned.name = this.name;
		gameCloned.release_date = (Date) this.release_date.clone();
		gameCloned.owners = this.owners;
		gameCloned.age = this.age;
		gameCloned.price = this.price;
		gameCloned.dlcs = this.dlcs;
		gameCloned.languages = this.languages.clone();
		gameCloned.website = this.website;
		gameCloned.windows = this.windows;
		gameCloned.mac = this.mac;
		gameCloned.linux = this.linux;
		gameCloned.upvotes = this.upvotes;
		gameCloned.avg_pt = this.avg_pt;
		gameCloned.developers = this.developers;
		gameCloned.genres = this.genres.clone();

		return gameCloned;
	}

	// imprime na tela todos os atributos privados
	public void imprimir() {
		System.out
				.println(this.app_id + " " + this.name + " " + dateFormat.format(this.release_date) + " " + this.owners
						+ " " + this.age + " " + this.price + " " + this.dlcs + printarLinguas() + this.website + " "
						+ this.windows + " " + this.mac + " " + this.linux + " " + Math.round(this.upvotes) + "% "
						+ printarTime(avg_pt) + " " + this.developers + printarGenres());
	}

	// lê o arquivo csv
	/**
	 * @param conteudo
	 * @throws Exception
	 */
	public void ler(String conteudo) throws Exception {
		// tratamento do app_id
		int first_index = 0;
		int last_index = conteudo.indexOf(",");

		String app_id = conteudo.substring(first_index, last_index); // pegando a parcela entre first até last index
		this.app_id = Integer.parseInt(app_id);

		// tratamento do nome
		first_index = ++last_index; // pular virgula

		// tratando jogos em que o nome possui virgula no mesmo
		// obs: a barra antes das aspas (\") significa um caracter de escape
		if (conteudo.charAt(first_index) == '\"') {
			last_index = conteudo.indexOf("\"", first_index + 1); // pesquisa a próxima aspas no nome do jogo
			last_index++; // pular para poder chegar na virgula
		} else {
			last_index = conteudo.indexOf(",", first_index); // caso não tenha virgula, trate normalmente
		}

		String name = conteudo.substring(first_index, last_index);
		this.name = name;

		// tratamento do Date
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String release_date = conteudo.substring(first_index, last_index);

		// tentando capturar datas com apenas mes e ano (primeiro caso)
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy", Locale.US); // locale é para mudar a formatação das
																				// datas para o estilo norte americano
			this.release_date = sdf.parse(release_date); // verifica o formato da data
		} catch (Exception e) { // se não der
			try { // tentar esse formato
				SimpleDateFormat sdf = new SimpleDateFormat("\"MMM dd, yyyy\"", Locale.US);
				last_index = conteudo.indexOf(",", last_index + 1); // o +1 tem como funçao pular a virgula já
																	// encontrada
				release_date = conteudo.substring(first_index, last_index); // pegar a parcela com a data
				this.release_date = sdf.parse(release_date);
			} catch (Exception e2) {
				e2.printStackTrace(); // printa erro caso falhe os dois try
			}
		}

		// tratamento do owners
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String owners = conteudo.substring(first_index, last_index);
		this.owners = owners;

		// tratamento do age
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String age = conteudo.substring(first_index, last_index);
		this.age = Integer.parseInt(age);

		// tratamento do price
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String price = conteudo.substring(first_index, last_index);
		this.price = Float.parseFloat(price);

		// tratamento das dlcs
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String dlcs = conteudo.substring(first_index, last_index);
		this.dlcs = Integer.parseInt(dlcs);

		// tratamento das languages
		first_index = conteudo.indexOf("[", first_index);

		if (conteudo.charAt(first_index - 1) == '\"') {
			last_index = conteudo.indexOf("]\"", first_index);
		} else {
			last_index = conteudo.indexOf("]", first_index);
		}

		String tmp = conteudo.substring(first_index + 1, last_index);
		String[] languages = tmp.split(",");

		for (int i = 0; i < languages.length; i++) {
			String temp = (languages[i].trim().substring(0, languages[i].trim().length()));
			languages[i] = (temp.replaceAll("'", ""));
		}

		last_index = conteudo.indexOf(",", last_index); // procura virgula após ]

		this.languages = languages;

		// tratamento do website
		first_index = ++last_index;

		if (first_index + 1 != last_index) {
			if (conteudo.charAt(first_index) == '\"') {
				last_index = conteudo.indexOf("\"", first_index + 1); // pesquisa a próxima aspas no website
				last_index++; // pular para poder chegar na virgula
			} else {
				last_index = conteudo.indexOf(",", first_index); // caso não tenha aspas, trate normalmente
			}

			String website = conteudo.substring(first_index, last_index);
			this.website = website;

		} else {
			this.website = null;
		}
		// tratamento do windows
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String windows = conteudo.substring(first_index, last_index);
		this.windows = Boolean.parseBoolean(windows);

		// tratamento do mac
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String mac = conteudo.substring(first_index, last_index);
		this.mac = Boolean.parseBoolean(mac);

		// tratamento do linux
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String linux = conteudo.substring(first_index, last_index);
		this.linux = Boolean.parseBoolean(linux);

		// tratamento do upvotes
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);
		float A = 0;
		float B = 0;

		// ler a
		String a = conteudo.substring(first_index, last_index);
		try {
			A = Float.parseFloat(a);
		} catch (Exception e) {
			e.printStackTrace(); // mostra erro
			System.err.println(a);
			System.exit(0);
		}

		// avança para ler b
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		// ler b
		String b = conteudo.substring(first_index, last_index);
		try {
			B = Float.parseFloat(b);
		} catch (Exception e) { // mostra erro
			e.printStackTrace();
			System.err.println(b);
			System.err.println("Name:" + this.name + " " + "ID: " + this.app_id);
			System.exit(0);
		}

		float upvotes = (A / (A + B) * 100); // formula para transformar em porcentagem
		this.upvotes = upvotes;

		// tratamento do avg_pt
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String avg_pt = conteudo.substring(first_index, last_index);

		this.avg_pt = Integer.parseInt(avg_pt);

		// tratamento do developers
		first_index = ++last_index;

		if (conteudo.charAt(first_index) == '\"') {
			last_index = conteudo.indexOf("\"", first_index + 1); // pesquisa a próxima aspas no nome do jogo
			first_index++; // pular para poder chegar na virgula
			conteudo.replaceAll(",", " ");
		} else {
			last_index = conteudo.indexOf(",", first_index); // caso não tenha virgula, trate normalmente
		}

		String developers = conteudo.substring(first_index, last_index);
		this.developers = developers;

		// tratamento dos genres
		try {
			first_index = conteudo.indexOf("\"", last_index + 1);
			last_index = conteudo.indexOf("\"", first_index + 1);
		} catch (Exception e) {
			try {
				first_index = ++last_index;
			} catch (Exception e2) {
				e.printStackTrace();
			}
		}

		String tmp3 = "";
		String[] genres = new String[1];

		try {
			tmp3 = conteudo.substring(first_index + 1, last_index);
		} catch (Exception e) {
			// crash here
			e.printStackTrace();
			System.err.println("first: " + first_index + "last: " + last_index);
			System.err.println(this.name);
		}

		try {
			genres = tmp3.split(",");
		} catch (Exception e) {
			genres[0] = tmp3;
		}

		for (int i = 0; i < genres.length; i++) {
			String temp3 = (genres[i].trim().substring(0, genres[i].trim().length()));
			genres[i] = (temp3.replaceAll("'", ""));

		}

		last_index = conteudo.indexOf(",", last_index);

		this.genres = genres;
	}

	// formata saida de languages
	public String printarLinguas() {
		String s = " [";

		for (int i = 0; i < languages.length; i++) {
			s += languages[i];

			if (i != languages.length - 1) {
				s += ", ";
			}
		}

		s += "] ";

		return s;
	}

	// formata saida de genres
	public String printarGenres() {

		String s = " [";

		for (int i = 0; i < genres.length; i++) {
			s += genres[i];

			if (i != genres.length - 1) {
				s += ", ";
			}
		}

		s += "] ";

		return s;
	}

	// formata saida do release_date
	public String printarTime(int avg_pt) {
		int horas, minutos;
		String timeFinish = "";

		horas = avg_pt / 60; // calc
		minutos = avg_pt % 60; // calc

		timeFinish = horas + "h" + " " + minutos + "m"; // formula

		if (avg_pt == 0)
			timeFinish = null;

		return timeFinish;
	}

	// Funcao para terminar a execucao do programa ao ser lido "FIM"
	public static boolean isFim(String entrada) {
		boolean isFim = true;

		// verifica
		if (entrada.equals("FIM")) {
			isFim = false;
		}

		return isFim;
	}

	// lê o arquivo game.csv
	public static String lerArquivoCsv(String app_id) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader("/tmp/games.csv"));

		String line = "";

		while ((line = br.readLine()) != null)
			if (line.contains(app_id))
				return line;

		return line;
	}
}

/*
 * to do in 'Game': fazer uma função para cada tratamento da função ler(),
 * alterando também caso necessário o método lerArquivoCsv.
 */

/*
 * =========================================*
 * CLASS Lista
 * ========================================*
 */

class Lista {

	// DECLARAÇÃO de VARIAVEIS
	public Game[] array;
	public int n;

	// CONSTRUTORES
	public Lista() {
		array = new Game[5000];
		n = 0;
	}

	// INSERIR NO INICIO
	public void inserirInicio(Game game) throws Exception {

		// validar insercao
		if (n >= array.length) {
			throw new Exception("Erro ao inserir!");
		}

		// levar elementos para o fim do array
		for (int i = n; i > 0; i--) {
			array[i] = array[i - 1];
		}

		array[0] = game;
		n++;
	}

	// INSERIR NO FIM
	public void inserirFim(Game game) throws Exception {

		// validar insercao
		if (n >= array.length) {
			throw new Exception("Erro ao inserir!");
		}

		array[n] = game;
		// contar numero de inserções
		n++;
	}

	// INSERIR NA POSIÇÃO DESEJADA
	public void inserir(Game game, int pos) throws Exception {

		// validar insercao
		if (n >= array.length || pos < 0 || pos > n) {
			throw new Exception("Erro ao inserir!");
		}

		// levar elementos para o fim do array
		for (int i = n; i > pos; i--) {
			array[i] = array[i - 1];
		}

		array[pos] = game;
		n++;
	}

	// REMOVER NO INICIO
	public Game removerInicio() throws Exception {

		// validar remocao
		if (n == 0) {
			throw new Exception("Erro ao remover!");
		}

		Game resp = array[0];
		n--;

		for (int i = 0; i < n; i++) {
			array[i] = array[i + 1];
		}

		return resp;
	}

	// REMOVER NO FIM
	public Game removerFim() throws Exception {

		// validar remocao
		if (n == 0) {
			throw new Exception("Erro ao remover!");
		}

		return array[--n];
	}

	// REMOVER
	public Game remover(int pos) throws Exception {

		// validar remoção
		if (n == 0 || pos < 0 || pos >= n) {
			throw new Exception("Erro ao remover!");
		}

		Game resp = array[pos];
		n--;

		for (int i = pos; i < n; i++) {
			array[i] = array[i + 1];
		}

		return resp;
	}

	// ORDENAR ARRAY
	public void sort() {

		for (int i = (n - 1); i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j].getName().compareTo(array[j + 1].getName()) > 0) {
					swap(j, j + 1);
				}
			}
		}
	}

	public void swap(int i, int j) {
		Game aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	// PESQUISA
	/**
	 * @param games
	 * @param entrada
	 * @return
	 */
	public boolean pesquisaSequencial(String entrada) {

		boolean resp = false;

		for (int i = 0; i < n; i++) {

			if (entrada.compareTo(array[i].getName()) == 0)
				resp = true;
		}

		return resp;
	}

	/**
	 * @param entrada
	 * @param esq
	 * @param dir
	 * @return
	 */
	public boolean pesquisaBinariaRecursiva(String entrada, int esq, int dir) {

		boolean resp;
		int meio = (esq + dir) / 2;

		// BUUBLESORT
		if (esq > dir) {
			resp = false;
		} else if (entrada.compareTo(array[meio].getName()) == 0) {
			resp = true;
		} else if (entrada.compareTo(array[meio].getName()) > 0) {
			resp = pesquisaBinariaRecursiva(entrada, meio + 1, dir);
		} else {
			resp = pesquisaBinariaRecursiva(entrada, esq, meio - 1);
		}

		return resp;
	}

	public boolean pesquisaBinariaRecursiva(String x) {
		return pesquisaBinariaRecursiva(x, 0, (n - 1));
	}

	public void imprimirLista() {

		for (int i = 0; i < n; i++) {
			System.out.printf("[%d] ", i);
			array[i].imprimir();
		}
	}
}

/*
 * =========================================*
 * CLASS MAIN
 * ========================================*
 */

class Main {

	public static String pesquisarGame(String id) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader("games.csv"));

		String linha = br.readLine();

		while(linha != null) {
			if(encontrarId(linha).equals(id)) {
				break;
			}

			linha = br.readLine();
		}

		br.close();

		return linha;
	}

	public static String encontrarId(String string) {
		return string.substring(0, string.indexOf(','));
	}

	public static BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Lista lista = new Lista();
		Game g = new Game();

		String entrada = bufferReader.readLine();

		while (!entrada.equals("FIM")) {

			String gameLine = Game.lerArquivoCsv(entrada);

			g.ler(gameLine);
			lista.inserirFim(g);

			entrada = bufferReader.readLine();
		}

		// lista.sort();

		// numero de operações
		int numOp = Integer.parseInt(bufferReader.readLine());

		// mudar para for de 0 ate numOp

		for (int i = 0; i < numOp; i++) {

			entrada = bufferReader.readLine();

			
			if (entrada.substring(0, 2).equals("II")) {
				
				entrada = entrada.substring(3, entrada.length());
				System.out.println(entrada);
				g.ler(pesquisarGame(entrada));

				lista.inserirInicio(g);

			}
			if (entrada.substring(0, 2).equals("IF")) {

				entrada = entrada.substring(3, entrada.length());
				System.out.println(entrada);
				g.ler(pesquisarGame(entrada));
				lista.inserirFim(g);
			}
			if(entrada.substring(0, 2).equals("I*")) {
				String aux = entrada.substring(3, 5);
				entrada = entrada.substring(5, entrada.length());

				System.out.println(entrada);
				g.ler(pesquisarGame(entrada));
				lista.inserir(g, Integer.parseInt(aux));
			}
			if(entrada.substring(0, 2).equals("RI")) {
				entrada = entrada.substring(3, entrada.length());

				System.out.println(entrada);
				g.ler(pesquisarGame(entrada));
				lista.removerInicio();
			}
			/*if(entrada.substring(0, 2).equals("RF")) {
				entrada = entrada.substring(3, entrada.length());

				System.out.println(entrada);
				g.ler(pesquisarGame(entrada));
				lista.removerFim();
			}
			if(entrada.substring(0, 2).equals("R*")) {
				String aux2 = entrada.substring(3, 5);
				entrada = entrada.substring(5, entrada.length());

				System.out.println(entrada);
				g.ler(pesquisarGame(entrada));
				lista.remover(Integer.parseInt(aux2));
			}
			if(entrada.substring(0, 3).equals("RF*")) {
				entrada = entrada.substring(5, entrada.length());

				System.out.println(entrada);
				g.ler(pesquisarGame(entrada));
				lista.removerFim();
			}*/

		}
		lista.imprimirLista();
	}
}