

public class myVector<E> {

    private Object[] element;
    private int Count;
    private int lenght;



    public myVector() {
        element = new Object[10];
        this.lenght =10;
    }
    public myVector(myVector<E> e){
        this.lenght =e.capacity();
        this.Count =e.elements();
        element = new Object[lenght];

        System.arraycopy(e.getElement(), 0,this.element, 0, lenght);
    }

    private Object[] enlargementVector() {
        return enlargementVector(0);
    }

    private Object[] enlargementVector(int size) {
        if(size==0){
            lenght =(lenght *2)+10;
        }
        else {
            lenght =size;
        }
        Object[] newVector= new Object[lenght];
        System.arraycopy(element,0,newVector, 0, Count);
        return newVector;

    }



    public boolean add(E e)
    {
        if(Count +1== lenght)
            element =enlargementVector();
        element[Count++]=e;
        return true;
    }
    public boolean add(int index, E e)
    {
        if(index<0||index> lenght) {
            throw new IndexOutOfBoundsException();
            //return false;
        }
        if(Count +1== lenght)
            element =enlargementVector();
        System.arraycopy(element, index, element, index+1, Count -index);
        element[index]=e;
        Count++;
        return true;
    }

    public boolean remove() {
        if(Count -1==-1) {
            throw new IndexOutOfBoundsException();
            //return false;
        }
        element[Count]=null;
        Count--;
        return true;
    }

    public boolean removeElementAt(int index) {
        if(index>= Count ||index<0||(Count -1==-1)) {
           throw  new IndexOutOfBoundsException();
            //return false;
        }
        int j = Count - index - 1;

        if (j > 0) {
            System.arraycopy(element, index + 1, element, index, j);
        }
        Count--;
        element[Count] = null;
    return true;
    }


    public boolean removeAll(){
        if(Count ==0) {
           throw  new IllegalArgumentException();
            //return false;
        }
        for(int i = 0; i< Count; i++) {
            element[i] = null;
        }
        Count =0;
        return true;
    }

    public String toString() {
        String result= ("");
        for(int i = 0; i< Count; i++) {
            result+= element[i].toString();
        }
        return result;
    }


    public boolean setSize(int size) {
        if(size< lenght) {
            throw new IllegalArgumentException();
           // return false;
        }//check
        enlargementVector(size);
        return true;
    }

    public int elements() {
        return Count;
    }

    public int capacity() {
        return lenght;
    }

    public Object[] getElement() {
        return element;
    }
}


