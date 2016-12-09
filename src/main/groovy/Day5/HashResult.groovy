package aoc.day5

class HashResult {
  int index
  String hash

  public HashResult(int index, String hash) {
    this.index = index
    this.hash = hash
  }

  public String toString() {
    "${hash}"
  }
}
