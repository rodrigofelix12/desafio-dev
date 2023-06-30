package com.example.desafio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DesafioApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testIfTheFileIsNotEmpty(@TempDir Path tempDir) throws IOException {
		Path file1 = tempDir.resolve("myfile.txt");

		List<String> input = Arrays.asList("input1", "input2", "input3");
		Files.write(file1, input);

		assertTrue(Files.exists(file1), "File should exist");
	}

}
