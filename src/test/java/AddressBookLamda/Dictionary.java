package AddressBookLamda;

import java.util.*;
import java.util.Map.Entry;
public class Dictionary extends AddressBookMain
{
      public static HashMap<String, ArrayList<Contact>> dict=new HashMap<String, ArrayList<Contact>>();
	  
        public void search_by_city(String city)
        {
            int con=0;
            System.out.println("People living in the city "+city+" are");
  		    for(Entry<String, ArrayList<Contact>> ee:dict.entrySet())
            {
                for(Contact i:ee.getValue())
                {
                	if(i.getCity().equals(city))
                {con++;System.out.println(i.getFirst_name()+" "+i.getLast_name());}
                }
            }
            System.out.println("Number of contact person by city= "+con);
        }
        public void search_by_state(String state)
        {

            int con=0;
            System.out.println("People living in the state "+state+" are");
            for(Entry<String, ArrayList<Contact>> ee:dict.entrySet())
            {
                for(Contact i:ee.getValue())
                {
                	if(i.getState().equals(state))
                {con++;System.out.println(i.getFirst_name()+" "+i.getLast_name());}}
                }
            System.out.println("Number of contact person by state= "+con);
        }
        public void contact_details()
        {
            System.out.println("Contact Namewise Details");
  		  for(Entry<String, ArrayList<Contact>> ee:dict.entrySet())
            {
                String names=ee.getKey();
                ArrayList<Contact> ar=ee.getValue();
                System.out.println("The name is: "+names);
                for(Contact i:ar)
                {
                    System.out.println(i.getFirst_name());
                    System.out.println(i.getLast_name());
                    System.out.println(i.getAddress());
                    System.out.println(i.getCity());
                    System.out.println(i.getState());
                    System.out.println(i.getZip());
                    System.out.println(i.getPhone_number());
                    System.out.println(i.getEmail());
                }
            }
        }
        public void add_dict(ArrayList<Contact> ar)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the name of the Address book");
            dict.put(sc.nextLine(),ar);
        }
}