package com.hashtables;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnagramFun {

    private final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private final static ThreadLocalRandom random = ThreadLocalRandom.current();

    public List<List<String>> Anagram(List<String> words){
        final long startTime = System.currentTimeMillis();

        // Initialize  map
        Map<String,List<String>> anagramMap = new HashMap<>();

        // Loop through each and create key
        for(String word : words){
            int[] keyMaker = new int[alphabet.length()];
            for(Character letter : word.toCharArray()){
                keyMaker[alphabet.indexOf(letter)]+=1;
            }
            StringBuilder base = new StringBuilder();
            for(int i : keyMaker){
                base.append(i).append("#");
            }
            final String key = base.toString();
            if(!anagramMap.containsKey(key)){
                anagramMap.put(key,new ArrayList<>());
            }
            anagramMap.get(key).add(word);
        }

        // return list
        final long endTime = System.currentTimeMillis();
        System.out.println("Finished in " + (endTime - startTime) + ((endTime - startTime) == 1 ? " millisecond" : " milliseconds"));
        return new ArrayList<>(anagramMap.values());
    }

    public List<List<String>> Anagram2(List<String> words){
        final long startTime = System.currentTimeMillis();

        // Initialize  map
        Map<String,List<String>> anagramMap = new HashMap<>();

        // Loop through each and create key
        words.forEach(word -> {
            int[] keyMaker = new int[alphabet.length()];
            Arrays.asList(word)
                    .forEach(letter -> {
                        keyMaker[alphabet.indexOf(letter)]+=1;
                    });

            final String key = Arrays.stream(keyMaker)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("#"));
            if(!anagramMap.containsKey(key)){
                anagramMap.put(key,new ArrayList<>());
            }
            anagramMap.get(key).add(word);
        });


        // return list
        final long endTime = System.currentTimeMillis();
        System.out.println("Finished in " + (endTime - startTime) + ((endTime - startTime) == 1 ? " millisecond" : " milliseconds"));
        return new ArrayList<>(anagramMap.values());
    }

    private List<String> GenerateSample(final int sampleSize){
        return IntStream
                .range(0, sampleSize)
                .mapToObj(s -> IntStream
                        .range(0, random.nextInt(3, 4))
                        .mapToObj(i -> String.valueOf(alphabet.toCharArray()[(random.nextInt(0, alphabet.length() - 1))]))
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
    }

    public static void main(String...args){
        // case 1
        AnagramFun anagramFun = new AnagramFun();
        // ["eat", "bat", "tea", "ant"]
        List<String> givenInput = Arrays.asList("eat","bat","tea","ant");
        final List<String> sample = anagramFun.GenerateSample(10000);//.forEach(System.out::println);
        System.out.println("------------------------------------------------");
        anagramFun.Anagram(givenInput)
                .forEach(System.out::println);
        System.out.println("------------------------------------------------");

        anagramFun.Anagram(sample)
                .stream()
                .filter(s -> s.size() > 8)
                .sorted(Comparator.comparingInt((ToIntFunction<List<String>>) List::size).reversed())
                //.flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println("------------------------------------------------");

    }
}
