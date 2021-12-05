package Classes;

public class Vector{
    public int x=0;
    public int y=0;
    public Vector(int X,int Y){
        x=X;
        y=Y;
    }
    public Vector(){}

    public Vector add(Vector v){
        return new Vector(x+v.x,y+v.y);
    }

    public Vector sub(Vector v){
        return new Vector(x-v.x,y-v.y);
    }

    //Returns magnitude of vector
    public double mag(){
        return Math.sqrt((x*x)+(y*y));
    }


    public String toString(){
        return"{"+x+","+y+"}";
    }

}
