package com.hackerrank.strings;

public class RegexSplit {

    public static void main(String... args){

        String regex = "^[\\s!,?._'@]+";
        String s = "He is a very very good boy, isn't he?";
        String[] result = s.split(regex);
        // Write your code here.
        System.out.println(result.length);
        for(String e : result){
            System.out.println(e);
        }

        String s2 = "                a ";
        String[] result2 = s2.split(regex);
        // Write your code here.
        System.out.println(result2.length);
        for(String e : result2){
            System.out.println(e);
        }

        String s3 = "   nbibqfgtpqabtvcprapnhvwmummqxpteitvabduimmjhblokdgxcdvopbsibbdvkwtkpowxccabedqogwgbrthavcioddlncwqjnobpjbjnfbtdpreanmakgbabedhwcxipfjwochthahlhqhhflahjbxlfdsefjemgncnpcapchscarjvfbfoceraxluumaitflimfithinjahlneeskhpexohtlullhiopmtpitpnepmhfqmptlgxknwvakadrisamniuixkfhwemhqtctsrvhpkxckclkmmxsulctvxsmeglmsnimwvtfisxsmlvbpmtlxnwnfrbbpmnjrnnhlimlsmfxpsqggljwqxlnieoaiebbjpimpuxcavbpprvouwmewpsgtiwdeaeohesoqsqjhrawkoewmidkxvjsfhvkxrqgnkngufhdxhsbnwashdegqfbvnoxmiplnsqtovcsucmohcgbbjwirdboqhovhvavpqigfdqsfuimwooqpeaihroqaefasvvjnfhkixeflmkcsqsjukjddaltuqtoniqsopfohbmsowuaooccalvtdjharsgxdojjggpnidhobuohkqbduxwxavprqoqtecukilxipxwitnivvjqripjieacuokhledvnpnvwemgxbomoqfaamjbqbdnifmtkqipxvevbqtqjcfascasobtwcodkmqvwigfxtjuvshfdjcdtetgkurjpimrmepcenhdiqpvkxdgavbusvcertfatssxojblwiowrwudvpbnmdbgatdjhikcsecbfdmtecrvanqnustbvuxnqcoxdarnulobhcmlvgivlqdikwbxkaecttrotddiosbnuoaruahxjcxtaalcbpvmkocwrvwapxnengnbwmrhoqtgrgjkngwamqownmwvddbjbgkatdxjmsqfqrpgxfwdnmbsqpptliemphmccmlowtlpmsvdplhexaphqwsdhphowmqqqtxopcftvsxmfwjuoatg";
        String[] result3 = s3.split(regex);
        System.out.println(result3.length);
        for(String e : result3){
            System.out.println(e);
        }


        String s4 ="                        ";

        String[] result4 = s4.split(regex);
        System.out.println(result4.length);
        for(String e : result4){
            System.out.println(e);
        }


    }
}
