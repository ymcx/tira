package oy.interact.tira.tools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import oy.interact.tira.model.Coder;
import oy.interact.tira.util.JSONConverter;

class TestPhoneBookGenerator {
	public static void main(String[] args) {
		TestPhoneBookGenerator generator = new TestPhoneBookGenerator();
		try {
			generator.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void run() throws IOException {
		final int MAX_KNOWN_LANGUAGES = 10;
		final int MAX_FRIENDS = 11;
		ThreadLocalRandom random = ThreadLocalRandom.current();
		List<String> countries = Arrays.asList("1", "20", "212", "358", "33", "372", "380", "39");
		List<String> operators = Arrays.asList("040", "050", "042", "045", "030", "020");
		List<String> firstNames = new ArrayList<>();
		List<String> lastNames = new ArrayList<>();
		List<Coder> generatedCoders = new ArrayList<>();

		loadNames(firstNames, lastNames);

		Integer[] population = { 10,
										 100, 
										 1000, 
										 5000, 
										 10000, 
										 50000, 
										 100000, 
										 1000000,
										 2000000};
		final String[] name = { "10-village-coders.json",
										"100-city-coders.json",
										"1000-area-coders.json", 
										"5000-town-coders.json", 
										"10000-large-city-coders.json", 
										"50000-country-coders.json", 
										"100000-europe-coders.json", 
										"1000000-global-coders.json",
										"2000000-milky-way-orion-spur-coders.json"};
		for (int locality = 0; locality < population.length; locality++) {
			List<Integer> randomNumbers = new ArrayList<>();
			for (int counter = 0; counter < population[locality]; counter++) {
				randomNumbers.add(counter + 5020304);
			}
			Collections.shuffle(randomNumbers);
			System.out.println("Creating phonebook for " + name[locality]);

			generatedCoders.clear();

			for (int counter = 0; counter < population[locality]; counter++) {
				StringBuilder builder = new StringBuilder();
				builder.append(countries.get(random.nextInt(countries.size())));
				builder.append("-");
				builder.append(operators.get(random.nextInt(operators.size())));
				builder.append("-");
				builder.append(randomNumbers.remove(0));
				StringBuilder firstNameBuilder = new StringBuilder();
				firstNameBuilder.append(firstNames.get(random.nextInt(firstNames.size())));
				firstNameBuilder.append(" ");
				firstNameBuilder.append(firstNames.get(random.nextInt(firstNames.size())));
				Coder newCoder = new Coder(
					firstNameBuilder.toString(), 
					lastNames.get(random.nextInt(lastNames.size())),
					builder.toString()
				);
				newCoder.setCoderName(WuTangNameGenerator.generateRandomProgrammerName());
				int languageCount = Math.max(2, random.nextInt(MAX_KNOWN_LANGUAGES + 1));
				do {
					newCoder.addLanguage(ProgrammingLanguages.languages[random.nextInt(ProgrammingLanguages.languages.length)]);
					languageCount--;
				} while (languageCount > 0);
				generatedCoders.add(newCoder);
			}
			for (Coder coder : generatedCoders) {
				int friendCount = Math.max(1, random.nextInt(MAX_FRIENDS + 1));
				do {
					final String friendID = generatedCoders.get(random.nextInt(generatedCoders.size())).getId();
					if (!friendID.equals(coder.getId())) {
						coder.addFriend(friendID);
						friendCount--;
					}
				} while (friendCount > 0);
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(name[locality], StandardCharsets.UTF_8))) {
				writer.write("[");
				writer.newLine();
				int counter = 0;
				for (Coder coder : generatedCoders) {
					writer.write(JSONConverter.coderToJSON(coder));
					if (counter < generatedCoders.size() - 1) {
						writer.write(",");
					}
					writer.newLine();
					counter++;
				}
				writer.write("]");
			} catch (IOException e) {
				System.out.println("Something went wrong: " + e.getMessage());
			}
		}
	}

	private void loadNames(List<String> firstNames, List<String> lastNames) throws IOException {
		String allFirstNames = new String(getClass().getClassLoader().getResourceAsStream("tools/random-firstnames.txt").readAllBytes());
		String [] names = allFirstNames.split("\\s*,\\s*");
		firstNames.addAll(Arrays.asList(names));

		String allLastNames = new String(getClass().getClassLoader().getResourceAsStream("tools/finnish-surnames.txt").readAllBytes());
		String [] names2 = allLastNames.split("\\s*,\\s*");
		lastNames.addAll(Arrays.asList(names2));
	}
}
