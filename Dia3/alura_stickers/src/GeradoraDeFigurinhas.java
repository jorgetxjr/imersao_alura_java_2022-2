import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;//biblioteca para trabalhar com imagens

public class GeradoraDeFigurinhas{
	public void criar(InputStream inStream, String nomeArquivo) throws Exception{
		//leitura da imagem
		//nota pessoal: por que esses estranhos da Alura começam a escrever o conteúdo
		//e depois o tipo/nome da variável?
		//InputStream inStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
		BufferedImage imagemOriginal=ImageIO.read(inStream);
		//criar uma nova imagem em memória, com transparência e com tamanho novo
		int largura=imagemOriginal.getWidth();
		int altura=imagemOriginal.getHeight();
		int novaAltura=altura+200;
		
		BufferedImage novaImagem=new BufferedImage(largura,novaAltura,BufferedImage.TRANSLUCENT);
		//criando uma nova imagem, com o fundo transparente, eu acho.
		
		//copiar a imagem original para a nova imagem (ainda em memória)
		Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal,0,0,null);
		
		//configurar a fonte
		var fonte=new Font(Font.SANS_SERIF,Font.BOLD, 64);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(fonte);
		
		//escrever uma frase na nova imagem
		String str="texto para a imagem";
		graphics.drawString(str, 100, novaAltura-100);
		
		//escrever a nova imagem em um novo arquivo (salvar)
		String saida="../saida/"+nomeArquivo+".png";
		ImageIO.write(novaImagem,"png", new File(saida));
	}
}