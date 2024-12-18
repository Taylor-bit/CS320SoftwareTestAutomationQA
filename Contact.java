public class Contact {
	
	// Additional required fields
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Public constructor
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid input for contactId");
		}
		
		this.contactId = contactId;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhone(phone);
		this.setAddress(address);
	}
	
	// Getters and setters
	// ContactId only has a getter as it should be immutable
    public String getContactId() {
        return contactId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
    	if (firstName != null && firstName.length() < 10) {
    		this.firstName = firstName;
    	} else {
    		throw new IllegalArgumentException("Invalid input for firstName");
    	}
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public void setLastName(String lastName) {
    	if (lastName != null && lastName.length() < 10) {
    		this.lastName = lastName;
    	} else {
    		 throw new IllegalArgumentException("Invalid input for lastName");
    	}
    }
    
    public String getPhone() {
    	return phone;
    }
    
    public void setPhone(String phone) {
    	if (phone != null && phone.length() == 10) {
    		this.phone = phone;    		
    	} else {
    		 throw new IllegalArgumentException("Invalid input for phone");
    	}
    }
    
    public String getAddress() {
    	return this.address;
    }
    
    public void setAddress(String address) {
    	if (address != null && address.length() < 30) {
    		this.address = address;    		
    	} else {
    		 throw new IllegalArgumentException("Invalid input for address");
    	}
    }
}
