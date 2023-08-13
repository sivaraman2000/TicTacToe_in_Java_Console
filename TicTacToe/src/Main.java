import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void print_board(char board[][]){
        System.out.println("The Board is : ");
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static char check_board(char board[][]){
        //horizontal
        for(int i = 0; i < 3; i++){
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '_')
                return board[i][0];
        }
        // Vertical
        for(int i = 0; i < 3; i++){
            if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i]  != '_')
                return board[0][i];
        }
        // Left Diagonal
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '_')
            return board[0][0];
        // Right Diagonal
        if(board[2][0] == board[1][1] && board[2][0] == board[0][2] && board[2][0] != '_')
            return board[2][0];
        return '_';
    }
    public static void main(String[] args) {
        char[][] board= {{'_','_','_'}, {'_','_','_'}, {'_','_','_'} };
        char[] players= {'X','O'};
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Welcome to Tick Tack Toe Game");
        System.out.println("Initially the Board was :");
        print_board(board);
        // Randomly choose any 1 player from 'X' or 'O'
        int choice = rand.nextInt(2); // This will generate a random number between 0 and 1
        // Totally 9 moves - 5 for player who starts first and 4 for player who starts then
        // For 1st 4 moves no player will be announced as winner
        for(int i = 0; i < 4; i++){
            int row, col;
            System.out.println("Its " +(choice == 0 ? "X" : "O") +" turn");
            System.out.print("Enter the row number from 0 to 2 : ");
            row = sc.nextInt();
            System.out.print("Enter the column number from 0 to 2 : ");
            col = sc.nextInt();
            if(choice == 0){
                board[row][col] = 'X';
                choice = 1;
            }
            else{
                board[row][col] = 'O';
                choice = 0;
            }
            print_board(board);
        }
        // From 5th move board will be checked at every move
        char winner = '_';
        for(int i = 4; i < 9; i++){ // 4 5 6 7 8 - Winning Moves
            int row, col;
            System.out.println("Its " +(choice == 0 ? "X" : "O") +" turn");
            System.out.print("Enter the row number from 0 to 2 : ");
            row = sc.nextInt();
            System.out.print("Enter the column number from 0 to 2 : ");
            col = sc.nextInt();
            if(choice == 0){
                board[row][col] = 'X';
                choice = 1;
            }
            else{
                board[row][col] = 'O';
                choice = 0;
            }
            print_board(board);
            winner = check_board(board);
            System.out.println("Winner Variable : "+winner);
            if(winner == 'X' || winner == 'O'){
                break;
            }
            else{
                continue;
            }
        }
        if(winner == '_'){
            System.out.println("Game Tied");
            System.out.println("Both of you Well Played");
        }
        else{
            System.out.println("The Winner is : " +(winner == 'X' ? "X" : "O"));
        }
        System.out.println("The Game Ends");
    }
}
