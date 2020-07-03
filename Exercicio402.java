package estruturadados;

/*Escreva um programa que leia uma sequência de números naturais,
 * armazenando-os numa pilha. O fim da leitura deve ser feito pela
 * entrada de um número negativo. O programa deve verificar a ocorrência,
 * na lista, de dois nós vizinhos que sejam primos.*/

import java.util.Scanner;


public class Exercicio402 {
	private static class LISTA
	{
		int numero;
		LISTA prox;
	}
	public static LISTA empilhar(LISTA topo, int numero)
	{
		LISTA novo;
		// criando um novo nó e inserindo no topo da pilha
  		novo = new LISTA();
  		novo.numero = numero;
  		novo.prox = topo;
  		topo = novo;
  		
  		return topo;
	}	
	public static int verifica(LISTA l, int resp)
	{
		int b;
		if(l!=null)
		{
			b = primo(l.numero);
			if(resp==1 && b==1) 
				return 1;
			else
				return verifica(l.prox, b);
		}
		return 0;
	}
	public static int primo(int n)
	{
		for(int i = 2; i <= Math.sqrt(n); i++)
			if(n%i == 0)
				return 0;
		
                return 1; 
	}
	public static void imprimir(LISTA l)
	{
		String novamsg = "";
		novamsg = "\nElementos da pilha: ";
		while(l != null)
		{
			novamsg = novamsg + l.numero + " ";
			l = l.prox;
		}	
		System.out.print(novamsg);
	}	
	public static void main(String args[])
	{
	  	// a pilha está vazia, logo,
	  	// o objeto topo tem o valor null
	  	LISTA topo = null;
	  	// entrada de dados
	  	Scanner entrada = new Scanner(System.in);
	  	// variáveis auxiliares
	  	int numero;
	  	
	  	System.out.print("Digite os números da pilha: ");
		numero = entrada.nextInt();
	  	while(numero != -1)
	  	{
  			topo = empilhar(topo, numero);
  			numero = entrada.nextInt();
	  	}
	  	// verificando se há dois primos vizinhos na lista
	  	if(topo == null)
	  		System.out.print("Pilha vazia");
	  	else
	  	{
		  	imprimir(topo);
		  	if(verifica(topo,0)==1)
			  	System.out.print("\n\nHá dois primos vizinhos na pilha");
		  	else System.out.print("\n\nNão há dois primos vizinhos na pilha");
	  	}
	}
}
