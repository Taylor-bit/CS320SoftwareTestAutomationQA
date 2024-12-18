import org.junit.jupiter.api.*;

public class ContactTest {
	protected String contactId;
	protected String firstName;
	protected String lastName;
	protected String phone;
	protected String address;
	protected Contact contact;
	
	@BeforeEach
	protected void setUp() {
		contactId = "1";
		firstName = "Samwise";
		lastName = "Gamgee";
		phone = "1234567890";
		address = "The Shire";
		
		contact = new Contact(contactId, firstName, lastName, phone, address);
	}
	
	// ContactId and Constructor
	@Test
	public void ContactConstructorReturnsContact() {
		Assertions.assertTrue(new Contact(contactId, firstName, lastName, phone, address) instanceof Contact);
	}
	
	@Test
	public void ContactIdCannotBeNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact(null, "Jon", "Jones", "2555555555", "21 main street");
    		}
    	);
	}
	
	@Test
	public void ContactIdCannotBeMoreThanTenCharacters() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("12345678910", "Jon", "Jones", "2555555555", "21 main street");
    		}
    	);
	}
	
	@Test
	public void GetContactIdReturnsId() {
		Assertions.assertEquals("1", contact.getContactId());
	}
	
	// FirstName	
	@Test
	public void FirstNameCannotBeNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		contact.setFirstName(null);
    		}
    	);
	}
	
	@Test
	public void FirstNameCannotBeMoreThanTenCharacters() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		contact.setFirstName("12345678910");
    		}
    	);
	}

	@Test
	public void FirstNameCanBeChanged() {
		contact.setFirstName("Frodo");
		
		Assertions.assertEquals("Frodo", contact.getFirstName());
	}
    
	@Test
	public void GetFirstNameReturnsFirstName() {
		Assertions.assertEquals("Samwise", contact.getFirstName());
	}
    
	// LastName
    @Test
    public void LastNameCannotBeNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		contact.setLastName(null);
    		}
    	);
    }
    
    @Test
    public void LastNameCannotBeMoreThanTenCharacters() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		contact.setLastName("1234567910");
    	});
    }
    
    @Test
    public void LastNameCanBeChanged() {
    	contact.setLastName("Baggins");
    	
    	Assertions.assertEquals("Baggins", contact.getLastName());
    }
    
	@Test
	public void GetLastNameReturnsLastName() {
		Assertions.assertEquals("Gamgee", contact.getLastName());
	}
	
	// Phone
    @Test
    public void PhoneCannotBeNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		contact.setPhone(null);
    		}
    	);
    }
    
    @Test
    public void PhoneCannotBeMoreThanTenCharacters() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		contact.setPhone("12345678910");
    	});
    }
    
    @Test
    public void PhoneCannotBeLessThanTenCharacters() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		contact.setPhone("123");
    	});
    }
    
    @Test
    public void PhoneCanBeChanged() {
    	contact.setPhone("7894561230");
    	
    	Assertions.assertEquals("7894561230", contact.getPhone());
    }
    
	@Test
	public void GetPhoneReturnsLastPhone() {
		Assertions.assertEquals("1234567890", contact.getPhone());
	}
    
	// Address
    @Test
    public void AddressCannotBeNull() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		contact.setAddress(null);
    		}
    	);
    }
    
    @Test
    public void AddressCannotBeMoreThanThirtyCharacters() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		contact.setAddress("123456789101234567891012345678910");
    	});
    }
    
    @Test
    public void AddressCanBeChanged() {
    	contact.setAddress("Mount Doom");
    	
    	Assertions.assertEquals("Mount Doom", contact.getAddress());
    }
    
	@Test
	public void GetAddressReturnsAddress() {
		Assertions.assertEquals("The Shire", contact.getAddress());
	}
 }
