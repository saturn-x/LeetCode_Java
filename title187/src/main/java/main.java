import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> test=new ArrayList<>();
        if(s.length()<10)
            return test;
        Map<String,Integer> map=new HashMap<>();
        /*
        找出所有重复的目标子串，一个子串10个字符
        可以使用HashMap
        就是将遍历到每10个字符都加入map 如果有相同的 则更新value值
        最后找出其中大于10的
         */
        for(int i=0;i<s.length()-10+1;i++){

            String ss=s.substring(i,i+10);
            if(map.get(ss)==null){
                //map中没有 加入
                map.put(ss,0);
            }else{
                int cur=map.get(ss)+1;
                if(cur==1){
                    test.add(ss);
                }
                map.put(ss,cur);
            }
        }




        return test;
    }
}
