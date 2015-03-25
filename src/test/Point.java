package test;

public class Point {
    int x, y;
    Point(){super();};
    Point(int x, int y) {this.x = x; this.y = y;}
    Point(Point p) {this.x = p.x; this.y = p.y;}
    int getX() {return this.x;}
    int getY() {return this.y;}
    void setX(int xval) {this.x = xval;}
    void setY(int yval) {this.y = yval;}
    Point add(Point p) {
        this.x += p.getX();
        this.y += p.getY();
        return this;
    }
    double distance(Point p) {
        return Math.abs(Math.sqrt(Math.pow(Math.abs(this.x = p.getX()), 2)
               + Math.pow(Math.abs(this.y - p.getY()), 2)));
    }
    public static void main(String[] args) {
        Point pp1, pp2;
        pp1 = new Point();
        pp2 = new Point();
        for (int i = 0; i < 10; i++) {
            pp1.setX(i); pp1.setY(i);
            pp2.setX(i + i * 2); pp2.setY(i + i * 2);         
            System.out.println("The distance between ");
            System.out.println("pp1(" + pp1.getX() + ", " + pp1.getY() +") and ");
            System.out.println("pp2(" + pp2.getX() + ", " + pp2.getY() +") : ");
            System.out.println(pp1.distance(pp2));
            pp1 = null; pp2 = null;
        }
        return;
     }
  } 
