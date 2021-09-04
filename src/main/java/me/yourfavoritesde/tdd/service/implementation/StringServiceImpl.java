package me.yourfavoritesde.tdd.service.implementation;


import me.yourfavoritesde.tdd.service.StringService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StringServiceImpl implements StringService {
    @Override
    public String capitalizeFirstLetter(String text) {
        String[] words = text.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String word : words){
            if(!word.equals(words[0])){
                ans.append(" ");
            }
            ans.append(word.replaceFirst(word.charAt(0) + "", (word.charAt(0) + "").toUpperCase()));

        }

        return ans.toString();
    }

    @Override
    public String capitalizeFirstWord(String text) {
        String[] stops = {".","\\?"};
        StringBuilder ansStringBuilder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(String stop: stops) {
            list.addAll(findIndex(text, stop));
        }
        System.out.println(list);
        List<String> split = splitAtMulti(text,list);
        for(String word : split){
            ansStringBuilder.append(capitalization(word));
        }
        return ansStringBuilder.toString();
    }

    @Override
    public String capitalizeOneLetterWords(String text) {
        return null;
    }

    @Override
    public String yes() {
        return "yes";
    }

    private String capitalization(String text){
        String firstChar = text.trim().charAt(0)+"";
        int i =0;
        while(firstChar.equals(".") || firstChar.equals("?") || firstChar.equals(" ")){
             firstChar = text.trim().charAt(++i)+"";
        }
        return text.replaceFirst(firstChar,firstChar.toUpperCase());
    }

    private String[] splitAt(String text, int indexAt){
        if(indexAt == 0) return new String[]{"", text};
        return new String[]{text.substring(0, indexAt ), text.substring(indexAt)};
    }
    private List<String> splitAtMulti(String text, List<Integer> indexes){
        List<String> ans = new ArrayList<String>();
        List<Integer> inds = new ArrayList<>();
        for(Integer indx : indexes){
            if(inds.size()>0){
                inds.add(indx-inds.get(inds.size()-1));
                continue;
            }
            inds.add(indx);

        }
        Collections.sort(inds);
        for( int indx : inds){
            String [] temp = splitAt(text,indx);
            ans.add(temp[0]);
            text = temp[1];
        }
        ans.add(text);
        return ans;
    }

    private List<Integer> findIndex(String text, String find) {
        int index = -1;
        List<Integer> ans = new ArrayList<Integer>();
        while (true) {
            index = text.indexOf(find, index+1);
            if(index == -1)break;
            ans.add(index);
        }
        return ans;
    }
}
