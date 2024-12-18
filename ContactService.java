import java.util.HashMap;
import java.util.Map;

public class ContactService {
	// Contacts stored in a HashMap
	private Map<String, Contact> contacts;
	
	// Service constructor
	public ContactService() {
		contacts = new HashMap<>();
	}
	
	// Required service methods
	public void addContact(Contact contact) {
		if (contact == null || contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Invalid input for contact");
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	public void deleteContact(String contactId) {
		if (contactId == null || !contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Invalid input for contactId");
		}
		contacts.remove(contactId);
	}
	
	public void updateContactFirstName(String contactId, String firstName) {
		if (contactId == null || !contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Invalid input for contactId");
		}

		Contact contact = contacts.get(contactId);
		contact.setFirstName(firstName);
	}
	
	public void updateContactLastName(String contactId, String lastName) {
		if (contactId == null || !contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Invalid input for contactId");
		}

		Contact contact = contacts.get(contactId);
		contact.setLastName(lastName);
	}
	
	public void updateContactNumber(String contactId, String number) {		
		if (contactId == null || !contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Invalid input for contactId");
		}

		Contact contact = contacts.get(contactId);
		contact.setPhone(number);
	}
	
	public void updateContactAddress(String contactId, String address) {
		if (contactId == null || !contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Invalid input for contactId");
		}

		Contact contact = contacts.get(contactId);		
		contact.setAddress(address);
	}
	
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
	
}
