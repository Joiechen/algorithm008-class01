package Week_07;

//题目：https://leetcode-cn.com/problems/valid-sudoku
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if(null == board || board.length < 1){
            return false;
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    if(!isValidHelp(board, board[i][j], i, j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidHelp(char[][] board,char c,int row,int column){
        //检查同一列
        for(int i = 0; i < board.length; i++){
            if(board[i][column] == c && i != row){
                return false;
            }
        }
        //检查同一行
        for(int i = 0;i < board[0].length;i++){
            if(board[row][i] == c && i != column){
                return false;
            }
        }
        //小九宫格
        int n = row/3 * 3;
        int m = column/3 * 3;
        for(int i = n; i < n + 3; i++){
            for(int j = m; j < m + 3; j++){
                if(board[i][j] == c){
                    //判断是否是自己
                    if(i != row && j != column){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
}