/*
objetivos aula 1:
>>escrever um código que consuma dados do IMDB
*/
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
public class App{
	public static void main(String[] args)throws Exception{
		//fazer uma conexão http e buscar os top 250 filmes
		/*
		acesso do the movie data base
		String key="127d364048070d51ae2bb3d15264af35";
		String url="https://api.themoviedb.org/3/trending/all/day?api_key="+key;
		*/
		//acesso ao IMDB
		String key="k_ekfdc6n4";
		String url="https://imdb-api.com/en/API/Top250Movies/"+key;
		
		URI endereco=URI.create(url);//uma URL mais simples para o sistema
		HttpClient client=HttpClient.newHttpClient();
		HttpRequest requisicao=HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> resposta=client.send(requisicao,BodyHandlers.ofString());
		String body=resposta.body();
		//System.out.println(body);
		/*
		lembrando do funcionamento de uma requisição html;
		um cliente faz uma requisição e recebe uma resposta;
		desta resposta, retiramos apenas a parte do corpo(resposta.body())
		*/
		//extrair somente os dados que nos interessam (título, poster e classificação)
		JsonParser parser=new JsonParser();
		List<Map<String, String>> listaDeFilmes=parser.parse(body);
		//exibir e manipular os dados na aplicação
		System.out.println("Tamanho da lista: "+listaDeFilmes.size());
		for(Map<String,String> filmes:listaDeFilmes){
			System.out.println("Nome: "+filmes.get("title"));
			System.out.println("Poster: "+filmes.get("image"));
			System.out.println("Nota: "+filmes.get("imDbRating"));
			System.out.println();
		}
	} 
}
