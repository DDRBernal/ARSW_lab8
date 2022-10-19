package edu.eci.arsw.collabpaint.model;

public class Polygon {

    private Point[] points;

    public Polygon(){

    }

    public Polygon(Point[] points){
        this.points = points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
