package main;

public class Position {
    private float x;
    private float y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static float calcDistance(Position pos1, Position pos2) {
        float _distanceX = (pos1.getX() - pos2.getX());
        
        float _distanceY = pos1.getY() - pos2.getY();
        
        float _diagonalSquared = (_distanceX*_distanceX) + (_distanceY*_distanceY);

        return _diagonalSquared;
    }
}