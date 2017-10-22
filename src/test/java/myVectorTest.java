import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class myVectorTest {
    public String result = ("ddddfddd156577");
    @Test
    void add_addTwoElements_True() {
          myVector myVector=myVectorFabric();
          assertEquals(myVector.elements(), 4);
          assertEquals(myVector.capacity(), 10);

    }
    @Test
    void toString_Default_True() {
        myVector myVector = myVectorFabric();
        assertEquals(myVector.toString(), result);

    }
    @Test
    void addIndex_QuantityElement_True() {
        myVector myVector = myVectorFabric();
        myVector.add(2, 32);
        assertEquals(myVector.elements(), 5);
        assertEquals(myVector.capacity(), 10);
        assertEquals(myVector.toString(), "ddddfddd32156577");
    }
    @Test
    void remove_Default_True() {
        myVector myVector = myVectorFabric();
        myVector.remove();
        assertEquals(myVector.elements(), 3);
        assertEquals(myVector.capacity(), 10);
        assertEquals(myVector.toString(), "ddddfddd1");
    }

    @Test
    void removeElementAt_Default_True() {
        myVector myVector = myVectorFabric();
        myVector.removeElementAt(2);
        assertEquals(myVector.elements(), 3);
        assertEquals(myVector.capacity(), 10);
        assertEquals(myVector.toString(), "ddddfddd56577");
        myVector.removeElementAt(2);
        assertEquals(myVector.elements(), 2);
        assertEquals(myVector.toString(), "ddddfddd");


    }

    @Test
    void removeAll_Default_True() {
        myVector myVector= myVectorFabric();
        myVector.removeAll();

        assertEquals(myVector.elements(), 0);
        assertEquals(myVector.capacity(), 10);
        assertEquals(myVector.toString(),"");
    }

    @Test
    void setSize_Default_True() {
        myVector myVector = myVectorFabric();
        myVector.setSize(234);
        assertEquals(myVector.capacity(), 234);
        assertEquals(myVector.elements(), 4);
    }

    @Test
    void remove_removeEmptyVector_IndexException() {
        myVector myVector = new myVector();
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            myVector.remove();
        });

    }
    @Test
    void removeElementAt_removeEmptyVectorAndWrongIndex_IndexException() {
        myVector myVector = new myVector();
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            myVector.removeElementAt(567);
        });
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            myVector.removeElementAt(-455);
        });
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            myVector.removeElementAt(0);
        });
    }

    @Test
    void removeAll_removeEmptyVector_ArgumentException() {
        myVector myVector = new myVector();
        assertThrows(IllegalArgumentException.class, () -> {
            myVector.removeAll();
        });
    }

    @Test
    void setSize_WrongArgument_ArgumentException() {
        myVector myVector = new myVector();
        assertThrows(IllegalArgumentException.class, () -> {
            myVector.setSize(3);
        });
    }
    @Test
    void add_WrongIndex_IndexException() {
        myVector myVector = new myVector();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myVector.add(-1, 456);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
        myVector.add(544, 456);
        });
    }
    @Test
    void myVector_Copy_True() {

        myVector myVector = myVectorFabric();
        myVector newVector = new myVector(myVector);
        assertEquals(newVector.capacity(), 10);
        assertEquals(newVector.elements(), 4);
        assertEquals(newVector.toString(), result);
    }




    myVector myVectorFabric()
    {
        myVector myVector = new myVector();
        myVector.add("dddd");
        myVector.add("fddd");
        myVector.add(1);
        myVector.add(56577);
        return myVector;
    }

}