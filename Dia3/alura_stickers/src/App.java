/*
objetivos aula 3:
>> deixar o código mais abstrato, podendo receber outras origens de dados
*/
import java.io.InputStream;
import java.net.URL;
import java.util.List;
public class App{
	public static void main(String[] args)throws Exception{
		//fazer uma conexão http e buscar os top 250 filmes
		/*
		acesso do the movie data base
		String key="127d364048070d51ae2bb3d15264af35";
		String url="https://api.themoviedb.org/3/trending/all/day?api_key="+key;
		/*acesso ao IMDB
		String key="k_ekfdc6n4";
		String url="https://imdb-api.com/en/API/Top250Movies/"+key;
		ExtratorDeConteudo extrator = new ExtratorDeConteudoImdb();
		*/
		//Acesso ao API da Nasa
		String key="xFP73f7uspELiyDEASJu1gtXoYoH0aLVefqYhRN9";
		//String url="https://api.nasa.gov/planetary/apod?api_key="+key;
		String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
		ExtratorDeConteudo extrator=new ExtratorDeConteudoDaNasa();
		
		//extrair somente os dados que nos interessam (título, poster e classificação)
		ClienteHttp http=new ClienteHttp();
		String json=http.buscarDados(url);
		//System.out.println("JSON: \n"+json);//for debug
		
		//exibir e manipular os dados
		
		List<Conteudo> conteudos=extrator.extrairConteudos(json);
		GeradoraDeFigurinhas gerador=new GeradoraDeFigurinhas();
		//System.out.println("Tamanho da lista: "+conteudos.size());
		InputStream in=null;
		String nome="";
		Conteudo conteudo=null;
		
		for(int i=0;i<3;i++){
			conteudo=conteudos.get(i);
			in=new URL(conteudo.getUrlImagem()).openStream();
			nome=conteudo.getTitulo();
			gerador.criar(in,nome);
			System.out.println(nome);
			//System.out.println("Poster: "+filmes.get("image"));
			//System.out.println("Nota: "+filmes.get("imDbRating"));
			System.out.println();
		}
	} 
}
