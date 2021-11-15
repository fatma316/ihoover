package hoover;

public interface IHoover {
    public void rotateToLeft();

    public void rotateToRight();

    public void advance();

    public int getCurrentX();

    public int getCurrentY();

    public void showCurrentPosition();

}
