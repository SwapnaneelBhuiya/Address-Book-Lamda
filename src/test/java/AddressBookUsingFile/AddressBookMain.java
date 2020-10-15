package AddressBookUsingFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.Test;
@FunctionalInterface
interface demo
{
	boolean equals(String a, String b);
}
public class AddressBookMain
{
    public static ArrayList<Contact> Address_Book;
    public static Dictionary dict=new Dictionary();
    public static Scanner sc=new Scanner(System.in);
    public AddressBookMain()
    {
        Address_Book=new ArrayList<Contact>();
    }
    demo check_equal=(String a, String b) ->{ 
        if(a.equals(b))
        	return true;
        else
        	return false;
        };
    public static void Contact_delete(Contact i)
    {
        Address_Book.remove(i);
    }
    public void writeInFile(ArrayList<Contact> ar) throws IOException
    {
    	StringBuffer empbuffer=new StringBuffer();
    	ar.forEach(address-> {String adr=address.toString().concat("\n");
    	empbuffer.append(adr);});
    	Files.write(Paths.get("AddressBook.txt"), empbuffer.toString().getBytes());
    }
    public static ArrayList<Contact> getAddress_Book() {
		return Address_Book;
	}
	public static void setAddress_Book(ArrayList<Contact> address_Book) {
		Address_Book = address_Book;
	}
	public void readFromFile() throws IOException
    {
		List<String> fileLines=Files.readAllLines(Paths.get("AddressBook.txt"));
		fileLines.forEach(System.out::println);
    }
    public void Add_Contact() throws IOException
    {
        System.out.println("Enter user info");
        String a = sc.nextLine();
        String b = sc.nextLine();
        String c = sc.nextLine();
        String d = sc.nextLine();
        String e = sc.nextLine();
        String f = sc.nextLine();
        String g = sc.nextLine();
        String h = sc.nextLine();
        if(Equals(a,b))
            System.out.println("Can't add as duplicate exists");
        else
        {Contact obj = new Contact(a, b, c, d, e, f, g, h);
            Address_Book.add(obj);
        }
    }
    public void contact_edit()
    {
        System.out.println("Enter first and last name of person to be edited");
        String temp_fname=sc.nextLine();
        String temp_lname=sc.nextLine();
        int c=0;
        for(Contact i: Address_Book)
        {
            if(i.getFirst_name().equals(temp_fname)&&i.getLast_name().equals(temp_lname))
            {
                System.out.println("Enter new details");
                i.setAddress(sc.nextLine());
                i.setCity(sc.nextLine());
                i.setState(sc.nextLine());
                i.setZip(sc.nextLine());
                i.setPhone_number(sc.nextLine());
                i.setEmail(sc.nextLine());
                c=1;
                break;
            }
        }
        if(c==0)
            System.out.println("Name not found");
    }
    public ArrayList<Contact> get_alist()
    {
        return Address_Book;
    }
    @Test
    public void sort_by_city()
    {
    	Address_Book=(ArrayList<Contact>) Address_Book.stream().sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());
    }
    @Test
    public void sort_by_state()
    {
    	Address_Book=(ArrayList<Contact>) Address_Book.stream().sorted(Comparator.comparing(Contact::getState)).collect(Collectors.toList());
    }
    @Test
    public void sort_by_zip()
    {
    	Address_Book=(ArrayList<Contact>) Address_Book.stream().sorted(Comparator.comparing(Contact::getZip)).collect(Collectors.toList());
    }
    public boolean Equals(String a, String b) {
        for (Contact i : Address_Book)
        {if (i.getFirst_name().equals(a) && i.getLast_name().equals(b))
            return true;
        }
        return false;
    }
    public static void main(String args[]) throws IOException
    {
        System.out.println("Welcome to the Address Book problem in Address Book Main class");
        AddressBookMain obj=new AddressBookMain();
        while(true)
        {
            System.out.println(" Press 1 to Enter Contact");
            System.out.println(" Press 2 to edit existing contact");
            System.out.println(" Press 3 to delete existing contact");
            System.out.println(" Press 4 to add to dictionary");
            System.out.println(" Press 5 to search and display by City");
            System.out.println(" Press 6 to search and display by State");
            System.out.println(" Press 7 to display all contact detail");
            System.out.println(" Press 8 to sort all contact detail by city");
            System.out.println(" Press 9 to sort all contact detail by state");
            System.out.println(" Press 10 to sort all contact detail by zip");
            System.out.println(" Press 11 to exit");
            int n=sc.nextInt();sc.nextLine();
            switch(n) {
                case 1:
                    obj.Add_Contact();
                    break;
                case 2:
                    obj.contact_edit();
                    break;
                case 3:
                    System.out.println("Enter first and last name of person to be deletd");
                    String temp_fname=sc.nextLine();
                    String temp_lname=sc.nextLine();
                    int c=0;
                    for(Contact i:Address_Book)
                        if(i.getFirst_name().equals(temp_fname)&&i.getLast_name().equals(temp_lname))
                        {
                            Contact_delete(i);c=1;
                            break;
                        }
                    if(c==0)
                        System.out.println("Name to be deleted not found");
                    break;
                case 4:
                    dict.add_dict(Address_Book);
                    Address_Book.clear();
                    break;
                case 5:
                    System.out.println("Enter city by which to search for");
                    dict.search_by_city(sc.nextLine());
                    break;
                case 6:
                    System.out.println("Enter state by which to search");
                    dict.search_by_state(sc.nextLine());
                    break;
                case 7:
                	dict.contact_details();
                	break;
                case 8:
                	obj.sort_by_city();
                	break;
                case 9:
                	obj.sort_by_state();
                	break;
                case 10:
                	obj.sort_by_zip();
                	break;
                case 11:
                    System.exit(0);
                default:
                    System.out.println("Enter again!");
            }
        }
    }
}