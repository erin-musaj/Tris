public class Tris {
    private final int[][] grid = new int[3][3];
    private int currentPlayer;

    public Tris(int firstPlayer){
        this.currentPlayer=firstPlayer;
    }

    public String getCurrentPlayer() {
        if(currentPlayer==1){
            return "x";
        } else {
            return "o";
        }
    }

    public String getLastPlayer() {
        if(currentPlayer==1){
            return "o";
        } else {
            return "x";
        }
    }

    public boolean place(int x, int y){
        if(this.grid[x][y] == 0 && !this.IsGameOver()){
            grid[x][y] = currentPlayer;
            currentPlayer -= currentPlayer*2;
            return true;
        } else {
            return false;
        }
    }

    public String gameStatus(){
        for (int i = 0; i < grid.length; i++) {
            if(grid[i][1] + grid[i][2] + grid[i][0] == 3){
                return "x";
            } else if(grid[i][1] + grid[i][2] + grid[i][0] == -3){
                return "o";
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            if(grid[1][i] + grid[2][i] + grid[0][i] == 3){
                return "x";
            } else if(grid[1][i] + grid[2][i] + grid[0][i] == -3){
                return "o";
            }
        }

        if(grid[0][0] + grid[1][1] + grid[2][2] == 3 || grid[0][2] + grid[1][1] + grid[2][0] == 3){
            return "x";
        } else if (grid[0][0] + grid[1][1] + grid[2][2] == -3 || grid[0][2] + grid[1][1] + grid[2][0] == -3){
            return "o";
        }
        return "0";
    }

    public boolean IsGameOver(){
        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0){
                    c++;
                } else {
                    break;
                }
            }
        }

        if(c==9 || this.gameStatus() != "0"){
            return true;
        } else {
            return false;
        }
    }
}
