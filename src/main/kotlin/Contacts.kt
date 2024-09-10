import kotlin.system.exitProcess

fun main(args: Array<String>) {
  val contacts = Contacts(::readln)
  contacts.run()
}

class Contacts (
  private val readln: () -> String
) {
  private val contactNames = mutableSetOf<String>()
  private val contactPhoneNumbers = mutableMapOf<String, String>()

  fun run() {
    while (true) {
      println("Welcome to the Contact List Manager!")
      println("1. Add Contact")
      println("2. Remove Contact")
      println("3. Update Contact")
      println("4. Display All Contacts")
      println("5. Exit")
      print("Enter your choice: ")

      val input = readln()
      val option = input.toIntOrNull()

      when (option) {
        1 -> addContact()
        2 -> removeContact()
        3 -> updateContactPhone()
        4 -> displayContacts()
        5 -> exit()
        else -> println("Invalid option, please select between 1-5")
      }

    }
  }

  fun addContact(): String {
    print("Enter name: ")
    val name = readln()
    print("Enter phone number: ")
    val phone = readln()
    contactNames.add(name)
    contactPhoneNumbers[name] = phone
    return "$name: $phone"
  }

  fun removeContact() {
    print("Enter the name of the contact to remove: ")
    val name = readln()

    if (contactNames.contains(name)) {
      contactNames.remove(name)
      contactPhoneNumbers.remove(name)
      println("Contact '$name' has been removed.")
    } else {
      println("Contact '$name' not found.")
    }
  }

  fun updateContactPhone() {
    print("Enter the name of the contact to update: ")
    val name = readln()
    if (contactNames.contains(name)) {
      print("Enter new phone number: ")
      val newPhone = readln()
      contactPhoneNumbers[name] = newPhone
      println("Contact '$name' has been updated with new phone number: $newPhone")
    } else {
      println("Contact '$name' not found.")
    }
  }

  fun displayContacts(): Set<String> {
    val contacts = mutableSetOf<String>()
    for (contactName in contactNames) {
      val phoneNumber = contactPhoneNumbers[contactName]
      println("Name: $contactName, Phone: $phoneNumber")
      contacts.add("$contactName: $phoneNumber")
    }
    return contacts
  }

  fun exit() {
    exitProcess(0)
  }
}