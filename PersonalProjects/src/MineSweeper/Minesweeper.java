package MineSweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Andrei-Traian Mandris
 * @version 1.0
 */
public class Minesweeper extends JFrame implements ActionListener {

    private final JPanel p1 = new JPanel();
    private final JPanel p2 = new JPanel(new GridLayout(10, 10));

    private final JButton s = new JButton();
    private final JButton[][] b = new JButton[10][10];

    private final Icon ico1 = new ImageIcon("s.gif");
    private final Icon ico2 = new ImageIcon("m.gif");

    private final JMenuBar mb = new JMenuBar();
    private final JMenu menu = new JMenu("Options");
    private final JMenuItem mi1 = new JMenuItem("New Game");
    private final JMenuItem mi2 = new JMenuItem("Exit");
    private final KeyStroke ks1 = KeyStroke.getKeyStroke("alt shift N");
    private final KeyStroke ks2 = KeyStroke.getKeyStroke("alt shift E");

    private final int[][] m = new int[10][10];

    public Minesweeper() {
        super("Minesweeper");
        this.add(p1, BorderLayout.NORTH);
        p1.add(s);
        s.setIcon(ico1);
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                initialize();
                generate(20);
                count();
                for (int i = 0; i < b.length; i++) {
                    for (int j = 0; j < b[i].length; j++) {

                        b[i][j].setEnabled(true);
                        b[i][j].setText("");
                        b[i][j].setIcon(null);
                    }
                }

            }
        });
        this.add(p2);
        this.setJMenuBar(mb);
        mb.add(menu);
        menu.add(mi1);
        menu.add(mi2);
        menu.setMnemonic('o');
        mi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                initialize();
                generate(20);
                count();
                for (int i = 0; i < b.length; i++) {
                    for (int j = 0; j < b[i].length; j++) {

                        b[i][j].setEnabled(true);
                        b[i][j].setText("");
                        b[i][j].setIcon(null);
                    }
                }

            }
        });
        mi1.setAccelerator(ks1);
        mi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                int r = JOptionPane.showConfirmDialog(null, "Do you really want to exit the game?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (r == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        mi2.setAccelerator(ks2);

        initialize();
        generate(20);
        count();

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = new JButton();
                p2.add(b[i][j]);
                b[i][j].addActionListener(this);
            }
        }

        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Initializing a bidimensional [10][10] array of zeros
     */
    public void initialize() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = 0;
            }
        }

    }

    /**
     * Generates a specified number of random -1 in the array preveously defined
     *
     * @param nr - Represents the number of random -1 introduced in the array
     */
    public void generate(int nr) {
        Random r = new Random();
        for (int i = 0; i < nr; i++) {

            int x = r.nextInt(10);
            int y = r.nextInt(10);
            if (m[x][y] == 0) {
                m[x][y] = -1;
            } else if (m[x][y] == -1) {
                i--;
            }

        }
    }

    /**
     * Counts for each element of a [10][10] array how many -1 numbers has as
     * neighbors
     */
    public void count() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    try {
                        if (m[i - 1][j - 1] == -1) {
                            m[i][j]++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (m[i - 1][j] == -1) {
                            m[i][j]++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (m[i - 1][j + 1] == -1) {
                            m[i][j]++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (m[i][j - 1] == -1) {
                            m[i][j]++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (m[i][j + 1] == -1) {
                            m[i][j]++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (m[i + 1][j - 1] == -1) {
                            m[i][j]++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (m[i + 1][j] == -1) {
                            m[i][j]++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                    try {
                        if (m[i + 1][j + 1] == -1) {
                            m[i][j]++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {

                    }
                }
            }
        }
    }

    /**
     * When the button is hit, it does the match between the array of the
     * buttons and the one defined as "m". Then for each element it checks the
     * value and if it's not -1 it shows the value otherwise it activates all
     * the buttons that contain -1 value and finishes the game.
     *
     * @param ev helps by getting the source button and do all the checkings.
     */
    @Override
    public void actionPerformed(ActionEvent ev) {
        JButton aux = (JButton) ev.getSource();
        if (aux.isEnabled() == false) {
            return;
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (aux == b[i][j]) {
                    if (m[i][j] != -1) {

                        if (m[i][j] == 0) {
                            aux.setText(String.valueOf(m[i][j]));
                            b[i][j].setEnabled(false);
                            zeroHit(i, j);
                        }
                        b[i][j].setText(String.valueOf(m[i][j]));
                        b[i][j].setEnabled(false);
                    } else {
                        gameOver();

                    }
                }
            }
        }
    }

    /**
     *
     * @param x - boolean value for choosing if all the buttons will be enabled
     * or disabled
     */
    public void activateButtons(boolean x) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j].setEnabled(x);
            }
        }
    }

    /**
     * It activates all the buttons that contains -1 values then it disable all
     * the buttons. After that a message dialog is pop-uped informing that the
     * game is over.
     */
    public void gameOver() {
        showMines();
        activateButtons(false);
        JOptionPane.showMessageDialog(null, "GAME OVER");

    }

    /**
     * It activates all the -1 values assigning each one a "mine" icon.
     */
    public void showMines() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == -1) {
                    b[i][j].setIcon(ico2);
                    b[i][j].setEnabled(false);
                }
            }
        }
    }

    /**
     * If a button that contains s zero is hit then it activates the other
     * buttons in its surroundings
     *
     * @param i the first index of the button that contained a zero
     * @param j the second index of the button that contained a zero
     */
    public void zeroHit(int i, int j) {
        try {
            b[i - 1][j - 1].doClick(1);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            b[i - 1][j].doClick(1);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            b[i - 1][j + 1].doClick(1);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            b[i][j - 1].doClick(1);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            b[i][j + 1].doClick(1);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            b[i + 1][j - 1].doClick(1);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            b[i + 1][j].doClick(1);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
        try {
            b[i + 1][j + 1].doClick(1);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    public static void main(String[] args) {
        new Minesweeper();
    }
}
