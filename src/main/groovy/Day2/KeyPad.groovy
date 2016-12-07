package aoc.day2

abstract class KeyPad {
  List<Key> keys

  public Key getKeyFromValue(String value) {
    keys.find { k -> k.value == value }
  }
}
