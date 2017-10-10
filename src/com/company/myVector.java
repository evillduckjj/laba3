package com.company;

public class myVector<E> {

    private Object[] elementData;
    private int elementCount;
    private int maxCapacity;



    public myVector() {
        elementData = new Object[10];
        this.maxCapacity=10;
    }

    private Object[] enlargementVector() {
        return enlargementVector(0);
    }

    private Object[] enlargementVector(int size) {
        if(size==0){
            maxCapacity=(maxCapacity*2)+10;
        }
        else {
            maxCapacity=size;
        }
        Object[] newVector= new Object[maxCapacity];
        System.arraycopy(elementData,0,newVector, 0,elementCount);
        return newVector;

    }



    public boolean add(E e)
    {
        if(elementCount+1==maxCapacity)
            elementData=enlargementVector();
        elementData[elementCount++]=e;
        return true;
    }
    public boolean add(int index, E e)
    {
        if(index<0||index>maxCapacity) {
            throw new IndexOutOfBoundsException();
            //return false;
        }
        if(elementCount+1==maxCapacity)
            elementData=enlargementVector();
        System.arraycopy(elementData, index, elementData, index+1, elementCount-index);
        elementData[index]=e;
        elementCount++;
        return true;
    }

    public boolean remove() {
        if(elementCount-1==-1) {
            throw new IndexOutOfBoundsException();
            //return false;
        }
        elementData[elementCount]=null;
        elementCount--;
        return true;
    }

    public boolean removeElementAt(int index) {
        if(index>=elementCount||index<0||(elementCount-1==-1)) {
           throw  new IndexOutOfBoundsException();
            //return false;
        }
        int j = elementCount - index - 1;

        if (j > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null;
    return true;
    }


    public boolean removeAll(){
        if(elementCount==0) {
           throw  new IllegalArgumentException();
            //return false;
        }
        for(int i=0; i<elementCount;i++) {
            elementData[i] = null;
        }
        elementCount=0;
        return true;
    }

    public String toString() {
        String result= ("");
        for(int i =0; i<elementCount; i++) {
            result+=elementData[i].toString();
        }
        return result;
    }


    public boolean setSize(int size) {
        if(size<maxCapacity) {
            throw new IllegalArgumentException();
           // return false;
        }//check
        enlargementVector(size);
        return true;
    }

    public int elements() {
        return elementCount;
    }

    public int capacity() {
        return maxCapacity;
    }
}


