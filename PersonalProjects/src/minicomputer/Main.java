/////////////////////////////////////////////////////////
//
// Student: Mandris Andrei-Traian
// Homework: 1
//
/////////////////////////////////////////////////////////
package minicomputer;

public class Main {

    public static void main(String[] args) {
        MiniComputer mc = new MiniComputer();
        // initialize the memory        //0 1 9 7 0 0 0 0
        // The program computes the product of two integers 
        mc.mem[0] = new Instruction("MOVE", 1, 0, 1); // a cosntant used for decrementing the multiplier
        mc.mem[1] = new Instruction("MOVE", 2, 0, 9); // the multiplicand is in R[2]
        mc.mem[2] = new Instruction("MOVE", 3, 0, 7); // the multiplier is in R[3]
        mc.mem[3] = new Instruction("CMP", 0, 0, 3); // compare the multiplier with zero
        mc.mem[4] = new Instruction("JMPC", 0, 0, 8); // if the multiplier was zero exit the loop
        mc.mem[5] = new Instruction("ADD", 4, 4, 2); // add the multiplicand to the partial sum
        mc.mem[6] = new Instruction("SUB", 3, 3, 1); // decrement the multiplier
        mc.mem[7] = new Instruction("JMP", 0, 0, 3); // jump to the beginning of the loop
        mc.mem[8] = new Instruction("HALT", 0, 0, 0); // end of program (the result is inside R[4]
        mc.reset();
        mc.execute();
        // print the content of all registers
        for (int i = 0; i < 8; i++) {
            System.out.println("reg " + i + ": " + mc.read(i));
        }
    }
}
