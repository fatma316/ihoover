package hoover;

import enums.Direction;

public class Hoover implements IHoover {
    private int x;
    private int y;
    private Direction direction;

    public Hoover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void rotateToLeft() {
        this.direction = direction.before();
    }

    @Override
    public void rotateToRight() {
        this.direction = direction.next();
    }

    @Override
    public void advance() {
        switch (direction) {
            case NORTH:
                this.y++;
                break;
            case SOUTH:
                this.y--;
                break;
            case EAST:
                this.x++;
                break;
            case WEST:
                this.x--;
                break;
        }
    }

    @Override
    public int getCurrentX() {
        return this.x;
    }

    @Override
    public int getCurrentY() {
        return this.y;
    }

    @Override
    public void showCurrentPosition() {
        System.out.println("X=" + x + " Y=" + y + " direction : " + direction.toString());
    }
}
