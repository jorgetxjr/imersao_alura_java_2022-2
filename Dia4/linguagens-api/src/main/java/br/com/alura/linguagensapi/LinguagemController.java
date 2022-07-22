package br.com.alura.linguagensapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {
  @Autowired
  private LinguagemRepository repositorio;

  @GetMapping(value = "/linguagem-preferida")
  public String getLinguagemPreferida(){
    return "Oi, java!";
  }

  @GetMapping(value = "/linguagens")
  public List<Linguagem> getLinguagens(){
    List<Linguagem> linguagens =repositorio.findAll();
    return linguagens;
  }
  @PostMapping("/linguagens")
  public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem){
    var linguagemSalva=repositorio.save(linguagem);
    return linguagemSalva;
    //testar com o postman local

  }
  
}
