import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapImplementation 
{


	public static void main(String args[]) throws IOException 
	{
		HashMap<String , String> hm=new HashMap<String , String>();
		File file=new File("F://raghu//Fruits_Vitamins.txt");

		try {

			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			List<String> lines=br.lines().collect(Collectors.toList());

			for(int i=0;i<lines.size();i++)
			{

				String line=lines.get(i).toString();
				String[] fruitVitamin=line.split(" ");
				String fruit=fruitVitamin[0];
				String vitamin=fruitVitamin[1];
				hm.put(fruit, vitamin);
			}
			br.close();
			fr.close();
			System.out.println(hm);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("File is not available");
			
			
		}
		
		Set<Map.Entry<String, String>> entries=hm.entrySet();
		for(Map.Entry<String, String> ent: entries)
		{
			ThreadImplementation t=new ThreadImplementation(ent);
			t.run();
			System.out.println(ent);
		}
		Printer.print();
	}


		
	

}
