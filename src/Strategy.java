abstract class Sort {

    Sort(){};

    public abstract void sort(Container input_container);

}

class SelectionSort extends Sort{

    public void sort(Container input_container){

        for (int i=0; i<input_container.size(); i++){
            Base min =  input_container.at(i);
            int minIndex = i;

            for (int j=i+1; j<input_container.size(); j++){
                if (input_container.at(j).evaluate()< min.evaluate()){
                    min = input_container.at(j);
                    minIndex = j;
                }
            }

            if (minIndex!=i){
                input_container.swap(i,minIndex);
            }
        }
    }
}

class BubbleSort extends Sort{

    public void sort(Container input_container){
        for (int i=0; i<input_container.size()-1; i++){
            for (int j=0; j<input_container.size()-i-1; j++){
                if (input_container.at(j).evaluate()>input_container.at(j+1).evaluate()){
                    input_container.swap(j,j+1);
                }
            }
        }
    }
}

class InsertionSort extends Sort{

    public void sort(Container input_container){
        for (int i=1; i<input_container.size(); i++){
            for (int j=i; j>0; j--){
                if (input_container.at(j).evaluate()<input_container.at(j-1).evaluate()){
                    input_container.swap(j,j-1);
                }
            }
        }
    }
}