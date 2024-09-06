import junit.framework.TestCase.assertEquals
import org.junit.Test

class ContactsTest{
  @Test
  fun testAddingANewContact(){
    val contacts = Contacts()
    val result = contacts.addContact()

    assertEquals(String, result, "The addContact function should add a name and phone number to the list")
  }
}