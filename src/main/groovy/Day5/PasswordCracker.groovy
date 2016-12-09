package aoc.day5

import java.util.concurrent.*

abstract class PasswordCracker {

  private static int THREADS = 10
  
  protected ExecutorService pool

  public List<HashResult> getHashResults(String input, int length, Closure addCondition) {
    int offset = 0
    int batchSize = 500000
    List futures = []
    List results = []

    if (!this.pool) {
      this.pool = Executors.newFixedThreadPool(THREADS)
    }

    HashResult hashResult

    print "Scanning (${length} characters): "

    while (results.size() < length) {

      print "_"

      batchSize.times { index ->
        int newIndex = index + offset

        futures << pool.submit(new Hasher("${input}${newIndex}", newIndex))
      }

      futures.each { f ->
        try {
          hashResult = f.get(20, TimeUnit.MILLISECONDS)

          if (addCondition(hashResult, results)) {
              print "X"
              results << hashResult
          }
        } 
        catch (TimeoutException to) { }
      }

      futures = []

      offset += batchSize
    }

    print " - Complete."

    pool.shutdownNow()

    return results.take(length)
  }
}