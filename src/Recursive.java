public class Recursive {

    Recursive(){

    }

    public int GCD(int a_in, int b_in){

        if (b_in==0){
            return a_in;
        }
        else {
            return GCD(b_in, a_in%b_in);
        }

    }

    public void GCD_DEMO(int a_in, int b_in){

        int a, b;

        // Make sure that larger number is stored in a;
        if (a_in>=b_in){
            a = a_in;
            b = b_in;
        }
        else {
            b = a_in;
            a = b_in;
        }

        int result = GCD(a,b);

        System.out.printf("GCD(%d,%d) = %d\n", a_in, b_in, result);

    }

    public long Factorial(int n){

        if (n==1){
            return 1;
        }
        else {
            // We should check for overflow!
            return (n * Factorial(n-1));
        }
    }

    public void Factorial_DEMO(int n){
        System.out.printf("Factorial %d = %d\n",n, Factorial(n));
    }

    public void Hanoi(int n, char SRC, char DST, char MID){
        if (n==1){
            System.out.printf("%c -> %c\n", SRC, DST);
        }
        else {
            Hanoi(n-1,SRC,MID,DST);
            Hanoi(1,SRC,DST,MID);
            Hanoi(n-1,MID,DST,SRC);
        }
    }

    public void Hanoi_DEMO(int n){
        Hanoi(n,'A','C','B');
    }


}
