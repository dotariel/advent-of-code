package aoc.day4

import org.junit.*

class RoomTest {

  @Test
  public void should_throw_exception_for_invalid_room_name() {
    assert throwsException(null)
    assert throwsException('foo')
    assert !throwsException('aaaaa-bbb-z-y-x-123[abxyz]')
  }

  private boolean throwsException(String name) {
    boolean exceptionThrown = false
    
    try  { 
      new Room(name) 
    }
    catch (InvalidRoomName ex) {
      exceptionThrown = true
    }

    return exceptionThrown
  }

  @Test
  public void should_parse_name() {
    new Room('aaaaa-bbb-z-y-x-123[abxyz]').with { room ->
      assert room.encrypted == 'aaaaa-bbb-z-y-x'
      assert room.sector == '123'
      assert room.checksum == 'abxyz'
    }
  }

  @Test
  public void should_determine_if_room_is_valid() {
    assert true == new Room('aaaaa-bbb-z-y-x-123[abxyz]').valid
    assert true == new Room('a-b-c-d-e-f-g-h-987[abcde]').valid
    assert true == new Room('not-a-real-room-404[oarel]').valid
    assert false == new Room('totally-real-room-200[decoy]').valid
  }

  @Test
  public void should_decrypt_name() {
    def room = new Room('qzmt-zixmtkozy-ivhz-343[zimth]')

    assert room.decrypted == 'very encrypted name'
  }
}