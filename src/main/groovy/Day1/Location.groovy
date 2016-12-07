package aoc.day1

class Location {
  Coordinate coordinate
  Orientation orientation
  List movements = []

  public Location() {
    this(Orientation.NORTH, new Coordinate())
  }

  public Location(int x, int y) {
    this(Orientation.NORTH,new Coordinate(x,y))
  }

  public Location(Orientation orientation, int x, int y) {
    this.orientation = orientation
    this.coordinate = new Coordinate(x,y)
  }

  public Location(Orientation orientation, Coordinate coordinate) {
    this.orientation = orientation
    this.coordinate = coordinate
  }

  public int getDistance(Location start) {
    this.coordinate.distanceFrom(start.coordinate)
  }

  public Location changeOrientation(String operation) {
    int modifier = (operation == 'L') ? -1 : 1

    def list = Orientation.values() as List
    def currentIndex = list.indexOf(this.orientation) as Integer
    this.orientation = list[(currentIndex + modifier) % list.size()]

    this
  }

  public Location shift() {
    def newCoordinate = this.coordinate.clone()

    switch (this.orientation) {
      case Orientation.NORTH:
        newCoordinate.y += 1
        break

      case Orientation.EAST:
        newCoordinate.x += 1
        break

      case Orientation.SOUTH:
        newCoordinate.y -= 1
        break

      case Orientation.WEST:
        newCoordinate.x -= 1
        break 
    }

    this.movements << newCoordinate.toList()
    this.coordinate = newCoordinate

    this
  }

  public Location move(String operation) throws InvalidOperation {
    def matcher = (operation =~ /([RL])([0-9]+)/)

    if (!matcher.matches()) {
      throw new InvalidOperation("Not a valid operation: '${operation}'")
    }
    
    def direction = matcher[0][1] as String
    def distance = matcher[0][2] as Integer

    this.changeOrientation(direction)

    distance.times { 
      this.shift() 
    }

    this
  }
}
