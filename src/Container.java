import java.util.ArrayList;
import java.util.ListIterator;

abstract class Container{

    Container() {}
    Container(Sort input_sort_function){};

    private Sort sort_function;

    public void set_sort_function(Sort input_sort_function){
        sort_function = input_sort_function;
    }

    public Sort get_sort_function(){
        return sort_function;
    }

    public abstract void add_element(Base input_element);
    public abstract void remove_element(int i);
    public abstract void print();
    public abstract void sort();
    public abstract void swap(int i, int j);
    public abstract Base at(int i);
    public abstract int size();

}


class ListContainer extends Container {

    private ArrayList<Base> date = new ArrayList<Base>();

    ListContainer(){}
    ListContainer(Sort intpu_sort_function){
        set_sort_function(intpu_sort_function);
    }

    public void add_element(Base input_element){
        date.add(input_element);
    }

    public void remove_element(int i){
        date.remove(i);
    }

    public void print(){
        ListIterator<Base> dataIterator = date.listIterator();
        while (dataIterator.hasNext()){
            dataIterator.next().print();
        }
    }

    public void sort(){
        Sort sort_function = get_sort_function();

        sort_function.sort(this);

    }

    public void swap(int i, int j){
        Base temp = date.get(j);
        date.set(j, date.get(i));
        date.set(i, temp);
    }

    public Base at(int i){
        return date.get(i);
    }

    public int size(){
        return date.size();
    }

}


class LinkedListContainer extends Container{

    class Node {
        private Base data;
        private Node next_node;
        private Node prev_node;


        Node(){
            this.data = null;
            this.next_node = null;
            this.prev_node = null;
        }

        Node(Base data_input){
            this.data = data_input;
            this.next_node = null;
            this.prev_node = null;
        }

        Node(Base data_input, Node next_node_input, Node prev_node_input){
            this.data = data_input;
            this.next_node = next_node_input;
            this.prev_node = prev_node_input;
        }

        public void setData(Base data_input){
            this.data = data_input;
        }

        public void set_next_node(Node next_node_input){
            this.next_node = next_node_input;
        }

        public void set_prev_node(Node prev_node_input){
            this.prev_node = prev_node_input;
        }

        public Base getData(){
            return this.data;
        }

        public Node get_next_node(){
            return this.next_node;
        }

        public Node get_prev_node(){
            return this.prev_node;
        }

        @Override
        public String toString(){

            if (this.data==null){
                return " ";
            }

            String myString = "[" +
                    "Data: " + this.data+
                    "] ";

            return myString;
        }

    }

    private Node headNode;
    private Node tailNode;
    private int size;


    LinkedListContainer(Sort intpu_sort_function){
        set_sort_function(intpu_sort_function);
        headNode = new Node();
        tailNode = new Node();
        size = 0;
    }




    public void add_element(Base input_element){
        Node newNode = new Node(input_element);
        newNode.set_next_node(this.headNode);
        headNode.set_prev_node(newNode);
        if (this.tailNode.data==null){
            this.tailNode = newNode;
        }
        this.headNode = newNode;
        this.size++;
    }

    public void add_element_tail(Base input_element){
        Node newNode = new Node(input_element);
        newNode.set_prev_node(this.tailNode);
        this.tailNode.next_node = newNode;
        if (this.headNode.data==null){
            this.headNode = newNode;
        }
        this.tailNode = newNode;
        this.size++;

    }

