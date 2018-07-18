package com.legendary.servlet;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class BaseServletTest {

	@Test
	public void testGetSpec() {
		String[] strings = {"b","c","a","t","d"};
		Arrays.sort(strings);
		for (String string : strings) {
			System.out.println(string);
		}
	}

}
