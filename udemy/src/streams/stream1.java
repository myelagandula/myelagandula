package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;


public class stream1 {

	@Test
	public void regular()
	{
		String namesArray[]= {"Mounica","Anoop","Madhuri","Adarsh"};
		List<String> namesList=Arrays.asList(namesArray);
		int count=0;
		for(String name : namesList)
		{
			if(name.startsWith("A"))
			{
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	//same with streams
	@Test
	public void streamFilter()
	{
		ArrayList<String> namesList=new ArrayList<String>();
		namesList.add("Anoop");
		namesList.add("mounica");
		namesList.add("kbhijeet");
		
		Long c=namesList.stream().filter(a->a.startsWith("A")).count();
		System.out.println(c);
		
		//creating stream
		long d=Stream.of("Anoop","mounica","sanaya").filter(s->
		{
			//if actions requires more than one line
			s.startsWith("a");
			return true;        //id return false, d will print 0
		}).count();
		System.out.println(d);
		
		//print all names of stream where name length>4
		System.out.println("name length>4");
		Stream.of("radhika","tillu","prakash").filter(b->b.length()>4).forEach(b->System.out.println(b));
		
		//print all names of namesList where name length<6
		System.out.println("namelength<6");
		namesList.stream().filter(n->n.length()<6).forEach(n->System.out.println(n));
		
		namesList.stream().filter(j->j.length()<6).limit(1).forEach(j->System.out.println(j)); //out of all results, give only 1 result
		
		
		
	}
	
	@Test
	public void streamMap()
	{
		//print names with last letter "a" with uppercase
		Stream.of("radhika","tillu","prakash").filter(n->n.endsWith("a")).map(n->n.toUpperCase()).forEach(n->System.out.println(n));
		
		Stream.of("rama","satya","kishore","ranjith","mounica").filter(r->r.endsWith("a")).forEach(n->System.out.println(n.toUpperCase()));
		
		//print names with first letter "k" with uppercase and sorted
		List<String> perlu=Arrays.asList("rama","satya","kishore","ranjith","mounica","kamal");
		perlu.stream().filter(s->s.startsWith("k")).map(k->k.toUpperCase()).sorted().forEach(s->System.out.println(s));
		
		
		//merge two streams or lists
		List<String> items1=Arrays.asList("pencil","eraser","sharpener");
		List<String> items2=Arrays.asList("pen","eraser","book");
		Stream<String> combinedStream=Stream.concat(items1.stream(),items2.stream());
		combinedStream.forEach(s->System.out.println(s));
		
		//if stream contains pencil, return true
		boolean returnValue=combinedStream.anyMatch(s->s.equalsIgnoreCase("pencil"));
		System.out.println(returnValue);
		Assert.assertTrue(returnValue);
		
		
	}
	
	public void streamCollect() {
	
		//list
		//new list
		//stream
		//again convert to list
		
		List<String> collectorList=Stream.of("sindu","lilly","mounica","maggi").filter(s->s.startsWith("m")).sorted().collect(Collectors.toList());
		collectorList.get(0);
		
		List<Integer> numbers=Arrays.asList(3,4,4,2,2,6,7,8);
		//print unique numbers
		//sort the array
		numbers.stream().distinct().forEach(s->System.out.println(s));
		//sort and give 3rd index
		numbers.stream().distinct().sorted().collect(Collectors.toList()).get(2); //print it -this is using collectors
		
		
	}
	
	
}
