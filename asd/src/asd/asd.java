package asd;

public class asd extends Thread{
	public asd(String name){
		super(name);
	}
	static int tick=20;
	static Object ob="aa";
	public void run(){
		while(tick>=0){
			synchronized(ob){
				if(tick>0){
					System.out.println(getName()+"�����˵�"+tick+"��Ʊ");
					tick--;
				}else{
					System.out.println("Ʊ������");
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
