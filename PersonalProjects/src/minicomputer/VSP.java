package minicomputer;

/**
 * The very simple processor
 *
 * @author Andrei-Traian Mandris
 * @version 1.0
 */
public class VSP {

    protected int pc;
    private int REGSIZE = 8;
    protected int[] r;
    private boolean flag;
    protected boolean halt;

    public VSP() {  //Constructor of VSP
        r = new int[8];
        pc = 0;
        flag = false;
        halt = false;
        for (int i = 0; i < REGSIZE; i++) {
            r[i] = 0;
        }
    }

    /**
     * Runs the program, starting with its first instruction until a HALT
     * instruction is encountered, then sets the halt state and returns. It is
     * supposed that all memory locations have valid instructions and at least
     * one of them is a HALT instruction. At each step it calls the VSP execute
     * method. The method ends immediately if the processor is already in the
     * halt state.
     *
     * @param instruction is one of the functions that work on registers ex:
     * NOP, MOVE, ADD, SUB, CMP, JMP, JMPC, HALT
     */
    public void execute(Instruction instruction) {
        //above we have the function to execute an instruction
        String opcode = instruction.getOpcode();
        int field1 = instruction.getField1();
        int field2 = instruction.getField2();
        int field3 = instruction.getField3();
        switch (opcode) {
            case "NOP":
                nop();
                break;
            case "MOVE":
                move(field1, field3);
                break;
            case "ADD":
                add(field1, field2, field3);
                break;
            case "SUB":
                sub(field1, field2, field3);
                break;
            case "CMP":
                cmp(field2, field3);
                break;
            case "JMP":
                jmp(field3);
                break;
            case "JMPC":
                jmpc(field3);
                break;
            case "HALT":
                halt();
                break;
            default:
                System.out.println("Command Unknown!");
        }
    }

    /**
     * General reset. Calls VSP reset method which sets all VSP's fields (PC,
     * register, flag, halt state) to their default values.
     */
    public void reset() {   //function to reset VSP
        pc = 0;
        halt = false;
        flag = false;
        for (int i = 0; i < REGSIZE; i++) {
            r[i] = 0;
        }
    }

    private void nop() {
        pc++;
        flag = false;
        halt = false;
    }

    /**
     * r[dest] <- value @par
     *
     *
     * am dest is the index of the vector r for the location in which the value
     * will be updated
     * @param value is the number that will be introduced in the r[dest]
     */
    private void move(int dest, int value) {
        r[dest] = value;
        flag = false;
        halt = false;
        pc++;
    }

    /**
     * Adds the number from the address specified in the second parameter to the
     * number from the address specified in the third parameter and stores the
     * result at the
     *
     * @param dest
     * @param src1 - index to the first term
     * @param src2 - index to the second term
     */
    private void add(int dest, int src1, int src2) {
        r[dest] = r[src1] + r[src2];
        flag = false;
        halt = false;
        pc++;
    }

    /**
     * r[dest] <- r[src1] - r[src2]
     *
     * @param dest - the index of the r vector where the result is stored
     * @param src1 - the index of the r vector from where the minuend is taken
     * @param src2 - the index of the r vector from where the subtrahend is
     * taken
     */
    private void sub(int dest, int src1, int src2) {
        r[dest] = r[src1] - r[src2];
        flag = false;
        halt = false;
        pc++;
    }

    /**
     * Shows if the two parameters are equal
     *
     * @param src1 - the index of the r vector for the first number
     * @param src2 - the index of the r vector for the second number
     */
    private void cmp(int src1, int src2) {
        if (r[src1] == r[src2]) {
            flag = true;
        } else {
            flag = false;
        }
        halt = false;
        pc++;
    }

    /**
     * Assigns to PC(Program Counter) a value
     *
     * @param value - the value assigned to PC (program counter)
     */
    private void jmp(int value) {
        pc = value;
        flag = false;
        halt = false;
    }

    /**
     * Assigns to PC(Program Counter) the value specified as parameter only if
     * the flag is true
     *
     * @param value - the value that is assigned to PC(Program Counter) only if
     * the flag is true
     */
    private void jmpc(int value) {
        if (flag) {
            pc = value;
        } else {
            pc++;
        }
        flag = false;
        halt = false;
    }

    /**
     * Stops the execute method
     */
    private void halt() {
        halt = true;
        flag = false;
    }
}
