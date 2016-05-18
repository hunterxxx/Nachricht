
public class Verrauschen extends Nachricht{
	
	public Verrauschen(float rausch, int wh, boolean voe, String nachr){
		super(rausch,wh,voe, nachr);
	}
	
	public String encoden(){
		int z=0;
		String speicher=original;
		int a=Math.round((float)(original.length()*rauschen));
		int [] save=new int[a];
		int zaehler=0;
		int repval=0;
		for(int i=0; i<a;i++){
			boolean act=true;
			
			while(act){
				z=Math.round((float)Math.random()*original.length());
				for(int j=0;j<a;j++){
					if(save[j]==z){
						act=true;
					}
					else{
						act=false;
					}
				}
			}
			save[zaehler]=z;
			zaehler++;
			repval=(int)((float)Math.random()*28+95);
			speicher=replace(speicher,z-1,(char)(repval));
			
		}
		
		
		
		return speicher;
		
	}
	
	public String replace(String spe,int v,char neu){
		String anf=spe.substring(0,v);
		String end=spe.substring(v+1);
		return anf+neu+end;
	}
}
