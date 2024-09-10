package oy.interact.tira.grade_1.task_8;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import oy.interact.tira.model.Coder;
import oy.interact.tira.util.JSONConverter;

class CoderHashTests {

	private static int currentIndex = 0;
	private static final String[] testFiles = {
			"100-city-coders.json",
			"1000-area-coders.json",
			"5000-town-coders.json",
			"10000-large-city-coders.json",
			"50000-country-coders.json",
			"100000-europe-coders.json",
			"1000000-global-coders.json",
			"2000000-milky-way-orion-spur-coders.json"
	};

	@Test
	void testHashUniqueness() {
		try {
			currentIndex = 0;
			while (currentIndex < testFiles.length) {
				System.out.format(
						"%d/%d ==> Starting to analyse Coder.hashCode with %s %s%n",
						currentIndex + 1,
						testFiles.length,
						testFiles[currentIndex],
						new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
				Coder[] coders = readCodersFromFile(testFiles[currentIndex]);
				// For the first dataset only, check that id hash is not the same has coder.hash
				if (currentIndex == 0) {
					Integer [] stringHashes = new Integer[coders.length];
					Integer [] coderHashes = new Integer[coders.length];
					// get hash both from coder.hashCode() and coder.getId().hashCode()
					int index = 0;
					for (Coder coder : coders) {
						stringHashes[index] = coder.getId().hashCode();
						coderHashes[index] = coder.hashCode();
						index++;
					}
					// Count how many times the coder.hashCode is identical to coder.getId().hashCode()
					int sameHashCount = 0;
					for (index = 0; index < stringHashes.length; index++) {
						if (stringHashes[index].equals(coderHashes[index])) {
							sameHashCount++;
						}
					}
					if (sameHashCount == stringHashes.length) {
						fail("You have not implemented Coder.hashCode() correctly, but just call id.hashCode(). READ THE INSTRUCTIONS!");
					}
					// Also, count how many times the coder.hashCode() returns the same value
					Set<Integer> coderHashesInSet = new HashSet<>();
					coderHashesInSet.addAll(Arrays.asList(coderHashes));
					if (coderHashesInSet.size() == 1) {
						fail("Your Coder.hashCode() returns the same value always. Implement a proper hash function!");
					}
				}
				long start = System.currentTimeMillis();
				Set<Integer> hashes = new HashSet<>();
				for (Coder coder : coders) {
					hashes.add(coder.hashCode());
				}
				long end = System.currentTimeMillis();
				long duration = end - start;
				System.out.format("  Testing Coder.hashCode took %d ms%n", duration);
				System.out.format("  For %d coders, there were %d duplicate hashes%n%n", coders.length, coders.length - hashes.size());
				currentIndex++;
			}
		} catch (OutOfMemoryError oom) {
			System.out.println("\n*** ERROR: Run out of memory while handling test json files\n");
		} catch (Exception e) {
			e.printStackTrace();
			fail("*** Could not execute tests: " + e.getMessage());
		}
	}

	private Coder[] readCodersFromFile(String fileName)
			throws IOException {
		long start = System.currentTimeMillis();
		JSONTokener tokener = new JSONTokener(
				new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8)));
		JSONArray array = new JSONArray(tokener);
		System.out.format("  JSON Parsing - from file %s to JSONArray it took %d ms%n", fileName,
				System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		Coder[] coders = JSONConverter.codersFromJSONArray(array);
		System.out.format("  From JSONArray to Coders array it took %d ms%n",
				System.currentTimeMillis() - start);
		return coders;
	}
}
