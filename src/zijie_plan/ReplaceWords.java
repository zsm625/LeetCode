package zijie_plan;

import java.util.*;
import java.lang.*;
/**
 * 648. 单词替换
 * 在英语中，我们有一个叫做 词根(root) 的概念，
 * 可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。
 * 你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 你需要输出替换之后的句子。
 */
public class ReplaceWords{

    /**
     * 第一种方式：暴力破解，最后一个用例超出时间限制
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords1(List<String> dictionary, String sentence) {
        //空格分割 一个单词遍历 与词根匹配
        String[] words = sentence.split(" ");
        StringBuilder resultSb = new StringBuilder();
        for(int i=0;i<words.length;i++){
            char[] ch = words[i].toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for(char c:ch){
                sb.append(c);
                if(dictionary.contains(sb.toString())){
                    resultSb.append(sb.toString());
                    flag = false;
                    break;
                }
            }
            if(flag){
                resultSb.append(sb);
            }
            if(i<words.length-1){
                resultSb.append(" ");
            }
        }
        return resultSb.toString();
    }

    /**
     * 第二种，使用hash集查询 通过
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords2(List<String> dictionary, String sentence){
        Set<String> dictSet  = new HashSet<>();
        for(String dic : dictionary){
            dictSet.add(dic);
        }
        String[] words = sentence.split(" ");
        for(int j=0;j<words.length;j++){
            String w = words[j];
            for(int i=0;i:w.length;i++){
                if(dictSet.contains(w.substr(0,1+i))){
                    words[j] = dictSet.get(w.substr(0,i+1));
                    break;
                }
            }
        }

        return String.join(" ",words);
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        ReplaceWords replaceWords = new ReplaceWords();
        String root = replaceWords.findRoot(dictionary, sentence);
    }

    /**
     * 第三种，使用字典树，
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords3(List<String> dictionary, String sentence){

        TrieTree trie = new TrieTree();
        for(String dict:dictionary){
            TrieTree cur = trie;
            for(int i=0;i<dict.length();i++){
                char c = dict.charAt(i);
                cur.children.puIfAbsent(c,new TrieTree());
                cur = cur.children.get(c);
            }
            cur.children.put('#',new TrieTree());
        }

        String[] words = sentence.split(" ");
        for(int i=0;i<words.length();i++){
            words[i] = findRoot(words[i],trie);
        }
        return String.join(" ",words);

    }

    public String findRoot(String word,TrieTree trie){
        StringBuilder root = new StringBuilder();
        TrieTree cur = trie;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.children.containsKey('#')){
                return root.toString();
            }
            if(!cur.children.containsKey(c)){
                return word;
            }
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }

    /**
     * 构建字典树
     */
    class TrieTree {
        Map<Character,TrieTree> children;
        public TrieTree(){
            children = new HashMap<>();
        }


    }
}
