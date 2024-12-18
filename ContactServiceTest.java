import org.junit.jupiter.api.*;

public class ContactServiceTest {
	protected String contactId;
	protected String contactFirstName;
	protected String contactLastName;
	protected String contactNumber;
	protected String contactAddress;
	protected Contact contact;
	protected ContactService contactService;

	@BeforeEach
	protected void setUp() {
		contactId = "1";
		contactFirstName = "Samwise";
		contactLastName = "Gamgee";
		contactNumber = "1234567890";
		contactAddress = "The Shire";
		contact = new Contact(contactId, contactFirstName, 
				contactLastName, contactNumber, contactAddress);
		contactService = new ContactService();
	}
	
	// Test methods
	// AddContact
	@Test
	public void testAddContact() {
		contactService.addContact(contact);
		Assertions.assertTrue(contactService.getContact(contactId) == contact);
	}
	
	@Test
	public void testAddContactWithNullContact() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(null);			
		});
	}
	
	@Test
	public void testAddContactWithExistingContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Add contact with same ID twice
			contactService.addContact(contact);
			contactService.addContact(contact);
		});
	}
	
	// UpdateContactFirstName
	@Test
	public void testUpdateFirstName() {
		contactService.addContact(contact);
		contactService.updateContactFirstName(contactId, "Frodo");
		Assertions.assertTrue("Frodo".equals(
				contactService.getContact(contactId).getFirstName()));
	}
	
	@Test
	public void testUpdateFirstNameWithNullContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName(
					null, 
					contactFirstName
					);
		});
	}

	@Test
	public void testUpdateFirstNameWithInvalidContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName(
					contactId, 
					contactFirstName
					);
		});
	}
	
	// UpdateContactLastName
	@Test
	public void testUpdateLastName() {
		contactService.addContact(contact);
		contactService.updateContactLastName(contactId, "Baggins");
		Assertions.assertTrue("Baggins".equals(
				contactService.getContact(contactId).getLastName()));
	}
	
	@Test
	public void testUpdateLastNameWithNullContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactLastName(
					null, 
					contactLastName
					);
		});
	}

	@Test
	public void testUpdateLastNameWithInvalidContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactLastName(
					contactId, 
					contactLastName
					);
		});
	}
	
	// UpdateContactNumber
	@Test
	public void testUpdateContactNumber() {
		contactService.addContact(contact);
		contactService.updateContactNumber(contactId, "1234567890");
		Assertions.assertTrue("1234567890".equals(contactService.getContact(contactId).getPhone()));
	}
	
	@Test
	public void testUpdateNumberWithNullContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactNumber(
					null, 
					contactNumber
					);
		});
	}

	@Test
	public void testUpdateNumberWithInvalidContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactNumber(
					contactId, 
					contactNumber
					);
		});
	}
	
	// UpdateContactAddress
	@Test
	public void testUpdateAddress() {
		contactService.addContact(contact);
		contactService.updateContactAddress(contactId, "Middle Earth");
		Assertions.assertTrue("Middle Earth".equals(contactService.getContact(contactId).getAddress()));
	}
	
	@Test
	public void testUpdateAddressWithNullContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactAddress(
					null, 
					contactAddress
					);
		});
	}

	@Test
	public void testUpdateAddressWithInvalidContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactAddress(
					contactId, 
					contactAddress
					);
		});
	}

	// DeleteContact
	@Test
	public void testDeleteContact() {
		contactService.addContact(contact);
		contactService.deleteContact(contactId);
		Assertions.assertTrue(contactService.getContact(contactId) == null);
	}
	
	@Test
	public void testDeleteContactWithNullContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact(null);
		});
	}
	
	@Test
	public void testDeleteContactWithWithInvalidContactId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact(contactId);
		});
	}
}
