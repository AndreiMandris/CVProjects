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

public class MiniComputer extends VSP {

    public Instruction[] mem;   //instruction memory
    private int SIZE = 256;

    public MiniComputer() { //Constructor of MiniComputer
        super();
        mem = new Instruction[SIZE]; //memory for 256 instructions
    }
    /**
     * Runs the execute method from the super class with mem[pc] as parameter while halt is not true.
     */
    public void execute() {
        //the function to execute all the instructions in the memory
        while (!halt) {
            super.execute(mem[pc]);
        }
    }
    /**
     * Getter of the value found in r vector at the position specified as parameter
     * @param n - the index from the r vector
     * @return - the value from the r vector at the position n
     */
    public int read(int n) {    //function to read the values in the registers
        return r[n];
    }
}