    public void remove_element(int i){

        try{
            Node targetNode = this.getNode(i);
            System.out.println("remove_element "+i+" Size "+size);
            if (targetNode!=null) {
                if (i==0){
                    // Remove Tail
                    targetNode.prev_node.next_node = null;
                    tailNode = targetNode.prev_node;
                    System.out.println("remove_element_atTail "+targetNode.data);
                    size--;
                }
                else if (i==(size-1)){
                    // Remove Head
                    targetNode.next_node.prev_node = null;
                    headNode = targetNode.next_node;
                    System.out.println("remove_element_atHead "+targetNode.data);
                    size--;
                }
                else {
                    System.out.println("remove_element_atMid "+targetNode.data);
                    targetNode.next_node.prev_node = targetNode.prev_node;
                    targetNode.prev_node.next_node = targetNode.next_node;
                }

            }
            else {
                throw new IndexOutOfBoundsException("Warning: The index is out of range!\n");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.err.println("IndexOutOfBoundsException: "+e.getMessage()+"\tclass: "+ getClass().getName()+"\n\tfucntion: "+Thread.currentThread().getStackTrace()[1].getMethodName());
        }
    }


    @Override
    public String toString() {

        Node currentNode = this.headNode;

        String myString = "{ ";

        while (currentNode!=null){
            myString = myString + currentNode;
            currentNode = currentNode.get_next_node();
        }

        myString =  myString + "}";

        myString = myString + "[Head: "+headNode+" } - [Tail: "+tailNode+" ]";

        return myString;

    }

    public void print(){

        Node currentNode = this.headNode;

        String myString = "Print : { ";

        while (currentNode!=null){
            myString = myString + currentNode;
            currentNode = currentNode.get_next_node();
        }

        myString =  myString + "}";
        myString = myString + "[Head: "+headNode+" } - [Tail: "+tailNode+" ]";
        System.out.println(myString);
    }

    public void print_reverse(){

        Node currentNode = this.tailNode;

        String myString = "Print Reverse: { ";

        while (currentNode!=null){
            myString = myString + currentNode;
            currentNode = currentNode.get_prev_node();
        }

        myString =  myString + "}";

        myString = myString + "[Head: "+headNode+" } - [Tail: "+tailNode+" ]";

        System.out.println(myString);
    }

    public void sort(){
        Sort sort_function = get_sort_function();
        sort_function.sort(this);
    }

    public void swap(int i, int j){

        Node nodeI = this.getNode(i);
        Node nodeJ = this.getNode(j);

        Base tempDate = nodeI.getData();

        nodeI.setData(nodeJ.getData());
        nodeJ.setData(tempDate);

    }

    public Node getNode(int i){

        try {

            if ( (i<this.size) && (i>=0) ){

                // Element 0 is stored at the tail node
                // Elemenet size-1 is the head node

                if (i>=0 && i<(size/2)){
                    // Move from tail backward
                    Node currentNode = this.tailNode;

                    for (int index=0; index<i; index++){
                        currentNode = currentNode.get_prev_node();
                    }

                    //System.out.printf("CurrentNode at close to tail: %d " + currentNode+"\n",i);
                    return currentNode;
                }
                else {
                    // Move from head forward
                    Node currentNode = this.headNode;
                    for (int index=(size-1); index>i; index--){
                        currentNode = currentNode.get_next_node();
                    }
                    //System.out.printf("CurrentNode at close to head: %d " + currentNode+"\n",i);
                    return currentNode;
                }
            }
            else{
                throw new IndexOutOfBoundsException("Error: The index is out of range!\n");
            }
        }
        catch (IndexOutOfBoundsException e){
            System.err.println("IndexOutOfBoundsException: "+e.getMessage()+"\tclass: "+ getClass().getName()+"\n\tfucntion: "+Thread.currentThread().getStackTrace()[1].getMethodName());
            return null;
        }
    }

    public Base at(int i){

        try{
            Node targetNode = this.getNode(i);
            if (targetNode==null) {
                throw new IndexOutOfBoundsException("Error: The index is out of range!\n");
            }
            else {
                return targetNode.data;
            }
        }
        catch (IndexOutOfBoundsException e){
            System.err.println("IndexOutOfBoundsException: "+e.getMessage()+"\tclass: "+ getClass().getName()+"\n\tfucntion: "+Thread.currentThread().getStackTrace()[1].getMethodName());
            return null;
        }

    }

    public int size(){
      return this.size;
    }
}