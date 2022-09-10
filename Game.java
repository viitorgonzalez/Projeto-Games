import java.util.*;
import java.io.File;
import java.text.SimpleDateFormat;

public class Game {

	private int app_id;
	private	String name;
	private Date release_date = new Date();
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

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.US);
	static int cont = 0;

	//CONSTRUTORES
	public  Game(){
		this.app_id = -1;
		this.name = "admin";
		this.owners = "admin";
		this.age = -1;
		this.price = -1;
		this.dlcs = -1;
		this.website = "admin";
		this.windows = false;
		this.mac = false;
		this.linux = false;
		this.upvotes = -1;
		this.avg_pt = -1;
		this.developers = "admin";

		//verificar se está nulo ou não
		this.languages = null;
		this.genres = null;
	}
	
	public Game(/*to do genres and languages*/int app_id, String name, String owners, int age, float price, int dlcs, String website, boolean windows, boolean mac, boolean linux, float upvotes, int avg_pt, String developers){
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

	//MÉTODOS E FUNÇÕES
	//SET
	public void setAppId(int new_id){
		this.app_id = new_id;
	}

	public void setName(String new_name){
		this.name = new_name;
	}

	public void setData(Date new_data){
		this.release_date = new_data;
	}

	public void setOwners(String new_owners){
		this.owners = new_owners;
	}

	public void setAge(int new_age){
		this.age = new_age;
	}

	public void setPrice(float new_price){
		this.price = new_price;
	}

	public void setDlcs(int new_dlcs){
		this.dlcs = new_dlcs;
	}

	public void setLanguages(String[] new_languages){
		this.languages = new_languages;
	}

	public void setWebsite(String new_website){
		this.website = new_website;
	}

	public void setMac(boolean new_mac){
		this.mac = new_mac;
	}

	public void setLinux(boolean new_linux){
		this.linux = new_linux;
	}

	public void setWindows(boolean new_windows){
		this.windows = new_windows;
	}

	public void setUpvotes(float new_upvotes){
		this.upvotes = new_upvotes;
	}

	public void setAvgPt(int new_avgpt){
		this.avg_pt = new_avgpt;
	}

	public void setDevelopers(String new_developers){
		this.developers = new_developers;
	}

	public void setGenres(String[] new_genres){
		this.genres = new_genres;
	}

	//GET

	public int getAppId(){
		return this.app_id;
	}

	public String getName(){
		return this.name;
	}

	public Date getData(){
		return this.release_date;
	}

	public String getOwners(){
		return this.owners;
	}

	public int getAge(){
		return this.age;
	}

	public float getPrice(){
		return this.price;
	}

	public int getDlcs(){
		return this.dlcs;
	}

	public String[] getLanguages(){
		return this.languages;
	}

	public String getWebsite(){
		return this.website;
	}

	public boolean getWindows(){
		return this.windows;
	}
	
	public boolean getMac(){
		return this.mac;
	}

	public boolean getLinux(){
		return this.linux;
	}

	public float getUpvotes(){
		return this.upvotes;
	}

	public int getAvgPt(){
		return this.avg_pt;
	}

	public String getDevelopers(){
		return this.developers;
	}

	public String[] getGenres(){
		return this.genres;
	}

	//CLONE	
	public Game clonar(){
		Game gameCloned = new Game();

		gameCloned.app_id = this.app_id;
		gameCloned.name = this.name;
		gameCloned.release_date = (Date)this.release_date.clone();
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

	//imprime na tela todos os atributos privados
	public void imprimir(){
		MyIO.println(this.app_id + " " + this.name + " " + dateFormat.format(this.release_date) + " " + this.owners + " " + this. age + " " + this. price + " " + this.dlcs + printarLinguas() + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " " + this.upvotes + " " + this.avg_pt + " " + this.developers + printarGenres());
	}

	//lê o arquivo csv
	public void ler(String conteudo) throws Exception{
		//tratamento do app_id
		int first_index = 0;
		int last_index = conteudo.indexOf(",");

		String app_id = conteudo.substring(first_index, last_index); //pegando a parcela entre first até last index
		this.app_id = Integer.parseInt(app_id); 

		//tratamento do nome
		first_index = ++last_index; //pular virgula

		//tratando jogos em que o nome possui virgula no mesmo
		//obs: a barra antes das aspas (\") significa um caracter de escape
		if(conteudo.charAt(first_index) == '\"'){
			last_index = conteudo.indexOf("\"", first_index + 1); //pesquisa a próxima aspas no nome do jogo
			last_index++; //pular para poder chegar na virgula
		} else {
			last_index = conteudo.indexOf(",", first_index); //caso não tenha virgula, trate normalmente
		}

		String name = conteudo.substring(first_index, last_index);
		this.name = name;
		
		//tratamento do Date
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String release_date = conteudo.substring(first_index, last_index);

		//tentando capturar datas com apenas mes e ano (primeiro caso)
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy", Locale.US); //locale é para mudar a formatação das datas para o estilo norte americano
			this.release_date = sdf.parse(release_date); //verifica o formato da data
		}catch (Exception e) { //se não der
			try{ //tentar esse formato
				SimpleDateFormat sdf = new SimpleDateFormat("\"MMM dd, yyyy\"", Locale.US);
				last_index = conteudo.indexOf(",", last_index + 1); //o +1 tem como funçao pular a virgula já encontrada
				release_date = conteudo.substring(first_index, last_index); //pegar a parcela com a data
				this.release_date = sdf.parse(release_date);
			}catch (Exception e2){
				e2.printStackTrace(); //printa erro caso falhe os dois try
			}	
		}	

		//tratamento do owners
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String owners = conteudo.substring(first_index, last_index);	
		this.owners = owners;	

		//tratamento do age
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String age = conteudo.substring(first_index, last_index);	
		this.age = Integer.parseInt(age);

		//tratamento do price
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String price = conteudo.substring(first_index, last_index);	
		this.price = Float.parseFloat(price);

		//tratamento das dlcs
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String dlcs = conteudo.substring(first_index, last_index);	
		this.dlcs = Integer.parseInt(dlcs);

		//tratamento das languages
		first_index = conteudo.indexOf("[");
		last_index = conteudo.indexOf("]");

		String tmp = conteudo.substring(first_index + 1, last_index);
		String[] languages = tmp.split(",");

		for(int i = 0; i < languages.length; i++){
			String temp = (languages[i].trim().substring(0,languages[i].trim().length()));
			languages[i] = (temp.replaceAll("'", ""));
		}			

		this.languages = languages;
		  
		//tratamento do website
		first_index = last_index += 2;
		last_index = conteudo.indexOf(",", first_index);

		String website = conteudo.substring(first_index, last_index);	
		this.website = website;

 		//tratamento do windows
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String windows = conteudo.substring(first_index, last_index);	
		this.windows = Boolean.parseBoolean(windows);

		//tratamento do mac
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String mac = conteudo.substring(first_index, last_index);	
		this.mac = Boolean.parseBoolean(mac);

		//tratamento do linux
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String linux = conteudo.substring(first_index, last_index);	
		this.linux = Boolean.parseBoolean(linux);

	   //tratamento do upvotes
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		// a / (a + b) == upvotes

		String upvotes = conteudo.substring(first_index, last_index);	
		this.upvotes = Float.parseFloat(upvotes);
	

	/*	//tratamento do avg_pt
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String avg_pt = conteudo.substring(first_index, last_index);	
		this.avg_pt = Integer.parseInt(avg_pt);

		//tratamento do developers
		first_index = ++last_index;
		last_index = conteudo.indexOf(",", first_index);

		String developers = conteudo.substring(first_index, last_index);	
		this.developers = developers;

	 	//tratamento dos genres
		first_index = conteudo.indexOf("\"");
		last_index = conteudo.indexOf("\"");

		String tmp2 = conteudo.substring(first_index, last_index);
		String[] genres = tmp2.split(",");

		for(int i = 0; i < genres.length; i++){
			String temp2 = (genres[i].trim().substring(0,genres[i].trim().length()));
			genres[i] = (temp2.replaceAll("'", ""));
		}

		this.genres = genres; 
		*/
	}	
	
	public String printarLinguas(){
		String s = " [";

		for(int i = 0; i < languages.length; i++){
			s += languages[i];

			if(i != languages.length - 1){
				s += ", ";
			}
		}

		s += "] ";

		return s;
	}

	public String printarGenres(){
		String s = " [";

		for(int i = 0; i < genres.length; i++){
			s += genres[i];

			if(i != genres.length - 1){
				s += ", ";
			}
		}

		s += "] ";

		return s;
	}

	//lê pub.in
	public static boolean isFim(String entrada){  //Funcao para terminar a execucao do programa ao ser lido "FIM"
		boolean isFim = true;

		if(entrada.equals("FIM")){ //verifica
				isFim = false;
		}
		return isFim;
	}

	public static Game[] lerArquivoCsv() throws Exception{
		Game[] games = new Game[5000];
		Scanner scanner = new Scanner(new File("/tmp/games.csv")); //entrada pelo arquivo games.csv
		String entrada = new String();

		//lê até acabar o arquivo
		while(scanner.hasNext()){
			entrada = scanner.nextLine(); //lê csv
			Game objeto = new Game(); 

			objeto.ler(entrada);	//tratamento para transformar em conteudo do jogo
			games[cont++] = objeto; //adiciona jogo para o array
		}

	return games;
	}

	//MAIN
	 public static void main(String[] args) throws Exception{
		String entrada = MyIO.readLine();

		Game[] games = lerArquivoCsv();

		while(isFim(entrada)){
			
			int app_id = Integer.parseInt(entrada);

			for(int i = 0; i < cont; i++){
				if(games[i].app_id == app_id){
					games[i].imprimir();
				}
			}
			
			entrada = MyIO.readLine();
			
	    }	


	}
}



/*	SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy")
 * 	release_date = new sdf.parse("texto")   string to date
 * sysout((sdf.format)(release_date));     date to string
 */


 //criar array de games para imprimir (melhor pro tp3)


 /*for(int i = 0; i < games.length; i++){
	if(games[i].app_id == app_id){
		games[i].imprimir();
		}
	}*/