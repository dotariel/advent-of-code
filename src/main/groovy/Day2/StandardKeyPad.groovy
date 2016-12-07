package aoc.day2

/* 
---------
| 1 2 3 |
| 4 5 6 |
| 7 8 9 |
---------
*/

class StandardKeyPad extends KeyPad {
  public StandardKeyPad() {
    keys = []
    keys << new Key('1', null, "4", null, "2")
    keys << new Key('2', null, "5", "1", "3")
    keys << new Key('3', null, "6", "2", null)
    keys << new Key('4', "1", "7", null, "5")
    keys << new Key('5', "2", "8", "4", "6")
    keys << new Key('6', "3", "9", "5", null)
    keys << new Key('7', "4", null, null, "8")
    keys << new Key('8', "5", null, "7", "9")
    keys << new Key('9', "6", null, "8", null)
  }
}