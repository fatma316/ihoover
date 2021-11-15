package hoover;

import enums.Direction;
import utils.HooverUtils;

public class HooverFactory {
    public IHoover createHoover(int x, int y, String direction) {
        Direction directionEnum = HooverUtils.generateDirection(direction);
        return new Hoover(x, y, directionEnum);
    }
}
