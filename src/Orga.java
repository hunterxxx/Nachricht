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
	
	public void fromNachricht1(){
		try{
			FileReader fr = new FileReader("Nachricht1.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String str;
			while((str=br.readLine()) != null){
				Entrauschen et = new Entrauschen((float)0.7,6,false,str); 
				System.out.println(et.decoden());
			}		
			br.close();
		}catch (IOException e){
			out.println("File not found");
		}
	}
	
	public void fromNachricht2(){
		try{
			FileReader fr = new FileReader("Nachricht2.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String str;
			while((str=br.readLine()) != null){
				Entrauschen et = new Entrauschen((float)0.9,11,false,str); 
				System.out.println(et.decoden());
			}		
			br.close();
		}catch (IOException e){
			out.println("File not found");
		}
	}
	
	public String start(){
		Nachricht nr=new Nachricht((float)0.7,6,true,"wettbewerb");
		System.out.println(nr.durchf());
		return nr.durchf();
	}
	
	public void output(){
		try{
			//FileWriter fw = new FileWriter("Wettbewerb.txt");
			PrintWriter pw = new PrintWriter("Wettbewerb.txt");
			
			//Nachricht nr=new Nachricht((float)0.7,6,true,"wettbewerb");			
			pw.println(start());
			
			pw.close();
		}catch (IOException e){
			out.println("Error");
		}
	}
}
