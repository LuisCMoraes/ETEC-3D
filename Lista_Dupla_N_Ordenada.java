package estruturadados;


import java.util.Scanner;

public class Lista_Dupla_N_Ordenada{
    
    /*Definindo a classe que representará
    cada elelmento da lista*/
    
    private static class LISTA{
        
        public int num;
        ????????????????????????????????
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
         * do último elelmento da lista*/
        LISTA fim = null;
        
        /* o  objeto aux é um objeto auxiliar*/
        LISTA aux;
        
        //apresentando o menu de opções
        int op, numero, achou;
        do{
            System.out.println("_________________________________");
            System.out.println("Menu de opções\n");
            System.out.println("1 - Inserir no inicio da lista");
            System.out.println("2 - Inserir no fim da lista");
            System.out.println("3 - Consultar lista do INICIO ao fim");
            System.out.println("4 - Consultar lista do FIM ao inicio");
            System.out.println("5 - Remover da lista");
            System.out.println("6 - Esvaziar a lista");
            System.out.println("7 - Sair");
            System.out.println("\nDigite sua opção: ");
            op = entrada.nextInt();
            if(op <1 || op>7){
                System.out.println("\nOpção INVÁLIDA");
            }
            if (op ==1){
                System.out.println("Digite o número a ser inserido no início da lista");
               ???????????????????????????
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
                     * será inserido no início da lista
                     */
                    novo.prox = inicio;
                ???????????????????????
                    novo.ant = null;
                    inicio=novo;
                }
                System.out.println("Número inserido no início da Lista!!");
                
            }if(op==2){
                System.out.println("Digite o número a ser inserido no fim da lista");
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
                     * será inserido no fim da lista
                     */
                    fim.prox = inicio;
                    novo.ant = fim;
                    novo.prox = null;
                    fim = novo;
                }
                System.out.println("Número inserido no fim da Lista!!");    
            }if(op==3){
                if (inicio ==null){
                    //a lista está vazia!!
                    System.out.println("Lista vazia!!");
                }else{
                    /* a lista contém elementos e estes
                     * serão mostrados do incício ao fim*/
                    System.out.println("\nConsultado a lista do início ao fim\n");
                    aux = inicio;
                    while (aux != null){
                     ??????????????????????????
                        aux = aux.prox;
                    }
                }
            }if(op==4){
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
            }if (op==5){
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
                            * na lista e ser� removido
                            */
                            achou++;
                            if (aux==inicio){
                                /* o número a ser removido é o primeiro
                                * da lista
                                */
                                inicio = aux.prox;
                                if(inicio !=null){
                                    inicio.ant = fim;
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
                          ????????????????????????????????????
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
            }if(op==6){
                 if (inicio == null){
                    //a lista está vazia
                    System.out.println("Lista vazia!!!");
                }else{
                    // a lista será esvaziada
                    inicio = null;
                    System.out.println("Lista esvaziada!!");
                }
                
            }
        }while (op!=7);
    }
}
