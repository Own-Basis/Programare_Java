package Test4;

public class SuperClasa {
    protected int a;
    private int x; public
    SuperClasa(){
        a=2; x=calcul();
    }
    public int calcul()
    {
        return a*a;
    }
    public String toString(){
        return a+", "+x;
    }
}
