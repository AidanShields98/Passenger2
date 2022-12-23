package ie.atu;

import atu.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PassengerTest {

        private Passenger myPassenger;

        @BeforeEach
        void setUp() {
            myPassenger = new Passenger("Mr", "John Doe", "1234334567891L", 1233456789, 42);
        }

        @Test
        void testTitlePass(){
            assertEquals("Mr", myPassenger.getTitle());
            myPassenger.setTitle("Ms");
            assertEquals("Ms", myPassenger.getTitle());
            myPassenger.setTitle("Mrs");
            assertEquals("Mrs", myPassenger.getTitle());

        }

        @Test
        void testNamePass(){
            assertEquals("John Doe", myPassenger.getName());
        }

        @Test
        void testIdPass(){
            assertEquals("1234334567891L", myPassenger.getId());
        }

        @Test
        void testPhonePass(){
            assertEquals(1233456789, myPassenger.getPhone());
        }

        @Test
        void testAgePass(){
            assertEquals(42, myPassenger.getAge());
        }

        @Test
        void testTitleFail(){
            Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {new Passenger("Mister", "John Doe", "1235473822", 1222222223, 19);});
            assertEquals("This is not a valid name. Use Mr, Ms or Mrs.", exMessage.getMessage());
        }

        @Test
        void testNameFail(){
            Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {new Passenger("Mr", "ls", "1235422173822L", 1222222223, 19);});
            assertEquals("This is not a valid name.", exMessage.getMessage());
        }

        @Test
        void testIdFail(){
            Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {new Passenger("Mr", "John Doe", "1", 1222222223, 19);});
            assertEquals("This is not a valid ID.", exMessage.getMessage());
        }

        @Test
        void testPhoneFail(){
            Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {new Passenger("Mr", "John Doe", "1235423221213L", 122222, 19);});
            assertEquals("This is not a valid phone number.", exMessage.getMessage());
        }

        @Test
        void testAgeFail(){
            Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {new Passenger("Mr", "John Doe", "1235423243243L", 1222222223, 13);});
            assertEquals("You must be over 16.", exMessage.getMessage());
        }

}
