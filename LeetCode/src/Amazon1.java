/**
* pickup two movies that length is exactly 30 minutes before the plan ends
* Example: flightduration = 90,  movieDuration = [1, 10, 25, 35, 60]
* output [2, 3]
*/
import java.util.*;
import java.io.*;

public class Amazon1{
	public static void main(String[] args){
		ArrayList<Integer> output = movieDuration(90, new ArrayList<Integer>(Arrays.asList(1,10,25,35,60)));
		System.out.println("Output is: "+output);
	}
	public static int maxHelp(ArrayList<Integer> indexes, ArrayList<Integer> duration){
		int result = Integer.MIN_VALUE;
		for(int index: indexes)
			result = Math.max(result, duration.get(index));
		return result;
	}
	public static ArrayList<Integer> movieDuration(int flightDuration, ArrayList<Integer> movieDuration){
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<Integer,Integer> durationToID = new HashMap<Integer,Integer>();
		for(int i=0; i<movieDuration.size(); i++){
			int thisMovieLength = movieDuration.get(i);
			int needLength = flightDuration-30-thisMovieLength;
			if(durationToID.containsKey(needLength)){
				int otherID = durationToID.get(needLength);
				ArrayList<Integer> newResult = new ArrayList<Integer>(Arrays.asList(otherID,i));
				if(result.isEmpty() || maxHelp(result,movieDuration)<maxHelp(newResult,movieDuration))
					result = newResult;
			}
			durationToID.put(thisMovieLength,i);
		}
		return result;
	}
}
