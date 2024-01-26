import java.util.*;

public class tictactoe {
    public static void main(String[] args) {
        char ans;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("********************************************");
            System.out.println("Welcome to the TIC TAC TOE GAME ");
            System.out.println("Rule 1: You have to only use 'O' and 'X' in capital.");
            System.out.println("Rule 2: The row and columns in the matrix can only be specified between 0 and 2.");
            System.out.println("Rule 3: You know about the rest.");
            System.out.println("********************************************");

            singleplay();

            System.out.println("Would you like to play again: Y or N ?");
            ans = sc.next().charAt(0);
        } while (ans == 'Y');

    }// main ended

    // Single Player
    public static void singleplay() {
        char machine;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Hello " + name + ", What do you want? X or O: ");
        char[][] m = new char[3][3];
        Random random = new Random();
        char j = sc.next().charAt(0); // char input
        if (j == 'X') {
            machine = 'O';
        } else {
            machine = 'X';
        }
        // blocks
        if (j == 'O') {
            System.out.println(name + ": " + j + " Machine: " + machine);
        }
        if (j == 'X') {
            System.out.println(name + ": " + j + " Machine: " + machine);
        }
        if (j == 'X' || j == 'O') {

            printmatrix(m);// Empty blanks fn call.
            for (int l = 0; l < 5; l++) {
                int r, c;
                // Placement of X or O
                do {
                    System.out.print("\nWhere would you like to place your " + j + ": ");
                    r = sc.nextInt();
                    c = sc.nextInt();
                } while (m[r][c] == 'X' || m[r][c] == 'O');

                m[r][c] = j; // user input

                printmatrix(m);// function call for user input display
                if (wins(m) == true) {
                    System.out.println(name + " won");
                    break;
                } // user win fn call

                // generating machine input
                if (l == 4) {
                    break;
                }
                int rand1, rand2;
                do {
                    rand1 = random.nextInt(3);
                    rand2 = random.nextInt(3);
                } while (m[rand1][rand2] == 'X' || m[rand1][rand2] == 'O');

                // placing machine input
                m[rand1][rand2] = machine;
                System.out.println("Machine's input:");

                printmatrix(m);// function call for machine input display
                if (wins(m) == true) {
                    System.out.println("Machine won");
                    break;
                } // machine win function call
            }
        }

        else {
            System.out.println("You haven't chosen X or O.");
        }
    }

    public static boolean wins(char m[][]) {
        int flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0;

        for (int k = 0; k <= 2; k++) {
            // row winning
            if ((m[k][0] == 'X' && m[k][1] == 'X' && m[k][2] == 'X')
                    || (m[k][0] == 'O' && m[k][1] == 'O'
                            && m[k][2] == 'O')) {
                flag1 = 1;
                break;
            }
        }
        if (flag1 == 1)
            return true;
        // col winning
        for (int k = 0; k <= 2; k++) {
            if ((m[0][k] == 'X' && m[1][k] == 'X' && m[2][k] == 'X')
                    || (m[0][k] == 'O' && m[1][k] == 'O'
                            && m[2][k] == 'O')) {
                flag2 = 1;
                break;
            }
        }
        if (flag2 == 1)
            return true;
        // i and j are same diag winning statement.
        for (int k = 0; k <= 2; k++) {
            if (m[k][k] == 'O') {
                flag3++;

            }
        }
        if (flag3 == 3)
            return true;
        for (int k = 0; k <= 2; k++) {
            if (m[k][k] == 'X') {
                flag4++;
            }

        }
        if (flag4 == 3)
            return true;

        // right diag statement.
        if (m[0][2] == 'X' && m[1][1] == 'X' && m[2][0] == 'X') {
            return true;
        } else if (m[0][2] == 'O' && m[1][1] == 'O' && m[2][0] == 'O') {
            return true;
        }
        return false;
    }

    public static void printmatrix(char[][] m) {
        for (int k = 0; k <= 2; k++) {
            for (int i = 0; i <= 2; i++) {
                if (m[k][i] != 'X' && m[k][i] != 'O') {
                    System.out.print(" _");
                }
                System.out.print(" " + m[k][i]);
            }
            System.out.println();

        }

    }

}
