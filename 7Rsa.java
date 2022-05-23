import java.io.*;
//import java.math.*;
class Rsa7 {
    public static void main(String args[])throws IOException {
        int q,p,n,pn,publickey=0,d=0,msg;
        double cipher,ptext;
        int check,check1;
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1st Number : ");
        p=Integer.parseInt(in.readLine());
        System.out.println("Enter 2nd Number : ");
        q=Integer.parseInt(in.readLine());
        check=prime(p);
        check1=prime(q);
        if(check!=1||check1!=1) {
            System.exit(0); }
        n=p*q;
        pn=(p-1)*(q-1);
        for(int e=2;e<pn;e++) {
            if(gcd(e,pn)==1) {
                publickey=e;
                System.out.println("PUBLIC KEY:"+e);
                break; }}
        for(int i=0;i<pn;i++) {
            d=i;
            if(((d*publickey)%pn)==1)
                break; }
        System.out.println("PRIVATE KEY:"+d);
        System.out.println("ENTER MESSAGE");
        msg=Integer.parseInt(in.readLine());
        cipher=Math.pow(msg,publickey);
        cipher=cipher%n;
        System.out.println("ENCRYPTED:"+cipher);
        ptext=Math.pow(cipher,d);
        ptext=ptext%n;
        System.out.println("DECRYPTED:"+ptext); }
    static int prime(int a) {
        int flag=0;
        for(int i=2;i<a;i++) {
            if(a%i==0) {
                System.out.println(a+ "is not a Prime Number");
                flag = 1;
                return 0; }}
        if(flag==0)
            return 1;
        return 1; }
    static int gcd(int number1, int number2) {
        if(number2 == 0){
            return number1; }
        return gcd(number2, number1%number2);
    }
}
