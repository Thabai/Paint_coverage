
import com.paint.Room;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {

    @Test

    public void testSetLength() {
        Room testRoom = new Room();
        testRoom.setWallNumber(1);
        testRoom.setLength(5);
        testRoom.setHeight(1);
        assertEquals(5,testRoom.getAreaForTest(), "Not quite right");
    }


}