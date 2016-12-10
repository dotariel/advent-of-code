package aoc.day1

import org.junit.*

class LocationTest {

  @Test
  public void should_get_distance() {
    assert new Location(2,3).getDistance(new Location(0,0)) == 5
    assert new Location(10,2).getDistance(new Location(0,0)) == 12
    assert new Location(-140,138).getDistance(new Location(0,0)) == 278
  }

  @Test
  public void should_accept_valid_operation() {
    assert true == testOperationException('foo')
    assert true == testOperationException('X1')
    assert true == testOperationException('R')
    assert true == testOperationException('L')
    assert false == testOperationException('R2')
    assert false == testOperationException('L10')
  }

  private boolean testOperationException(operation) {
    def exceptionCaught = false

    try {
      new Location().move(operation)
    }
    catch (InvalidOperation e) {
      exceptionCaught = true
    }

    exceptionCaught
  }

  @Test
  public void should_change_orientation() {
    def c = new Location(Orientation.NORTH, 0, 0)
    
    assert c.changeOrientation('L').orientation == Orientation.WEST
    assert c.changeOrientation('L').orientation == Orientation.SOUTH
    assert c.changeOrientation('L').orientation == Orientation.EAST
    assert c.changeOrientation('L').orientation == Orientation.NORTH
    assert c.changeOrientation('R').orientation == Orientation.EAST
  }

  @Test
  public void should_move() {
    new Location(0,0).move('R1').with { c ->
      assert c.coordinate.x == 1
      assert c.coordinate.y == 0
    }

    new Location(0,0).move('L5').with { c ->
      assert c.coordinate.x == -5
      assert c.coordinate.y == 0
    }

    new Location(0,0).move('L5').move('R5').with { c ->
      assert c.coordinate.x == -5
      assert c.coordinate.y == 5
    }
  }

  @Test
  public void should_determine_distance_moved() {
    def start = new Location(0,0)

    assert 5 == new Location(0,0)
                .move('R2')
                .move('L3')
                .getDistance(start)

    assert 2 == new Location(0,0)
                .move('R2')
                .move('R2')
                .move('R2')
                .getDistance(start)

    assert 12 == new Location(0,0)
                .move('R5')
                .move('L5')
                .move('R5')
                .move('R3')
                .getDistance(start)
  }
}