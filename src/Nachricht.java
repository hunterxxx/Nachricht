
public class Nachricht {
	
	protected String original;
	protected String verrauscht;
	protected boolean verIent;
	protected float rauschen;
	protected int wiederholungen;
	
	public Nachricht(float rausch, int wh, boolean voe, String nachr){    //voe true => verrauschen  false=> entrauschen
		this.verIent=voe;
		if(voe){
			this.original=nachr;
			this.verrauscht="";
		}
		else{
			this.verrauscht=nachr;
			this.original="";
		}
		this.rauschen=rausch;
		this.wiederholungen=wh;
	}


	public void wiederh(){
		Verrauschen verr=new Verrauschen(rauschen,wiederholungen,verIent,original);
		for(int i=0;i<wiederholungen;i++){
			verrauscht+=verr.encoden();

		}
	}
	
	public String durchf(){
		if(verIent){
			wiederh();
			return verrauscht;
		}
		else{
			Entrauschen entr=new Entrauschen(rauschen,wiederholungen,verIent,verrauscht);
			original=entr.decoden();
			return original;
		}
	}
}
