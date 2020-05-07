package lab17;

import java.util.List;

/**
 * An implementation of LineConverter that converts Player objects
 */
public class CountryLineConverter implements LineConverter<Country> {

	@Override
	public String toLine(Country country) {

		//TODO convert object to String
		return country.getName() + "\t" + country.getPopulation();
		
	}

	@Override
	public Country fromLine(String line) {
		String[] list = line.split("\t");
		String name = list[0];
		int number = Integer.parseInt(list[1]);
		
		return new Country(name, number);
	}
	
}

