import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class ExtratorDeConteudoDoImdb implements ExtratorDeConteudo{
	
	public List<Conteudo> extrairConteudos(String json){
		JsonParser parser=new JsonParser();
		List<Map<String, String>> listaDeAtributos=parser.parse(json);
		List<Conteudo> conteudos=new ArrayList<>();
		String titulo="";
		String urlImagem="";
		Conteudo conteudo=null;
		for (Map<String, String> atributos : listaDeAtributos) {

            titulo = atributos.get("title");
            urlImagem = atributos.get("image")
                    .replaceAll("(@+)(.*).jpg$", "$1.jpg");
            conteudo = new Conteudo(titulo, urlImagem);
 
            conteudos.add(conteudo);
         }
		return conteudos;
	}
	
}