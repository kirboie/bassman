import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class c2a3q4_2021_LeonKirby {

    public static void main(String[] args) throws Exception {
	String[] keyWords = { "audi", "porsche", "mitsubishi", "bmw", "volvo" };
	Path path = Paths.get(System.getProperty("user.dir")).resolve("src\\carMakes.txt");
	System.out.println(path);
	BufferedReader getFile = new BufferedReader(new FileReader(path.toFile()));

	Map<String, Integer> allowedCarMakes = new HashMap<>();
	for (String str : keyWords) {
	    allowedCarMakes.put(str, 1);
	}
	String cars = getFile.readLine();
	System.out.println("Contents of file: ");
	System.out.println(cars);
	while (cars != null) {

	    if (!cars.trim().equals("")) {
		String[] words = cars.split(" ");

		for (String word : words) {
		    if (word == null) {
			continue;

		    }
		    String processed = word.toLowerCase();


		    if (allowedCarMakes.containsKey(processed)) {
			allowedCarMakes.put(processed, allowedCarMakes.get(processed) + 1);
		    }
		}
	    }
	    cars = getFile.readLine();
	}


	for (String word : allowedCarMakes.keySet()) {
	    System.out.println(word + " " + allowedCarMakes.get(word));
	}

    }
}
