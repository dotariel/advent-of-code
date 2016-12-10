package aoc.day6

class Signal {
  private String message
  private DecodingStrategy strategy

  public Signal(String message) {
    this(message, new MaxDecodingStrategy())
  }

  public Signal(String message, DecodingStrategy strategy) {
    this.message = message
    this.strategy = strategy
  }

  public String decode() {
    List splits = this.message.split('\n')
    List rows = splits.collect { r -> r.collect { c -> c }}
    List colSizes = rows.collect { c -> c.size() }.unique()
    
    if (colSizes.size() != 1) 
      throw new InvalidMessage()

    List cols =  (0..colSizes[0]-1).collect { n -> rows.collect { it[n] } }

    cols.collect(strategy.bind()).join()
  }
}
