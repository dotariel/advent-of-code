package aoc.day5

class SimplePasswordCracker extends PasswordCracker {

  /*
  A hash indicates the next character in the password if its hexadecimal 
  representation starts with five zeroes. If it does, the sixth character in 
  the hash is the next character of the password.
  */
  public String generate(String input, int length) {

    List<HashResult> hashResults = getHashResults(input, length) { hr, results -> shouldAdd(hr) }

    return buildPassword(hashResults)
  }

  private boolean shouldAdd(HashResult hashResult) {
    hashResult.hash.startsWith('00000') 
  }

  private String buildPassword(List<HashResult> hashResults) {
    hashResults.sort { a,b -> a.index <=> b.index }
      .collect { r -> r.hash[5] }
      .join("")
    }
}

