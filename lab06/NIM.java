/*
 * Written by Hydreesia
 * */


public class NIM {

    /**
     * cerate a game state array
     * @param size -- the number of rows
     * @param stickMax -- the largest value
     * @return an array representing a token array. The array in the first position will be one, each following will be
     *     one larger up to the max.
     */
    public static int[] createGameState(int size, int stickMax){
        int[] game_state = new int[size];
        int token = 1;
        for (int i = 0; i < size; i++) {
            game_state[i] = token;
            if (token < stickMax) {
                token++;
            }
        }
        return game_state;
    }

    /**
     * This provided function operators similarly to the python isDigit method. You give it a string and it will tell
     * you if the string contains only digits. Give it a read -- the actual design isn't hard, basically a linear search.
     * @param str any string
     * @return true if all letters in the string are digits.
     */
    private static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a given move (as represented by two input strings) is valid. This should check if the inputs are numbers
     * if those numbers are in the valid range.
     * @param gameState an array representing the number of tokens in each row.
     * @param row a string representing which row the user wants to take from. 1-indexed.
     * @param takes a string representing how many tokens the user wants to take.
     * @return true if and only if the move would be valid
     */
    public static boolean isValidMove(int[] gameState, String row, String takes) {
        if (isDigit(row) && isDigit(takes)) {
            int rowInt = Integer.parseInt(row);
            int takesInt = Integer.parseInt(takes);

            if ((rowInt <= gameState.length) && (rowInt > 0)) {
                if ((takesInt >= 0) && (takesInt <= 3) && (takesInt <= gameState[rowInt - 1])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * User System.out.println to represent a token grid to the program user.
     * @param gameState an array representing the number of tokens in each row.
     */
    public static void drawGameState(int[] gameState){
        System.out.println("====================");
        for (int i = 0; i < gameState.length; i++) {
            System.out.print((i + 1) + " ");
            repeat("#", gameState[i]);
            System.out.println();
        }
        System.out.println("====================");
    }

    /**
     * Repeats whatever is passed into it x amount of times
     * @param str a string representing whatever will be repeated
     * @param numRepeat an int for the number of times str will be repeated 
     */
    public static void repeat(String str, int numRepeat){
        for (int i = 0; i < numRepeat; i++) {
            System.out.print(str);
        }
    }

    /**
     * Create an updated version of the game state. You can assume the row and takes are valid for the gameState array provided.
     * @param gameState an array representing the number of tokens in each row.
     * @param row the row the user wants to take from (0-indexed)
     * @param takes the number of tokens the user wants to take
     * @return a new array representing the state number of tokens in each row after the given numbers were removed.
     */
    public static int[] update(int[] gameState, int row, int takes){
        int[] updatedGameState = gameState.clone();
        updatedGameState[row] -= takes;
        return updatedGameState;
    }

    /**
     *
     * @param gameState an array representing the number of tokens in each row.
     * @return true if and only if every element of gameState is false.
     */
    public static boolean isOver(int[] gameState) {
        for (int i = 0; i < gameState.length; i++) {
            if (gameState[i] != 0) {
                return false;
            }
        }
        return true;
    }
}