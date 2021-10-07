public class main {
    public static void main(String[] args) {
        System.out.println(
                "hello world"
        );
//        String s="The one-hour drama series Westworld is a dark odyssey about the dawn of artificial consciousness and the evolution of sin. Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged.";
//        String s="The one-hour drama series Westworld is a dark odyssey about the dawn of artificial consciousness and the evolution of sin. Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged.";
        //String s="aefawf...eawfawf . feawfwe will begin the urgent task of rebuilding our nation and renewing the American dream";
//        String s="aefawf...eawfawf . feawfwe will begin the urgent task of rebuilding our nation and renewing the American dream";
        String s="f . ";
        System.out.println("字符串个数："+countSegments(s));
    }
    public static int countSegments(String s) {
        if (s.length()==0)
            return 0;
        if(s.length()==1)
            return 1;
        int result=0;
        //识别到空格或者单独的一个.采用+1
        int pre_char=0;//前面的字符是否为空格，如果为空格则为pre_char=1;
        int cur_index=0;
        for (int i = 0; i < s.length(); i++) {
            char cur_char=s.charAt(i);
            if(cur_char==' '){
                if (pre_char==0&&cur_index!=0){
                    result++;
                    pre_char=1;
                    cur_index=0;
                }else{
                    pre_char=1;
                    cur_index++;
                }
                continue;
            }else if(cur_char=='.'){
                cur_index++;
                int j=i;
                for(;j<s.length();j++){
                    if(s.charAt(j)!='.')
                        break;
                }
                if(j!=i+1){
                    //此处有省略号，需要跳过并且不加result
                    i=j-1;
                    continue;
                }else{
                    if(cur_index!=0){
                        cur_index=0;
                        result++;
                    }
                    continue;
                }
            }

                pre_char=0;
                cur_index++;
            if(s.length()-1==i&&cur_index!=0)
                result++;


        }






        return result;
    }
}
