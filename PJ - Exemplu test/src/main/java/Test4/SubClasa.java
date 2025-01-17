package Test4;

public class SubClasa extends SuperClasa{
    private int y; public SubClasa(){
        y=calcul();
    }
    public int calcul()
    {
        return a*a*a;
    }
    public String toString()
    {
        return super.toString() + ", "+y;
    }
}
