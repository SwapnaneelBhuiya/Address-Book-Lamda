package AddressBook;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.junit.Test;

public class Dictionary extends AddressBookMain
{
      public static HashMap<String, ArrayList<Contact>> dict=new HashMap<String, ArrayList<Contact>>();
      public AddressBookMain ob=new AddressBookMain();
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
//	  	@Test
//        public void search_by_city(String city)
//        {
//            int con=0;
//            System.out.println("People living in the city "+city+" are");
//  		    for(Entry<String, ArrayList<Contact>> ee:dict.entrySet())
//            {
//                for(Contact i:ee.getValue())
//                {
//                	if(i.getCity().equals(city))
//                {con++;System.out.println(i.getFirst_name()+" "+i.getLast_name());}
//                }
//            }
//            System.out.println("Number of contact person by city= "+con);
//        }
//	  	@Test
//        public void search_by_state(String state)
//        {
//
//            int con=0;
//            System.out.println("People living in the state "+state+" are");
//            for(Entry<String, ArrayList<Contact>> ee:dict.entrySet())
//            {
//                for(Contact i:ee.getValue())
//                {
//                	if(i.getState().equals(state))
//                {con++;System.out.println(i.getFirst_name()+" "+i.getLast_name());}}
//                }
//            System.out.println("Number of contact person by state= "+con);
//        }
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
	                }
	            }
        }
        public void add_dict(ArrayList<Contact> ar) throws IOException
        {
	  		Scanner sc=new Scanner(System.in);
            System.out.println("Enter the name of the Address book");
            Collections.sort(ar,new Comparator<Contact>() {
            	public int compare(Contact ob1, Contact ob2) {
            		return ob1.getFirst_name().compareTo(ob2.getFirst_name());
            	}
            });
            ob.writeInFile(ar);
            //ArrayList<Contact> sorted_Ar=(ArrayList<Contact>) ar.stream().sorted(Comparator.comparing(Contact::getFirst_name)).collect(Collectors.toList());
            dict.put(sc.nextLine(),ar);
        }
//	  	public void writeIntoFile() throws IOException
//	  	{
//	  		for(Entry<String, ArrayList<Contact>> ee:dict.entrySet())
//            {
//                ArrayList<Contact> ar=ee.getValue();
//                ob.writeInFile(ar);
//            }
//	  	}
//	  	public void readFromFile() throws IOException
//	  	{
//	  		ob.readFromFile();
//	  	}
}