import java.util.*;
public class CountTriplet{
	public static long count(List<Long> arr,long r){
		Map<Long,Long> leftmap=new HashMap<>();
		Map<Long,Long> rightmap=new HashMap<>();
		for(long item:arr){
			rightmap.put(item,rightmap.getOrDefault(item,0L)+1);
		}
		long cnt=0;
		for(int i=0;i<arr.size();i++){
			long c1=0,c2=0;
			long midterm=arr.get(i);
			
			rightmap.put(midterm,rightmap.getOrDefault(midterm,0L)-1);
			if(leftmap.containsKey(midterm/r)&&midterm%r==0)
				c1=leftmap.get(midterm/r);
			if(rightmap.containsKey(midterm*r))
				c2=rightmap.get(midterm*r);
			cnt+=c1*c2;
			leftmap.put(midterm,leftmap.getOrDefault(midterm,0L)+1);
		}return cnt;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long r=sc.nextLong();
		List<Long> ar=new ArrayList<>();
		for(int i=0;i<n;i++){
			ar.add(sc.nextLong());
		}		
		System.out.println(count(ar,r));
	}
}