package Recursion;


public class Ex3 {
	public static void Move(int src, int dest){
		System.out.println("The disk has been moved from"+src+"to"+dest);}
	public static void TowerOfHanoi(int disk, int src, int mid, int dest){
		int count=0;
		if(disk%2!=0){
			int j=(int) (Math.pow(2, disk)/6);
			int r=0;
			for(int i=0;i<j;i++){
				Move(src,dest);
				Move(src,mid);
				Move(dest,mid);
				count+=3;
				r++;
				if(r==1){
					Move(src, dest);
					Move(mid, src);
					Move(mid, dest);
					r-=2;
				}
				if(r==0){
					Move(dest, src);
					Move(mid, src);
					Move(dest, mid);
				}
				count+=3;
			}
			Move(src,dest);
			count+=1;
		}
		else{
			int j=(int)(Math.pow(2, disk)/6);
			int r=0;
			for(int i=0;i<j;i++){
				Move(src,mid);
				Move(src,dest);
				Move(mid,dest);
				count+=3;
				r++;
				if(r==1){
					Move(src,mid);
					Move(dest,src);
					Move(dest,mid);
					count+=3;
					r-=2;
				}
				else{
					Move(mid,src);
					Move(dest,src);
					Move(mid,dest);
					count+=3;
				}
			}
			Move(src,mid);
			Move(src,dest);
			Move(mid,dest);
			count+=3;
		}
		System.out.println("It took "+count+" moves.");
	}
	public static void main(String[] args){
		TowerOfHanoi(8, 1, 2, 3);
	}
}
