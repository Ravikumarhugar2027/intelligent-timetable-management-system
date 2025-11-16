package computer_networks;
import java.util.Scanner;
public class RSA9 {

	public static void main(String[] args) {
		String msg;
		int pt[]=new int[100];
		int ct[]=new int[100];
		int z,n,p,q,e,d,mlen;
		Scanner in=new Scanner(System.in);
		do {
			System.out.println("Enter the two large prime numbers p and q : ");
			p=in.nextInt();
			q=in.nextInt();
		}while(prime(p)==0||prime(q)==0);
		n=p*q;
		z=(p-1)*(q-1);
		System.out.println("value of n : "+n+" and value of z : "+z);
		for(e=2;e<z;e++) {
			if(gcd(e,z)==1)
				break;
		}
		System.out.println("Public key(e,n) : "+e+" , "+n+"\t Encrytpion key, e : "+e);
		for(d=2;d<z;d++) {
			if((e*d)%z==1)
				break;
		}
		System.out.println("Private key(d,n) : "+d+" , "+n+"\t Decrytpion key, d : "+d);
		in.nextLine();
		System.out.println("Enter the message for encryption : ");
		msg=in.nextLine();
		mlen=msg.length();
		for(int i=0;i<mlen;i++)
			pt[i]=msg.charAt(i);
		System.out.println("ASCII values of PT array : ");
		for(int i=0;i<mlen;i++)
			System.out.print(pt[i]+" ");
		System.out.println("\nCipher text obtained : ");
		for(int i=0;i<mlen;i++)
			ct[i]=mult(pt[i],e,n);
		for(int i=0;i<mlen;i++)
			System.out.print(ct[i]+" ");
		System.out.println("\nPlain text obtained : ");
		for(int i=0;i<mlen;i++)
			pt[i]=mult(ct[i],d,n);
		for(int i=0;i<mlen;i++)
			System.out.println(pt[i]+" "+(char)pt[i]);
	}
	public static int mult(int base,int exp,int n) {
		int j,res=1;
		for(j=1;j<=exp;j++)
			res=(res*base)%n;
		return res;
	}
	public static int prime(int n) {
		for(int i=2;i<n-1;i++) {
			if(n%i==0) {
				return 0;
			}
		}
		return 1;
	}
	public static int gcd(int a, int b) {
		if(b==0) {
			return a;
		}
		return(gcd(b,a%b));
	}
}
