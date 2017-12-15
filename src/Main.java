

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

        myContainer.add_element(A);
        myContainer.add_element(C);
        myContainer.add_element(D);
        myContainer.add_element(E);
        myContainer.add_element(B);

        myContainer.print();

        myContainer.sort();

        System.out.printf("____________________________________\n\n");

        myContainer.print();


    }



}
