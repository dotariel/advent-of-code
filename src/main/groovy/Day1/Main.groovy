package aoc.day1

import aoc.InputReader

class Main {
  
  public static void main(String[] args) {
    new Main().getTotalDistance()
    new Main().getDistanceToFirstLocationVisitedTwice()
  }

  private void getTotalDistance() {
    def location = new Location()
    def input = InputReader.readInput("resources/Day1/input.txt")

    input.split(",").each { m -> location.move(m) }

    println "Final Distance: " + location.getDistance(new Location())
  }

  private void getDistanceToFirstLocationVisitedTwice() {
    def location = new Location()
    def input = InputReader.readInput("resources/Day1/input.txt")
    def inputList = input.split(",")

    inputList.each { location.move(it) }

    def targetCoordinate = location.movements.groupBy { it }.find { k,v -> v.size() == 2 }.key
    def targetLocation = new Location(targetCoordinate[0], targetCoordinate[1])

    println "Final distance to first location visited twice: " + targetLocation.getDistance(new Location())
  }
}