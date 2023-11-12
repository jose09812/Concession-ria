package concessionaria.concessionaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcessionariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcessionariaApplication.class, args);
		//tentar criar um metodo de verificação:
		//Funcionario cria cliente e Gerente cria funcionario.

		 /*
     Case:Para deixar o codigo de uma forma melhor para quando outra pessoa for fazer a manutenção
     tudo tem que ficar separado, porém nessa parte da minha aplicação atingi uma barreira.
     Como fazer para buscar o carro que esta sendo vendido sem ter que usar a classe carro 
     porque se eu usar a classe carro e duas pessoas estiverem fazendo a manutenção o codigo 
     vendas vai quebrar quando a pessoa manipular a classe Carro ou cliente até mesmo o 
     funcionario que vai estar vendendo o carro eu iria usar essa mesma forma para incluir ele
     na TAB vendas.
     Possiveis soluções que eu pensei para o carro Adicionar uma coluna com um atributo perguntando se 
     o carro é da loja se o carro for da loja ele vai ser TRUE na variavel carro disponivel, sendo assim
     eu poderia fazer todo carro que for FALSE ser adicionado na tabela vendas aí eu nn teria esse problema.
     */
	}

}
