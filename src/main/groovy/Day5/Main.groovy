package aoc.day5

class Main {

   public static void main(String[] args) {
    if (args.size() != 3) {
      usage(); return
    }
    
    if ( !(args[0] in ["simple", "advanced"]) ){
      usage(); return
    }

    if ( !args[2].isNumber()) {
      usage(); return 
    }

    def mode = args[0]
    def input = args[1]
    def length = args[2] as Integer

    switch(mode) {
      case "simple":
        println new SimplePasswordCracker().generate(input, length)
        break
      case "advanced":
        println new AdvancedPasswordCracker().generate(input, length) 
        break
    }
  }

  private static void usage() {
    println "Usage: PasswordCracker <simple|advanced> <input> <length>"
  } 
}