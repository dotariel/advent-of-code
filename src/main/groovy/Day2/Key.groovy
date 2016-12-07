package aoc.day2

class Key {
  String value
  Map neighbors = [:]

  public Key(String value) {
    this.value = value
  }

  public Key(String value, Map neighbors) {
    this(value)
    this.neighbors = neighbors
  }

  public Key(String value, String up, String down, String left, String right) {
    this(value)
    this.neighbors = [:]

    if (up)    neighbors["U"] = up
    if (down)  neighbors["D"] = down
    if (left)  neighbors["L"] = left
    if (right) neighbors["R"] = right
  }
}
