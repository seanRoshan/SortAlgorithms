abstract class Base{

   // Default Constructor
   Base(){}

   // Returns Values of Base
   // Virtual function
   abstract double evaluate();

}

class Op extends Base{

    // Storage for a double value
    private double value;

    // Constructor for a leaf operand with double type
    Op (double inputValue){
        value = inputValue;
    }


    // Returns Values of Op
    public double evaluate(){
        return value;
    }

    // Print the Value of OP
    public void print(){
        System.out.printf("Value: %f \n",value);
    }

}

class BinaryOperator extends Base{

    // Storage for child Operands
    private Base leftChild, rightChild;

    // Overloaded Constructor
    BinaryOperator(Base inputLeftChild, Base inputRightChild){
        leftChild = inputLeftChild;
        rightChild = inputRightChild;
    }

    // Accessor
    public Base getLeftOperand(){
        return leftChild;
    }

    // Accessor
     public Base getRightOperand() {
        return rightChild;
    }

    public double evaluate(){
        return 0;
    }

}

class UnaryOperator extends Base {

    private Base child;


    UnaryOperator(Base inputChild){
        child = inputChild;
    }

    public Base getChild(){
        return child;
    }

    public double evaluate() {
        return 0;
    }

}