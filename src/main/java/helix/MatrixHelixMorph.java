package helix;
import java.util.Scanner;
//Janhvi Vora
public class MatrixHelixMorph {


    public static int[][] helix(int[][] mat){
        int m = mat.length; //no of rows
        int n = mat[0].length; //no of columns
        int[][] result = new int[m][n];
        //first row of helix will be the same
        for(int k = 0; k<n; k++){
            result[0][k] = mat[0][k];
        }
        //if no of rows is 1 or 0
        if(m==1 || m == 0)
            return result;
// counters for start and end of rows and columns
        int k = 1;int l = n-1;
        int a = 1;int b = m-1;
        int p = 0;int q = n-1;
        String turnWay = "d";
        for(int i = 1 ; i<m ; i++){ for(int j = 0; j<n; j++){
                result[k][l] = mat[i][j];
                if(turnWay.equals("d")){
                    if(k < b)
                        k++;
                    else{
                        q--;
                        l--;
                        turnWay = "l";
                    }
                } else if(turnWay.equals("l")){
                    if(l > p)
                        l--;
                    else{
                        b--;
                        k--;
                        turnWay = "u";
                    }
                } else if(turnWay.equals("u")){
                    if(k > a)
                        k--;
                    else{
                        p++;
                        l++;
                        turnWay = "r";
                    }
                } else{
                    if(l < q)
                        l++;
                    else{
                        a++;
                        k++;
                        turnWay = "d";
                    }
                }
            }
        }
        return result;
    }

    public static void display(int[][] mat){
        int x = mat.length;
        int y = mat[0].length;
        for(int i = 0; i<x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int x = sc.nextInt();
        System.out.println("Enter columns");
        int y = sc.nextInt();
        int[][] matrixInput = new int[x][y];
        //generating matrix of size provided
        for(int i = 0; i<x; i++) {
            for (int j = 0; j < y; j++) {
                matrixInput[i][j] = (int) (Math.random() * 9);
            }
        }
        System.out.println("Original Matrix is : \n");
        display(matrixInput);

        int [][] result = helix(matrixInput);
        System.out.println("Helix Matrix is : \n");
        display(result);
    }
}
