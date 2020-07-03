package estruturadados;

/* Dadas uma fila simplesmente encadeada F e uma pilha encadeada P, 
 * construa um programa para ler uma série dos dados de
 * nome e sexo de pessoas (F-Feminino/M-Masculino), de acordo com os
 * critérios: 
- se o sexo lido for feminino, inseri-lo na fila;
- se o sexo lido for masculino, inseri-lo na pilha;
- se o sexo lido for R, remover uma pessoa (se houver) de cada lista
 * e imprimir seus nomes.
*/

import javax.swing.JOptionPane;

public class Exercicio401{
	private static class LISTA{
		String nome;
		LISTA prox;
	}
	
	public static LISTA enfileirar(LISTA inicio, String nome){
		LISTA novo, aux;
		novo = new LISTA();
  		??????????????????????????????
  		novo.prox = null;
  		// inserção no fim da lista
  		if(inicio == null)
  			inicio = novo;
  		else{	  
  			aux = inicio;
  			while(aux.prox != null)
  				aux = aux.prox;
  			aux.prox = novo;
  		}
  		return inicio;
	}
	
	public static LISTA empilhar(LISTA topo, String nome){
		LISTA novo;
		// criando um novo nó e inserindo no topo da pilha
  		novo = new LISTA();
  		novo.nome = nome;
  		novo.prox = topo;
  		topo = novo;
  		
  		return topo;
	}	
	
	public static String imprimir(LISTA l, String msg, String novamsg){
		novamsg = novamsg + "\nElementos da " + msg +": ";
		while(l != null){
			????????????????????????????????
			l = l.prox;
		}	
		return novamsg;
	}
	
	public static void main(String args[]){
	  	// a lista está vazia, logo,
	  	// os objetos fila e topo têm o valor null
	  	// os objetos conterão o endereço 
		// do primeiro elemento da lista
	  	LISTA fila = null;
	  	LISTA topo = null;

	  	String nome="", sexo, msg="";
	  	
		sexo = JOptionPane.showInputDialog("Digite o sexo (F/M/R-Remover/P-Parar):");
	  	while(sexo.equalsIgnoreCase("P")==false){
	  		if(sexo.equalsIgnoreCase("R")==false)
	  			
	  		if(sexo.equalsIgnoreCase("F"))
	  			fila = enfileirar(fila, nome);
	  	
	  			topo = empilhar(topo, nome);
	  		else if(sexo.equalsIgnoreCase("R")){
	  			msg="";
	  			if(fila != null)
	  				msg = "\nElemento removido: "+fila.nome;
	  			if(topo != null)
	  				msg = msg + "\nElemento removido: "+topo.nome;
	  			if(msg.length() > 0)
	  				JOptionPane.showMessageDialog(null, msg);
	  			msg="";
	  			if(fila==null)
	  				msg = "Fila Vazia.";
	  			else{	// remover o primeiro elemento da fila
	  				fila = fila.prox;
	  				if(fila!=null)
	  					msg = imprimir(fila, "fila", "");
	  				else msg = msg + "\nFila Vazia.";
	  			}
	  			if(topo==null)
	  				msg = msg + "\nPilha vazia.";
	  			else{	// remover o primeiro elemento da pilha
	  				topo = topo.prox;
	  				if(topo!=null)
	  					msg = imprimir(topo, "pilha", msg);
	  				else msg = msg + "\nPilha Vazia.";
	  			}
	  			JOptionPane.showMessageDialog(null, msg);
	  		}
	  		// leitura do próximo sexo
			?????????????????????????
	  	}
	}
}

