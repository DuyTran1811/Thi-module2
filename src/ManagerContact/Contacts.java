package ManagerContact;

import ManagerContact.Exception.InvalidEmailException;
import ManagerContact.Exception.InvalidPhoneNumberException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacts {
    private String phoneNumber;
    private String groupContact;
    private String fullName;
    private String gender;
    private String address;
    private String dateOfBirth;
    private String email;

    public Contacts() {
    }

    public Contacts(String phoneNumber, String groupContact,
                    String fullName, String gender, String address,
                    String dateOfBirth, String email) {
        try {
            this.setPhoneNumber(phoneNumber);
        } catch (InvalidPhoneNumberException e) {
            System.err.println(e.getInvalidPhoneNumberException());
        }
        this.groupContact = groupContact;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        try {
            this.setEmail(email);
        } catch (InvalidEmailException e) {
            System.err.println(e.getInvalidEmailException());
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        String regex = "^(03|05|07|08|09)+([0-9]{8})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new InvalidPhoneNumberException("Số Điện Thoại Không Hợp Lệ");
        }
    }

    public String getGroupContact() {
        return groupContact;
    }

    public void setGroupContact(String groupContact) {
        this.groupContact = groupContact;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        String regex = "[a-z]+[a-z0-9._]*@gmail.com$";
        Pattern part = Pattern.compile(regex);
        Matcher matcher = part.matcher(email);
        if (matcher.matches()){
            this.email = email;
        }else {
            throw new InvalidEmailException("Địa Chỉ Email Không Hợp Lện");
        }
    }
}
