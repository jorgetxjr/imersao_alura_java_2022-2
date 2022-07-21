import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;
//isto é realmente necessário???
import java.lang.InterruptedException;
import java.lang.RuntimeException;

public class ClienteHttp{
	
	public String buscarDados(String url){
		try{
			URI endereco=URI.create(url);
			HttpClient client=HttpClient.newHttpClient();
			HttpRequest requisicao=HttpRequest.newBuilder(endereco).GET().build();
			HttpResponse<String> resposta=client.send(requisicao,BodyHandlers.ofString());
			String body=resposta.body();
			return body;
		}
		catch(IOException | InterruptedException ex){
			throw new RuntimeException(ex);
			//"embrulhando" uma exception que é obrigatória de ser tratada
			//em uma que não é obrigatória - RuntimeException.
		}
		
	}
}