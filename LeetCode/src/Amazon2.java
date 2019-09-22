/**
* From top-left corner to bottom-right corner
* find all routes and its minimum values
* find the maximum values in those values
* input: columnCount =2
* rowCount = 2
* mat = [[5,1], [4,5]]
*/

import java.util.*;
import java.io.*;
import java.lang.*;

public class Amazon2{

	public static int maxValue(List<Integer> l){
		int result = Integer.MIN_VALUE;
		for(int temp: l)
			result = Math.max(result, temp);
		return result;
	}
	public static int maxOfMinElevations(int columnCount, int rowCount, int[][] mat){
		List<Integer> result = new ArrayList<Integer>();
		go(Integer.MAX_VALUE,0,0,rowCount,columnCount,mat,result);
		return maxValue(result);
	}
	public static void go(int theMin, int r, int c, int rowC, int colC, int[][] mat, List<Integer> result){
		if(r>=rowC || c>=colC)
			return;
		int thisValue = mat[r][c];
		int nextMin = Math.min(theMin,thisValue);
		if(r==rowC-1 && c==colC-1){
			result.add(nextMin);
			return;
		}
		go(nextMin, r+1, c, rowC, colC, mat, result);
		go(nextMin, r, c+1, rowC, colC, mat, result);
	}

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int col,row;
		col = Integer.parseInt(br.readLine());
		row = Integer.parseInt(br.readLine());
		int[][] theArray = new int[row][col];
		for(int i=0; i<row; i++){
			String[] strArray = br.readLine().split(" ");
			for(int j=0; j<col; j++)
				theArray[i][j] = Integer.parseInt(strArray[j]);
		}
		System.out.println("col is: "+col);
		System.out.println("row is: "+row);
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++)
				System.out.print(String.valueOf(theArray[i][j])+" ");
			System.out.print("\n");
		}
		int result = maxOfMinElevations(col, row, theArray);
		System.out.println("result is: "+result);
	}
}
