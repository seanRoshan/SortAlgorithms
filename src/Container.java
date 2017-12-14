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
