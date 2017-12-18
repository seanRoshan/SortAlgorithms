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

class MargeSort extends Sort{

    public void sort(Container input_container){
        this.mergeSort(input_container, 0, input_container.size()-1);
    }


    private void mergeSort(Container input_contrainer, int start, int end){
        if (start<end){
            int mid = (int)Math.floor((start+end)/2);
            mergeSort(input_contrainer,start,mid);
            mergeSort(input_contrainer,mid+1,end);
            merge(input_contrainer, start, mid, end);
        }
    }

    private void merge(Container input_container, int start, int mid, int end){

        ListContainer leftContainer = new ListContainer();
        ListContainer rightContainer = new ListContainer();



        for (int i=start; i<=mid; i++){
            leftContainer.add_element(input_container.at(i));
        }

        for (int j=mid+1; j<=end; j++){
            rightContainer.add_element(input_container.at(j));
        }

        int i = 0;
        int j = 0;

        for (int k=start; k<=end; k++){
            if (  ( i>=leftContainer.size() ) || (   ( j<rightContainer.size() ) && leftContainer.at(i).evaluate()>rightContainer.at(j).evaluate() ) ){
                input_container.modify_element(rightContainer.at(j),k);
                j++;
            }
            else {
                if (i<leftContainer.size()){
                    input_container.modify_element(leftContainer.at(i),k);
                    i++;
                }

            }
        }

    }
}