package triangle;

public class Triangle extends Point{
    Point p1,p2,p3;
    int a,b,c;
    public Triangle(){a = 1; b = 1; c = 1;}
    public Triangle(int x, int y, int z){ a = x; b =y; c = z;}
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
        p1 = new Point(x1,y1);
        p2 = new Point(x2,y2);
        p3 = new Point(x3,y3);
        a = p1.findLength(p2);
        b = p2.findLength(p3);
        c = p3.findLength(p1);
    }
    public triType classify() {
        if (a <= 0 || b <= 0 || c <= 0) return triType.none;
        if (a == b && b == c) return triType.equilateral;
        if (a >= b+c || c >= b+a || b >= a+c) return triType.none;
        if (b==c || a==b || c==a) return triType.isosceles;
        return triType.scalene;
    }
    public double getArea(){
        double s = (a+b+c)/2;
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return area;
    }

    public void setLength(int x, int y, int z){a = x; b = y; c = z;}

    public static void main(String[] args) {

    }
}

class Point{
    int x,y;
    Point(){x = 0; y = 0;}
    Point(int newX, int newY){x = newX; y = newY;}
    public int findLength(Point temp){
        int length = (int) Math.sqrt((Math.pow(temp.x-this.x,2)+Math.pow(temp.y-this.y,2)));
        return length;
    }
}
