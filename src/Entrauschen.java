import java.util.*;
public class Entrauschen extends Nachricht{
	
	public Entrauschen(float rausch, int wh, boolean voe, String nachr){
		super(rausch,wh,voe, nachr);
	}
	
	public String decoden(){
		int l=verrauscht.length()/wiederholungen;
		String ret="";
		char[][] text=new char[wiederholungen][l];
		for(int i=0;i<wiederholungen;i++){
			for(int j=0;j<l;j++){
				text[i][j]=verrauscht.charAt(i*l+j);
			}
		}
		LinkedList<Character> chars=new LinkedList<Character>();
		LinkedList<Integer>  anz=new LinkedList<Integer>();
		for(int j=0;j<l;j++){
			for(int i=0;i<wiederholungen;i++){
				if(!chars.contains(text[i][j])){
					chars.add(text[i][j]);
					anz.add(1);
				}
				else{
					anz.set(chars.indexOf(text[i][j]),anz.get(chars.indexOf(text[i][j]))+1);
				}
			}
			int max=0;
			for(int h=1;h<anz.size();h++){
				if(anz.get(max)<anz.get(h)){
					max=h;
				}
			}
			ret+=chars.get(max);
			chars.clear();
			anz.clear();
		}
		return ret;
	}
	
}
