package asd;

public class asd extends Thread{
	public asd(String name){
		super(name);
	}
	static int tick=20;
	static Object ob="aa";
	public void run(){
	syso("你是一个大傻逼");
		while(tick>=0){
			synchronized(ob){
				if(tick>0){
					System.out.println(getName()+"Âô³öÁËµÚ"+tick+"ÕÅÆ±");
					tick--;
				}else{
					System.out.println("Æ±ÂôÍêÁË");
					return;
				}
			}
			try{
				sleep(100);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
