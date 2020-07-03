    import java.util.Scanner;

public class Lista_Dupla_Ordenada{
    
    /*Definindo a classe que representará
    cada elelmento da lista*/
    
    private static class LISTA{
        
        public int num;
        public LISTA prox;
        public LISTA ant;
    }
    
    public static void main(String args[]){
        
        Scanner entrada = new Scanner(System.in);
        
        /* a lista está vazia, logo,
         * o objeto inicio tem o valor null
         * o objeto inicio conterá o endereço
         * do primeiro elemento da lista*/
        LISTA inicio = null;
        
        /* o objeto fim conterá o endereço
         * do último elemento da lista*/
        LISTA fim = null;
        
        /* o  objeto aux é um objeto auxiliar*/
        LISTA aux;
        
        //apresentando o menu de opções
        int op, numero, achou;
        do{
            System.out.println("_________________________________");
            System.out.println("Menu de opções\n");
            System.out.println("1 - Inserir na lista");
            System.out.println("2 - Consultar lista do INICIO ao fim");
            System.out.println("3 - Consultar lista do FIM ao inicio");
            System.out.println("4 - Remover da lista");
            System.out.println("5 - Esvaziar a lista");
            System.out.println("6 - Sair");
            System.out.println("\nDigite sua opção: ");
            op = entrada.nextInt();
            if(op <1 || op>6){
                System.out.println("\nOpção INVÁLIDA");
            }
            if (op ==1){
                System.out.println("Digite o número a ser inserido na lista");
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
                novo.ant = null;
                }else{
                    /* a lista já contém elementos
                     * e o novo elemento
                     * será inserido na lista
                     * respeitando a ordenação crescente
                     */
                    aux = inicio;
                    while(aux != null && novo.num > aux.num){
                        aux = aux.prox;
                    }
                    if (aux == inicio){
                        /* o novo número a ser inserido é 
                         * menor que todos os números da lista,
                         * logo, será inserido no
                         * início*/
                        novo.prox = inicio;
                        novo.ant = null;
                        inicio.ant = novo;
                        inicio = novo;
                   }else if(aux == null){
                    /* o novo número a ser inserido
                     * é maior que todos os números
                     * da lista, logo, será inserido
                     * no fim */
                     fim.prox = novo;
                     novo.ant = fim;
                     fim = novo;
                     fim.prox = null;
                    }else{
                       /* o novo número a ser inserido
                        * será inserido entre dois
                        * números que já estão na lista
                        */
                       novo.prox = aux;
                       aux.ant.prox = novo;
                       novo.ant = aux.ant;
                       aux.ant = novo;
                   }
                }
                System.out.println("Número inserido na Lista!!");
                
            }if(op==2){
                if (inicio ==null){
                    //a lista está vazia!!
                    System.out.println("Lista vazia!!");
                }else{
                    /* a lista contém elementos e estes
                     * serão mostrados do incício ao fim*/
                    System.out.println("\nConsultado a lista do início ao fim\n");
                    aux = inicio;
                    while (aux != null){
                        System.out.print(aux.num+"  ");
                        aux = aux.prox;
                    }
                }
            }if(op==3){
                if (inicio ==null){
                    //a lista está vazia!!
                    System.out.println("Lista vazia!!");
                }else{
                    /* a lista contém elementos e estes
                     * serão mostrados do fim ao inicio*/
                    System.out.println("\nConsultado a lista do fim ao inicio\n");
                    aux = fim;
                    while (aux != null){
                        System.out.print(aux.num+"  ");
                        aux = aux.ant;
                    }
                }                
            }if (op==4){
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
                    achou = 0;
                    while(aux != null){
                        if(aux.num == numero){
                            /* o número digitado foi encontrado
                            * na lista e será removido
                            */
                            achou++;
                            if (aux==inicio){
                                /* o número a ser removido é o primeiro
                                * da lista
                                */
                                inicio = aux.prox;
                                if(inicio !=null){
                                    inicio.ant = null;
                                }
                                aux = inicio;
                            }else if(aux == fim){
                                /* o número a ser removido é
                                * o último da lista   */
                                fim = fim.ant;
                                fim.prox = null;
                                aux = null;
                            }else{
                                /*o némero a ser removido está
                                * no meio da lista*/
                                aux.ant.prox = aux.prox;
                                aux.prox.ant = aux.ant;
                                aux = aux.prox;
                            }
                        }else{
                            aux = aux.prox;
                        }
                    }
                    if (achou ==0){
                        System.out.println("número não encontrado");
                    }else if(achou ==1){
                        System.out.println("Número removido uma vez");
                    }else{
                        System.out.println("Número removido "+ achou + " vezes");
                    }
                }
            }if(op==5){
                 if (inicio == null){
                    //a lista está vazia
                    System.out.println("Lista vazia!!!");
                }else{
                    // a lista será esvaziada
                    inicio = null;
                    System.out.println("Lista esvaziada!!");
                }
                
            }
        }while (op!=6);
    }
}