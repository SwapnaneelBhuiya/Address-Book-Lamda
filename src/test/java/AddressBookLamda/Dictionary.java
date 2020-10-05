package AddressBookLamda;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map.Entry;
public class Dictionary extends AddressBookMain
{
      public static HashMap<String, ArrayList<Contact>> dict=new HashMap<String, ArrayList<Contact>>();
	  
        public void search_by_city(String city)
        {

            int con=0;
            System.out.println("People living in the state "+city+" are");
            //Predicate<String> isState= n -> n.equals(Contact.getState());
            for(Entry<String, ArrayList<Contact>> ee:dict.entrySet())
            {
				ArrayList<Contact> ar=ee.getValue();
                Stream<Contact> res=ar.stream().filter(n-> n.getCity().equals(city)).peek(n->System.out.println(n.getFirst_name()+" "+n.getLast_name()));
                con+=(int) ar.stream().filter(n-> n.getState().equals(city)).count();
            }
            System.out.println("Number of contact person by state= "+con);
        }
        public void search_by_state(String state)
        {

            int con=0;
            System.out.println("People living in the state "+state+" are");
            //Predicate<String> isState= n -> n.equals(Contact.getState());
            for(Entry<String, ArrayList<Contact>> ee:dict.entrySet())
            {
				ArrayList<Contact> ar=ee.getValue();
                Stream<Contact> res=ar.stream().filter(n-> n.getState().equals(state)).peek(n->System.out.println(n.getFirst_name()+" "+n.getLast_name()));
                con+=(int) ar.stream().filter(n-> n.getState().equals(state)).count();
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
                	i.toString();
					/*
					 * System.out.println(i.getFirst_name()); System.out.println(i.getLast_name());
					 * System.out.println(i.getAddress()); System.out.println(i.getCity());
					 * System.out.println(i.getState()); System.out.println(i.getZip());
					 * System.out.println(i.getPhone_number()); System.out.println(i.getEmail());
					 */
                }
            }
        }
        public void add_dict(ArrayList<Contact> ar)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the name of the Address book");
            Collections.sort(ar,new Comparator<Contact>() {
            	public int compare(Contact ob1, Contact ob2) {
            		return ob1.getFirst_name().compareTo(ob2.getFirst_name());
            	}
            });
            //ArrayList<Contact> sorted_Ar=(ArrayList<Contact>) ar.stream().sorted(Comparator.comparing(Contact::getFirst_name)).collect(Collectors.toList());
            dict.put(sc.nextLine(),ar);
        }
}