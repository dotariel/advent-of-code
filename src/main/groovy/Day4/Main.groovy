package aoc.day4

import aoc.InputReader

class Main {
  public static void main(String[] args) {
    getSectorIdSums()
    getNorthPoleSector()
  }

  private static void getSectorIdSums() {
    def result = getInputs().collect { new Room(it) }.findAll { r -> r.valid }.sum { r -> r.sector as Integer }

    println "Sector ID Total: " + result
  }

  private static void getNorthPoleSector() {
    def result = getInputs().collect { new Room(it) }.find { r -> r.decrypted.contains('northpole') }

    println "${result.decrypted}: ${result}"
  }

  private static List getInputs() {
    def input = InputReader.read("resources/Day4/input.txt")
    def inputs = []

    input.eachLine { l -> inputs << l }

    return inputs
  }
}