class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 3; i ++) {
            for(int j = 0; j < 3; j++) {
                int controlArray[] = new int[10];
                for(int k=i*3; k<3+i*3; k++) {
                    int noNrs = 0;
                    for(int l=j*3; l<3+j*3; l++) {
                        try {
                            int num = Character.getNumericValue(board[k][l]);
                            // System.out.println("index["+k+"]["+l+"]="+num);
                            controlArray[num] ++;
                        } catch (Exception e) {
                            noNrs++;
                        }
                    }
                }
                // System.out.println("__________");
                for (int m=1; m<10; m++) {
                    // System.out.println(controlArray[m]);
                    if(controlArray[m]>1){
                        return false;
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i ++) {
            int controlArrayLine[] = new int[10];
            int controlArrayCol[] = new int[10];
            for(int j = 0; j < board.length; j++) {
                 try {
                    int numLine = Character.getNumericValue(board[i][j]);
                    controlArrayLine[numLine] ++;
                    if(controlArrayLine[numLine] >= 2) {
                        return false;
                    }
                } catch (Exception e) {
                }
                try {
                    int numCol = Character.getNumericValue(board[j][i]);
                    controlArrayCol[numCol] ++;
                    if(controlArrayCol[numCol] >= 2) {
                        return false;
                    }
                } catch (Exception e) {
                }
            }
        }
        return true;
    }
}
