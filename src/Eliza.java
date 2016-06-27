import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;
import java.util.Random;

public class Eliza {
	public static void main(String[] args){
		Set<String>hedgeSet=hedgeInit();
		Set<String>qualifierSet=qualifierInit();
		HashMap<String,String>switchMap=switchInit();
		
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		Thread interruptor = new Thread(new Interruptor());
		
		System.out.println("Hi, my name is Eliza!  Tell me about your day.");
		interruptor.start();
		while(true){
			String response = in.nextLine();
			response.toLowerCase();
			String[] words = response.split(" ");
			for(int i = 0;i<words.length;i++){
				if(switchMap.containsKey(words[i])){
					words[i]=switchMap.get(words[i]);
				}
			}
			if(rand.nextInt(2)==0){
				int pick = rand.nextInt(hedgeSet.size());
				int i = 0;
				for(String str:hedgeSet){
					if(i==pick){
						System.out.println(str);
						break;
					}
					else i++;
				}
			}
			
			else{
				int pick = rand.nextInt(qualifierSet.size());
				int i = 0;
				String output = new String();
				for(String str:qualifierSet){
					if(i==pick){
						output= output+str;
						break;
					}
					else i++;
				}
				for(String word:words){
					output+= " " + word;
				}
				System.out.println(output);
			}
		}	
	}
	public static HashSet hedgeInit(){
		HashSet<String>hedges=new HashSet<String>();
		hedges.add("Tell me more about that.");
		hedges.add("Many of my patients say the same thing.");
		hedges.add("That's sounds interesting, tell me more.");
		hedges.add("Do you think that's a good or bad thing?");
		hedges.add("Please tell me more.");
		hedges.add("It is getting late, maybe we had better quit.");
		
		return hedges;
	}
	
	public static HashSet qualifierInit(){
		HashSet<String>qual=new HashSet<String>();
		qual.add("You seem to think that");
		qual.add("Why do you say that");
		qual.add("So, you are concerned that");
		
		return qual;
	}
	
	public static HashMap switchInit(){
		HashMap<String,String>switches=new HashMap<String,String>();
		switches.put("me","you");
		switches.put("I","you");
		switches.put("my","your");
		switches.put("mine","yours");
		switches.put("myself","yourself");
		switches.put("us","you");
		switches.put("we","you");
		switches.put("am","are");
		return switches;
	}
}
