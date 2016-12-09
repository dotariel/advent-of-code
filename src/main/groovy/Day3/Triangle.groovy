package aoc.day3

class Triangle {
  private int a,b,c

  public Triangle(String input) {
    List<String> sides = input.tokenize(",")

    this.a = sides[0] as Integer
    this.b = sides[1] as Integer
    this.c = sides[2] as Integer
  }

  public Triangle(int a, int b, int c) {
    this.a = a
    this.b = b
    this.c = c
  }

  public boolean isValid() {
    (a + b > c) && (a + c > b) && (b + c > a) 
  }

  public String toString() {
    "${a},${b},${c}"
  }
}
