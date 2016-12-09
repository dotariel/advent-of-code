package aoc.day3

import aoc.InputReader

class Main {
  public static void main(String[] args) {
    getValidTriangles()
    getValidTrianglesByColumn()
  }

  private static void getValidTriangles() {
    def input = InputReader.readInput("resources/Day3/input.txt")
    def inputList = []

    input.eachLine { l -> inputList << l }
    println "Valid Triangles: " + inputList.count { new Triangle(it).valid }
  }

  private static void getValidTrianglesByColumn() {
    def input = InputReader.readInput("resources/Day3/input.txt")

    def rows = input.split('\n').collect { line ->
      line.split(',').with { parts ->
        int a = parts[0] as Integer
        int b = parts[1] as Integer
        int c = parts[2] as Integer

        [a,b,c]
      }
    }

    def newList = rows.collect { it[0] } + rows.collect { it[1] } + rows.collect { it[2] }

    int position = 0
    int valid = 0

    while (position < newList.size()) {
      def sides = newList[position..position+2]

      if (new Triangle(sides[0], sides[1], sides[2]).valid)
        valid++

      position += 3
    }

    println "Valid Triangles (by column): " + valid
  }
}