

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Op A = new Op(1);
        Op B = new Op(2);
        Op C = new Op(3);
        Op D = new Op(4);
        Op E = new Op(5);


        Sort selectionSort = new SelectionSort();
        Sort bubbleSort = new BubbleSort();
        Sort insertionSort = new InsertionSort();

        ListContainer myContainer = new ListContainer(insertionSort);

        LinkedListContainer myContainer2 = new LinkedListContainer(insertionSort);
        LinkedListContainer myContainer3 = new LinkedListContainer(insertionSort);



        //System.out.println(myContainer2);

        myContainer2.add_element(A);
        myContainer2.add_element(B);
        myContainer2.add_element(C);
        myContainer2.add_element(D);
        myContainer2.add_element(E);


        myContainer2.remove_element(0);
        myContainer2.remove_element(3);
        myContainer2.remove_element(1);



        myContainer3.add_element_tail(A);
        myContainer3.add_element_tail(B);
        myContainer3.add_element_tail(C);
        myContainer3.add_element_tail(D);
        myContainer3.add_element_tail(E);

        myContainer2.print();

        myContainer2.print_reverse();


        System.out.printf("____________________________________\n\n");

        myContainer3.print();

        myContainer3.sort();

        System.out.printf("____________________________________\n\n");

        myContainer3.print();

        System.out.printf("____________________________________\n\n");


        //System.out.println(myContainer2);




/*        myContainer.add_element(A);
        myContainer.add_element(C);
        myContainer.add_element(D);
        myContainer.add_element(E);
        myContainer.add_element(B);

        myContainer.print();

        myContainer.sort();

        System.out.printf("____________________________________\n\n");

        myContainer.print();*/


    }



}
