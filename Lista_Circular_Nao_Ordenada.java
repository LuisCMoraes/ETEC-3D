import java.util.*;
public class Lista_Circular_Nao_Ordenada{
    /*Definindo a classe que representará
    cada elemento da lista*/
    private static class LISTA{
        public int num;
        public LISTA prox;
    }
    public static void main(String args[]){
        Scanner entrada = new Scanner(System.in);
        /* a lista está vazia, logo, o objeto
         * inicio tem o valor null e o objeto
         * inicio conterá o endereço do 
         * primeiro elemento da lista*/
     
        LISTA inicio = null;
        
        /*o objeto fim conterá o endereço
         * do último elemento da lista*/
         
        LISTA fim = null;
        
        //o objeto aux é um objeto auxiliar
        LISTA aux;
        
        //o objeto anterior é um objeto auxiliar
        LISTA anterior;
        
        //Apresetando o menu de opções
        int op, numero, achou;
        do{
            System.out.println("_________________________________");
            System.out.println("Menu de opções\n");
            System.out.println("1 - Inserir no inicio da lista");
            System.out.println("2 - Inserir no fim da lista");
            System.out.println("3 - Consultar toda a lista");
            System.out.println("4 - Remover da lista");
            System.out.println("5 - Esvaziar a lista");
            System.out.println("6 - Sair");
            System.out.println("\nDigite sua opção: ");
            op = entrada.nextInt();
            if(op <1 || op>6){
                System.out.println("\nOpção INVÁLIDA");
            }
            if ( op==1){
                System.out.println("Digite o número a ser inserido no início da lista");
                LISTA novo = new LISTA();
                novo.num = entrada.nextInt();
                if(inicio == null){
                    /* a lista estava vazia
                     * e o elemento inserido será
                     * o primeiro e o último
                     */
                inicio = novo;
                fim = novo;
                novo.prox = null;
                }else{
                    /* a lista já contém elementos
                     * e o novo elemento
                     * será inserido no início da lista
                     */
                    novo.prox = inicio;
                    inicio=novo;
                    fim.prox = inicio;
                }
                System.out.println("Número inserido no início da Lista!!");
            }
            if (op==2){
                System.out.println("Digite um número a ser inserido no fim da lista");
                LISTA novo = new LISTA();
                novo.num = entrada.nextInt();
                if(inicio == null){
                    /* a lista estava vazia
                     * e o elemento inserido será
                     * o primeiro e o último
                     */
                inicio = novo;
                fim = novo;
                novo.prox = inicio;
                }else{
                    /* a lista já contém elementos
                     * e o novo elemento
                     * será inserido no fim da lista
                     */
                    fim.prox = novo;
                    fim=novo;
                    fim.prox = inicio;
                }
                System.out.println("Número inserido no fim da Lista!!");
            }
         if(op==3){
                if(inicio==null){
                    //a lista está vazia
                    System.out.println("Lista vazia!!");
                }else{
                    /* a lista contém elementos e estes
                     * serão mostrados do início ao fim
                     */
                    System.out.println("Consultado toda a lista\n");
                    aux = inicio;
                    do{ 
                        System.out.println(aux.num + " ");
                        aux = aux.prox;
                    }while (aux != inicio);
                    }
                }
            if (op==4){
                if (inicio==null){
                    //a lista está vazia
                    System.out.println("Lista vazia!!");
                }else{
                    /* a lista contém elementos e o elemento a ser
                     * removido deve ser digitado
                     */
                    System.out.println("\nDigite o elemento a ser removido: ");
                    numero = entrada.nextInt();
                    /* todas as ocorrências da lista,
                     * iguais ao número digitado, serão removidas*/
                    aux = inicio;
                    anterior = null;
                    achou = 0;
                    /*descobrindo a quantidade de elementos
                     * da lista*/
                    int quantidade = 0;
                    aux = inicio;
                    do{
                        quantidade++;
                        aux = aux.prox;
                    }while (aux != inicio);
                    int elemento =1;
                    
                    do{
                        /* se a lista possui apenas
                         * um elemento*/
                        if (inicio==fim && inicio.num ==numero){
                            inicio = null;
                            achou++;
                        }else{
                            if (aux.num == numero){
                                /* o número digitado foi encontrado
                                 na lista e será removido*/
                                achou++;
                                
                                if (aux == inicio){
                                    /* o número a ser removido é o 
                                    * primeiro da lista*/
                                    inicio = aux.prox;
                                    fim.prox = inicio;
                                    aux = inicio;
                                }else if(aux == fim){
                                    /* o número a ser removido é
                                    * o último da lista   */
                                    fim = anterior;
                                    fim.prox = inicio;
                                    aux = aux.prox;
                                }else{
                                    /*o número a ser removido está
                                    * no meio da lista*/
                                    anterior.prox = aux.prox;
                                    aux = aux.prox;
                                }
                            }else{
                                anterior = aux;
                                aux = aux.prox;
                            }
                        }
                    elemento++;
                }while(elemento <=quantidade);
                 
                    if (achou ==0){
                        System.out.println("número não encontrado");
                    }else if(achou ==1){
                        System.out.println("Número removido uma vez");
                    }else{
                        System.out.println("Número removido "+ achou + " vezes");
                    }
                }
            }
            if (op==5){
                if (inicio == null){
                    //a lista está vazia
                    System.out.println("Lista vazia!!!");
                }else{
                    // a lista será esvaziada
                    inicio = null;
                    System.out.println("Lista esvaziada!!");
                }
           }    
        }while(op!=6);  
    }
}