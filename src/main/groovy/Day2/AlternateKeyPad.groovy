package aoc.day2

/* 
-------------
|     1     |
|   2 3 4   |
| 5 6 7 8 9 |
|   A B C   |
|     D     |
-------------
*/

class AlternateKeyPad extends KeyPad {
  public AlternateKeyPad() {
    keys = []
    keys << new Key('1', null, "3", null, null)
    keys << new Key('2', null, "6", null, "3")
    keys << new Key('3', "1", "7", "2", "4")
    keys << new Key('4', null, "8", "3", null)
    keys << new Key('5', null, null, null, "6")
    keys << new Key('6', "2", "A", "5", "7")
    keys << new Key('7', "3", "B", "6", "8")
    keys << new Key('8', "4", "C", "7", "9")
    keys << new Key('9', null, null, "8", null)
    keys << new Key('A', "6", null, null, "B")
    keys << new Key('B', "7", "D", "A", "C")
    keys << new Key('C', "8", null, "B", null)
    keys << new Key('D', "B", null, null, null)
  }
}