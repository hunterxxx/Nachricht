import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;;

public class Orga {
	
	private boolean active;
	private String[] wiederholungen;
	
	public Orga(){
		this.active=true;
	}
	
	public void toFile(){
		
	}
	
	public String fromNachricht1(){
		String ent = null;
		try{
			FileReader fr = new FileReader("Nachricht1.txt");
			BufferedReader br = new BufferedReader(fr);
			

			Entrauschen et = new Entrauschen((float)0.7,6,false,br.readLine()); 
			ent = et.decoden();
			
			System.out.println("Entrauschte Nachricht 1 :");
			System.out.println(ent);
		
			br.close();
		}catch (IOException e){
			out.println("File not found");
		}
		return ent;
	}
	
	public String fromNachricht2(){
		String ent = null;
		try{
			FileReader fr = new FileReader("Nachricht2.txt");
			BufferedReader br = new BufferedReader(fr);
			
			Entrauschen et = new Entrauschen((float)0.9,11,false,br.readLine()); 
			ent = et.decoden();
			
			System.out.println("Entrauschte Nachricht 2 :");
			System.out.println(ent);
	
			br.close();
		}catch (IOException e){
			out.println("File not found");
		}
		return ent;
	}
	
	public String start(){
		Nachricht nr=new Nachricht((float)0.7,6,true,"wettbewerb");
		System.out.println("Verrauschte Nachricht : Wettbewerb:");
		System.out.println(nr.durchf());
		return nr.durchf();
	}
	
	public void output(){
		try{
			PrintWriter wb = new PrintWriter("Wettbewerb.txt");
			PrintWriter et1 = new PrintWriter("Entrauschen1.txt");
			PrintWriter et2 = new PrintWriter("Entrauschen2.txt");
						
			wb.println(start());
			System.out.println("Wettbewerb.txt has been created \n");
			et1.println(fromNachricht1());
			System.out.println("Entrauschen1.txt has been created \n");
			et2.println(fromNachricht2());
			System.out.println("Entrauschen2.txt has been created \n");
			
			wb.close();
			et1.close();
			et2.close();
		}catch (IOException e){
			out.println("Error");
		}
	}
}
