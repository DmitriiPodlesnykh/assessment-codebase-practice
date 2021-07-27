class Position {
    private int x = 0;
    
    private int y = 5;
    
    public Position() {
    }
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(int dx) {
        this.x = x + dx;
    }
    
    public int getX() {
        return x;
    }
    
    public void setY(int dy) {
        this.y = y + dy;
    }
    
    public int getY() {
        return y;
    }
    
    public String getCoordinateInformation() {
        return x + " " + y;
    }
}

public class Robot {
    
    private Position currentPosition;
    
    private Position previosPosition;
    
    public Robot(int x, int y) {
        this.currentPosition = new Position(x, y);
        this.previosPosition = new Position(0, 5);
    }
    
    public Robot() {
        this.previosPosition = new Position();
        this.currentPosition = new Position(0, 5);
    }
    
    
    public void moveX(int dx) {
        this.previosPosition = new Position(currentPosition.getX(), currentPosition.getY());
        this.currentPosition.setX(dx);
    }
    
    public void moveY(int dy) {
        this.previosPosition = new Position(currentPosition.getX(), currentPosition.getY());
        this.currentPosition.setY(dy);
    }
    
    public void printCurrentCoordinates() {
        System.out.println(currentPosition.getCoordinateInformation());
    }
    
    public void printLastCoordinates() {
        System.out.println(previosPosition.getCoordinateInformation());
    }
    
    public void printLastMove() {
        System.out.println(calculateLastMove());
    }
    
    private String calculateLastMove() {
        if (currentPosition.getX() == previosPosition.getX()) {
            int diff = currentPosition.getY() - previosPosition.getY();
            return "y " + diff; 
        } else if (currentPosition.getY() == previosPosition.getY()){
            int diff = currentPosition.getX() - previosPosition.getX();
            return "x " + diff; 
        } return "stay";
    }
    
}
