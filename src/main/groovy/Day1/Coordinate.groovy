package aoc.day1

class Coordinate {
  int x
  int y

  public Coordinate() {
    this(0,0)
  }

  public Coordinate(int x, int y) {
    this.x = x
    this.y = y
  }

  public Coordinate clone() {
    return new Coordinate(this.x, this.y)
  }

  public int distanceFrom(Coordinate other) {
    Math.abs(this.x - other.x) + Math.abs(this.y - other.y)
  }

  public List toList() {
    return [this.x, this.y]
  }
}

class InvalidOperation extends Exception {
  public InvalidOperation(String msg) {
    super(msg)
  }
}

public enum Orientation {
  NORTH, EAST, SOUTH, WEST
}