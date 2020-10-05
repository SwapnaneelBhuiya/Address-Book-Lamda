package AddressBookLamda;

public class Contact {
    public static String first_name;
    public static String last_name;
    public static String address;
    public static String city;
    public static String state;
    public static String zip;
    public static String phone_number;
    public static String email;

    public  String getFirst_name() {
        return first_name;
    }

    public  String getLast_name() {
        return last_name;
    }

    public  String getAddress() {
        return address;
    }

    public  String getCity() {
        return city;
    }

    public  String getState() {
        return state;
    }

    public  String getZip() {
        return zip;
    }

    public  String getPhone_number() {
        return phone_number;
    }

    public  String getEmail() {
        return email;
    }

    public  void setFirst_name(String a) {
        first_name = a;
    }

    public  void setLast_name(String a) {
        last_name = a;
    }

    public  void setAddress(String a) {
        address = a;
    }

    public  void setCity(String a) {
        city = a;
    }

    public  void setState(String a) {
        state = a;
    }

    public  void setZip(String a) {
        zip = a;
    }

    public  void setPhone_number(String a) {
        phone_number = a;
    }

    public  void setEmail(String a) {
        email = a;
    }
    @Override
    public String toString()
    {
    	return first_name+" "+last_name+" address: "+address+" city "+city+" state "+state+"zip"+zip+"phone number"+phone_number+"email"+email;
    }
    public Contact(String a, String b, String c, String d, String e, String f, String g, String h) {
        first_name = a;
        last_name = b;
        address = c;
        city = d;
        state = e;
        zip = f;
        phone_number = g;
        email = h;
    }
}
