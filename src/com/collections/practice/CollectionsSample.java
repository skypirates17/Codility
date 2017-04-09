package com.collections.practice;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;


public class CollectionsSample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// List
		List<?> list1 = new ArrayList<>();
		List<?> list2 = new LinkedList<>();
		List<?> list3 = new Vector<>();
		List<?> list4 = new Stack<>();
		
		Vector<?> vec1 = new Stack<>();
		
		// Set
		Set<?> set1 = new HashSet<>();
		Set<?> set2 = new LinkedHashSet<>();
		Set<?> set3 = new TreeSet<>();
		
		SortedSet<?> sset1 = new TreeSet<>();
		
		NavigableSet<?> navSet = new TreeSet<>().descendingSet();
		Iterator<?> iteSet = new TreeSet<>().descendingIterator();
		
		// Queue
		Queue<?> qu1 = new PriorityQueue<>();
		Queue<?> qu2 = new ArrayDeque<>();
		Queue<?> qu3 = new LinkedList<>();
		
		Deque<?> dqu1 = new ArrayDeque<>();
		Deque<?> dqu2 = new LinkedList<>();
		
		// Map
		Map<?, ?> map1 = new Hashtable<>();
		Map<?, ?> map2 = new LinkedHashMap<>();
		Map<?, ?> map3 = new HashMap<>();
		Map<?, ?> map4 = new TreeMap<>();
	
		SortedMap<?, ?> smap1 = new TreeMap<>();
		
		NavigableMap<?, ?> navMap1 = new TreeMap<>().descendingMap();
		NavigableSet<?> navMap2 = new TreeMap<>().descendingKeySet();
		
		
		
	}
}

/**
 * @url : http://www.javatpoint.com/collections-in-java
 * @url : http://beginnersbook.com/java-collections-tutorials/
 * 
 */