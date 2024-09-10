import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.LinkedList

class ContactsTest{
  @Test
  fun testAddingANewContact() {
    val inputQueue = LinkedList<String>()
    inputQueue.addLast("Mathew")
    inputQueue.addLast("0400123456")
    val readln = { inputQueue.pop() }

    val contacts = Contacts(readln)

    contacts.addContact()

    val expected = setOf("Mathew: 0400123456")

    val result = contacts.displayContacts()

    assertEquals(expected, result)
  }

  @Test
  fun testRemovingAContact() {
    val inputQueue = LinkedList<String>()
    inputQueue.addLast("Mathew")
    inputQueue.addLast("0400123456")
    val readln = { inputQueue.pop() }

    val contacts = Contacts(readln)
    contacts.addContact()

    inputQueue.addLast("Mathew")
    inputQueue.addLast("0400456789")
    contacts.removeContact()

    val result = contacts.displayContacts()

    assertEquals(emptySet<String>(), result)
  }

  @Test
  fun testUpdateContactPhoneNumber(){
    val inputQueue = LinkedList<String>()
    inputQueue.addLast("Mathew")
    inputQueue.addLast("0400123456")
    val readln = { inputQueue.pop() }

    val contacts = Contacts(readln)
    contacts.addContact()

    inputQueue.addLast("Mathew")
    inputQueue.addLast("0400456789")
    contacts.updateContactPhone()

    val expected = setOf("Mathew: 0400456789")
    val result = contacts.displayContacts()

    assertEquals(expected, result)

  }
}