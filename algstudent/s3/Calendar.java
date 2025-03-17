package algstudent.s3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
	
	
	
	
	public static  List<String> readCompetitorNames(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int numParticipants = Integer.parseInt(br.readLine().trim());
            List<String> competitors = new ArrayList<>();
            
            for (int i = 0; i < numParticipants; i++) {
                competitors.add(br.readLine().trim());
            }
            
            return competitors;
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return null; // Return empty array in case of an error
        }
    }
	
	private static String[][] generatePairings(List<String> players) {
		int n=players.size();
		String[][] pairings = new String[n][n];
		List<String> playersOrder = new ArrayList<>(players);
		
		
		
		
		
		for(int game = 1; game<n;game++) {
			
			for(int i = 0; i<playersOrder.size();i++) {
				System.out.println(playersOrder.get(i));
			}
			System.out.println();
			
			for(int i=0;i<n;i++) {
				if(i%2==0)
					pairings[game][i]=players.get(i+1);
				else
					pairings[game][i]=players.get(i-1);
			}
			rotate(playersOrder);
		}
		return pairings;
	}
	
	private static void rotate(List<String> players) {
		String last = players.remove(players.size()-1);
		players.add(1,last);
	}
	
	private static void printPairings(List<String> players, String[][] pairings) {
		 System.out.println("\nPLAYER/OPPONENT\tDAY 1\tDAY 2\tDAY 3");
		 for (int i = 0; i < players.size(); i++) {
	            System.out.print(players.get(i) + "\t\t ");
	            for (int j = 0; j < pairings.length; j++) {
	                System.out.print(pairings[i][j] + "\t");
	            }
	            System.out.println();
	        }
	}
	
	public static void main(String[] args) {
		List<String> players = readCompetitorNames(args[0]);
		String pairings[][] = generatePairings(players);
		
		
		
		printPairings(players,pairings);
	}

	
	

}
