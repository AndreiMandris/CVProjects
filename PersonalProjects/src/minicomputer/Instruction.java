/////////////////////////////////////////////////////////
//
// Student: Mandris Andrei-Traian
// Homework: 1
//
/////////////////////////////////////////////////////////

package minicomputer;
/**
 * 
 * @author Andrei
 * @version 1.0
 */

public class Instruction {

    private String opcode;  //field for the opcode string
    private int field1;     //field for the first integer
    private int field2;     //field for the second integer
    private int field3;     //field for the third integer

    public Instruction(String code, int f1, int f2, int f3) {
        //Constructor of Instruction
        opcode = code;
        field1 = f1;
        field2 = f2;
        field3 = f3;
    }

    public String getOpcode() { //get function for opcode
        return opcode;
    }

    public int getField1() {    //get function for first field
        return field1;
    }

    public int getField2() {    //get function for second field
        return field2;
    }

    public int getField3() {    //get function for third field
        return field3;
    }
}
