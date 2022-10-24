package section14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> name=new ArrayList<String>();
		name.add("Tarun");
		name.add("Mohit");
		name.add("Vinay");
		name.add("Ashok");
		name.add("Ankit");
		
		//pull out the name starts with a
		int count=0;
		for(int i=0;i<name.size();i++)
		{
			if(name.get(i).startsWith("A"))
			{
				count++;
			}
		}
		System.out.println("Count of names start with A: "+count);
		StreamProgram.streamFilter();
	}
	
	public static void streamFilter()
	{
		ArrayList<String> name=new ArrayList<String>();
		name.add("Tarun");
		name.add("Mohit");
		name.add("Vinay");
		name.add("Ashok");
		name.add("Ankit");
		name.add("Anu");
		
		//Getting count of names start with A
		System.out.println("Stram Result is: "+name.stream().filter(s->s.startsWith("A")).count());
		
		//Getting count of names start with A
		System.out.println("Getting count of names start with A: ");
		long d=Stream.of("Tarun","Mohit","Vinay","Ashok","Ankit").filter(sm->sm.startsWith("A")).count();
		
		//Getting names whose length is greater than 4
		System.out.println("Getting names whose length is greater than 4: ");
		name.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//Limiting result in output
		System.out.println("Limiting result in output: ");
		name.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		//Name ends with t and converting them into upper case
		System.out.println("Name ends with t and converting them into upper case: ");
		name.stream().filter(s->s.endsWith("t")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print name which have first letter as A with uppercase and Sorted
		System.out.println("print name which have first letter as A with uppercase and Sorted: ");
		List<String> al=Arrays.asList("Tarun","Mohit","Vinay","Ashok","Ankit");
		al.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//Concatenated String is
		System.out.println("Concatenated String is: ");
		Stream<String> newStream=Stream.concat(name.stream(), al.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		Stream<String> newStream1=Stream.concat(name.stream(), al.stream());
		boolean flag=newStream1.anyMatch(s->s.contains("ar"));
		Assert.assertTrue(flag);
		System.out.println(flag);
		
		System.out.println("Validation using collect method: ");
		//collect method: Take a list, convert it to stream, collect your result and convert it back to list
		System.out.println("collect method: Take a list, convert it to stream, collect your result and convert it back to list: ");
		List<String> ls=Stream.of("Tarun","Mohit","Vinay","Ashok","Ankit").filter(s->s.startsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> number=Arrays.asList(3,2,2,7,5,1,9,7);
		List<Integer> newList=number.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(newList.get(2));
		
	}

}
