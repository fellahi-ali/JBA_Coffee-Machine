class Move {
    // highly inspired by: https://hyperskill.org/learn/step/2180#solutions-579659
    public static void moveRobot(Robot robot, int toX, int toY) {
        if (toX != robot.getX()) {
            // turn to X
            Direction directionToX = toX > robot.getX() ? Direction.RIGHT : Direction.LEFT;
            while (robot.getDirection() != directionToX) {
                robot.turnRight();
            }
            // move to X
            while (toX != robot.getX()) {
                robot.stepForward();
            }
        }

        if (toY != robot.getY()) {
            // turn to Y
            Direction directionToY = toY > robot.getY() ? Direction.UP : Direction.DOWN;
            while (robot.getDirection() != directionToY) {
                robot.turnRight();
            }
            // move to Y
            while (toY != robot.getY()) {
                robot.stepForward();
            }
        }
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx();
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}